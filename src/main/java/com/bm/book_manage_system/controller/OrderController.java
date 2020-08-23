package com.bm.book_manage_system.controller;

import com.bm.book_manage_system.domain.Order;
import com.bm.book_manage_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/recharge")
    public void recharge(HttpServletResponse response, HttpServletRequest request, @RequestBody Order order) {
        orderService.recharge(response, request, order);
    }
}
