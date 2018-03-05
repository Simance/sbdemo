package com.doo.sbdemo.exception;

import com.doo.sbdemo.enums.ResultEnum;

/**
 * 自定义异常
 * @author doo at 2018/03/05
 */
public class GirlException extends RuntimeException{
    private Integer code;

    /*
    public GirlException(Integer code, String message) {
        super(message);
        this.code = code;
    }*/

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
