package com.wangwei.spring.boot.web.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Auther wangwei
 * @Date 2018/11/25 10:02 PM
 */
@EnableAutoConfiguration
@ServletComponentScan(basePackages = "com.wangwei.spring.web.servlet")
public class SpringBootServletBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootServletBootstrap.class, args);
    }
}
