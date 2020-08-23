package com.bm.book_manage_system.repository;

import com.bm.book_manage_system.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository {
    Boolean saveOrder(@Param("order")Order order);
}
