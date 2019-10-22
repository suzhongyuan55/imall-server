package com.szy.basic.commons.utils;


/**
 * 返回结果工具类
 */
public class ResultUtil {

    /**
     * 返回成功，传入具体出参
     * @param object
     * @return
     */
    public static ResultData success(Object object){
        ResultData result = new ResultData();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    /**
     * 提供不需回传参数的接口
     * @return
     */
    public static ResultData success(){
        return success(null);
    }

    /**
     * 常规异常类型
     * @param exceptionEnum
     * @return
     */
    public static ResultData exception(ExceptionEnum exceptionEnum){
        ResultData result = new ResultData();
        result.setCode(exceptionEnum.getCode());
        result.setMsg(exceptionEnum.getMsg());
        result.setData(null);
        return result;
    }

    /**
     * 自定义错误类型
     * @param code
     * @param msg
     * @return
     */
    public static ResultData exception(Integer code, String msg){
        ResultData result = new ResultData();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }

}
