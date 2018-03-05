package com.doo.sbdemo.enums;

/**
 * 返回结果的code和message的枚举类
 * @author doo at 2018/03/05
 */
public enum ResultEnum {
    UNKONW_ERROR(-1,"位置错误"),
    SUCCESS(1,"成功"),
    PRIMARY(100,"年龄小于10"),
    MIDDLE(101,"年龄大于10小于16");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
