package com.sevendream.springbootdemo.utils;

import com.sevendream.springbootdemo.bean.BaseResult;
import com.sevendream.springbootdemo.common.CommonException;
import com.sevendream.springbootdemo.common.ExceptionEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResult handle(Exception e){
        if(e instanceof CommonException){
            System.out.println("属于CommonException");
            CommonException commonException =(CommonException)e;
            return ResultUtils.fail(commonException.getCode(),e.getMessage());
        }
        return ResultUtils.fail(ExceptionEnum.EXCEPTION_FAIL.getCode(),e.getMessage());
    }
}
