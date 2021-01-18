package com.bishe.controller;

import com.bishe.bean.BackstageFormat;
import com.bishe.bean.User;
import com.bishe.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class backstageController {

    @Autowired
    UserMapper userMapper;

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
}
