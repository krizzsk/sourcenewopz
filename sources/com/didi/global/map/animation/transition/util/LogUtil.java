package com.didi.global.map.animation.transition.util;

import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;

public class LogUtil {

    /* renamed from: a */
    private static final String f22835a = "sfs";

    /* renamed from: i */
    public static void m16420i(String str) {
        if (!TextUtils.isEmpty(str)) {
            SystemUtils.log(3, f22835a, str, (Throwable) null, "com.didi.global.map.animation.transition.util.LogUtil", 15);
        }
    }

    /* renamed from: w */
    public static void m16421w(String str) {
        if (!TextUtils.isEmpty(str)) {
            SystemUtils.log(5, f22835a, str, (Throwable) null, "com.didi.global.map.animation.transition.util.LogUtil", 21);
        }
    }

    /* renamed from: e */
    public static void m16419e(String str) {
        if (!TextUtils.isEmpty(str)) {
            SystemUtils.log(6, f22835a, str, (Throwable) null, "com.didi.global.map.animation.transition.util.LogUtil", 27);
        }
    }
}
