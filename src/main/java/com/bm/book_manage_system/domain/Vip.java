package com.bm.book_manage_system.domain;

import com.bm.book_manage_system.utils.annotation.SqlName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 会员信息表
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class Vip extends MainDomain {

    @SqlName(name = "id")
    private Integer id;

    @SqlName(name = "account")
    private String account;

    @SqlName(name = "password")
    private String password;

    @SqlName(name = "name")
    private String name;

    @SqlName(name = "tel")
    private String tel;

    @SqlName(name = "sex")
    private String sex;

    @SqlName(name = "reservation")
    private Integer reservation;

    @SqlName(name = "balance")
    private BigDecimal balance;

    @SqlName(name = "create_time")
    private Date createTime;

}
