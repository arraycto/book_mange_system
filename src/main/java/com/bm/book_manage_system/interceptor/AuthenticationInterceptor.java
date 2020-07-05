package com.bm.book_manage_system.interceptor;

import com.bm.book_manage_system.utils.AcessLevel;
import com.bm.book_manage_system.utils.annotation.Permission;
import com.bm.book_manage_system.utils.jwt.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限认证的拦截器
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("ACCESS-TOKEN");

        //请求的对象必须是方法
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Permission permission = handlerMethod.getMethodAnnotation(Permission.class);
            if (permission != null) {
                // 进入这里说明token校验不通过（伪造或则过期）
                if (!JWTUtils.verity(token)) {
                    String msg = "非法token";
                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().write(msg);
                    return false;
                }

                AcessLevel[] privileges = permission.values();
                String[] require = new String[privileges.length];
                for (int i = 0; i < privileges.length; i++) {
                    require[i] = privileges[i].getPrivilege();
                }
                String[] own = JWTUtils.getRoles(token);
                if (own == null || own.length < 1) {
                    // 进入这里说明没有任何权限但是访问的接口需要权限
                    String msg = "您未被授权";
                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().write(msg);
                    return false;
                }
                for (int i = 0; i < own.length; i++) {
                    for (int j = 0; j < require.length; j++) {
                        if (own[i].equals(require[j])) {
                            return true;
                        }
                    }
                }
                // 进入这里说明权限不够
                String msg = "您没有这项权限";
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().write(msg);
                return false;
            }
        }

        return HandlerInterceptor.super.preHandle(request, response, handler); //执行之后的过滤链
    }
}

