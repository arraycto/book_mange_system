package com.bm.book_manage_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.bm.book_manage_system.repository")
@EnableTransactionManagement
public class BookManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookManageSystemApplication.class, args);
    }

}
