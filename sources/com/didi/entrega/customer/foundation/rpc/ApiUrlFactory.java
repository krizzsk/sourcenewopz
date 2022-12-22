package com.didi.entrega.customer.foundation.rpc;

public final class ApiUrlFactory {
    public static final String CUSTOMER_API_COMMON = "https://common.didiglobal.com";
    public static final String CUSTOMER_API_HTTPS_ONLINE = "https://entrega.didi-food.com";

    /* renamed from: a */
    private static final String f19946a = "https://shepherd.didiglobal.com/";

    public static String getCommonApiDomain() {
        return "https://common.didiglobal.com";
    }

    public static String getCustomerApiDomain() {
        return CUSTOMER_API_HTTPS_ONLINE;
    }

    public static String getMsgApiDomain() {
        return f19946a;
    }

    private ApiUrlFactory() {
    }
}
