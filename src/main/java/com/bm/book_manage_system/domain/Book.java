package com.bm.book_manage_system.domain;

import com.bm.book_manage_system.utils.annotation.SqlName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 图书基本信息表
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class Book extends MainDomain {

    @SqlName(name = "id")
    private Integer id;

    @SqlName(name = "name")
    private String name;

    @SqlName(name = "author")
    private String author;

    @SqlName(name = "publisher")
    private String publisher;

    @SqlName(name = "cover")
    private String cover;

    @SqlName(name = "price")
    private BigDecimal price;

    @SqlName(name = "status")
    private String status;

    @SqlName(name = "bookrack_id")
    private Integer bookrackId;

    @SqlName(name = "create_time")
    private Date createTime;
}
