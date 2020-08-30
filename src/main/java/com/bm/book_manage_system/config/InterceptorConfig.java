package com.bm.book_manage_system.config;

import com.bm.book_manage_system.interceptor.AuthenticationInterceptor;
import com.bm.book_manage_system.interceptor.PageInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    AuthenticationInterceptor authenticationInterceptor;
    @Autowired
    PageInterceptor pageInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/api/**");
        registry.addInterceptor(pageInterceptor).addPathPatterns("/api/**");
    }
}