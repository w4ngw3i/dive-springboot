package com.wangwei.web.template.engine;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Auther wangwei
 * @Date 2018/11/23 3:29 PM
 */
public class ThymeleafTemplateEngineBootstrap {
    public static void main(String[] args) throws IOException {
        // 构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine(); // 创建渲染上下文
        Context context = new Context();
        context.setVariable("message", "Hello,World");
        // 模板的内容
        //String content = "<p th:text=\"${message}\">!!!</p>";

        /**
         * 读取内容从classpath:/templates/thymeleaf/demo.html
         */
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource("classpath:/templates/thymeleaf/demo.html");
        File file = resource.getFile();

        FileInputStream fileInputStream = new FileInputStream(file);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        IOUtils.copy(fileInputStream, byteArrayOutputStream);

        String content = byteArrayOutputStream.toString("UTF-8");


        // 渲染(处理)结果
        String result = templateEngine.process(content, context);

        // 输出渲染(处理)结果
        System.out.println(result);
    }
}
