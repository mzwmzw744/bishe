package com.bishe;

import com.bishe.bean.Admin;
import com.bishe.mapper.AdminMapper;
import com.bishe.service.Service;
import com.bishe.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

@SpringBootTest
class BisheApplicationTests {
    @Autowired
    Service service;
    @Autowired
    com.bishe.mapper.UserMapper UserMapper;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    AdminMapper adminMapper;
    @Test
    void contextLoads(){

        Admin admin;
        admin = adminMapper.getAdminByName("1");
        System.out.println(admin);
//        System.out.println(redisUtil.get("1"));
    }
}
