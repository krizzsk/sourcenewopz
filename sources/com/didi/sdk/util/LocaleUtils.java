package com.didi.sdk.util;

import android.text.TextUtils;

public class LocaleUtils {
    public static String getLanguage(String str) {
        return splitLocale(str, 0);
    }

    public static String getCountryCode(String str) {
        return splitLocale(str, 1);
    }

    public static String splitLocale(String str, int i) {
        try {
            return str.split("-")[i];
        } catch (Exception unused) {
            return "";
        }
    }

    public static String convertLang2Locale(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("-");
        if (split.length != 2) {
            return str;
        }
        return split[0] + "_" + split[1];
    }
}
