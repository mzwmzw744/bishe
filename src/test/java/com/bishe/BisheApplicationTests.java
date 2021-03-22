package com.bishe;

import com.bishe.bean.Shop;
import com.bishe.bean.ShopMainPicture;
import com.bishe.mapper.BackstageMapper;
import com.bishe.mapper.ShopMapper;
import com.bishe.service.Service;
import com.bishe.util.RedisUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

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
    @Test
    void contextLoads() throws IOException {
//      List<Shop> list= shopMapper.getShopMessage(1);
//      System.out.println(list);
//        int num = new Integer(1);
//        Assert.assertEquals(1,2);
//        Service.createDir("E:\\毕业设计\\upload\\1");
        ShopMainPicture shopMainPicture = shopMapper.getShopMainPicByShopID(2);
        System.out.println(shopMainPicture);
    }
}
