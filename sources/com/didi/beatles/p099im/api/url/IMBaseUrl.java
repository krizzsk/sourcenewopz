package com.didi.beatles.p099im.api.url;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.beatles.im.api.url.IMBaseUrl */
public abstract class IMBaseUrl {
    public static final int INTEGRATION_URL_CUS = 100;
    public static final int INTEGRATION_URL_V0 = 11;
    public static final int INTEGRATION_URL_V1 = 12;
    public static final int INTEGRATION_URL_V2 = 13;
    public static final int ONLINE_URL = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.api.url.IMBaseUrl$IMUrlType */
    public @interface IMUrlType {
    }

    public abstract String getCommonHost(int i);

    public String getOffLineIp() {
        return null;
    }

    public abstract String getProfileHost();
}
