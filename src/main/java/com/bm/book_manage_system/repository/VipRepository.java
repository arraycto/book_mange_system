package com.bm.book_manage_system.repository;

import com.bm.book_manage_system.domain.Vip;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;

@Repository
public interface VipRepository {
    boolean save(@Param("Vip")Vip vipInfo);

    boolean updateById(@Param("vipId") String id, @Param("newInfo") Map<String, Object> newInfo);

    boolean recharge(@Param("vipId") String id, @Param("amount")BigDecimal amount);
}
