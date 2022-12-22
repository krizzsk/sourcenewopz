package com.didi.safety.god.util;

import com.didi.sdk.apm.SystemUtils;

public class LogUtils {

    /* renamed from: a */
    private static final String f34844a = "SafetyGod";

    private LogUtils() {
    }

    /* renamed from: d */
    public static void m24579d(String str, String str2) {
        com.didichuxing.dfbasesdk.utils.LogUtils.m33564d(str, str2);
    }

    /* renamed from: d */
    public static void m24578d(String str) {
        m24579d("SafetyGod", str);
    }

    /* renamed from: i */
    public static void m24585i(String str, String str2) {
        SystemUtils.log(4, str, str2, (Throwable) null, "com.didi.safety.god.util.LogUtils", 20);
    }

    /* renamed from: i */
    public static void m24584i(String str) {
        m24585i("SafetyGod", str);
    }

    /* renamed from: e */
    public static void m24581e(String str, String str2) {
        SystemUtils.log(6, str, str2, (Throwable) null, "com.didi.safety.god.util.LogUtils", 28);
    }

    /* renamed from: e */
    public static void m24582e(String str, String str2, Throwable th) {
        SystemUtils.log(6, str, str2, th, "com.didi.safety.god.util.LogUtils", 32);
    }

    /* renamed from: e */
    public static void m24580e(String str) {
        m24581e("SafetyGod", str);
    }

    /* renamed from: e */
    public static void m24583e(String str, Throwable th) {
        m24582e("SafetyGod", str, th);
    }

    public static void logStackTrace(Throwable th) {
        com.didichuxing.dfbasesdk.utils.LogUtils.logStackTrace(th);
    }
}
