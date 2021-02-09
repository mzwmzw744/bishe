package com.bishe;

import com.bishe.bean.Shop;
import com.bishe.mapper.BackstageMapper;
import com.bishe.mapper.ShopMapper;
import com.bishe.service.Service;
import com.bishe.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BisheApplicationTests {
    @Autowired
    com.bishe.mapper.UserMapper UserMapper;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    BackstageMapper backstageMapper;
    @Autowired
    ShopMapper shopMapper;
    @Test
    void contextLoads(){
//        List<Shop> list= shopMapper.getShopMessage(1);
//        System.out.println(list);
    }
}
