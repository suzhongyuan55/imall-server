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
@Component
@PropertySource(value = "classpath:/properties/message.yml")
@ConfigurationProperties(prefix = "yunzhixun.reqparam")
public class MessageReqDto {

    @Value("${sid}")
    private String sid;

    @Value("${token}")
    private String token;

    @Value("${appid}")
    private String appid;

    @Value("${templateid}")
    private String templateid;

    private String param;

    private String mobile;

    private String uid;
}
