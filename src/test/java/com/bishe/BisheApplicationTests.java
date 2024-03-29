package com.bishe;

import com.bishe.bean.SearchShopConditionBean;
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

    @Test
    synchronized void contextLoads() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Run of Runnable");
            }
        })
        {
            public void run() {
                System.out.println("Run of Thread");
            }
        }.start();


    }

}
