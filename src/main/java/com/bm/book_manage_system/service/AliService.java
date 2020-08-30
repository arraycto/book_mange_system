package com.bm.book_manage_system.service;

import com.bm.book_manage_system.domain.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AliService {

    /**
     * 同步回调方法
     * @param request
     * @return
     */
    String synchronousFallback(HttpServletRequest request);

    /**
     * 异步回调方法
     * @param request
     * @param response
     */
    void notifyFallback(HttpServletRequest request, HttpServletResponse response);
}
