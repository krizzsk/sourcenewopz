package com.didichuxing.diface;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import java.io.PrintStream;
import java.util.Locale;

public class SwitchLangUtil {
    public static void switchLang(Context context, String str) {
        PrintStream printStream = System.out;
        printStream.println("switchLang, newLang====" + str);
        if (TextUtils.isEmpty(str)) {
            str = "en";
        }
        String[] a = m33661a(str);
        Locale locale = new Locale(a[0], a[1]);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    /* renamed from: a */
    private static String[] m33661a(String str) {
        if (str.contains("-")) {
            return str.split("-");
        }
        return new String[]{str, ""};
    }
}
