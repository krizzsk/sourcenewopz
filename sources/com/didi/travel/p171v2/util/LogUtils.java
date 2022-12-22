package com.didi.travel.p171v2.util;

import com.didi.sdk.apm.SystemUtils;
import com.didi.travel.p171v2.TravelSDKV2;

/* renamed from: com.didi.travel.v2.util.LogUtils */
public class LogUtils {
    /* renamed from: v */
    public static void m31494v(String str, String str2) {
        if (TravelSDKV2.isDebug()) {
            SystemUtils.log(2, TravelSDKV2.TAG + "." + str, str2, (Throwable) null, "com.didi.travel.v2.util.LogUtils", 11);
        }
    }

    /* renamed from: d */
    public static void m31491d(String str, String str2) {
        if (TravelSDKV2.isDebug()) {
            SystemUtils.log(3, TravelSDKV2.TAG + "." + str, str2, (Throwable) null, "com.didi.travel.v2.util.LogUtils", 17);
        }
    }

    /* renamed from: i */
    public static void m31493i(String str, String str2) {
        if (TravelSDKV2.isDebug()) {
            SystemUtils.log(4, TravelSDKV2.TAG + "." + str, str2, (Throwable) null, "com.didi.travel.v2.util.LogUtils", 23);
        }
    }

    /* renamed from: w */
    public static void m31495w(String str, String str2) {
        if (TravelSDKV2.isDebug()) {
            SystemUtils.log(5, TravelSDKV2.TAG + "." + str, str2, (Throwable) null, "com.didi.travel.v2.util.LogUtils", 29);
        }
    }

    /* renamed from: e */
    public static void m31492e(String str, String str2) {
        if (TravelSDKV2.isDebug()) {
            SystemUtils.log(6, TravelSDKV2.TAG + "." + str, str2, (Throwable) null, "com.didi.travel.v2.util.LogUtils", 35);
        }
    }
}
