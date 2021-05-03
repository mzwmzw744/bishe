package com.bishe.controller;

import com.bishe.bean.BuyOrder;
import com.bishe.bean.Shop;
import com.bishe.bean.ShopCarBean;
import com.bishe.bean.User;
import com.bishe.mapper.OrderMapper;
import com.bishe.mapper.ShopCarMapper;
import com.bishe.mapper.ShopMapper;
import com.bishe.mapper.UserMapper;
import com.bishe.util.RedisUtil;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ShopCarController {
    @Resource
    ShopCarMapper shopCarMapper;
    @Resource
    RedisUtil redisUtil;
    @Resource
    ShopMapper shopMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    OrderMapper orderMapper;

    @RequestMapping("/token/addShopCar")
    public String addShopCar(@RequestBody Map map,@RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        User user = (User)redisUtil.get(token);
        ShopCarBean shopCarBean = new ShopCarBean();
        shopCarBean.setShopId((int)map.get("shopId"));
        shopCarBean.setUserId(user.getId());
        int t = shopCarMapper.addShopCar(shopCarBean);
        if(t > 0){
            return "成功";
        }else{
            return "失败";
        }
    }
    @RequestMapping("/token/getShopCar")
    public List<Shop> getShopCar(@RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        User user = (User)redisUtil.get(token);
        List<ShopCarBean> shopCars = shopCarMapper.getShopCar(user.getId());
        List<Shop> shops = new ArrayList<>();
        for(int i = 0; i < shopCars.size();i++){
            int shopId = shopCars.get(i).getShopId();
            Shop shop = shopMapper.getShopById(shopId);
            String ceateDate = shopCars.get(i).getCreateTime();
            shop.setCreateDate(ceateDate);
            shops.add(shop);
        }
        return shops;
    }
    @RequestMapping("/token/jsShopCar")
    public double jsShopCar(@RequestBody Map map,@RequestHeader Map<String, String> headers){
        List list = (List)map.get("AllChooseId");
        String token = headers.get("token");
        User user = (User)redisUtil.get(token);
        User newuser = userMapper.getUserById(user.getId());
        String t = newuser.getBalance();
        String t1 = map.get("AllPrice").toString();
        Double newBalance = Double.valueOf(t) - Double.valueOf(t1);
        if(newBalance < 0){
           return -1;
        }
        Shop shop = new Shop();
        shop.setAuditStatus("2");
        BuyOrder buyOrder = new BuyOrder();
        for(int i = 0;i < list.size();i++){
            shop.setId((int)list.get(i));
            shopCarMapper.deleteShopCar((int)list.get(i),user.getId());
            shopMapper.updateShopState(shop);
            buyOrder.setAddress_id( String.valueOf(map.get("address"))  );
            buyOrder.setBuy_user_id(user.getId());
            buyOrder.setShop_id((int)list.get(i));
            int t11 = orderMapper.addOrder(buyOrder);
        }
        userMapper.xfBalance(String.valueOf(newBalance),user.getId());
        return newBalance;
    }
}
