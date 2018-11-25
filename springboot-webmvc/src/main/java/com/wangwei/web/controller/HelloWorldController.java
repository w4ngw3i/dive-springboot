package com.wangwei.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther wangwei
 * @Date 2018/11/21 5:43 PM
 */
@Controller
public class HelloWorldController {
    @RequestMapping("")
    public String index(@RequestParam("test") String test){
        return "index";
    }
}
