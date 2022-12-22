package com.didi.sdk.resource.warehouse.tools;

import com.didi.sdk.apm.SystemUtils;

public class LogUtil {

    /* renamed from: a */
    private static final String f37122a = "WareHouse_";

    /* renamed from: b */
    private static boolean f37123b = false;

    public static void setDebug(boolean z) {
        f37123b = z;
    }

    public static boolean isDebug() {
        return f37123b;
    }

    /* renamed from: v */
    public static void m26315v(String str, String str2) {
        if (f37123b) {
            SystemUtils.log(2, f37122a + str, str2, (Throwable) null, "com.didi.sdk.resource.warehouse.tools.LogUtil", 20);
        }
    }

    /* renamed from: d */
    public static void m26312d(String str, String str2) {
        if (f37123b) {
            SystemUtils.log(3, f37122a + str, str2, (Throwable) null, "com.didi.sdk.resource.warehouse.tools.LogUtil", 26);
        }
    }

    /* renamed from: i */
    public static void m26314i(String str, String str2) {
        if (f37123b) {
            SystemUtils.log(4, f37122a + str, str2, (Throwable) null, "com.didi.sdk.resource.warehouse.tools.LogUtil", 32);
        }
    }

    /* renamed from: w */
    public static void m26316w(String str, String str2) {
        if (f37123b) {
            SystemUtils.log(5, f37122a + str, str2, (Throwable) null, "com.didi.sdk.resource.warehouse.tools.LogUtil", 38);
        }
    }

    /* renamed from: e */
    public static void m26313e(String str, String str2) {
        if (f37123b) {
            SystemUtils.log(6, f37122a + str, str2, (Throwable) null, "com.didi.sdk.resource.warehouse.tools.LogUtil", 44);
        }
    }
}
