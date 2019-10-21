package com.szy.custom.web.remote;

import java.util.Map;

public interface CustomerService {


    public Map<String, Object> customLogin(String reqString);

    public Map<String, Object> customRegister(String reqString);

    public Map<String, Object> customLogout(String reqString);
}
