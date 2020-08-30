package com.bm.book_manage_system.repository;

import com.bm.book_manage_system.domain.PayRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PayRecordRepository {
    boolean saveRecord(@Param("record")PayRecord record);
    PayRecord getByOrderId(@Param("id") String id);
}