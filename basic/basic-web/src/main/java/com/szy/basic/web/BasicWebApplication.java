package com.szy.basic.web;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableDubbo
@ComponentScan({"com.szy.basic", "com.szy.basic.web.aop","com.szy.basic.dal"})
@SpringBootApplication
public class BasicWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicWebApplication.class, args);
    }

}
