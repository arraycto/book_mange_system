package com.bm.book_manage_system.domain;

import com.bm.book_manage_system.utils.annotation.SqlName;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MainDomain {
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field: fields) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(this);
            }catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (value != null) {
                SqlName annotation = field.getAnnotation(SqlName.class);
                if(annotation != null) {
                    map.put(annotation.name(), value);
                }
            }
        }
        return map;
    }
}
