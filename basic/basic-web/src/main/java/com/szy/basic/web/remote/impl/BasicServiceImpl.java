package com.szy.basic.web.remote.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.szy.basic.commons.utils.ResultData;
import com.szy.basic.dal.service.MassageService;
import com.szy.basic.web.remote.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Service
@RequestMapping("basicService")
public class BasicServiceImpl implements BasicService {

    @Autowired
    private MassageService massageService;

    @RequestMapping("sendMessage")
    @ResponseBody
    @Override
    public Object sendMessage(@RequestBody String reqString){
        ResultData resultData = massageService.sendCheckCodeMessage(reqString);
        return resultData;
    }
}
