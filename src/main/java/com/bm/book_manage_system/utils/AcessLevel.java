package com.bm.book_manage_system.utils;

/**
 * 权限等级
 */
public enum AcessLevel {

    /**
     * 超级管理员
     */
    SUPER_ADMIN("super_admin"),

    /**
     * 管理员
     */
    ADMIN("admin");

    private String privilege;

    AcessLevel(String privilege) {
        this.privilege = privilege;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
}
