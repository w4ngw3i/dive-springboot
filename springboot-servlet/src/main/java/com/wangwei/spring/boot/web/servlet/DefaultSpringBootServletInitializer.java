package com.wangwei.spring.boot.web.servlet;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Auther wangwei
 * @Date 2018/11/26 12:19 AM
 */
public class DefaultSpringBootServletInitializer extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(SpringBootServletBootstrap.class);
        return builder;
    }

}
