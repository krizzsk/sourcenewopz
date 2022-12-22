package com.didi.beatles.p099im.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.TextUtils;
import com.didi.beatles.p099im.IMContextInfoHelper;
import java.util.Locale;

/* renamed from: com.didi.beatles.im.utils.IMLocaleUtil */
public class IMLocaleUtil {

    /* renamed from: a */
    private static String f9773a = "";

    public static Context attachBaseContext(Context context) {
        return Build.VERSION.SDK_INT >= 24 ? m6625a(context) : context;
    }

    /* renamed from: a */
    private static Context m6625a(Context context) {
        String str;
        Configuration configuration = IMContextInfoHelper.getContext().getResources().getConfiguration();
        if (f9773a.equals("")) {
            str = configuration.getLocales().get(0).getLanguage();
        } else {
            str = f9773a;
        }
        context.getApplicationContext();
        return m6626a(context, str);
    }

    /* renamed from: a */
    private static Context m6626a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return context;
        }
        Configuration configuration = context.getResources().getConfiguration();
        Locale a = m6627a(str);
        Locale.setDefault(a);
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(a);
        } else {
            configuration.locale = a;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return context.createConfigurationContext(configuration);
        }
        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());
        return context;
    }

    /* renamed from: a */
    private static Locale m6627a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new Locale(str);
        }
        String[] split = str.split("_");
        int length = split.length;
        if (length == 2) {
            return new Locale(split[0], split[1]);
        }
        if (length != 3) {
            return new Locale(str);
        }
        return new Locale(split[0], split[1], split[2]);
    }

    public static void setLanguage(String str) {
        f9773a = str;
    }
}
