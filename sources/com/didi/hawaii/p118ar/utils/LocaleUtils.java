package com.didi.hawaii.p118ar.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.google.gson.Gson;
import java.util.Locale;

/* renamed from: com.didi.hawaii.ar.utils.LocaleUtils */
public class LocaleUtils {
    public static final Locale LOCALE_CHINESE = Locale.CHINESE;
    public static final Locale LOCALE_ENGLISH = Locale.ENGLISH;
    public static final Locale LOCALE_RUSSIAN = Locale.JAPANESE;

    /* renamed from: a */
    private static final String f23318a = "HAWAII_AR_LOCALE_FILE";

    /* renamed from: b */
    private static final String f23319b = "HAWAII_AR_LOCALE_KEY";

    public static Locale getUserLocale(Context context) {
        return m16714a(SystemUtils.getSharedPreferences(context, f23318a, 0).getString(f23319b, ""));
    }

    public static Locale getCurrentLocale(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.getResources().getConfiguration().getLocales().get(0);
        }
        return context.getResources().getConfiguration().locale;
    }

    public static void saveUserLocale(Context context, Locale locale) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, f23318a, 0).edit();
        edit.putString(f23319b, m16713a(locale));
        edit.apply();
    }

    /* renamed from: a */
    private static String m16713a(Locale locale) {
        return new Gson().toJson((Object) locale);
    }

    /* renamed from: a */
    private static Locale m16714a(String str) {
        return (Locale) new Gson().fromJson(str, Locale.class);
    }

    public static void updateLocale(Context context, Locale locale) {
        if (needUpdateLocale(context, locale)) {
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 17) {
                configuration.setLocale(locale);
            } else {
                configuration.locale = locale;
            }
            context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
            saveUserLocale(context, locale);
        }
    }

    public static boolean needUpdateLocale(Context context, Locale locale) {
        return locale != null && !getCurrentLocale(context).equals(locale);
    }
}
