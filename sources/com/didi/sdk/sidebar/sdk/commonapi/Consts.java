package com.didi.sdk.sidebar.sdk.commonapi;

import android.content.Context;
import com.didi.sdk.developermode.DevModeUtil;

public class Consts {
    public static final String COMMON_API_ONLINE_URL = "https://common.didiglobal.com";
    public static final String CONF_API_ONLINE_URL = "https://conf.didiglobal.com";
    public static final String LAW_POP_API_URL = "https://common.didiglobal.com";
    public static final String SIDEBAR_COFNIG = "https://conf.didiglobal.com";
    public static final String SODA_API_ONLINE_URL = "https://c.didi-food.com";

    /* renamed from: a */
    private static final String f37426a = "082102fb74f14fe28aa6d06ed8b5ffe8";

    /* renamed from: b */
    private static final String f37427b = "79216099e4ad4b72a2ed29a1ba04d17e";

    /* renamed from: c */
    private static final String f37428c = "3bf284bbffd74b158ceaa009e9928497";

    /* renamed from: d */
    private static final String f37429d = "f6432f47c1e94ba490ef466f784b2ace";

    public static String getCommonApiByEnviroment(Context context) {
        return "https://common.didiglobal.com";
    }

    public static String getDDriverDomain(Context context) {
        return "";
    }

    public static String getLawPopApiByEnvironment(Context context) {
        return "https://common.didiglobal.com";
    }

    public static String getSodaApiByEnviroment(Context context) {
        return "https://c.didi-food.com";
    }

    public static boolean isTestEnviroment(Context context) {
        return DevModeUtil.DevEnvironment.RELEASE != DevModeUtil.getDevEnvironment(context);
    }

    public static String getDDriverSignSecret(Context context) {
        return isTestEnviroment(context) ? f37429d : f37428c;
    }

    public static String getDDriverAppKey(Context context) {
        return isTestEnviroment(context) ? f37427b : f37426a;
    }
}
