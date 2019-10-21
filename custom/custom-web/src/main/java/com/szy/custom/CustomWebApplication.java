package com.szy.custom;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableDubbo
@ComponentScan({"com.szy.custom", "com.szy.custom.web.aop","com.szy.custom.dal"})
@SpringBootApplication
public class CustomWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomWebApplication.class, args);
    }

}
