package com.szy.custom.dal.enums;

import lombok.Getter;

/**
 * 已知异常类型枚举
 */
@Getter
public enum ExceptionEnum {

    UNKNOW_ERROR(01, "未知错误"),
    PARAMETER_ERROR(02, "用户不存在"),
    ;

    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
