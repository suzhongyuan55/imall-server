package com.szy.custom.web.remote.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.szy.custom.web.remote.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("custom")
@Service
public class CustomerServiceImpl implements CustomerService {

    private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);


    @ResponseBody
    @RequestMapping("customLogin")
    @Override
    public Map<String, Object> customLogin(@RequestBody String reqString){
        Map result = new HashMap();
        result.put("Result","success");
        return result;
    }

    @ResponseBody
    @RequestMapping("customRegister")
    @Override
    public Map<String, Object> customRegister(String reqString){
        return null;
    }

    @ResponseBody
    @RequestMapping("customLogout")
    @Override
    public Map<String, Object> customLogout(String reqString){
        return null;
    }
}
