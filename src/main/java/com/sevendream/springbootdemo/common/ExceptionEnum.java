package com.sevendream.springbootdemo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ExceptionEnum {
    EXCEPTION_SUCCESS("000000","成功"),
    EXCEPTION_FAIL("000010","失败")

    ;
    private String code;

    private String desc;
}
