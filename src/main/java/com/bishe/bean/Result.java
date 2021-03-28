package com.bishe.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 返回信息风格
 * @author MZW
 */
@Data
public class Result {
    private String message;
    private Map data;
}
