package com.szy.basic.commons.utils;

import lombok.Getter;

/**
 * 已知异常类型枚举
 */
@Getter
public enum ExceptionEnum {

    UNKNOW_ERROR(01, "未知错误"),
    PARAMETER_NULL_ERROR(02, "入参为空异常"),
    ILLEGAL_PARAMETER_ERROR(03, "非法入参异常"),
    SOURCEFROM_ERROR(04, "非法来源异常"),
    OTHER_RETURN_ERROR(05, "第三方异常"),
    WEB_REQUEST_ERROR(06, "网络传输异常"),
    ;

    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
