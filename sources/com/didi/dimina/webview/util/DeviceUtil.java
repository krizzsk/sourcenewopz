package com.didi.dimina.webview.util;

import android.content.Context;

public final class DeviceUtil {

    /* renamed from: a */
    private static final String f18397a = "DeviceUtil";

    public static String getUUID(Context context) {
        return MD5.toMD5("1_" + WsgSafeUtil.getAndroidId(context) + "2_" + WsgSafeUtil.getDeviceId(context) + "3_" + WsgSafeUtil.getCpuSerialno(context));
    }

    private DeviceUtil() {
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() <= 0 || "null".equals(str);
    }
}
