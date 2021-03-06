package com.bishe.controller;
import com.bishe.bean.*;
import com.bishe.mapper.BackstageMapper;
import com.bishe.mapper.UserMapper;
import com.bishe.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;
@RestController
public class BackstageController {
    
    @Autowired
    UserMapper userMapper;

    @Autowired
    BackstageMapper backstageMapper;

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

    @RequestMapping("/backstage/getAllAdminApply")
    public BackstageFormat administratorApply(){
        BackstageFormat backstageFormat = new BackstageFormat();
        List<AdminApply> allApplyList = backstageMapper.getAllAdministratorApply();
        backstageFormat.setCode("0");
        backstageFormat.setMsg("成功");
        backstageFormat.setCount("100");
        backstageFormat.setData(allApplyList);
        return backstageFormat;
    }

    @RequestMapping("/backstage/login")
    public AdminLoginReturn adminLogin(HttpServletRequest request){
        AdminLoginReturn adminLoginReturn= new AdminLoginReturn();
        String token;
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String select = request.getParameter("select");
        System.out.println(select);
        if ("0".equals(select)){
            System.out.println("用户启用超级管理员登录");
            adminLoginReturn.setAddress("0");
        }
        if ("1".equals(select)){
            if ("0".equals(select)){
                System.out.println("用户启用普通管理员登录");
                adminLoginReturn.setAddress("1");
            }
        }
        if ("2".equals(select)){
            if ("0".equals(select)){
                System.out.println("用户启用查询管理员登录");
                adminLoginReturn.setAddress("2");
            }
        }
        System.out.println("管理员登录账号"+account);
        System.out.println("管理员登录密码"+password);
        Admin admin;
        admin = backstageMapper.getAdminByName(account);
        System.out.println(admin);
        if(admin == null){
            System.out.println("账号或密码错误");
            adminLoginReturn.setAddress("账号或密码错误");
            return adminLoginReturn;
        }
        if(admin.getPassword().equals(password)) {
            System.out.println("用户"+admin.getName()+"登陆成功");
            token = UUID.randomUUID()+"";
            redisUtil.set(token,admin,1800);
        }else {
            System.out.println("账号或密码错误");
            adminLoginReturn.setAddress("账号或密码错误");
            return adminLoginReturn;
        }
        adminLoginReturn.setToken(token);

        return adminLoginReturn;
    }
    @RequestMapping("/backstage/applyAdmin")
    public String applyAdmin(@RequestBody Map<String,Object> map){
        List checkboxChoose;
        String account = (String) map.get("account");
        String password = (String)map.get("password");
        String radio1 = (String)map.get("radio1");
        checkboxChoose = (List) map.get("checkboxChoose");
        String textarea = (String)map.get("textarea");
        System.out.println(checkboxChoose);
        System.out.println(account);
        System.out.println(radio1);
        System.out.println(password);
        System.out.println(checkboxChoose);
        System.out.println(textarea);
        AdminApply administratorApply = new AdminApply();
        administratorApply.setName(account);
        administratorApply.setPassword(password);
        administratorApply.setApplyGrade(radio1);
        administratorApply.setApplyRemarks(textarea);
        if("超级管理员".equals(radio1))
            administratorApply.setAddPower("true");
        administratorApply.setDeletePower("true");
        administratorApply.setUpdatePower("true");
        administratorApply.setSelectPower("true");
        if("普通管理员".equals(radio1)){
            administratorApply.setAddPower("false");
            administratorApply.setDeletePower("false");
            administratorApply.setUpdatePower("false");
            administratorApply.setSelectPower("false");
            for(int i = 0;i < checkboxChoose.size();i++) {
                if(checkboxChoose.get(i).equals("增加权限")){
                    administratorApply.setAddPower("true");
                }
                if(checkboxChoose.get(i).equals("删除权限")){
                    administratorApply.setDeletePower("true");
                }
                if(checkboxChoose.get(i).equals("修改权限")){
                    administratorApply.setUpdatePower("true");
                }
                if(checkboxChoose.get(i).equals("查询权限")){
                    administratorApply.setSelectPower("true");
                }
            }
        }
        if("查询管理员".equals(radio1)){
            administratorApply.setAddPower("false");
            administratorApply.setDeletePower("false");
            administratorApply.setUpdatePower("false");
            administratorApply.setSelectPower("false");
        }
        int isAddTrue = backstageMapper.addAdministratorApply(administratorApply);
        if(isAddTrue > 0) {
            return "申请成功,请等待审核";
        }
        return "申请失败，请重新申请";
  }
}
