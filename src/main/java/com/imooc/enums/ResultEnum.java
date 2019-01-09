package com.imooc.enums;

/**
 * 异常处理结果（枚举）
 * 统一code和message
 * Created by HD on 2018/7/15.
 */
public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你还在上小学吧"),
    MIDDLE_SCHOOL(101,"你应该已经上初中了")
    ;
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
