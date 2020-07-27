package com.bm.book_manage_system.domain;

import com.bm.book_manage_system.utils.annotation.SqlName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图书推荐表
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class BookRecommend extends MainDomain {

    @SqlName(name = "id")
    private Integer id;

    @SqlName(name = "book_id")
    private Integer bookId;

    @SqlName(name = "type")
    private String type;

}
