package com.didi.payment.base.utils;

import androidx.core.text.TextUtilsCompat;
import java.util.Locale;

public class RTLUtil {
    public static boolean isInRTLMode() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public static boolean isInRTLMode(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }
}
