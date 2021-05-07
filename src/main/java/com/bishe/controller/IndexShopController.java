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

    /**
     * 首页最新
     * @return 首页最新上架商品
     */
    @RequestMapping("/token/getIndexNewShopMeaage")
    public Result getIndexNewShopMeaage(@RequestBody Map<String,String> maps){
        int offset = (Integer.parseInt(maps.get("page"))-1)*10;
        Result result = new Result();
        Map map = new HashMap<String,Object>();
        List<Shop> list = indexShopMapper.getShopNew(10,offset);
        if(list.size() == 0) {
            result.setMessage("到底了");
        }
        if(list.size() > 0) {
            result.setMessage("成功");
        }
        map.put("data",list);
        result.setData(map);
        return result;
    }

    /**
     * 首页显示今日推荐
     * @param maps
     * @return
     */
    @RequestMapping("/token/getTjShop")
    public Result getTjShop(@RequestBody Map<String,String> maps) {
        Result result = new Result();
        int offset = (Integer.parseInt(maps.get("page"))-1)*10;
        Map map = new HashMap<String,Object>();
        List<Shop> tjShops = shopMapper.getTjShop(10,offset);

        if(tjShops.size() == 0) {
            result.setMessage("到底了");
        }
        if(tjShops.size() > 0) {
            result.setMessage("成功");
        }
        map.put("data",tjShops);
        result.setData(map);
        return result;
    }

    /**
     * 首页最新
     * @return 首页猜你喜欢商品
     */
    @RequestMapping("/token/getLikeShopMeaage")
    public Result getLikeShopMeaage(@RequestBody Map<String,String> maps){
        int offset = (Integer.parseInt(maps.get("page"))-1)*10;
        Result result = new Result();
        Map map = new HashMap<String,Object>();
        List<Shop> list = indexShopMapper.getShopNew(10,offset);
        if(list.size() == 0) {
            result.setMessage("到底了");
        }
        if(list.size() > 0) {
            result.setMessage("成功");
        }
        map.put("data",list);
        result.setData(map);
        return result;
    }
}
