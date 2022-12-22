package com.didi.dcrypto.util;

import com.global.didi.elvish.Elvish;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class DigitUtils {
    public static String keepNumOfDecimalDigits(double d, int i) {
        double doubleValue = BigDecimal.valueOf(d).setScale(i, RoundingMode.HALF_UP).doubleValue();
        Locale locale = Locale.US;
        return String.format(locale, "%." + i + "f", new Object[]{Double.valueOf(doubleValue)});
    }

    public static String getElvishedCurrency(double d) {
        return Elvish.Companion.getInstance().formatCurrency(Double.valueOf(d), false);
    }
}
