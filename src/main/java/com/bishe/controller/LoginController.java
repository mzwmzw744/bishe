package com.bishe.controller;

import com.bishe.bean.Test;
import com.bishe.bean.User;
import com.bishe.service.Service;
import com.bishe.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.Map;
import java.util.UUID;

@Controller
@CrossOrigin
public class LoginController {

    @Autowired
    private com.bishe.mapper.UserMapper userMapper;

    @Autowired
    private Service service;

    @Autowired
    private RedisUtil redisUtil;

    @ResponseBody
    @RequestMapping("/login")
    public String list(HttpServletRequest request){
        String token = null;
        String category = request.getParameter("category");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        System.out.println("用户账号类别"+category);
        System.out.println("用户登录账号"+account);
        System.out.println("用户登录密码"+password);
        if(category.equals("phone")) {
            User user = userMapper.getUserByPhone(account);
            if(user.getPassword().equals(password)) {
                System.out.println("用户"+user.getUsername()+"登陆成功");
                token = UUID.randomUUID()+"";
                redisUtil.set(token,user,1800);
            }else {
                System.out.println("登陆失败");
            }
        }
        if(category.equals("email")) {
            User user = userMapper.getUserByEmail("account");
            if(user.getPassword().equals(password)) {
                System.out.println("用户"+user.getUsername()+"登陆成功");
                token = UUID.randomUUID()+"";
                redisUtil.set(token,user,1800);
            }else {
                System.out.println("登陆失败");
            }
        }
//        User user = (User)redisUtil.get(token);
//        System.out.println(user.getUsername());

       return token;
    }

//  @RequestMapping(value = "/emailRegister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @RequestMapping(value = "/emailRegister")
    @ResponseBody
    public int email(@RequestBody Map<String,String> map) throws GeneralSecurityException, MessagingException {
        System.out.println("email注册服务启动");
        System.out.print("发送到email:");
        System.out.println(map.get("email"));
        service.emailSendService( map.get("email"));
        System.out.println("发送成功");
        return 1;
    }


    @RequestMapping("/Test")
    public String Test(HttpServletRequest request){


        return "/Test";
    }
}
