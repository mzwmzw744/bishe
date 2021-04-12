package com.bishe.controller;

import com.bishe.bean.Dynamic;
import com.bishe.bean.User;
import com.bishe.mapper.DynamicMapper;
import com.bishe.util.RedisUtil;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;



@RestController
public class DynamicController {
    @Resource
    DynamicMapper dynamicMapper;
    @Resource
    RedisUtil redisUtil;

    @RequestMapping("/token/getDynamicByTime")
    public List<Dynamic> getDynamicByTime(@RequestBody Map<String,String> map){
          int curPage = Integer.parseInt(map.get("page"));
          int pageSize = 10;
          int offset = pageSize*(curPage - 1);
          List<Dynamic> dynamic =  dynamicMapper.getDynamicByTime(pageSize,offset);
        return dynamic;
    }

    @RequestMapping("/token/Publishingnews")
    public void Publishingnews(@RequestBody String jsonStr,@RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        User user = (User)redisUtil.get(token);
        JSONObject json = JSONObject.fromObject(jsonStr);
        List list = (List) json.get("pic");
        Dynamic dynamic = new Dynamic();
        dynamic.setWords((String) json.get("textarea"));
        dynamic.setUser_id(user.getId());
        int dynamicId  = dynamicMapper.createUserDynamic(dynamic);
        if(list.size() >= 1) {
            String url1 = (String) JSONObject.fromObject(list.get(0)).get("url");
            dynamicMapper.addMyDynamicPic_1(url1,dynamicId);
        }
        if(list.size() >= 2) {
            String url2 = (String) JSONObject.fromObject(list.get(1)).get("url");
            dynamicMapper.addMyDynamicPic_2(url2,dynamicId);
        }
        if(list.size() >= 3) {
            String url3 = (String) JSONObject.fromObject(list.get(2)).get("url");
            dynamicMapper.addMyDynamicPic_3(url3,dynamicId);
        }
        if(list.size() >= 4) {
            String url4 = (String) JSONObject.fromObject(list.get(3)).get("url");
            dynamicMapper.addMyDynamicPic_4(url4,dynamicId);
        }
        if(list.size() >= 5) {
            String url5 = (String) JSONObject.fromObject(list.get(4)).get("url");
            dynamicMapper.addMyDynamicPic_5(url5,dynamicId);
        }
        if(list.size() >= 6) {
            String url6 = (String) JSONObject.fromObject(list.get(5)).get("url");
            dynamicMapper.addMyDynamicPic_6(url6,dynamicId);
        }
        if(list.size() >= 7) {
            String url7 = (String) JSONObject.fromObject(list.get(6)).get("url");
            dynamicMapper.addMyDynamicPic_7(url7,dynamicId);
        }
        if(list.size() >= 8) {
            String url8 = (String) JSONObject.fromObject(list.get(7)).get("url");
            dynamicMapper.addMyDynamicPic_8(url8,dynamicId);
        }
        if(list.size() >= 9) {
            String url9 = (String) JSONObject.fromObject(list.get(8)).get("url");
            dynamicMapper.addMyDynamicPic_9(url9,dynamicId);
        }
    }
}
