package com.blessingsoftware.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 图片绝对地址与虚拟地址映射
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/images/**")//这个将应用到url中
//                .addResourceLocations("file:/usr/local/uploadImage/");//这里填的是图片的绝对父路径
//        super.addResourceHandlers(registry);
//        registry.addResourceHandler("/img/**")//这个将应用到url中
//                .addResourceLocations("d:\\img");//这里填的是图片的绝对父路径
        // registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        // registry.addResourceHandler("/img/**").addResourceLocations("file:/usr/local/uploadImage/");
        registry.addResourceHandler("/static/**").addResourceLocations("file:/E:\\Program Files\\projects\\spring_boot\\kivotos_infoManage\\src\\main\\resources\\templates/static/");
        // System.out.println("url"+ResourceUtils.CLASSPATH_URL_PREFIX);
        // registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        super.addResourceHandlers(registry);
    }



}
