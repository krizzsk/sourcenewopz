package com.didiglobal.privacysdk.law.prepose;

import java.util.Locale;

public final class AppUtils {
    public static String getCountryCodeISO3166() {
        return Locale.getDefault().getCountry();
    }
}
