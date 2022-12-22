package com.adyen.checkout.core.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.adyen.checkout.core.exception.NoConstructorException;
import java.util.Locale;

public final class LocaleUtil {

    /* renamed from: a */
    private static final String f947a = "_";

    public static Locale getLocale(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.getResources().getConfiguration().getLocales().get(0);
        }
        return context.getResources().getConfiguration().locale;
    }

    public static String toLanguageTag(Locale locale) {
        return locale.getLanguage() + "_" + locale.getCountry();
    }

    public static Locale fromLanguageTag(String str) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("_");
            if (split.length == 1) {
                if (Build.VERSION.SDK_INT >= 21) {
                    return new Locale.Builder().setLanguage(split[0]).build();
                }
                return new Locale(split[0]);
            } else if (split.length < 2) {
                throw new IllegalArgumentException("Unexpected language tag - " + str);
            } else if (Build.VERSION.SDK_INT >= 21) {
                return new Locale.Builder().setLanguage(split[0]).setRegion(split[1]).build();
            } else {
                return new Locale(split[0], split[1]);
            }
        } else {
            throw new IllegalArgumentException("Locale tag is empty or null.");
        }
    }

    private LocaleUtil() {
        throw new NoConstructorException();
    }
}
