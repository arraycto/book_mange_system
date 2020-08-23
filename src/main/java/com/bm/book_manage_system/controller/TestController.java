package com.bm.book_manage_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/common/a")
    public String toStudentLogin() {
        return "official_website/a.html";
    }
}
