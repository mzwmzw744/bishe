package com.bishe.controller;

import com.bishe.bean.Shop;
import com.bishe.bean.User;
import com.bishe.mapper.ShopMapper;
import com.bishe.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


@RestController
public class ShopController {
    @Autowired
    ShopMapper shopMapper;
    @Autowired
    RedisUtil redisUtil;

    /**
     * 商品创建
     * @param map 传入的map集合
     * @return 是否创建成功
     */
    @RequestMapping("/token/shopCreate")
    public String list(@RequestBody Map<String,String> map,@RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        System.out.println(token);
        User user = (User)redisUtil.get(token);
        System.out.println(user);
        int userId = user.getId();
        String shopName = map.get("shopName");
        double shopPrice =  Double.parseDouble(map.get("shopPrice"));
        String shopIntroduction = map.get("shopIntroduction");
        String shopHeadPicture = map.get("shopHeadPicture");
        String shopFamily = map.get("shopFamily");
        Shop shop = new Shop();
        shop.setUserID(userId);
        shop.setShopName(shopName);
        shop.setShopFamily(shopFamily);
        shop.setShopPrice(shopPrice);
        shop.setShopIntroduction(shopIntroduction);
        shop.setShopHeadPicture(shopHeadPicture);
        shop.setAuditStatus("false");
        int isTrue = shopMapper.shopCreate(shop);
        if(isTrue > 0) {
            return "商品创建成功";
        }
        return "商品创建失败";
    }


    @RequestMapping("/token/getShopAccount")
    public int getShopAccount(@RequestBody Map<String,String> map,@RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        System.out.println(token);
        User user = (User)redisUtil.get(token);
        System.out.println(user);
        int count = shopMapper.getShopAccount(user.getId());
        return count;
    }
}
