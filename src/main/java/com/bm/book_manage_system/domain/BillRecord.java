package com.bm.book_manage_system.domain;

import com.bm.book_manage_system.utils.annotation.SqlName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
public class BillRecord extends MainDomain {

    @SqlName(name="id")
    private Integer id;

    @SqlName(name = "vip_id")
    private Integer vipId;

    @SqlName(name = "create_time")
    private Date createTime;

    @SqlName(name = "type")
    private String type;

    @SqlName(name = "amount")
    private BigDecimal amount;

    @SqlName(name = "old_balance")
    private BigDecimal oldBalance;

    @SqlName(name = "new_balance")
    private BigDecimal newBalance;

    @SqlName(name = "reason")
    private String reason;

    @SqlName(name = "order_id")
    private String orderId;
}
