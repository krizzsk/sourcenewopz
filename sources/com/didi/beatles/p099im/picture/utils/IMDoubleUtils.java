package com.didi.beatles.p099im.picture.utils;

/* renamed from: com.didi.beatles.im.picture.utils.IMDoubleUtils */
public class IMDoubleUtils {

    /* renamed from: a */
    private static long f9451a = 0;

    /* renamed from: b */
    private static final long f9452b = 800;

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f9451a < 800) {
            return true;
        }
        f9451a = currentTimeMillis;
        return false;
    }
}
