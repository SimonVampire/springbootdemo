package com.sevendream.springbootdemo.common;

import lombok.Data;

@Data
public class CommonException extends RuntimeException {
    private String code;

    public CommonException( String code,String message) {
        super(message);
        this.code = code;
    }
}
