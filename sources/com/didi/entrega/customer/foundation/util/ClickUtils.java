package com.didi.entrega.customer.foundation.util;

public final class ClickUtils {

    /* renamed from: a */
    private static final long f20076a = 500;

    /* renamed from: b */
    private static long f20077b;

    private ClickUtils() {
    }

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - f20077b < 500;
        if (!z) {
            f20077b = currentTimeMillis;
        }
        return z;
    }
}
