package com.bishe.bean;

import lombok.Data;

import java.util.List;

@Data
public class BackstageFormat {
    private String code;
    private String msg;
    private String count;
    private List data;
}