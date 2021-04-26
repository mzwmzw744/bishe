package com.bishe.bean;

import lombok.Data;

@Data
public class BuyOrder {
    int id;
    int shop_id;
    int buy_user_id;
    String address_id;
    String createTime;
}
