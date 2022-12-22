package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setOnFocusChangeListener */
public final class setOnFocusChangeListener {

    /* renamed from: a */
    static final int[] f2901a = {-1, -1, -1, -3};

    /* renamed from: b */
    private static int[] f2902b = {1, 0, 0, 4, -2, -1, 3, -4};

    /* renamed from: c */
    private static final int[] f2903c = {-1, -1, -1, -5, 1, 0, -4, 3};

    public static void Cardinal(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = ((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = ((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = ((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j9 = j4 + j8;
        long j10 = j7 + (j8 << 1);
        long j11 = j3 + j10;
        long j12 = j6 + (j10 << 1);
        long j13 = j2 + j12;
        long j14 = j5 + (j12 << 1);
        long j15 = j + j14;
        iArr3[0] = (int) j15;
        long j16 = j13 + (j15 >>> 32);
        iArr3[1] = (int) j16;
        long j17 = j11 + (j16 >>> 32);
        iArr3[2] = (int) j17;
        long j18 = j9 + (j14 << 1) + (j17 >>> 32);
        iArr3[3] = (int) j18;
        init((int) (j18 >>> 32), iArr3);
    }

    /* renamed from: a */
    private static void m2046a(int[] iArr) {
        long j = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        iArr[3] = (int) (j2 + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[3])) + 2);
    }

    public static void getInstance(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.getInstance(4, iArr, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && setAccessibilityTraversalBefore.getInstance(iArr2, f2901a))) {
            m2046a(iArr2);
        }
    }

    public static void init(int i, int[] iArr) {
        while (i != 0) {
            long j = ((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            long j2 = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j;
            iArr[0] = (int) j2;
            long j3 = j2 >> 32;
            if (j3 != 0) {
                long j4 = j3 + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr[1] = (int) j4;
                long j5 = (j4 >> 32) + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr[2] = (int) j5;
                j3 = j5 >> 32;
            }
            long j6 = j3 + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[3])) + (j << 1);
            iArr[3] = (int) j6;
            i = (int) (j6 >> 32);
        }
    }

    public static void init(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.Cardinal(4, iArr, 0, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && setAccessibilityTraversalBefore.getInstance(iArr2, f2901a))) {
            m2046a(iArr2);
        }
    }

    public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[3] = (int) j4;
        if (((int) (j4 >>> 32)) != 0 || ((iArr3[3] >>> 1) >= 2147483646 && setAccessibilityTraversalBefore.getInstance(iArr3, f2901a))) {
            m2046a(iArr3);
        }
    }

    public static int[] Cardinal(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[4];
        int i = 0;
        while (bigInteger.signum() != 0) {
            iArr[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i++;
        }
        if ((iArr[3] >>> 1) >= 2147483646 && setAccessibilityTraversalBefore.getInstance(iArr, f2901a)) {
            int[] iArr2 = f2901a;
            long j = ((((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT)) + 0;
            iArr[0] = (int) j;
            long j2 = (j >> 32) + ((((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
            iArr[1] = (int) j2;
            long j3 = (j2 >> 32) + ((((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
            iArr[2] = (int) j3;
            iArr[3] = (int) ((j3 >> 32) + ((((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT)));
        }
        return iArr;
    }

    public static void init(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[8];
        setAccessibilityTraversalBefore.configure(iArr, iArr2, iArr4);
        Cardinal(iArr4, iArr3);
    }

    public static void configure(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = iArr3;
        int i = 0;
        long j = InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = 0;
        while (i < 4) {
            long j7 = ((long) iArr[i]) & j;
            long j8 = j2;
            long j9 = (j7 * j2) + (((long) iArr4[i]) & j) + 0;
            iArr4[i] = (int) j9;
            int i2 = i + 1;
            long j10 = (j9 >>> 32) + (j7 * j3) + (((long) iArr4[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr4[i2] = (int) j10;
            int i3 = i + 2;
            long j11 = (j10 >>> 32) + (j7 * j4) + (((long) iArr4[i3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr4[i3] = (int) j11;
            int i4 = i + 3;
            long j12 = (j11 >>> 32) + (j7 * j5) + (((long) iArr4[i4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr4[i4] = (int) j12;
            int i5 = i + 4;
            long j13 = (j12 >>> 32) + j6 + (((long) iArr4[i5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr4[i5] = (int) j13;
            j6 = j13 >>> 32;
            j = 4294967295L;
            j2 = j8;
            i = i2;
            j3 = j3;
        }
        if (((int) j6) != 0 || ((iArr4[7] >>> 1) >= 2147483646 && setNextFocusLeftId.configure(iArr4, f2902b))) {
            int[] iArr5 = f2903c;
            setDrawingCacheQuality.configure(iArr5.length, iArr5, iArr4);
        }
    }

    public static void configure(int[] iArr, int[] iArr2) {
        if (setAccessibilityTraversalBefore.configure(iArr)) {
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            return;
        }
        setAccessibilityTraversalBefore.Cardinal(f2901a, iArr, iArr2);
    }

    public static void cca_continue(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[8];
        setAccessibilityTraversalBefore.Cardinal(iArr, iArr3);
        Cardinal(iArr3, iArr2);
    }

    public static void getInstance(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[8];
        setAccessibilityTraversalBefore.Cardinal(iArr, iArr3);
        while (true) {
            Cardinal(iArr3, iArr2);
            i--;
            if (i > 0) {
                setAccessibilityTraversalBefore.Cardinal(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    public static void getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setAccessibilityTraversalBefore.Cardinal(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - 1;
            iArr3[0] = (int) j;
            long j2 = j >> 32;
            if (j2 != 0) {
                long j3 = j2 + (((long) iArr3[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr3[1] = (int) j3;
                long j4 = (j3 >> 32) + (((long) iArr3[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr3[2] = (int) j4;
                j2 = j4 >> 32;
            }
            iArr3[3] = (int) (j2 + ((InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr3[3])) - 2));
        }
    }
}
