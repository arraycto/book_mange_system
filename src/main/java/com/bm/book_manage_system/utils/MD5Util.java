package com.bm.book_manage_system.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5加密的工具类
 */
public class MD5Util {
    /**
     * 加密
     *
     * @param key
     * @return
     */
    public static String getMD5(String key) {
        if (key == null || key.trim().equals("")) {
            return null;
        }
        return DigestUtils.md5Hex(key);
    }
}
