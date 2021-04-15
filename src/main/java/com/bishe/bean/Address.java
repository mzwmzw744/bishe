package com.bishe.bean;

import lombok.Data;

@Data
public class Address {
    int id;
    int user_id;
    String sheng;
    String shi;
    String qu;
    String addressDetail;
    String postCode;
    String name;
    String phone;
}
