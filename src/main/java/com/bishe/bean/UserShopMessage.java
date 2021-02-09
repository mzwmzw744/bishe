package com.bishe.bean;

import lombok.Data;

import java.util.List;

@Data
public class UserShopMessage {
    private int account;
    private List<Shop> shops;
}
