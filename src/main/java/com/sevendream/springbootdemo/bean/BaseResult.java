package com.sevendream.springbootdemo.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = -3997303214175793832L;
    private String code;
    private String msg;
    private T data;
}
