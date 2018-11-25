package com.wangwei.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther wangwei
 * @Date 2018/11/24 3:29 PM
 */
@RestController
public class HelloWordRestController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "hello, world";
    }

}
