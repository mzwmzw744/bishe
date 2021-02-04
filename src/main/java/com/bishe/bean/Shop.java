package com.bishe.bean;

import lombok.Data;

@Data
public class Shop {
    private int id;
    private int userID;
    private String shopName;
    private double shopPrice;
    private String shopFamily;
    private String shopIntroduction;
    private String shopHeadPicture;
    private String auditStatus;
    private String createDate;
}
