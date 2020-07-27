package com.bm.book_manage_system.domain;

import com.bm.book_manage_system.utils.annotation.SqlName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 书架信息表
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class Bookrack extends MainDomain {

    @SqlName(name = "id")
    private Integer id;

    @SqlName(name = "code")
    private String code;

}
