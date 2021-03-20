package com.bishe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/test11")
    public String Test1(){
        System.out.println("测试");
        return "1234";
    }
}
