package com.bm.book_manage_system.controller;

import com.bm.book_manage_system.utils.MD5Util;
import com.bm.book_manage_system.utils.result.Result;
import com.bm.book_manage_system.utils.result.RetResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/home/")
public class LoginController {

    @PostMapping("/login")
    public Result<Map> login(@RequestBody Map<String, Object> proof) {
        Map<String, Object> result = new HashMap<>();
        String username = proof.get("username") + "";
        String password = proof.get("password") + "";
        if(username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            result.put("result", "fail");
            result.put("reason", "用户名或密码错误");
            return RetResponse.makeOKRsp(result);
        }

        return RetResponse.makeOKRsp(result);
    }
}