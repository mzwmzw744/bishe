package com.bishe.controller;
import com.bishe.bean.ShopMainPicture;
import com.bishe.bean.User;
import com.bishe.mapper.ShopMapper;
import com.bishe.mapper.UserMapper;
import com.bishe.service.Service;
import com.bishe.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class FileController {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    ShopMapper shopMapper;
    @Resource
    UserMapper userMapper;

    @RequestMapping("/dynamicPic")
    public String dynamicPic(@RequestParam String shoHeadPicUploadToken,@RequestPart("file") byte[] file,@RequestPart("file") MultipartFile files) throws IOException {
        String name = files.getOriginalFilename();
        int length = name.length();
        String hz = name.substring(length-4, length);
        User user = (User)redisUtil.get(shoHeadPicUploadToken);
        String only = UUID.randomUUID()+"";
        return getString(file, user, only,hz);
    }

    @RequestMapping("/userHeadPicUpload")
    public String userHeadPicUpload(@RequestParam String token,@RequestPart("file") byte[] file,@RequestPart("file") MultipartFile files) throws IOException {
        String name = files.getOriginalFilename();
        int length = name.length();
        String hz = name.substring(length-4, length);
        System.out.println(token);
        User user = (User)redisUtil.get(token);
        String only = UUID.randomUUID()+"";
        String url = getString(file, user, only,hz);
        user.setHeadPic(url);
        userMapper.userHeadPicUpdate(user);
        return getString(file, user, only,hz);
    }

    @RequestMapping("/shopDetailPic")
    public String upload(@RequestParam String shoHeadPicUploadToken,@RequestPart("file") byte[] file,@RequestPart("file") MultipartFile files) throws IOException {
        String name = files.getOriginalFilename();
        int length = name.length();
        String hz = name.substring(length-4, length);
        User user = (User)redisUtil.get(shoHeadPicUploadToken);
        String only = UUID.randomUUID()+"";
        return getString(file, user, only,hz);
    }

    @RequestMapping("/updateShopHeadPic")
    public String shopHeadPic(@RequestParam String shoHeadPicUploadToken,@RequestPart("file") byte[] file,@RequestPart("file") MultipartFile files) throws IOException {
        String name = files.getOriginalFilename();
        int length = name.length();
        String hz = name.substring(length-4, length);
        User user = (User)redisUtil.get(shoHeadPicUploadToken);
        String only = UUID.randomUUID()+"";
        return getString(file, user, only,hz);
    }

    private String getString(@RequestPart("file") byte[] file, User user, String only,String hz) throws IOException {
        Service.createDir("upload\\userId"+user.getId());
        String xdPath="upload\\"+"\\userId"+user.getId()+"\\"+only+hz;
        String sqlHeadPicPath = "/upload"+"/userId"+user.getId()+"/"+only+hz;
        FileOutputStream fileOutputStream = new FileOutputStream(xdPath);
        FileCopyUtils.copy(file, fileOutputStream);
        return sqlHeadPicPath;

        //       Linux系统下的配置
        //       Service.createDir("/home/image/upload/userId"+user.getId());
        //        String xdPath="/home/image/upload/userId"+user.getId()+"/"+only+".png";
        //        String sqlHeadPicPath = "/upload"+"/userId"+user.getId()+"/"+only+".png";
        //        FileOutputStream fileOutputStream = new FileOutputStream(xdPath);
        //        FileCopyUtils.copy(file, fileOutputStream);
        //        return sqlHeadPicPath;
    }
}