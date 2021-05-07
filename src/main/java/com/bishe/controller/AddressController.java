package com.bishe.controller;

import com.bishe.bean.*;
import com.bishe.mapper.AddressMapper;
import com.bishe.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class AddressController {
    @Resource
    AddressMapper addressMapper;
    @Resource
    RedisUtil redisUtil;
    @RequestMapping("/token/addUserAddress")
    public String addUserAddress(@RequestBody Map<String,Object> map,@RequestHeader Map<String, String> headers){
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
        address.setSheng(sheng);
        address.setShi(shi);
        address.setQu(qu);
        address.setPhone(phone);
        address.setUser_id(user.getId());
//        Address addresss = addressMapper.getUserAddress(user.getId());
//        if(addresss != null) {
//            addressMapper.deleteUserAddress(user.getId());
//        }
        addressMapper.addUserAddress(address);
        return "成功";
    }
    @RequestMapping("/token/getUserAddress")
    public List getUserAddress(@RequestBody Map<String,Object> map,@RequestHeader Map<String, String> headers){
        String token = headers.get("token");
        System.out.println(token);
        User user = (User)redisUtil.get(token);
        List<Address> address = addressMapper.getUserAddress(user.getId());
        return address;
    }
    @RequestMapping("/token/getAddressShengTj")
    public List<AddressShengTj> getAddressShengTj(@RequestBody Map<String,Object> map,@RequestHeader Map<String, String> headers){
        List<AddressShengTj> list = addressMapper.getAddressShengTj();
        return list;
    }
}
