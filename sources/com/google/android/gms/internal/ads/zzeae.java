package com.google.android.gms.internal.ads;

import com.airbnb.lottie.utils.Utils;
import com.didi.sdk.onehotpatch.openapi.HotpatchStateConst;
import com.didi.soda.customer.C13565R2;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzeae {
    private static final byte[] zzibz = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
    private static final int[] zzica = {1, 10, 100, 1000, 10000, 100000, 1000000, HotpatchStateConst.ROLLBACK_PATHCH, 100000000, Utils.SECOND_IN_NANOS};
    private static final int[] zzicb = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    private static final int[] zzicc = {1, 1, 2, 6, 24, 120, 720, 5040, C13565R2.styleable.TunaProgress_tunaProgressArcBackgroundNormal, 362880, 3628800, 39916800, 479001600};
    private static int[] zzicd = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    public static int zzaa(int i, int i2) {
        long j = ((long) i) << 1;
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }
}
