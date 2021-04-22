package com.bishe.bean;

import lombok.Data;

@Data
public class Comment {
    int id;
    int user_id;
    int user_dynamicId;
    String pl;
    String dz;
}
