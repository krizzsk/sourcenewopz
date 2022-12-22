package com.didichuxing.dfbasesdk.utils;

public class StrToNumUtils {
    private StrToNumUtils() {
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static float toFloat(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (RuntimeException e) {
            CheckUtils.throwExceptionIfDebug(e);
            return f;
        }
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (RuntimeException e) {
            CheckUtils.throwExceptionIfDebug(e);
            return i;
        }
    }

    public static long toLong(String str) {
        return toLong(str, 0);
    }

    public static long toLong(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (RuntimeException e) {
            CheckUtils.throwExceptionIfDebug(e);
            return j;
        }
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    public static double toDouble(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (RuntimeException e) {
            CheckUtils.throwExceptionIfDebug(e);
            return d;
        }
    }
}
