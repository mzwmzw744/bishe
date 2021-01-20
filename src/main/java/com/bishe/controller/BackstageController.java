package com.bishe.controller;

import com.bishe.bean.Admin;
import com.bishe.bean.BackstageFormat;
import com.bishe.bean.User;
import com.bishe.mapper.AdminMapper;
import com.bishe.mapper.UserMapper;
import com.bishe.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class BackstageController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/backstage/getAllUserInformation")
    public BackstageFormat userQuery(){
        BackstageFormat backstageFormat = new BackstageFormat();
        List<User> allUserList = userMapper.getAllUser();
        backstageFormat.setCode("0");
        backstageFormat.setMsg("成功");
        backstageFormat.setCount("100");
        backstageFormat.setData(allUserList);
        return backstageFormat;
    }

    @RequestMapping("/backstage/login")
    public String adminLogin(HttpServletRequest request){
        String token;
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String select = request.getParameter("select");
        System.out.println(select);
        if ("0".equals(select)){

        }
        if ("1".equals(select)){

        }
        if ("2".equals(select)){

        }
        System.out.println("管理员登录账号"+account);
        System.out.println("管理员登录密码"+password);
        Admin admin;
        admin = adminMapper.getAdminByName(account);
        System.out.println(admin);
        if(admin == null){
            System.out.println("账号或密码错误");
            return "账号或密码错误";
        }
        if(admin.getPassword().equals(password)) {
            System.out.println("用户"+admin.getName()+"登陆成功");
            token = UUID.randomUUID()+"";
            redisUtil.set(token,admin,1800);
        }else {
            System.out.println("账号或密码错误");
            return "账号或密码错误";
        }
        return token;
    }
    @RequestMapping("/backstage/applyAdmin")
    public String applyAdmin(@RequestBody Map<String,Object> map){
        String account = (String) map.get("account");
        String password = (String)map.get("password");
        String radio1 = (String)map.get("radio1");
        List checkboxChoose;
        checkboxChoose = (List) map.get("checkboxChoose");
        String textarea = (String)map.get("textarea");
        System.out.println(account);
        System.out.println(radio1);
        System.out.println(password);
        System.out.println(checkboxChoose);
        System.out.println(textarea);
        return "123";
    }
}
