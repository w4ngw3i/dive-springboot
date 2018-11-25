package com.wangwei.spring.web.servlet.support;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring Web MVC 自动装配 默认实现
 * @Auther wangwei
 * @Date 2018/11/23 12:34 PM
 */
@ComponentScan(basePackages = "com.wangwei")
public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                getClass() //返回当前类
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
