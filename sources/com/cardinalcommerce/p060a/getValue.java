package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.getValue */
public final class getValue {

    /* renamed from: a */
    static final int[] f2589a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 511};

    public static void configure(int[] iArr, int[] iArr2) {
        int i = iArr[16];
        iArr2[16] = (setDrawingCacheQuality.Cardinal(16, iArr, i << 23, iArr2) | (i << 1)) & 511;
    }

    public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        int cca_continue = setDrawingCacheQuality.cca_continue(16, iArr, iArr2, iArr3) + iArr[16] + iArr2[16];
        if (cca_continue > 511 || (cca_continue == 511 && setDrawingCacheQuality.Cardinal(16, iArr3, f2589a))) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= 16) {
                    i = 1;
                    break;
                }
                int i3 = iArr3[i2] + 1;
                iArr3[i2] = i3;
                if (i3 != 0) {
                    break;
                }
                i2++;
            }
            cca_continue = (cca_continue + i) & 511;
        }
        iArr3[16] = cca_continue;
    }

    public static void getInstance(int[] iArr, int[] iArr2) {
        int instance = setDrawingCacheQuality.getInstance(16, iArr, iArr2) + iArr[16];
        if (instance > 511 || (instance == 511 && setDrawingCacheQuality.Cardinal(16, iArr2, f2589a))) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= 16) {
                    i = 1;
                    break;
                }
                int i3 = iArr2[i2] + 1;
                iArr2[i2] = i3;
                if (i3 != 0) {
                    break;
                }
                i2++;
            }
            instance = (instance + i) & 511;
        }
        iArr2[16] = instance;
    }

    public static int[] getInstance(BigInteger bigInteger) {
        int[] cca_continue = setDrawingCacheQuality.cca_continue(521, bigInteger);
        if (setDrawingCacheQuality.Cardinal(17, cca_continue, f2589a)) {
            for (int i = 0; i < 17; i++) {
                cca_continue[i] = 0;
            }
        }
        return cca_continue;
    }

    public static void init(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = iArr;
        int[] iArr5 = iArr2;
        int[] iArr6 = new int[33];
        setNextFocusLeftId.cca_continue(iArr4, iArr5, iArr6);
        long j = ((long) iArr5[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr5[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr5[10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr5[11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr5[12]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = ((long) iArr5[13]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = ((long) iArr5[14]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = ((long) iArr5[15]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j9 = ((long) iArr4[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j10 = 0;
        long j11 = (j9 * j) + 0;
        long j12 = j;
        iArr6[16] = (int) j11;
        char c = ' ';
        long j13 = (j11 >>> 32) + (j9 * j2);
        iArr6[17] = (int) j13;
        long j14 = (j13 >>> 32) + (j9 * j3);
        iArr6[18] = (int) j14;
        long j15 = (j14 >>> 32) + (j9 * j4);
        iArr6[19] = (int) j15;
        long j16 = (j15 >>> 32) + (j9 * j5);
        iArr6[20] = (int) j16;
        long j17 = (j16 >>> 32) + (j9 * j6);
        iArr6[21] = (int) j17;
        long j18 = (j17 >>> 32) + (j9 * j7);
        iArr6[22] = (int) j18;
        long j19 = (j18 >>> 32) + (j9 * j8);
        iArr6[23] = (int) j19;
        iArr6[24] = (int) (j19 >>> 32);
        int i = 1;
        int i2 = 1;
        int i3 = 16;
        while (i2 < 8) {
            i3 += i;
            long j20 = ((long) iArr[i2 + 8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            long j21 = (j20 * j12) + (((long) iArr6[i3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
            iArr6[i3] = (int) j21;
            int i4 = i3 + 1;
            long j22 = (j21 >>> c) + (j20 * j2) + (((long) iArr6[i4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr6[i4] = (int) j22;
            int i5 = i3 + 2;
            long j23 = (j22 >>> 32) + (j20 * j3) + (((long) iArr6[i5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr6[i5] = (int) j23;
            int i6 = i3 + 3;
            long j24 = (j23 >>> 32) + (j20 * j4) + (((long) iArr6[i6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr6[i6] = (int) j24;
            int i7 = i3 + 4;
            long j25 = (j24 >>> 32) + (j20 * j5) + (((long) iArr6[i7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr6[i7] = (int) j25;
            int i8 = i3 + 5;
            long j26 = (j25 >>> 32) + (j20 * j6) + (((long) iArr6[i8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr6[i8] = (int) j26;
            int i9 = i3 + 6;
            long j27 = (j26 >>> 32) + (j20 * j7) + (((long) iArr6[i9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr6[i9] = (int) j27;
            int i10 = i3 + 7;
            long j28 = (j27 >>> 32) + (j20 * j8) + (((long) iArr6[i10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr6[i10] = (int) j28;
            iArr6[i3 + 8] = (int) (j28 >>> 32);
            i2++;
            j3 = j3;
            j2 = j2;
            i = 1;
            c = ' ';
        }
        int instance = setNextFocusLeftId.getInstance(iArr6, iArr6);
        int i11 = 0;
        int Cardinal = instance + setNextFocusLeftId.Cardinal(iArr6, 24, iArr6, 16, setNextFocusLeftId.Cardinal(iArr6, 0, iArr6, 8, 0) + instance);
        int[] iArr7 = new int[8];
        int[] iArr8 = new int[8];
        int[] iArr9 = iArr;
        int[] iArr10 = iArr2;
        boolean z = setNextFocusLeftId.configure(iArr9, iArr9, iArr7) != setNextFocusLeftId.configure(iArr10, iArr10, iArr8);
        int[] iArr11 = new int[16];
        setNextFocusLeftId.cca_continue(iArr7, iArr8, iArr11);
        setDrawingCacheQuality.getInstance(32, Cardinal + (z ? setDrawingCacheQuality.cca_continue(16, iArr11, iArr6, 8) : setDrawingCacheQuality.getInstance(16, iArr11, iArr6, 8)), iArr6, 24);
        int i12 = iArr9[16];
        int i13 = iArr10[16];
        long j29 = ((long) i12) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j30 = ((long) i13) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        while (true) {
            long j31 = j29;
            long j32 = ((((long) iArr10[i11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * j29) + ((((long) iArr9[i11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * j30);
            int i14 = i11 + 16;
            long j33 = j10 + j32 + (((long) iArr6[i14]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr6[i14] = (int) j33;
            long j34 = j33 >>> 32;
            i11++;
            if (i11 >= 16) {
                iArr6[32] = ((int) j34) + (i12 * i13);
                m1911a(iArr6, iArr3);
                return;
            }
            int[] iArr12 = iArr3;
            j10 = j34;
            j29 = j31;
        }
    }

    public static void Cardinal(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.init(17, iArr)) {
            for (int i = 0; i < 17; i++) {
                iArr2[i] = 0;
            }
            return;
        }
        setDrawingCacheQuality.configure(17, f2589a, iArr, iArr2);
    }

    /* renamed from: a */
    private static void m1911a(int[] iArr, int[] iArr2) {
        int i = iArr[32];
        int cca_continue = (setDrawingCacheQuality.cca_continue(iArr, i, iArr2) >>> 23) + (i >>> 9) + setDrawingCacheQuality.configure(16, iArr, iArr2);
        if (cca_continue > 511 || (cca_continue == 511 && setDrawingCacheQuality.Cardinal(16, iArr2, f2589a))) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= 16) {
                    i2 = 1;
                    break;
                }
                int i4 = iArr2[i3] + 1;
                iArr2[i3] = i4;
                if (i4 != 0) {
                    break;
                }
                i3++;
            }
            cca_continue = (cca_continue + i2) & 511;
        }
        iArr2[16] = cca_continue;
    }

    public static void cca_continue(int[] iArr) {
        int i = iArr[16];
        int instance = setDrawingCacheQuality.getInstance(16, i >>> 9, iArr) + (i & 511);
        if (instance > 511 || (instance == 511 && setDrawingCacheQuality.Cardinal(16, iArr, f2589a))) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= 16) {
                    i2 = 1;
                    break;
                }
                int i4 = iArr[i3] + 1;
                iArr[i3] = i4;
                if (i4 != 0) {
                    break;
                }
                i3++;
            }
            instance = (instance + i2) & 511;
        }
        iArr[16] = instance;
    }

    public static void init(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[33];
        setWindowInsetsAnimationCallback.getInstance(iArr, iArr3);
        int i = iArr[16];
        iArr3[32] = setDrawingCacheQuality.configure(16, i << 1, iArr, iArr3, 16) + (i * i);
        m1911a(iArr3, iArr2);
    }

    public static void getInstance(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[33];
        setWindowInsetsAnimationCallback.getInstance(iArr, iArr3);
        int i2 = iArr[16];
        iArr3[32] = setDrawingCacheQuality.configure(16, i2 << 1, iArr, iArr3, 16) + (i2 * i2);
        m1911a(iArr3, iArr2);
        while (true) {
            i--;
            if (i > 0) {
                setWindowInsetsAnimationCallback.getInstance(iArr2, iArr3);
                int i3 = iArr2[16];
                iArr3[32] = setDrawingCacheQuality.configure(16, i3 << 1, iArr2, iArr3, 16) + (i3 * i3);
                m1911a(iArr3, iArr2);
            } else {
                return;
            }
        }
    }

    public static void configure(int[] iArr, int[] iArr2, int[] iArr3) {
        int configure = (setDrawingCacheQuality.configure(16, iArr, iArr2, iArr3) + iArr[16]) - iArr2[16];
        if (configure < 0) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= 16) {
                    i = -1;
                    break;
                }
                int i3 = iArr3[i2] - 1;
                iArr3[i2] = i3;
                if (i3 != -1) {
                    break;
                }
                i2++;
            }
            configure = (configure + i) & 511;
        }
        iArr3[16] = configure;
    }
}
