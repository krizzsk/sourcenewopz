package com.didichuxing.afanty.common.collector;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import java.util.UUID;

public class UserInfoCollector {

    /* renamed from: a */
    private static Context f45563a = null;

    /* renamed from: b */
    private static SharedPreferences f45564b = null;

    /* renamed from: c */
    private static final String f45565c = "omega_user_info";

    /* renamed from: d */
    private static final String f45566d = "omega_id";

    public static void init(Context context) {
        f45563a = context;
    }

    public static String getOmegaId() {
        try {
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(f45563a, "omega_user_info", 0);
            f45564b = sharedPreferences;
            String string = sharedPreferences.getString("omega_id", "");
            if (string.isEmpty()) {
                string = UUID.randomUUID().toString();
                f45564b.edit().putString("omega_id", string).commit();
            }
            return string;
        } catch (Exception unused) {
            return "";
        }
    }

    public static Long getSeq(String str) {
        Long.valueOf(0);
        try {
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(f45563a, "omega_user_info", 0);
            f45564b = sharedPreferences;
            Long valueOf = Long.valueOf(sharedPreferences.getLong(str, 0) + 1);
            f45564b.edit().putLong(str, valueOf.longValue()).commit();
            return valueOf;
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
