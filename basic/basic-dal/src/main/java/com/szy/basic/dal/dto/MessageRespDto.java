package com.szy.basic.dal.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 短信请求实体
 */
@Data
public class MessageRespDto {

    private String code;

    private String msg;

    private String count;

    private String create_date;

    private String smsid;

    private String mobile;

    private String uid;
}
