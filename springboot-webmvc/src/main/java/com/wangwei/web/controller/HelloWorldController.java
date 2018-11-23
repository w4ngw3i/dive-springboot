package com.wangwei.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther wangwei
 * @Date 2018/11/21 5:43 PM
 */
@Controller
public class HelloWorldController {
    @RequestMapping("")
    public String index(){
        return "index";
    }
}
