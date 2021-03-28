package com.bishe.controller;

import com.bishe.bean.Result;
import com.bishe.bean.Shop;
import com.bishe.bean.UserShopMessage;
import com.bishe.mapper.IndexShopMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
}
