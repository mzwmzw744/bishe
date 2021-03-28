package com.bishe.controller;
import com.bishe.bean.ShopMainPicture;
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
import java.util.List;
import java.util.UUID;

@RestController
public class FileController {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    ShopMapper shopMapper;

    @RequestMapping("/shopDetailPic")
    public String upload(@RequestParam int number,@RequestParam int shoHeadPicUploadId, @RequestParam String shoHeadPicUploadToken,@RequestPart("file") byte[] file) throws IOException {
        number = number+1;
        System.out.println(number);
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
        ShopMainPicture shopMainPicture = shopMapper.getAllShopPicByShopId(shoHeadPicUploadId);

//        if(number == 1){
//            shopMapper.updateShopMainPic_1(sqlHeadPicPath,shoHeadPicUploadId);
//        }
//        if(number == 2){
//            shopMapper.updateShopMainPic_2(sqlHeadPicPath,shoHeadPicUploadId);
//        }
//        if(number == 3){
//            shopMapper.updateShopMainPic_3(sqlHeadPicPath,shoHeadPicUploadId);
//        }
//        if(number == 4){
//            shopMapper.updateShopMainPic_4(sqlHeadPicPath,shoHeadPicUploadId);
//        }
//        if(number == 5){
//            shopMapper.updateShopMainPic_5(sqlHeadPicPath,shoHeadPicUploadId);
//        }
//        if(number == 6){
//            shopMapper.updateShopMainPic_6(sqlHeadPicPath,shoHeadPicUploadId);
//        }
//        if(number == 7){
//            shopMapper.updateShopMainPic_7(sqlHeadPicPath,shoHeadPicUploadId);
//        }
//        if(number == 8){
//            shopMapper.updateShopMainPic_8(sqlHeadPicPath,shoHeadPicUploadId);
//        }
//        if(number == 9){
//            shopMapper.updateShopMainPic_9(sqlHeadPicPath,shoHeadPicUploadId);
//        }
//        if(number == 10){
//            shopMapper.updateShopMainPic_10(sqlHeadPicPath,shoHeadPicUploadId);
//        }

//      shopMapper.updateShopHeadPic(sqlHeadPicPath,shoHeadPicUploadId);
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        FileCopyUtils.copy(file, fileOutputStream);
        return sqlHeadPicPath;
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
//        shopMapper.updateShopHeadPic(sqlHeadPicPath,shoHeadPicUploadId);
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        FileCopyUtils.copy(file, fileOutputStream);
        return sqlHeadPicPath;
    }




}