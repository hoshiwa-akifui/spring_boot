package com.blessingsoftware.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
// @ConfigurationProperties(prefix = "teacher")
public class Teacher {

    private String id;
    private String name;
    private String age;
    private String sex;
}
