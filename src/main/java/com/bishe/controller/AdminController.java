package com.bishe.controller;

import com.bishe.bean.Admin;
import com.bishe.bean.AdminApply;

import com.bishe.bean.BackstageFormat;
import com.bishe.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    AdminMapper adminMapper;


    @RequestMapping("/test1")
    public String test1(){

        return "成功";
    }



    @RequestMapping("/backstage/adminApplyPass")
    public String adminApplyPass(@RequestBody Map<String,Object> map){
        int deleteID = (int) map.get("ID");
        AdminApply adminApply = adminMapper.adminApplySelectByID(deleteID);
        int i = adminMapper.adminApplyDeleteByID(deleteID);
        if(i > 0) {
            Admin admin = new Admin();
            admin.setName(adminApply.getName());
            admin.setFace("null");
            admin.setPassword(adminApply.getPassword());
            adminMapper.adminInsert(admin);
            System.out.println("管理员添加成功");
        }
        return "成功";
    }

    @RequestMapping("/backstage/adminInformationQuery")
    public BackstageFormat adminInformationQuery(){
        BackstageFormat backstageFormat = new BackstageFormat();
        List<Admin> list = adminMapper.adminInformationQuery();
        backstageFormat.setCode("0");
        backstageFormat.setMsg("成功");
        backstageFormat.setCount("100");
        backstageFormat.setData(list);
        return backstageFormat;
    }
}
