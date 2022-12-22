package com.cardinalcommerce.p060a;

import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setAccessibilityTraversalBefore */
public abstract class setAccessibilityTraversalBefore {
    public static int Cardinal(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[3] = (int) j4;
        return (int) (j4 >> 32);
    }

    public static void Cardinal(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        int i = 8;
        int i2 = 3;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            long j2 = ((long) iArr[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            long j3 = j2 * j2;
            int i5 = i - 1;
            iArr2[i5] = (i3 << 31) | ((int) (j3 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i6 << 31)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (j4 >>> 33);
                iArr2[0] = (int) j4;
                long j6 = ((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j7 = ((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j8 = j5 + (j6 * j);
                int i7 = (int) j8;
                iArr2[1] = (i7 << 1) | (((int) (j4 >>> 32)) & 1);
                int i8 = i7 >>> 31;
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j11 = j6;
                long j12 = ((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j13 = ((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j14 = j9 + (j10 * j);
                int i9 = (int) j14;
                iArr2[2] = (i9 << 1) | i8;
                long j15 = j12 + (j14 >>> 32) + (j10 * j11);
                long j16 = j13 + (j15 >>> 32);
                long j17 = j15 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j18 = ((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j19 = j10;
                long j20 = (((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j16 >>> 32);
                long j21 = j16 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j22 = j20 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j23 = j17 + (j * j18);
                int i10 = (int) j23;
                iArr2[3] = (i10 << 1) | (i9 >>> 31);
                long j24 = j21 + (j23 >>> 32) + (j11 * j18);
                long j25 = j22 + (j24 >>> 32) + (j18 * j19);
                long j26 = (((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j20 >>> 32) + (j25 >>> 32);
                long j27 = j25 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                int i11 = (int) j24;
                iArr2[4] = (i10 >>> 31) | (i11 << 1);
                int i12 = (int) j27;
                iArr2[5] = (i11 >>> 31) | (i12 << 1);
                int i13 = (int) j26;
                iArr2[6] = (i12 >>> 31) | (i13 << 1);
                iArr2[7] = ((iArr2[7] + ((int) (j26 >>> 32))) << 1) | (i13 >>> 31);
                return;
            }
            i2 = i4;
            i3 = i6;
        }
    }

    public static boolean Cardinal(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 4; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean Cardinal(long[] jArr) {
        for (int i = 0; i < 2; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[3] = (int) j4;
        return (int) (j4 >>> 32);
    }

    public static boolean cca_continue(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 2; i++) {
            if (jArr[1] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void configure(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        int i = 1;
        long j2 = ((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = (j5 * j) + 0;
        iArr3[0] = (int) j6;
        char c = ' ';
        long j7 = (j6 >>> 32) + (j5 * j2);
        iArr3[1] = (int) j7;
        long j8 = (j7 >>> 32) + (j5 * j3);
        iArr3[2] = (int) j8;
        long j9 = (j8 >>> 32) + (j5 * j4);
        iArr3[3] = (int) j9;
        int i2 = (int) (j9 >>> 32);
        iArr3[4] = i2;
        for (int i3 = 4; i < i3; i3 = 4) {
            long j10 = ((long) iArr[i]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            long j11 = (j10 * j) + (((long) iArr3[i]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
            iArr3[i] = (int) j11;
            int i4 = i + 1;
            long j12 = j;
            long j13 = (j11 >>> c) + (j10 * j2) + (((long) iArr3[i4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i4] = (int) j13;
            int i5 = i + 2;
            long j14 = (j13 >>> 32) + (j10 * j3) + (((long) iArr3[i5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i5] = (int) j14;
            c = ' ';
            int i6 = i + 3;
            long j15 = (j14 >>> 32) + (j10 * j4) + (((long) iArr3[i6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i6] = (int) j15;
            iArr3[i + 4] = (int) (j15 >>> 32);
            i = i4;
            j = j12;
            j2 = j2;
        }
    }

    public static boolean configure(int[] iArr) {
        for (int i = 0; i < 4; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean configure(int[] iArr, int[] iArr2) {
        for (int i = 3; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean configure(long[] jArr, long[] jArr2) {
        for (int i = 1; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean getInstance(int[] iArr, int[] iArr2) {
        for (int i = 3; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }
}
