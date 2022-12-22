package com.didi.sdk.pay.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

@Deprecated
public class PaymentSharedPreferencesUtil {

    /* renamed from: a */
    private static SharedPreferences f36891a = null;

    /* renamed from: b */
    private static String f36892b = "payment";

    public static void putBoolean(Context context, String str, boolean z) {
        if (f36891a == null) {
            f36891a = SystemUtils.getSharedPreferences(context, f36892b, 0);
        }
        f36891a.edit().putBoolean(str, z).commit();
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        if (f36891a == null) {
            f36891a = SystemUtils.getSharedPreferences(context, f36892b, 0);
        }
        return f36891a.getBoolean(str, z);
    }

    public static void putString(Context context, String str, String str2) {
        if (f36891a == null) {
            f36891a = SystemUtils.getSharedPreferences(context, f36892b, 0);
        }
        f36891a.edit().putString(str, str2).commit();
    }

    public static String getString(Context context, String str, String str2) {
        if (f36891a == null) {
            f36891a = SystemUtils.getSharedPreferences(context, f36892b, 0);
        }
        return f36891a.getString(str, str2);
    }

    public static void remove(Context context, String str) {
        if (f36891a == null) {
            f36891a = SystemUtils.getSharedPreferences(context, f36892b, 0);
        }
        f36891a.edit().remove(str).commit();
    }
}
