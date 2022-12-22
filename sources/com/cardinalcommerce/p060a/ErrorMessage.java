package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.ErrorMessage */
public final class ErrorMessage {

    /* renamed from: a */
    static final int[] f2434a = {-1, -1, -1, 0, 0, 0, 1, -1};

    /* renamed from: b */
    private static int[] f2435b = {1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2};

    public static void Cardinal(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.Cardinal(8, iArr, 0, iArr2) != 0 || (iArr2[7] == -1 && setNextFocusLeftId.configure(iArr2, f2434a))) {
            m1814a(iArr2);
        }
    }

    /* renamed from: a */
    private static void m1814a(int[] iArr) {
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
        long j5 = j2 + ((((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - 1);
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr[5] = (int) j8;
            j6 = j8 >> 32;
        }
        long j9 = j6 + ((((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - 1);
        iArr[6] = (int) j9;
        iArr[7] = (int) ((j9 >> 32) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[7])) + 1);
    }

    public static void cca_continue(int[] iArr, int[] iArr2) {
        if (setNextFocusLeftId.getInstance(iArr)) {
            setNextFocusLeftId.cca_continue(iArr2);
        } else {
            setNextFocusLeftId.getWarnings(f2434a, iArr, iArr2);
        }
    }

    public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setNextFocusLeftId.init(iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && setDrawingCacheQuality.init(16, iArr3, f2435b))) {
            setDrawingCacheQuality.cca_continue(16, f2435b, iArr3);
        }
    }

    public static void getInstance(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = ((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            long j3 = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j2 + 0;
            iArr[0] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                long j5 = j4 + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr[1] = (int) j5;
                long j6 = (j5 >> 32) + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr[2] = (int) j6;
                j4 = j6 >> 32;
            }
            long j7 = j4 + ((((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - j2);
            iArr[3] = (int) j7;
            long j8 = j7 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr[4] = (int) j9;
                long j10 = (j9 >> 32) + (((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr[5] = (int) j10;
                j8 = j10 >> 32;
            }
            long j11 = j8 + ((((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - j2);
            iArr[6] = (int) j11;
            long j12 = (j11 >> 32) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[7])) + j2;
            iArr[7] = (int) j12;
            j = j12 >> 32;
        } else {
            j = 0;
        }
        if (j != 0 || (iArr[7] == -1 && setNextFocusLeftId.configure(iArr, f2434a))) {
            m1814a(iArr);
        }
    }

    public static void getInstance(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr[10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr[11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr[12]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = ((long) iArr[13]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = ((long) iArr[14]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = ((long) iArr[15]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j9 = j - 6;
        long j10 = j9 + j2;
        long j11 = j2 + j3;
        long j12 = (j3 + j4) - j8;
        long j13 = j4 + j5;
        long j14 = j5 + j6;
        long j15 = j6 + j7;
        long j16 = j7 + j8;
        long j17 = j15 - j10;
        long j18 = j9;
        long j19 = (((((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - j13) - j17) + 0;
        iArr3[0] = (int) j19;
        long j20 = (j19 >> 32) + ((((((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j11) - j14) - j16);
        iArr3[1] = (int) j20;
        long j21 = (j20 >> 32) + (((((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j12) - j15);
        iArr3[2] = (int) j21;
        long j22 = (j21 >> 32) + ((((((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j13 << 1)) + j17) - j16);
        iArr3[3] = (int) j22;
        long j23 = (j22 >> 32) + ((((((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j14 << 1)) + j7) - j11);
        iArr3[4] = (int) j23;
        long j24 = (j23 >> 32) + (((((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j15 << 1)) - j12);
        iArr3[5] = (int) j24;
        long j25 = (j24 >> 32) + (((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j16 << 1) + j17;
        iArr3[6] = (int) j25;
        long j26 = (j25 >> 32) + (((((((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j8 << 1)) + j18) - j12) - j14);
        iArr3[7] = (int) j26;
        getInstance((int) ((j26 >> 32) + 6), iArr3);
    }

    public static void getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setNextFocusLeftId.getInstance(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && setNextFocusLeftId.configure(iArr3, f2434a))) {
            m1814a(iArr3);
        }
    }

    public static int[] getInstance(BigInteger bigInteger) {
        int[] Cardinal = setNextFocusLeftId.Cardinal(bigInteger);
        if (Cardinal[7] == -1 && setNextFocusLeftId.configure(Cardinal, f2434a)) {
            setNextFocusLeftId.getWarnings(f2434a, Cardinal);
        }
        return Cardinal;
    }

    public static void init(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.getInstance(8, iArr, iArr2) != 0 || (iArr2[7] == -1 && setNextFocusLeftId.configure(iArr2, f2434a))) {
            m1814a(iArr2);
        }
    }

    public static void Cardinal(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[16];
        setNextFocusLeftId.cca_continue(iArr, iArr2, iArr4);
        getInstance(iArr4, iArr3);
    }

    public static void configure(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        setNextFocusLeftId.getSDKVersion(iArr, iArr3);
        getInstance(iArr3, iArr2);
    }

    public static void Cardinal(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[16];
        setNextFocusLeftId.getSDKVersion(iArr, iArr3);
        while (true) {
            getInstance(iArr3, iArr2);
            i--;
            if (i > 0) {
                setNextFocusLeftId.getSDKVersion(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    public static void configure(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setNextFocusLeftId.getWarnings(iArr, iArr2, iArr3) != 0) {
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
            long j5 = j2 + (((long) iArr3[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 1;
            iArr3[3] = (int) j5;
            long j6 = j5 >> 32;
            if (j6 != 0) {
                long j7 = j6 + (((long) iArr3[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr3[4] = (int) j7;
                long j8 = (j7 >> 32) + (((long) iArr3[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr3[5] = (int) j8;
                j6 = j8 >> 32;
            }
            long j9 = j6 + (((long) iArr3[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 1;
            iArr3[6] = (int) j9;
            iArr3[7] = (int) ((j9 >> 32) + ((((long) iArr3[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - 1));
        }
    }
}
