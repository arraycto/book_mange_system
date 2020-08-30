package com.bm.book_manage_system.repository;

import com.bm.book_manage_system.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface OrderRepository {
    Boolean saveOrder(@Param("order")Order order);
    boolean updateById(@Param("orderId") String orderId, @Param("newInfo") Map<String, Object> newInfo);
}
