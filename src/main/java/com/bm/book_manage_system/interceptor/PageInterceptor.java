package com.bm.book_manage_system.interceptor;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 进行分页的拦截器
 */
@Component
public class PageInterceptor implements HandlerInterceptor {

    public static final String PAGE_SIZE = "pageSize";
    public static final String PAGE_NUM = "pageNum";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String pgs = request.getParameter(PAGE_SIZE);
            String pgn = request.getParameter(PAGE_NUM);
            if (pgs != null && !"".equals(pgs) && pgn != null && !"".equals(pgn)) {
                Integer pageNum = Integer.valueOf(pgn);
                Integer pageSize = Integer.valueOf(pgs);
                PageHelper.startPage(pageNum, pageSize);
            }
        } catch (Exception e) {
            return true;
        }

        return true;
    }
}
