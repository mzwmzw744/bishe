package com.bishe.controller;

import com.bishe.bean.Address;
import com.bishe.bean.User;
import com.bishe.mapper.AddressMapper;
import com.bishe.util.RedisUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Resource
    AddressMapper addressMapper;
    @Resource
    RedisUtil redisUtil;
    @RequestMapping("/token/addUserOder")
    public String addUserAddress(@RequestBody Map<String,Object> map,@RequestHeader Map<String, String> headers){






        return "成功";
    }
}
