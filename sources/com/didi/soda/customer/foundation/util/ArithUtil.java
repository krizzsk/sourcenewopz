package com.didi.soda.customer.foundation.util;

import java.math.BigDecimal;

public final class ArithUtil {

    /* renamed from: a */
    private static final int f41130a = 10;

    private ArithUtil() {
    }

    public static double add(double d, double d2) {
        return new BigDecimal(Double.toString(d)).add(new BigDecimal(Double.toString(d2))).doubleValue();
    }

    public static double sub(double d, double d2) {
        return new BigDecimal(Double.toString(d)).subtract(new BigDecimal(Double.toString(d2))).doubleValue();
    }

    public static float sub(float f, float f2) {
        return new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Float.toString(f2))).floatValue();
    }

    public static double mul(double d, double d2) {
        return new BigDecimal(Double.toString(d)).multiply(new BigDecimal(Double.toString(d2))).doubleValue();
    }

    public static double div(double d, double d2) {
        return div(d, d2, 10);
    }

    public static float divFloat(double d, double d2) {
        return divFloat(d, d2, 10);
    }

    public static double div(double d, double d2, int i) {
        if (i >= 0) {
            return new BigDecimal(Double.toString(d)).divide(new BigDecimal(Double.toString(d2)), i, 4).doubleValue();
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }

    public static float divFloat(double d, double d2, int i) {
        if (i >= 0) {
            return new BigDecimal(Double.toString(d)).divide(new BigDecimal(Double.toString(d2)), i, 4).floatValue();
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }

    public static double round(double d, int i) {
        if (i >= 0) {
            return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), i, 4).doubleValue();
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }
}
