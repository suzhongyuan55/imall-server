package com.szy.basic.dal.service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.szy.basic.commons.utils.*;
import com.szy.basic.dal.dto.MessageReqDto;
import com.szy.basic.dal.dto.MessageRespDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class MassageService {

    private static Logger logger = LoggerFactory.getLogger(MassageService.class);

    @Autowired
    private MessageReqDto messageReqDto;

    /**
     * 发送验证码
     * @param reqString
     */
    public ResultData sendCheckCodeMessage(String reqString) {

        JSONObject object = JSONObject.parseObject(reqString);
        String sourceFrom = object.getString("sourceFrom");
        String mobile = object.getString("mobile");
        String checkCode = object.getString("checkCode");

        //入参校验
        if(!"imall".equals(sourceFrom)){
            return ResultUtil.exception(ExceptionEnum.SOURCEFROM_ERROR);
        }

        if(!ParamsUtil.validFieldByFileldName(mobile, checkCode)){
            return ResultUtil.exception(ExceptionEnum.PARAMETER_NULL_ERROR);
        }

        messageReqDto.setMobile(mobile);
        messageReqDto.setParam(checkCode);
        String reqJson = JSONObject.toJSONString(messageReqDto);

        Properties properties = new Properties();
        InputStream inputStream = Object.class.getResourceAsStream("/properties/request_path.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String respJson = null;
        try {
            String url = properties.getProperty("send_checkcode_url");
            logger.info("验证码信息发送请求参数：{},\n请求url：{}", reqJson, url);
            respJson = WebRequest.httpRequest(url, reqJson, null);
            logger.info("验证码信息发送返回参数{}", respJson);
        } catch (Exception e){
            return ResultUtil.exception(ExceptionEnum.WEB_REQUEST_ERROR);
        }

        //返回信息处理
        MessageRespDto messageRespDto = JSONObject.parseObject(respJson, MessageRespDto.class);
        if(!messageRespDto.getCode().equals("000000")){
            return ResultUtil.exception(Integer.parseInt(messageRespDto.getCode()), messageRespDto.getMsg());
        }

        return ResultUtil.success(messageRespDto);
    }
}
