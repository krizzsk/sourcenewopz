package com.didi.foundation.sdk.utils;

import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import androidx.core.p006os.LocaleListCompat;
import java.util.Locale;

public class LocaleUtils {
    public static Locale defaultConfigLocale;
    public static boolean isDubug = false;
    public static boolean isGlobal = false;

    static {
        initCofnigLocale();
    }

    public static Locale tagToLocale(String str) {
        return LocaleListCompat.forLanguageTags(str.replace("_", "-")).get(0);
    }

    public static String localeToTag(Locale locale) {
        return LocaleListCompat.create(locale).toLanguageTags();
    }

    public static void initCofnigLocale() {
        defaultConfigLocale = getDefaultLocale();
    }

    public static Locale getDefaultLocale() {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleList.getDefault().get(0);
        }
        return Locale.getDefault();
    }

    public static boolean equalLocales(Locale locale, Locale locale2) {
        return locale.getLanguage().startsWith(locale2.getLanguage());
    }

    public static boolean equalLocales(String str, String str2) {
        return equalLocales(tagToLocale(str), tagToLocale(str2));
    }

    public static Locale getSysLocale() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = Resources.getSystem().getConfiguration().getLocales().get(0);
        } else {
            locale = Resources.getSystem().getConfiguration().locale;
        }
        return locale == null ? new Locale("en-US") : locale;
    }

    public static String getSysLocaleTag() {
        return localeToTag(getSysLocale());
    }
}
