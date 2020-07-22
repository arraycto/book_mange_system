package com.bm.book_manage_system.controller;

import com.bm.book_manage_system.domain.Order;
import com.bm.book_manage_system.service.AliService;
import com.bm.book_manage_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    AliService aliService;

    @PostMapping("/recharge")
    public boolean recharge(HttpServletResponse response, @RequestBody Order order) {
        return aliService.pay(response, order);
    }
}
