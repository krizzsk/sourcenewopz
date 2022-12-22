package com.megvii.livenessdetection.obf;

import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.megvii.livenessdetection.obf.d */
public final class C20346d {

    /* renamed from: a */
    private static boolean f55804a = false;

    /* renamed from: b */
    private static String f55805b = "MegviiSDK";

    /* renamed from: a */
    public static void m40218a() {
        f55804a = true;
    }

    /* renamed from: b */
    public static void m40221b() {
        f55804a = false;
    }

    /* renamed from: a */
    public static void m40219a(String str) {
        m40223b(f55805b, str);
    }

    /* renamed from: b */
    public static void m40222b(String str) {
        m40220a(f55805b, str);
    }

    /* renamed from: a */
    public static void m40220a(String str, String str2) {
        if (f55804a) {
            if (str == null) {
                str = f55805b;
            }
            String str3 = str;
            if (str2 == null) {
                str2 = "";
            }
            SystemUtils.log(6, str3, str2, (Throwable) null, "com.megvii.livenessdetection.obf.d", 30);
        }
    }

    /* renamed from: b */
    public static void m40223b(String str, String str2) {
        if (f55804a) {
            if (str == null) {
                str = f55805b;
            }
            String str3 = str;
            if (str2 == null) {
                str2 = "";
            }
            SystemUtils.log(3, str3, str2, (Throwable) null, "com.megvii.livenessdetection.obf.d", 36);
        }
    }
}
