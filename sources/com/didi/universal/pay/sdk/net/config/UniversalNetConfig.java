package com.didi.universal.pay.sdk.net.config;

public class UniversalNetConfig {
    public static final String URL_ONLINE_HEAD_GLOBAL = "https://cashier.didiglobal.com";
    public static final String URL_ONLINE_HEAD_MAIN = "";

    /* renamed from: a */
    private static String f45120a = "";

    /* renamed from: b */
    private static final String f45121b = "";

    /* renamed from: c */
    private static final String f45122c = "/gulfstream/pay/v1/client/";

    /* renamed from: d */
    private static final String f45123d = "/gulfstream/pay/v1/didipay/";

    /* renamed from: e */
    private static String f45124e = (f45120a + f45122c);

    /* renamed from: f */
    private static String f45125f = f45122c;

    /* renamed from: g */
    private static String f45126g = (f45120a + f45123d);

    /* renamed from: h */
    private static String f45127h = f45123d;

    /* renamed from: i */
    private boolean f45128i = true;

    /* renamed from: j */
    private boolean f45129j;

    public UniversalNetConfig(boolean z, boolean z2) {
        this.f45129j = z;
        this.f45128i = z2;
    }

    public boolean isOnline() {
        return this.f45128i;
    }

    public void resetDomain(int i) {
        if (i == 1) {
            f45120a = "";
        } else if (i == 2) {
            f45120a = "https://cashier.didiglobal.com";
        }
        f45124e = f45120a + f45122c;
        f45126g = f45120a + f45123d;
    }

    public String getBaseUrl() {
        return this.f45129j ? this.f45128i ? f45124e : f45125f : this.f45128i ? f45126g : f45127h;
    }

    public void setTripSdkOfflineEnv(String str) {
        f45125f = str + f45122c;
    }

    public void setNonTripSdkOfflineEnv(String str) {
        f45127h = str + f45123d;
    }
}
