package com.bishe.controller;
import com.bishe.bean.User;
import com.bishe.mapper.ShopMapper;
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
    @Autowired
    ShopMapper shopMapper;

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

    @RequestMapping("/updateShopHeadPic")
    public String shopHeadPic(@RequestParam int shoHeadPicUploadId,@RequestParam String shoHeadPicUploadToken,@RequestPart("file") byte[] file) throws IOException {
        System.out.println(shoHeadPicUploadId);
        System.out.println(shoHeadPicUploadToken);
        User user = (User)redisUtil.get(shoHeadPicUploadToken);
//      System.out.println(user);
        String only = UUID.randomUUID()+"";
//      System.out.println(only);
//      System.out.println("文件上传被执行");
        String path = System.getProperty("user.dir");
        Service.createDir("E:\\upload\\userId"+user.getId());
//        File dir=new File("D:/test");
        String xdPath="\\upload\\"+"\\userId"+user.getId()+"\\"+only+".png";
        String filePath = "E:" + xdPath;
        String sqlHeadPicPath = "/upload"+"/userId"+user.getId()+"/"+only+".png";
        shopMapper.updateShopHeadPic(sqlHeadPicPath,shoHeadPicUploadId);
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        FileCopyUtils.copy(file, fileOutputStream);
        return sqlHeadPicPath;
    }
}