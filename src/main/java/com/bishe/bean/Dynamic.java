package com.bishe.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;


@Data
public class Dynamic {
     int id;
     int user_id;
     String words;
     String pic_1;
     String pic_2;
     String pic_3;
     String pic_4;
     String pic_5;
     String pic_6;
     String pic_7;
     String pic_8;
     String pic_9;
     String createTime;
}
