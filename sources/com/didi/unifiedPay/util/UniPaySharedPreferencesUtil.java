package com.didi.unifiedPay.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class UniPaySharedPreferencesUtil {

    /* renamed from: a */
    private static SharedPreferences f44614a = null;

    /* renamed from: b */
    private static String f44615b = "unipay";

    public static void putBoolean(Context context, String str, boolean z) {
        if (f44614a == null) {
            f44614a = SystemUtils.getSharedPreferences(context, f44615b, 0);
        }
        f44614a.edit().putBoolean(str, z).apply();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        if (f44614a == null) {
            f44614a = SystemUtils.getSharedPreferences(context, f44615b, 0);
        }
        return f44614a.getBoolean(str, z);
    }

    public static void putString(Context context, String str, String str2) {
        if (f44614a == null) {
            f44614a = SystemUtils.getSharedPreferences(context, f44615b, 0);
        }
        f44614a.edit().putString(str, str2).apply();
    }

    public static String getString(Context context, String str, String str2) {
        if (f44614a == null) {
            f44614a = SystemUtils.getSharedPreferences(context, f44615b, 0);
        }
        return f44614a.getString(str, str2);
    }

    public static void remove(Context context, String str) {
        if (f44614a == null) {
            f44614a = SystemUtils.getSharedPreferences(context, f44615b, 0);
        }
        f44614a.edit().remove(str).apply();
    }

    public static boolean exist(Context context, String str) {
        if (f44614a == null) {
            f44614a = SystemUtils.getSharedPreferences(context, f44615b, 0);
        }
        return f44614a.contains(str);
    }
}
