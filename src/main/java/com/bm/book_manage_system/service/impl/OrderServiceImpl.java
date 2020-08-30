package com.bm.book_manage_system.service.impl;

import com.bm.book_manage_system.domain.Order;
import com.bm.book_manage_system.domain.PayRecord;
import com.bm.book_manage_system.repository.OrderRepository;
import com.bm.book_manage_system.repository.PayRecordRepository;
import com.bm.book_manage_system.repository.VipRepository;
import com.bm.book_manage_system.service.OrderService;
import com.bm.book_manage_system.utils.OrderNoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private PayRecordRepository recordRepository;

    @Autowired
    private VipRepository vipRepository;

    /**
     * 初始化订单信息
     * @param order
     * @return
     */
    @Override
    public Order initOrder(Order order) {
        order.setOrderId(OrderNoFactory.getOrderNo());
        order.setCreateTime(new Date());
        order.setDealTime(null);
        if(order.getVipId() == null || order.getAmount() == null) {
            return null;
        }
        order.setStatus("待支付");
        boolean result = repository.saveOrder(order);
        return result ? order : null;
    }

    @Override
    public boolean savePayRecords(PayRecord payRecord) {
        if (payRecord.toMap().size() <= 0) {
            return false;
        }
        return recordRepository.saveRecord(payRecord);
    }

    @Override
    public PayRecord getPayRecordById(String tradeNo) {
        if(tradeNo == null || tradeNo.trim().equals("")) {
            return null;
        }
        return recordRepository.getByOrderId(tradeNo);
    }

    @Override
    @Transactional
    public boolean orderDeal(PayRecord record) {
        if(record == null) {
            return false;
        }
        Map<String, Object> recordInfo = record.toMap();
        if(recordInfo.size() < 3) {  //信息不全无法完成后续操作
            return false;
        }

        try {
            //修改订单状态
            String orderId = record.getOrderId().trim();
            if (orderId.equals("")) {
                return false;
            }
            Map<String, Object> newOrderInfo = new HashMap<>();
            newOrderInfo.put("status", "完成");
            newOrderInfo.put("deal_time", new Date());
            boolean orderResult = repository.updateById(orderId, newOrderInfo);

            //增加对应账号余额
            String vipId = "" + record.getVipId();
            BigDecimal amount = record.getAmount();
            vipRepository.recharge(vipId, amount);
            //新增对应账号交易流水记录
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean cancelOrderByIds(String id) {
        return false;
    }

    @Override
    public void recharge(HttpServletResponse response, HttpServletRequest request, Order order) {
        order = initOrder(order);
        if(order == null) {  //订单初始化异常交易取消
            try {
                response.sendRedirect("https://www.baidu.com"); //这里跳转到交易异常取消界面
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            request.setAttribute("order", order);
            request.getRequestDispatcher("/pay/getQRCode").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}