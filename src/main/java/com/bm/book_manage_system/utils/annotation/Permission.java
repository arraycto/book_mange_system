package com.bm.book_manage_system.utils.annotation;

import com.bm.book_manage_system.utils.AcessLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 只有拥有values中的至少一项权限才能访问被该注解标注的接口
 * 默认是只有管理员权限
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Permission {
    AcessLevel[] values() default {AcessLevel.ADMIN};
}
