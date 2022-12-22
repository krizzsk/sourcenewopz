package com.didi.sdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;

public class IMEIPreference {

    /* renamed from: a */
    private static final String f37632a = "imei_";

    public static void saveImeiBySharedPreferences(Context context, String str) {
        SharedPreferences.Editor edit = SystemUtils.getDefaultSharedPreferences(context).edit();
        edit.putString("imei_", str);
        edit.apply();
    }

    public static String getImeiBySharedPreferences(Context context) {
        return SystemUtils.getDefaultSharedPreferences(context).getString("imei_", "");
    }
}
