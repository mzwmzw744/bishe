package com.bishe.bean;

import lombok.Data;

@Data
public class Comment {
    int id;
    int user_id;
    int user_dynamic;
    String pl;
    String user_tx;
    String user_name;
}
