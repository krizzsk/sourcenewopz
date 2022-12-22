package com.didi.payment.base.utils;

import com.didi.dcrypto.DCryptoMainFragment;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MathUtil {
    public static int dollarToCent(double d) {
        return dollarToCent(d, 2);
    }

    public static int dollarToCent(double d, int i) {
        return (int) new BigDecimal(d + ((double) (1.0f / ((float) ((int) Math.pow(10.0d, (double) (i + 1))))))).multiply(new BigDecimal(100)).floatValue();
    }

    public static int dollarToCent(float f) {
        return dollarToCent(f, 2);
    }

    public static int dollarToCent(float f, int i) {
        return (int) new BigDecimal((double) (f + (1.0f / ((float) ((int) Math.pow(10.0d, (double) (i + 1))))))).multiply(new BigDecimal(100)).floatValue();
    }

    public static String centToDollar(Double d) {
        return new DecimalFormat(DCryptoMainFragment.DCRYPTO_ZERO).format(d.doubleValue() / 100.0d);
    }

    public static int dollarToCent(int i) {
        return dollarToCent(i, 2);
    }

    public static int dollarToCent(int i, int i2) {
        return (int) new BigDecimal((double) (((float) i) + (1.0f / ((float) ((int) Math.pow(10.0d, (double) (i2 + 1))))))).multiply(new BigDecimal(100)).floatValue();
    }

    public static double mul(String str, String str2) {
        return new BigDecimal(str).multiply(new BigDecimal(str2)).doubleValue();
    }
}
