package com.bishe.controller;
import com.bishe.bean.User;
import com.bishe.service.Service;
import com.bishe.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileController {
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping("/shopDetailPic")
    public String upload(@RequestParam String userToken,@RequestPart("file") byte[] file) throws IOException {
        User user = (User)redisUtil.get(userToken);
        System.out.println(user);
        String only = UUID.randomUUID()+"";
        System.out.println(only);
        System.out.println("文件上传被执行");
        String path = System.getProperty("user.dir");
        Service.createDir("E:\\毕业设计\\upload\\userId"+user.getId());
        File dir=new File("D:/test");
        String filePath = path + "\\upload\\"+"\\userId"+user.getId()+"\\"+only+".png";
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        FileCopyUtils.copy(file, fileOutputStream);
        return filePath;
    }
    }