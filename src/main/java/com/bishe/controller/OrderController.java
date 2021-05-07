package com.bishe.controller;

import com.bishe.bean.Address;
import com.bishe.bean.BuyOrder;
import com.bishe.bean.Shop;
import com.bishe.bean.User;
import com.bishe.mapper.AddressMapper;
import com.bishe.mapper.OrderMapper;
import com.bishe.mapper.ShopMapper;
import com.bishe.mapper.UserMapper;
import com.bishe.util.RedisUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {
    @Resource
    AddressMapper addressMapper;
    @Resource
    RedisUtil redisUtil;
    @Resource
    UserMapper userMapper;
    @Resource
    OrderMapper orderMapper;
    @Resource
    ShopMapper shopMapper;

    @RequestMapping("/token/xfBalance")
    @ResponseBody
    public Double xfBalance(@RequestBody Map<String,String> map,@RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        User user = (User)redisUtil.get(token);
        User newuser = userMapper.getUserById(user.getId());
        int shopId = Integer.parseInt(map.get("shopId"));

        String isShopping = shopMapper.getShopAuditStatus(shopId);
        int isShppings = Integer.parseInt(isShopping);

        if(isShppings == 10){
            isShppings = 1;
        }
        if(isShppings != 1  ){
            if(isShppings == 0){
                return -1.0;
            }else {
                return -2.0;
            }
        }
        double t =  Double.valueOf(newuser.getBalance());
        double z =Double.valueOf(map.get("balance"));
        Double num = t - z;
        userMapper.xfBalance(num.toString(),user.getId());
        BuyOrder buyOrder = new BuyOrder();

        Shop shop = new Shop();
        shop.setId(shopId);
        shop.setAuditStatus("2");
        shopMapper.updateShopState(shop);
        buyOrder.setShop_id(shopId);
        buyOrder.setBuy_user_id(user.getId());
        buyOrder.setAddress_id(map.get("adressId"));
        orderMapper.addOrder(buyOrder);
        return num;
    }
    @RequestMapping("/token/getMyOrder")
    @ResponseBody
    public List<Shop> getMyOrder(@RequestBody Map<String,String> map, @RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        User user = (User)redisUtil.get(token);
        User newuser = userMapper.getUserById(user.getId());;
        BuyOrder buyOrder = new BuyOrder();
        buyOrder.setBuy_user_id(user.getId());
        List<BuyOrder> list = orderMapper.getAllByOrder(buyOrder);
        List<Shop> shops = new ArrayList<>();
        for(BuyOrder buyOrder1 : list){
            Shop shop = shopMapper.getShopById(buyOrder1.getShop_id());
            shop.setCreateDate(buyOrder1.getCreateTime());
            shops.add(shop);
        }
        return shops;
    }
    @RequestMapping("/token/getOrderByShopId")
    @ResponseBody
    public Address getOrderByShopId(@RequestBody Map<String,String> map, @RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        User user = (User)redisUtil.get(token);
        BuyOrder buyOrder = orderMapper.getOrderByShopId(Integer.parseInt(map.get("shopId")));
        Address address = orderMapper.getAddressById(Integer.parseInt(buyOrder.getAddress_id()));
        return address;
    }
}
