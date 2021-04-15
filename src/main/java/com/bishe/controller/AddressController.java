package com.bishe.controller;

import com.bishe.bean.Address;
import com.bishe.bean.Admin;
import com.bishe.bean.AdminApply;
import com.bishe.bean.User;
import com.bishe.mapper.AddressMapper;
import com.bishe.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class AddressController {
    @Resource
    AddressMapper addressMapper;
    @Resource
    RedisUtil redisUtil;
    @RequestMapping("/token/addUserAddress")
    public String adminApplyPass(@RequestBody Map<String,Object> map,@RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        System.out.println(token);
        User user = (User)redisUtil.get(token);
        Address address = new Address();
        String addressDetail = (String) map.get("addressDetail");
        String phone = (String) map.get("phone");
        String name = (String) map.get("name");
        String postCode = (String) map.get("postCode");
        String sheng = (String) map.get("sheng");
        String shi = (String) map.get("shi");
        String qu = (String) map.get("qu");
        address.setAddressDetail(addressDetail);
        address.setName(name);
        address.setPostCode(postCode);
        address.setAddress(sheng+shi+qu);
        address.setPhone(phone);
        address.setUser_id(user.getId());
         addressMapper.addUserAddress(address);
        return "成功";
    }
}
