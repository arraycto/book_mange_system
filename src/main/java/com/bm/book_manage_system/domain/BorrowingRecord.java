package com.bm.book_manage_system.domain;

import com.bm.book_manage_system.utils.annotation.SqlName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 图书借阅记录
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class BorrowingRecord extends MainDomain {

    @SqlName(name = "id")
    private Integer id;

    @SqlName(name = "book_id")
    private Integer bookId;

    @SqlName(name = "vip_id")
    private Integer vipId;

    @SqlName(name = "borror_time")
    private Date borrorTime;

    @SqlName(name = "duration")
    private Integer duration;

    @SqlName(name = "status")
    private String status;

}
