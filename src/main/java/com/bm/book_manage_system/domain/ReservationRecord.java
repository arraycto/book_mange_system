package com.bm.book_manage_system.domain;

import com.bm.book_manage_system.utils.annotation.SqlName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
public class ReservationRecord extends MainDomain {

    @SqlName(name = "id")
    private Integer id;

    @SqlName(name = "vip_id")
    private Integer vipId;

    @SqlName(name = "create_time")
    private Date createTime;

    @SqlName(name = "type")
    private String type;

    @SqlName(name = "value")
    private Integer value;

    @SqlName(name = "old_reservation")
    private Integer oldReservation;

    @SqlName(name = "new_reservation")
    private Integer newReservation;

    @SqlName(name = "reason")
    private String reason;

}
