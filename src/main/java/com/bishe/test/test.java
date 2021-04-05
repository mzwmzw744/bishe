package com.bishe.test;

import com.bishe.bean.User;
import com.bishe.service.Service;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.UUID;

public class test {
    public static void main(String[] args) {

//      System.out.println(user);
        String only = UUID.randomUUID()+"";
//      System.out.println(only);
//      System.out.println("文件上传被执行");
        String path = System.getProperty("user.dir");
        try {
            Service.createDir("upload\\userId");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        File dir=new File("D:/test");
//        String filePath = "E:" + xdPath;

//        shopMapper.updateShopHeadPic(sqlHeadPicPath,shoHeadPicUploadId);


    }
}
