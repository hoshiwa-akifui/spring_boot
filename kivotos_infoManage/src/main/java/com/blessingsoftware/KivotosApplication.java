package com.blessingsoftware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.blessingsoftware.mapper")
@SpringBootApplication
public class KivotosApplication {

    public static void main(String[] args) {
        SpringApplication.run(KivotosApplication.class, args);
    }

}