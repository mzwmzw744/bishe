package com.bishe;

import com.bishe.mapper.BackstageMapper;
import com.bishe.service.Service;
import com.bishe.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BisheApplicationTests {
    @Autowired
    com.bishe.mapper.UserMapper UserMapper;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    BackstageMapper backstageMapper;
    @Test
    void contextLoads(){
        Service.getBJTime();
    }
}
