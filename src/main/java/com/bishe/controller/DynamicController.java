package com.bishe.controller;

import com.bishe.bean.*;
import com.bishe.mapper.DynamicMapper;
import com.bishe.mapper.UserMapper;
import com.bishe.util.RedisUtil;
import lombok.Data;
import lombok.Value;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



@RestController
public class DynamicController {
    @Resource
    DynamicMapper dynamicMapper;
    @Resource
    RedisUtil redisUtil;
    @Resource
    UserMapper userMapper;


    int judgePicLength(DynamicResult dynamicResult){

        if(dynamicResult.getPic_1() == null || dynamicResult.getPic_1().equals("")){
            return 0;
        }
        if(dynamicResult.getPic_2() == null || dynamicResult.getPic_2().equals("")){
            return 1;
        }
        if(dynamicResult.getPic_3() == null || dynamicResult.getPic_3().equals("")){
            return 2;
        }
        if(dynamicResult.getPic_4() == null || dynamicResult.getPic_4().equals("")){
            return 3;
        }
        if(dynamicResult.getPic_5() == null || dynamicResult.getPic_5().equals("")){
            return 4;
        }
        if(dynamicResult.getPic_6() == null || dynamicResult.getPic_6().equals("")){
            return 5;
        }
        if(dynamicResult.getPic_7() == null || dynamicResult.getPic_7().equals("")){
            return 6;
        }
        if(dynamicResult.getPic_8() == null || dynamicResult.getPic_8().equals("")){
            return 7;
        }
        if(dynamicResult.getPic_9() == null || dynamicResult.getPic_9().equals("")){
            return 8;
        }
        return 9;
    }

    @RequestMapping("/token/getDynamicByTime")
    public List getDynamicByTime(@RequestBody Map<String,String> map){
          int curPage = Integer.parseInt(map.get("page"));
          int pageSize = 10;
          int offset = pageSize*(curPage - 1);
          List<Dynamic> dynamic =  dynamicMapper.getDynamicByTime(pageSize,offset);
          List<DynamicResult> dynamicResultList = new ArrayList();
          for(int i = 0 ; i <dynamic.size() ; i++){
              DynamicResult dynamicResult = new DynamicResult();
              dynamicResult.setId(dynamic.get(i).getId());
              String createTime = dynamic.get(i).getCreateTime();
              dynamicResult.setCreateTime(createTime);
              dynamicResult.setPic_1(dynamic.get(i).getPic_1());
              dynamicResult.setPic_2(dynamic.get(i).getPic_2());
              dynamicResult.setPic_3(dynamic.get(i).getPic_3());
              dynamicResult.setPic_4(dynamic.get(i).getPic_4());
              dynamicResult.setPic_5(dynamic.get(i).getPic_5());
              dynamicResult.setPic_6(dynamic.get(i).getPic_6());
              dynamicResult.setPic_7(dynamic.get(i).getPic_7());
              dynamicResult.setPic_8(dynamic.get(i).getPic_8());
              dynamicResult.setPic_9(dynamic.get(i).getPic_9());
              dynamicResult.setWords(dynamic.get(i).getWords());
              User user = userMapper.getUserById(dynamic.get(i).getUser_id());
              dynamicResult.setUserHeadPic(user.getHeadPic());
              dynamicResult.setUserName(user.getUserName());
              int PicLength = judgePicLength(dynamicResult);
              dynamicResult.setPicLength(PicLength);
              dynamicResultList.add(dynamicResult);
          }

          return dynamicResultList;
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
        dynamicMapper.createUserDynamic(dynamic);
        int dynamicId  = dynamic.getId();
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

    /**
     * 评论发表
     */
    @RequestMapping("/token/plfb")
    public void plfb(@RequestBody Map<String,String> map,@RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        User user = (User)redisUtil.get(token);
        User newUser = userMapper.getUserById(user.getId());
        String pl = map.get("pl");
        int dynamicId =  Integer.parseInt(map.get("dynamicId"));
        Comment comment = new Comment();
        comment.setPl(pl);
        comment.setUser_dynamic(dynamicId);
        comment.setUser_id(newUser.getId());
        comment.setUser_tx(newUser.getHeadPic());
        comment.setUser_name(newUser.getUserName());
        dynamicMapper.tjpl(comment);
    }
    /**
     * 评论查看
     */
    @RequestMapping("/token/ckpl")
    public List ckpl(@RequestBody Map<String,String> map,@RequestHeader Map<String, String> headers){
     List<Comment> list = dynamicMapper.ckpl(Integer.parseInt(map.get("ckpldtid")));
     return list;
    }


    /**
     * 评论点赞
     */
    @RequestMapping("/token/pldz")
    public String pldz(@RequestBody Map<String,String> map, @RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        User user = (User)redisUtil.get(token);
        GiveUp giveUp = new GiveUp();
        giveUp.setUser_id(user.getId());
        giveUp.setDynamic_id(Integer.parseInt(map.get("dynamicId")));
        int bool = dynamicMapper.ckdzsfcf(giveUp);
        if(bool == 1){
            return "repeat";
        }
        dynamicMapper.pldz(giveUp);
        return "true";
    }
}
