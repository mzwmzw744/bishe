package com.bishe.bean;

import lombok.Data;

@Data
public class Address {
    int id;
    int user_id;
    String address;
    String addressDetail;
    String postCode;
    String name;
    String phone;
}
