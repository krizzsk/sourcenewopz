package com.didi.raven.config;

import java.util.ArrayList;
import java.util.List;

public class RavenConfigKey {
    public static final String APP_ID = "aid";
    public static final String OMEGA_ID = "oid";
    public static final String PHONE = "p";
    public static final String PHONE_ENCRYPT = "pe";
    public static final String U_ID = "uid";
    public static List<String> configKeyList;

    static {
        ArrayList arrayList = new ArrayList();
        configKeyList = arrayList;
        arrayList.add("aid");
        configKeyList.add("oid");
        configKeyList.add("uid");
        configKeyList.add(PHONE);
    }
}
