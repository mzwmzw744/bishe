package com.bishe.controller;

import com.bishe.bean.Result;
import com.bishe.bean.Shop;
import com.bishe.bean.ShopMainPicture;
import com.bishe.bean.UserShopMessage;
import com.bishe.mapper.IndexShopMapper;
import com.bishe.mapper.ShopMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author MZW
 */
@RestController
public class IndexShopController {
    @Resource
    IndexShopMapper indexShopMapper;
    @Resource
    ShopMapper shopMapper;

    @RequestMapping("/token/getIndexNewShopMeaage")
    public Result getIndexNewShopMeaage(){
        Result result = new Result();
        Map map = new HashMap<String,Object>();
        List<Shop> list = indexShopMapper.getShopNew();
        result.setMessage("成功");
        map.put("data",list);
        result.setData(map);
        return result;
    }


    @RequestMapping("/token/getTjShop")
    public List<Shop> getTjShop(@RequestBody Map<String,String> map) {
        int offset = (Integer.parseInt(map.get("page"))-1)*10;
        List<Shop> tjShops = shopMapper.getTjShop(10,offset);
        return tjShops;
    }
}
