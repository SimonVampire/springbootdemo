package com.sevendream.springbootdemo.utils;

import com.sevendream.springbootdemo.bean.BaseResult;

public class ResultUtils {

    /**
     * 调用成功
     * @param object
     * @return
     */
    public static BaseResult success(Object object){
        BaseResult result =new BaseResult();
        result.setCode("000000");
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 成功，但无数据返回时
     * @return
     */
    public static BaseResult success(){
        return success(null);
    }

    /**
     * 调用失败
     * @param code
     * @param msg
     * @return
     */
    public static BaseResult fail(String code,String msg){
        BaseResult result =new BaseResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
