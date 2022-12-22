package com.didi.rlab.uni_customer_business;

import java.util.HashMap;
import java.util.Map;

public class UniAPI {
    public static Map<String, Object> moduleMap = new HashMap();

    public static void registerModule(Object obj) {
        if (obj.getClass().getInterfaces().length == 0) {
            moduleMap.put(obj.getClass().getName(), obj);
        } else {
            moduleMap.put(obj.getClass().getInterfaces()[0].getName(), obj);
        }
    }

    public static <T> T get(Class<T> cls) {
        return moduleMap.get(cls.getName());
    }
}
