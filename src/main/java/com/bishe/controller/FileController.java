package com.bishe.controller;


import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileController {
    @RequestMapping("/upload")
    public String upload(@RequestPart("file") byte[] file) throws IOException {
        String only = UUID.randomUUID()+"";
        System.out.println(only);
        System.out.println("文件上传被执行");
        String path = System.getProperty("user.dir");
        String filePath = path + "\\upload\\"+only;
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        FileCopyUtils.copy(file, fileOutputStream);
        return filePath;
    }
}