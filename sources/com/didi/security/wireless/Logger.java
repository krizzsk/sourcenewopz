package com.didi.security.wireless;

import com.didi.sdk.apm.SystemUtils;

public class Logger {

    /* renamed from: a */
    private static boolean f38569a = false;

    /* renamed from: i */
    public static void m27324i(String str, String str2) {
        if (f38569a) {
            SystemUtils.log(4, str, str2, (Throwable) null, "com.didi.security.wireless.Logger", 11);
        }
    }

    /* renamed from: e */
    public static void m27323e(String str, String str2) {
        if (f38569a) {
            SystemUtils.log(6, str, str2, (Throwable) null, "com.didi.security.wireless.Logger", 17);
        }
    }
}
