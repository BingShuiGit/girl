package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * 自定义异常类，继承 RuntimeException，因为spring框架下只对抛出的RuntimeException类型的异常进行回滚
 * Created by HD on 2018/7/15.
 */
public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());    //父类的方法本身就会传入一个message
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
