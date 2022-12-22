package com.didi.entrega.customer.service;

import java.util.HashMap;
import java.util.Map;

public class CustomerServiceHelper {
    public static Map<Class, Class> getRegisterService() {
        HashMap hashMap = new HashMap();
        hashMap.put(IToolsService.class, ToolsService.class);
        hashMap.put(IOneSdkService.class, OneSdkService.class);
        hashMap.put(ILocaleService.class, CustomerLocaleService.class);
        hashMap.put(ISkinService.class, CustomerSkinService.class);
        return hashMap;
    }
}
