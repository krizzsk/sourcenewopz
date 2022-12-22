package com.didi.global.fintech.cashier.core.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class GlobalCashierSPUtil {

    /* renamed from: a */
    private static SharedPreferences f21491a = null;

    /* renamed from: b */
    private static String f21492b = "cashier";

    public static void putBoolean(Context context, String str, boolean z) {
        if (f21491a == null) {
            f21491a = SystemUtils.getSharedPreferences(context, f21492b, 0);
        }
        f21491a.edit().putBoolean(str, z).apply();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        if (f21491a == null) {
            f21491a = SystemUtils.getSharedPreferences(context, f21492b, 0);
        }
        return f21491a.getBoolean(str, z);
    }

    public static void putString(Context context, String str, String str2) {
        if (f21491a == null) {
            f21491a = SystemUtils.getSharedPreferences(context, f21492b, 0);
        }
        f21491a.edit().putString(str, str2).apply();
    }

    public static String getString(Context context, String str, String str2) {
        if (f21491a == null) {
            f21491a = SystemUtils.getSharedPreferences(context, f21492b, 0);
        }
        return f21491a.getString(str, str2);
    }

    public static void remove(Context context, String str) {
        if (f21491a == null) {
            f21491a = SystemUtils.getSharedPreferences(context, f21492b, 0);
        }
        f21491a.edit().remove(str).apply();
    }

    public static boolean exist(Context context, String str) {
        if (f21491a == null) {
            f21491a = SystemUtils.getSharedPreferences(context, f21492b, 0);
        }
        return f21491a.contains(str);
    }
}
