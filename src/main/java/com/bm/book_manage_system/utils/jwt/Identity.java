package com.bm.book_manage_system.utils.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 身份信息类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Identity {
    private String id;
    private String[] roles;
}
