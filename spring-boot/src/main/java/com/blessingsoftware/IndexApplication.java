package com.blessingsoftware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.blessingsoftware.mapper")
@SpringBootApplication
public class IndexApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndexApplication.class, args);
    }
}