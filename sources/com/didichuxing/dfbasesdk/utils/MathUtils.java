package com.didichuxing.dfbasesdk.utils;

public class MathUtils {

    /* renamed from: a */
    private static final float f46746a = 1.0E-7f;

    private MathUtils() {
    }

    public static int clamp(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static long clamp(long j, long j2, long j3) {
        return Math.max(j2, Math.min(j3, j));
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static double clamp(double d, double d2, double d3) {
        return Math.max(d2, Math.min(d3, d));
    }

    public static boolean isFloatEqual(float f, float f2) {
        return Math.abs(f - f2) < f46746a;
    }

    public static boolean isDoubleEqual(double d, double d2) {
        return Math.abs(d - d2) < 1.0000000116860974E-7d;
    }
}
