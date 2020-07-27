package com.bm.book_manage_system.domain;

import com.bm.book_manage_system.utils.annotation.SqlName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 书本分类表
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class BookCategory extends MainDomain {

    @SqlName(name = "id")
    private Integer id;

    @SqlName(name = "parent_id")
    private Integer parentId;

    @SqlName(name = "name")
    private String name;

}
