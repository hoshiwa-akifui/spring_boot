package com.blessingsoftware.config;

import com.blessingsoftware.entity.Student;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //xml
public class Config {
    @Bean
    @ConfigurationProperties(prefix = "student")
    public Student getData() {
        Student j = new Student();
        return j;
    }
}
