package com.bishe.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DynamicController {

    @RequestMapping("/token/Publishingnews")
    public void Publishingnews(@RequestBody Map<String, String> map){
        System.out.println("");
    }
}
