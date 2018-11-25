package com.wangwei.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Web MVC 引导类
 * @Auther wangwei
 * @Date 2018/11/23 12:50 PM
 */
@SpringBootApplication(scanBasePackages = "com.wangwei.web")
public class SpringBootWebMvcBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebMvcBootstrap.class, args);
    }
}
