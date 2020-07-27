package com.bm.book_manage_system.domain;

import com.bm.book_manage_system.utils.annotation.SqlName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付宝订单表
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class Order extends MainDomain {

    @SqlName(name="order_id")
    private String orderId;

    @SqlName(name = "amount")
    private BigDecimal amount;

    @SqlName(name = "create_time")
    private Date createTime;

    @SqlName(name = "pay_time")
    private Date payTime;

    @SqlName(name = "status")
    private String status;

    @SqlName(name = "vip _id")
    private Integer vipId;
}
