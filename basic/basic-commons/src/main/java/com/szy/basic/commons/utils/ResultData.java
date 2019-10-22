package com.szy.basic.commons.utils;

import lombok.Data;

/**
 * 统一类型返回值数据
 */
@Data
public class ResultData<T> {

    /**
     * 返回状态 00为成功
     */
    private Integer code;

    /**
     * 返回信息提示 code:00,对应msg：success
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

}
