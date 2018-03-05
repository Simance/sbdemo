package com.doo.sbdemo.utils;

import com.doo.sbdemo.domain.Result;

/**
 * 处理返回结果的工具类
 * @author doo at 2018/03/05
 */
public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("成功");
        result.setData(object);
        return  result;
    }
    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

}
