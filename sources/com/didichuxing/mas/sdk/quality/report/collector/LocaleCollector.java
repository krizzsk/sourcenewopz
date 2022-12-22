package com.didichuxing.mas.sdk.quality.report.collector;

import android.content.Context;
import android.text.TextUtils;
import java.util.Locale;
import java.util.TimeZone;

public class LocaleCollector {
    private static Context mContext;
    private static Locale mLocale;

    public static void init(Context context) {
        mContext = context;
        mLocale = Locale.getDefault();
    }

    public static String getLanguageAndCountry() {
        return mLocale.getLanguage() + "-" + mLocale.getCountry();
    }

    public static String getCanonicalCountryCode() {
        String country = mLocale.getCountry();
        if (!TextUtils.isEmpty(country)) {
            return country;
        }
        try {
            return mContext.getResources().getConfiguration().locale.getCountry();
        } catch (Exception unused) {
            return country;
        }
    }

    public static String getTimeZone() {
        return TimeZone.getDefault().getDisplayName();
    }
}
