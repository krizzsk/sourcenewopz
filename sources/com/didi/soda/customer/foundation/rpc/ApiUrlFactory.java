package com.didi.soda.customer.foundation.rpc;

import android.text.TextUtils;
import com.didi.soda.customer.debug.CustomerToolBoxUtil;
import com.didi.soda.customer.foundation.util.StringUtils;

public final class ApiUrlFactory {
    public static final String CUSTOMER_API_COMMON = "https://common.didiglobal.com";
    public static final String CUSTOMER_API_HTTPS_ONLINE = "https://c.didi-food.com";
    public static final String GLOBAL_CUSTOMER_LONG_CONNT_HOST = "csoda-push-us01.didiglobal.com";
    public static final int GLOBAL_CUSTOMER_LONG_CONNT_PORT = 25269;
    public static final String GLOBAL_CUSTOMER_PUSH_IP_ONLINE = "https://msggate.didiglobal.com/server/idcollector/p_cidcollector";
    public static final String HTTP_DNS_ONLINE = "https://hd.99taxis.mobi/d?";
    public static final String OMEGA_HOST_ONLINE = "omgup.didiglobal.com";
    public static final String UPGRADE_HOST_ONLINE = "https://apm.didiglobal.com";

    /* renamed from: a */
    private static final String f40965a = "https://shepherd.didiglobal.com/";

    /* renamed from: b */
    private static final String f40966b = "https://act-api.didi-food.com/";

    /* renamed from: c */
    private static final String f40967c = "http://msggate.didiglobal.com/";

    /* renamed from: d */
    private static final String f40968d = "https://skydome-broker.didi-food.com/";

    public static String getActApiDomain() {
        return f40966b;
    }

    public static String getBrokerApiDomain() {
        return f40968d;
    }

    public static String getCommonApiDomain() {
        return "https://common.didiglobal.com";
    }

    public static String getMsgApiDomain() {
        return f40965a;
    }

    public static String getMsgGateApiDomain() {
        return f40967c;
    }

    private ApiUrlFactory() {
    }

    public static String getCustomerApiDomain() {
        if (!CustomerToolBoxUtil.DEBUG) {
            return "https://c.didi-food.com";
        }
        String hostApi = CustomerToolBoxUtil.getHostApi();
        return (TextUtils.isEmpty(hostApi) || !StringUtils.isUrlValid(hostApi)) ? "https://c.didi-food.com" : hostApi;
    }
}
