package com.didi.component.common.util;

import com.global.didi.elvish.Elvish;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DecimalUtils {
    public static String formatDecimal(float f, int i) {
        String str = "0" + Elvish.Companion.getInstance().getDecimalSymbol();
        for (int i2 = 0; i2 < i; i2++) {
            str = str + "0";
        }
        return new DecimalFormat(str, DecimalFormatSymbols.getInstance(Locale.US)).format((double) f);
    }

    public static String getStandardAmountString(String str) {
        if (str == null) {
            return "";
        }
        Number parseBigDecimalSafely = Elvish.Companion.getInstance().parseBigDecimalSafely(str, (Number) null);
        if (parseBigDecimalSafely instanceof BigDecimal) {
            return parseBigDecimalSafely.toString();
        }
        if (parseBigDecimalSafely != null) {
            return String.valueOf(parseBigDecimalSafely.doubleValue());
        }
        return "";
    }
}
