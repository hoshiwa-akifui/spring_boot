package com.blessingsoftware.kivotos;

import com.blessingsoftware.kivotos.filter.KivotosFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@MapperScan("com.blessingsoftware.kivotos.mapper")
@SpringBootApplication
public class KivotosApplication {

    public static void main(String[] args) {
        SpringApplication.run(KivotosApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean<KivotosFilter> loggingFilter(){
        FilterRegistrationBean<KivotosFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new KivotosFilter());
        registrationBean.addUrlPatterns("/*"); // 设置需要拦截的URL模式

        return registrationBean;
    }
}