package com.bm.book_manage_system.service;

import com.bm.book_manage_system.domain.Order;
import com.bm.book_manage_system.domain.PayRecord;

public interface OrderService {
    Order initOrder(Order order);

    boolean savePayRecords(PayRecord payRecord);

    PayRecord getPayRecordById(String tradeNo);

    boolean orderDeal(PayRecord record);

    boolean cancelOrderByIds(String id);

}
