package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setCCAOnFocusChangeListener */
public final class setCCAOnFocusChangeListener {

    /* renamed from: a */
    static final int[] f2729a = {Integer.MAX_VALUE, -1, -1, -1, -1};

    /* renamed from: b */
    private static int[] f2730b = {1, 1073741825, 0, 0, 0, -2, -2, -1, -1, -1};

    /* renamed from: c */
    private static final int[] f2731c = {-1, -1073741826, -1, -1, -1, 1, 1};

    public static void cca_continue(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.Cardinal(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && setScrollContainer.cca_continue(iArr2, f2729a))) {
            setDrawingCacheQuality.getInstance(5, -2147483647, iArr2);
        }
    }

    public static void configure(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j + (j << 31) + 0;
        iArr3[0] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j2 + (j2 << 31);
        iArr3[1] = (int) j7;
        long j8 = (j7 >>> 32) + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j3 + (j3 << 31);
        iArr3[2] = (int) j8;
        long j9 = (j8 >>> 32) + (((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j4 + (j4 << 31);
        iArr3[3] = (int) j9;
        long j10 = (j9 >>> 32) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[4])) + j5 + (j5 << 31);
        iArr3[4] = (int) j10;
        init((int) (j10 >>> 32), iArr3);
    }

    public static void getInstance(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.getInstance(5, iArr, iArr2) != 0 || (iArr2[4] == -1 && setScrollContainer.cca_continue(iArr2, f2729a))) {
            setDrawingCacheQuality.getInstance(5, -2147483647, iArr2);
        }
    }

    public static void init(int i, int[] iArr) {
        if ((i != 0 && setScrollContainer.init(i, iArr) != 0) || (iArr[4] == -1 && setScrollContainer.cca_continue(iArr, f2729a))) {
            setDrawingCacheQuality.getInstance(5, -2147483647, iArr);
        }
    }

    public static void init(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setScrollContainer.getInstance(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && setScrollContainer.cca_continue(iArr3, f2729a))) {
            setDrawingCacheQuality.getInstance(5, -2147483647, iArr3);
        }
    }

    public static int[] init(BigInteger bigInteger) {
        int[] configure = setScrollContainer.configure(bigInteger);
        if (configure[4] == -1 && setScrollContainer.cca_continue(configure, f2729a)) {
            setScrollContainer.getInstance(f2729a, configure);
        }
        return configure;
    }

    public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[10];
        setScrollContainer.init(iArr, iArr2, iArr4);
        configure(iArr4, iArr3);
    }

    public static void Cardinal(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setScrollContainer.configure(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && setDrawingCacheQuality.init(10, iArr3, f2730b))) {
            int[] iArr4 = f2731c;
            if (setDrawingCacheQuality.configure(iArr4.length, iArr4, iArr3) != 0) {
                int length = f2731c.length;
                while (length < 10) {
                    int i = iArr3[length] + 1;
                    iArr3[length] = i;
                    if (i == 0) {
                        length++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static void init(int[] iArr, int[] iArr2) {
        if (setScrollContainer.init(iArr)) {
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            iArr2[4] = 0;
            return;
        }
        setScrollContainer.getWarnings(f2729a, iArr, iArr2);
    }

    public static void Cardinal(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[10];
        setScrollContainer.init(iArr, iArr3);
        configure(iArr3, iArr2);
    }

    public static void getInstance(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[10];
        setScrollContainer.init(iArr, iArr3);
        while (true) {
            configure(iArr3, iArr2);
            i--;
            if (i > 0) {
                setScrollContainer.init(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    public static void getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setScrollContainer.getWarnings(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - 2147483649L;
            iArr3[0] = (int) j;
            if ((j >> 32) != 0) {
                int i = 1;
                while (i < 5) {
                    int i2 = iArr3[i] - 1;
                    iArr3[i] = i2;
                    if (i2 == -1) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
