package com.szy.basic.commons.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

public class ParamsUtil {

    private static Logger logger = LoggerFactory.getLogger(ParamsUtil.class);

    /**
     * 校验对象属性均不能为空!
     *
     * @param obj
     * @return
     * @author DengYang
     */
    public static boolean validField(Object obj) throws IllegalAccessException {
        if (obj == null)
            ResultUtil.exception(ExceptionEnum.PARAMETER_NULL_ERROR);
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (StringUtils.isEmpty(field.get(obj))) {
                logger.error("==> " + field.getName() + "不能为空!");
                throw new IllegalAccessException(field.getName() + "不能为空!");
            }
        }
        return true;
    }


    /**
     * 指定字段名字,校验对象属性不能为空!
     *
     * @return
     * @author DengYang
     */
    public static boolean validFieldByFileldName(String... fieldName) {
        if (fieldName == null || fieldName.length < 1) {
            ResultUtil.exception(ExceptionEnum.PARAMETER_NULL_ERROR);
        }
        for (String name : fieldName) {
            if (StringUtils.isEmpty(name)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 过滤掉字段后,校验剩余对象属性不能为空!
     *
     * @param obj
     * @return
     * @author DengYang
     */
    public static boolean validFieldWithFilter(Object obj, String... filterField) throws IllegalAccessException {
        if (obj == null)
            return false;
        if (filterField == null || filterField.length < 1) {
            ResultUtil.exception(ExceptionEnum.PARAMETER_NULL_ERROR);
        }
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            for (String filter : filterField) {
                if (field.getName().equals(filter))
                    continue;
                if (StringUtils.isEmpty(field.get(obj))) {
                    logger.error("==> " + field.getName() + "不能为空!");
                    ResultUtil.exception(ExceptionEnum.PARAMETER_NULL_ERROR);
                }
            }
        }
        return true;
    }
}
