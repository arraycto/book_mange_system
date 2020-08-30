package com.bm.book_manage_system.repository;

import com.bm.book_manage_system.domain.BillRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository {
    boolean save(@Param("bill")BillRecord billRecord);
}
