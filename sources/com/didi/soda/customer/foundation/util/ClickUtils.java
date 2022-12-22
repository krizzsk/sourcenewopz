package com.didi.soda.customer.foundation.util;

public final class ClickUtils {

    /* renamed from: a */
    private static final long f41135a = 500;

    /* renamed from: b */
    private static long f41136b;

    private ClickUtils() {
    }

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - f41136b < 500;
        if (!z) {
            f41136b = currentTimeMillis;
        }
        return z;
    }
}
