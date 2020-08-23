package com.bm.book_manage_system.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 所有静态资源的请求
 */
@Controller
public class StaticController {

    private static final Logger logger = LoggerFactory.getLogger(StaticController.class.getName());// slf4j日志记录器

    /**
     * 得到登陆验证码
     */
    @Deprecated
    @RequestMapping("/login/getCode")
    public void getCode(HttpServletResponse response, HttpSession session) {
        // 定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 36, 4, 5);
        session.setAttribute("code", lineCaptcha.getCode());
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            lineCaptcha.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/backend/login")
    public String toBackendLogin() {
        logger.info("启动成功，进入登录页面");
        return "backend_manage/login/index.html";
    }

    @RequestMapping("/backend/index")
    public String toBackendIndex() {
        logger.info("登录成功，进入首页");
        return "backend_manage/home/index.html";
    }
}
