package com.bishe.bean;


import lombok.Data;

@Data
public class User {
    private int id;
    private String email;
    private String userName;
    private String password;
    private String headPic;
    private String balance;
}
