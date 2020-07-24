package com.bm.book_manage_system.domain;

import com.bm.book_manage_system.utils.annotation.SqlName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class Manager extends MainDomain {

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

    @SqlName(name = "profile")
    private String profile;

    @SqlName(name = "level")
    private Integer level;
}
