package com.didi.addressnew.util;

public class ViewFastDoubleClickInterceptor {

    /* renamed from: a */
    private static long f7478a = 0;

    /* renamed from: b */
    private static final long f7479b = 800;

    public static boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f7478a;
        if (0 < j && j < 800) {
            return true;
        }
        f7478a = currentTimeMillis;
        return false;
    }
}
