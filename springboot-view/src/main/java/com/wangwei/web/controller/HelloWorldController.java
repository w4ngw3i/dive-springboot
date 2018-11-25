package com.wangwei.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther wangwei
 * @Date 2018/11/23 4:11 PM
 */
@Controller
public class HelloWorldController {

    @RequestMapping("")
    public String index(@RequestParam(value = "value", required = false) Integer value){
        return "index";
    }

    @GetMapping("/demo")
    public String demo(){
        return "demo";
    }

    @ModelAttribute("message")
    public String message(){
        return "wanggwei 你好!";
    }
}
