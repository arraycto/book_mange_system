package com.bm.book_manage_system.domain;

import com.bm.book_manage_system.utils.annotation.SqlName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 支付记录单表
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class PayRecord extends MainDomain {

    @SqlName(name = "order_id")
    private String orderId;

    @SqlName(name = "amount")
    private BigDecimal amount;

    @SqlName(name = "vip_id")
    private Integer vipId;
}
