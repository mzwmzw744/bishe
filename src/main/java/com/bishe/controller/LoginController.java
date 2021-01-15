package com.bishe.controller;
import com.bishe.bean.User;
import com.bishe.service.Service;
import com.bishe.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.UUID;

@Controller
@CrossOrigin
public class LoginController {

    @Autowired
    private com.bishe.mapper.UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @ResponseBody
    @RequestMapping("/login")
    public String list(HttpServletRequest request){
        String token;
        String category = request.getParameter("category");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        System.out.println("用户账号类别"+category);
        System.out.println("用户登录账号"+account);
        System.out.println("用户登录密码"+password);
        User user;
        //if(category.equals("userName")) {
        if("userName".equals(category)) {
            user = userMapper.getUserByUserName(account);
        }else {
            user = userMapper.getUserByEmail("account");
        }
        System.out.println(user);
        if(user == null){
            System.out.println("账号或密码错误");
            return "账号或密码错误";
        }
        if(user.getPassword().equals(password)) {
            System.out.println("用户"+user.getUserName()+"登陆成功");
            token = UUID.randomUUID()+"";
            redisUtil.set(token,user,1800);
        }else {
            System.out.println("账号或密码错误");
            return "账号或密码错误";
        }
        return token;
    }

    //  @RequestMapping(value = "/emailRegister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @RequestMapping(value = "/emailRegister")
    @ResponseBody
    public int email(@RequestBody Map<String,String> map) throws GeneralSecurityException, MessagingException {
        System.out.println("email注册服务启动");
        System.out.print("发送到email:");
        System.out.println(map.get("email"));
        Service.emailSendService(map.get("email"));
        System.out.println("发送成功");
        return 1;
    }
    @RequestMapping(value = "/sendEmail")
    @ResponseBody
    public String sendEmail(HttpServletRequest request) throws GeneralSecurityException, MessagingException {
        System.out.println("email发送服务启动");
        System.out.print("发送到email:");
        System.out.println(request.getParameter("email"));
        String code = Service.emailSendService(request.getParameter("email"));
        System.out.println("发送成功");
        return code;
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setEmail(email);
        int isRepeat = userMapper.getUserIsRepeat(user);
        if(isRepeat >= 1) {
            System.out.println("账号或邮箱已被注册！");
            return ("账号或邮箱已被注册！");
        }
        int isTrue = userMapper.addUser(user);
        if(isTrue >= 1) {
            System.out.println("用户已成功注册");
            return "用户已成功注册";
        }else {
            System.out.println("注册失败");
            return "注册失败";
        }
    }
}
