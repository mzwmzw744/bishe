package com.bishe.service;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

@Component
public class Service {
    /**
     * 邮箱发送服务，发送六位验证码
     * @param email 要发送的邮箱地址
     * @throws MessagingException
     * @throws GeneralSecurityException
     */
    public static String  emailSendService(String  email) throws MessagingException, GeneralSecurityException {
        Properties prop = new Properties();

        String code;
        prop.setProperty("mail.host", "smtp.qq.com");  //设置QQ邮件服务
        prop.setProperty("mail.transport.protocol", "smtp"); // 邮件发送协议
        prop.setProperty("mail.smtp.auth", "true"); // 需要验证用户名密码
        // 关于QQ邮箱，还要设置SSL加密，加上以下代码即可
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        //使用JavaMail发送邮件的5个步骤
        //创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、授权码
                return new PasswordAuthentication("1163974499@qq.com", "vrfhgnctsrcebaah");
            }
        });
        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);

        //2、通过session得到transport对象
        Transport ts = session.getTransport();

        //3、使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.qq.com", "1163974499@qq.com", "tggbflpppzjzhfgj");

        //4、创建邮件

        //创建邮件对象
        MimeMessage message = new MimeMessage(session);

        //指明邮件的发件人
        message.setFrom(new InternetAddress("1163974499@qq.com"));

        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

        //邮件的标题
        message.setSubject("汉服圈邮箱验证码");


        //邮件的文本内容,发送六位验证码

        code = Service.smsCode();

        String Tips = "您的验证码为    "+code+"    请妥善处理，不要交予他人";

        message.setContent(Tips, "text/html;charset=UTF-8");

        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());

        ts.close();

        return code;
    }

    /**
     * 随机生成一个六位数
     * @return 随机六位数
     */
    public static String smsCode(){
        String random=(int)((Math.random()*9+1)*100000)+"";
        System.out.println("创建的验证码为："+random);
        return random;
    }


    /**
     * 获取北京时间
     * @return 北京时间
     */
    public static String getBJTime(){
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        Date time = calendar.getTime();
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = data.format(time);
        System.out.println(format);
        return format;

    }

    public static void createDir(String strPath) throws IOException {

        File file=new File(strPath);
        boolean flag=false;
        flag=file.mkdir();
        System.out.println(flag);


//        File file = new File(strPath);
//        if(!file.getParentFile().exists()){//判断文件夹在不在
//            file.getParentFile().mkdirs();//文件夹不在 创建文件夹
//        }
//        if(!file.exists()){  //判断文件是否存在 不存在创建一个文件
//            file.createNewFile();
//        }
    }

}
