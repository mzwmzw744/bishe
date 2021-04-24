package com.bishe;

import com.bishe.bean.Shop;
import com.bishe.bean.ShopMainPicture;
import com.bishe.mapper.BackstageMapper;
import com.bishe.mapper.IndexShopMapper;
import com.bishe.mapper.ShopMapper;
import com.bishe.service.Service;
import com.bishe.util.RedisUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
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
    @Resource
    IndexShopMapper indexShopMapper;
    @Test
    void contextLoads() throws IOException {
        List<Shop> list =  indexShopMapper.getShopNew();
        System.out.println(list);
    }
}
