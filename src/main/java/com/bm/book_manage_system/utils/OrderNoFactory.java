package com.bm.book_manage_system.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderNoFactory {

    public static Lock lock = new ReentrantLock();
    public static volatile Integer no = 0;
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    public static volatile String date = "20200701";

    public static synchronized String getOrderNo() {
        String dateStr = simpleDateFormat.format(new Date());
        if(!dateStr.equals(date)) {
                date = dateStr;
                no = 0;
        }
        String result = new String(date);
        no += 1;
        result += no;
        return result;
    }
}
