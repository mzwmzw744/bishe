package com.bishe;

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
    @Test
    void contextLoads() throws GeneralSecurityException, MessagingException {
//        service.emailSendService();
//        service.emailSendService("1163974499@qq.com");
//        System.out.println(UUID.randomUUID());
//        redisUtil.set("1",2);
        System.out.println(redisUtil.get("1"));
    }
}
