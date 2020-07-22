package com.bm.book_manage_system.service.impl;

import com.bm.book_manage_system.domain.Order;
import com.bm.book_manage_system.domain.PayRecord;
import com.bm.book_manage_system.repository.OrderRepository;
import com.bm.book_manage_system.service.OrderService;
import com.bm.book_manage_system.utils.OrderNoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    /**
     * 初始化订单信息
     * @param order
     * @return
     */
    @Override
    public Order initOrder(Order order) {
        order.setOrderId(OrderNoFactory.getOrderNo());
        order.setCreateTime(new Date());
        order.setPayTime(null);
        if(order.getVipId() == null || order.getAmount() == null) {
            return null;
        }
        order.setStatus("待支付");
        boolean result = repository.saveOrder(order);
        return result ? order : null;
    }

    @Override
    public boolean savePayRecords(PayRecord payRecord) {
        return false;
    }

    @Override
    public PayRecord getPayRecordById(String tradeNo) {
        return null;
    }

    @Override
    public boolean orderDeal(PayRecord record) {
        return false;
    }

    @Override
    public boolean cancelOrderByIds(String id) {
        return false;
    }
}