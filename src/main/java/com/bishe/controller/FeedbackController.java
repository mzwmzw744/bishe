package com.bishe.controller;

import com.bishe.bean.Feedback;
import com.bishe.bean.User;
import com.bishe.mapper.FeedbackMapper;
import com.bishe.util.RedisUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class FeedbackController {

    @Resource
    FeedbackMapper feedbackMapper;
    @Resource
    RedisUtil redisUtil;
    /**
     * 新增反馈
     */
    @RequestMapping("/feedback")
    public void addFeedback(@RequestBody Map map, @RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        User user = (User)redisUtil.get(token);
        feedbackMapper.addFeedback(user.getId(), (String) map.get("word"));
    }
    /**
     * 获取反馈按最新时间排序
     */
    @RequestMapping("/getFeedback")
    public List<Feedback>  getFeedback(@RequestBody Map map){
        List<Feedback> list = feedbackMapper.getFeedback();
        return list;
    }
}
