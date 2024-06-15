package com.blessingsoftware.config;

import com.blessingsoftware.entity.Teacher;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherConfig {

    @Bean
    @ConfigurationProperties(prefix = "teacher")
    public Teacher getTeacher() {
        return new Teacher();
    }
}
