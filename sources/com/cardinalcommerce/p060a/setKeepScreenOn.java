package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setKeepScreenOn */
public abstract class setKeepScreenOn {
    public static int Cardinal(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[5] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static BigInteger Cardinal(int[] iArr) {
        byte[] bArr = new byte[24];
        for (int i = 0; i < 6; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                setMinimumWidth.getInstance(i2, bArr, (5 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void Cardinal(int[] iArr, int[] iArr2, int i) {
        iArr2[i] = iArr[0];
        iArr2[i + 1] = iArr[1];
        iArr2[i + 2] = iArr[2];
        iArr2[i + 3] = iArr[3];
        iArr2[i + 4] = iArr[4];
        iArr2[i + 5] = iArr[5];
    }

    public static void Cardinal(int[] iArr, int[] iArr2, int[] iArr3, int i) {
        long j = ((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr2[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr2[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr2[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr2[10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = ((long) iArr2[11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = ((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = (j7 * j) + 0;
        iArr3[12] = (int) j8;
        char c = ' ';
        long j9 = (j8 >>> 32) + (j7 * j2);
        iArr3[13] = (int) j9;
        long j10 = (j9 >>> 32) + (j7 * j3);
        iArr3[14] = (int) j10;
        long j11 = (j10 >>> 32) + (j7 * j4);
        iArr3[15] = (int) j11;
        long j12 = (j11 >>> 32) + (j7 * j5);
        iArr3[16] = (int) j12;
        long j13 = (j12 >>> 32) + (j7 * j6);
        iArr3[17] = (int) j13;
        iArr3[18] = (int) (j13 >>> 32);
        int i2 = 1;
        int i3 = i;
        int i4 = 1;
        int i5 = 6;
        while (i4 < i5) {
            int i6 = i3 + i2;
            long j14 = ((long) iArr[i4 + 6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            long j15 = (j14 * j) + (((long) iArr3[i6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
            iArr3[i6] = (int) j15;
            int i7 = i6 + 1;
            long j16 = (j15 >>> c) + (j14 * j2) + (((long) iArr3[i7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i7] = (int) j16;
            int i8 = i6 + 2;
            long j17 = j3;
            long j18 = (j16 >>> 32) + (j14 * j3) + (((long) iArr3[i8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i8] = (int) j18;
            int i9 = i6 + 3;
            int i10 = i6;
            long j19 = (j18 >>> 32) + (j14 * j4) + (((long) iArr3[i9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i9] = (int) j19;
            int i11 = i10 + 4;
            long j20 = (j19 >>> 32) + (j14 * j5) + (((long) iArr3[i11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i11] = (int) j20;
            int i12 = i10 + 5;
            long j21 = (j20 >>> 32) + (j14 * j6) + (((long) iArr3[i12]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i12] = (int) j21;
            iArr3[i10 + 6] = (int) (j21 >>> 32);
            i4++;
            i3 = i10;
            j3 = j17;
            j = j;
            j2 = j2;
            i2 = 1;
            i5 = 6;
            c = ' ';
        }
    }

    public static boolean Cardinal(int[] iArr, int[] iArr2) {
        for (int i = 5; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean Cardinal(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 3; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int CardinalError(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT)) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr2[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr2[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[5])));
        iArr2[5] = (int) j6;
        return (int) (j6 >> 32);
    }

    /* renamed from: a */
    private static int m2029a(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((((long) iArr[i]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[i + 1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[i2 + 1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[i + 2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[i2 + 2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[i + 3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[i2 + 3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[i + 4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[i2 + 4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[i + 5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[i2 + 5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[5] = (int) j6;
        return (int) (j6 >> 32);
    }

    /* renamed from: a */
    private static boolean m2030a(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 5; i3 >= 0; i3--) {
            int i4 = iArr[i3 + 6] ^ Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE ^ iArr2[i3 + 0];
            if (i4 < i5) {
                return false;
            }
            if (i4 > i5) {
                return true;
            }
        }
        return true;
    }

    public static int cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[5] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static void cca_continue(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        int i = 0;
        int i2 = 5;
        int i3 = 12;
        while (true) {
            int i4 = i2 - 1;
            long j2 = ((long) iArr[i2 + 6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            long j3 = j2 * j2;
            int i5 = i3 - 1;
            iArr2[i5 + 12] = (i << 31) | ((int) (j3 >>> 33));
            i3 = i5 - 1;
            iArr2[i3 + 12] = (int) (j3 >>> 1);
            i = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i << 31)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (j4 >>> 33);
                iArr2[12] = (int) j4;
                int i6 = ((int) (j4 >>> 32)) & 1;
                long j6 = ((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j7 = ((long) iArr2[14]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j8 = j5 + (j6 * j);
                int i7 = (int) j8;
                iArr2[13] = (i7 << 1) | i6;
                int i8 = i7 >>> 31;
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j11 = ((long) iArr2[15]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j12 = ((long) iArr2[16]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j13 = j9 + (j10 * j);
                int i9 = (int) j13;
                iArr2[14] = (i9 << 1) | i8;
                long j14 = j11 + (j13 >>> 32) + (j10 * j6);
                long j15 = j12 + (j14 >>> 32);
                long j16 = j14 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j17 = ((long) iArr[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j18 = j10;
                long j19 = (((long) iArr2[17]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j15 >>> 32);
                long j20 = j19 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j21 = j16 + (j17 * j);
                int i10 = (int) j21;
                iArr2[15] = (i9 >>> 31) | (i10 << 1);
                int i11 = i10 >>> 31;
                long j22 = (j15 & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j21 >>> 32) + (j17 * j6);
                long j23 = j20 + (j22 >>> 32) + (j17 * j18);
                long j24 = j22 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j25 = (((long) iArr2[18]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j19 >>> 32) + (j23 >>> 32);
                long j26 = j23 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j27 = j17;
                long j28 = ((long) iArr[10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j29 = j26;
                long j30 = (((long) iArr2[19]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j25 >>> 32);
                long j31 = j30 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j32 = j24 + (j28 * j);
                int i12 = (int) j32;
                iArr2[16] = i11 | (i12 << 1);
                long j33 = j29 + (j32 >>> 32) + (j28 * j6);
                long j34 = (j25 & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j33 >>> 32) + (j28 * j18);
                long j35 = j33 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j36 = j31 + (j34 >>> 32) + (j28 * j27);
                long j37 = j34 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j38 = (((long) iArr2[20]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j30 >>> 32) + (j36 >>> 32);
                long j39 = j36 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j40 = j28;
                long j41 = ((long) iArr[11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j42 = j39;
                long j43 = (((long) iArr2[21]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j38 >>> 32);
                long j44 = j38 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j45 = j43 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j46 = j35 + (j * j41);
                int i13 = (int) j46;
                iArr2[17] = (i12 >>> 31) | (i13 << 1);
                int i14 = i13 >>> 31;
                long j47 = j37 + (j46 >>> 32) + (j6 * j41);
                long j48 = j42 + (j47 >>> 32) + (j41 * j18);
                long j49 = j44 + (j48 >>> 32) + (j41 * j27);
                long j50 = j45 + (j49 >>> 32) + (j41 * j40);
                long j51 = (((long) iArr2[22]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j43 >>> 32) + (j50 >>> 32);
                int i15 = (int) j47;
                iArr2[18] = i14 | (i15 << 1);
                int i16 = (int) j48;
                iArr2[19] = (i15 >>> 31) | (i16 << 1);
                int i17 = (int) j49;
                iArr2[20] = (i16 >>> 31) | (i17 << 1);
                int i18 = i17 >>> 31;
                int i19 = (int) j50;
                iArr2[21] = i18 | (i19 << 1);
                int i20 = i19 >>> 31;
                int i21 = (int) j51;
                iArr2[22] = i20 | (i21 << 1);
                iArr2[23] = (i21 >>> 31) | ((iArr2[23] + ((int) (j51 >>> 32))) << 1);
                return;
            }
            i2 = i4;
        }
    }

    public static boolean cca_continue(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 6; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int cleanup(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + ((((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[5] = (int) j6;
        return (int) (j6 >> 32);
    }

    public static int configure(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[12]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        int i = (int) j;
        iArr[6] = i;
        iArr2[12] = i;
        long j2 = (j >>> 32) + (((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[13]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        int i2 = (int) j2;
        iArr[7] = i2;
        iArr2[13] = i2;
        long j3 = (j2 >>> 32) + (((long) iArr[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[14]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        int i3 = (int) j3;
        iArr[8] = i3;
        iArr2[14] = i3;
        long j4 = (j3 >>> 32) + (((long) iArr[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[15]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        int i4 = (int) j4;
        iArr[9] = i4;
        iArr2[15] = i4;
        long j5 = (j4 >>> 32) + (((long) iArr[10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[16]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        int i5 = (int) j5;
        iArr[10] = i5;
        iArr2[16] = i5;
        long j6 = (j5 >>> 32) + (((long) iArr[11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr2[17]));
        int i6 = (int) j6;
        iArr[11] = i6;
        iArr2[17] = i6;
        return (int) (j6 >>> 32);
    }

    public static int configure(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = ((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = ((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = 0;
        while (i < 6) {
            long j9 = j7;
            long j10 = ((long) iArr[i]) & j;
            long j11 = j2;
            long j12 = (j10 * j2) + (((long) iArr3[i]) & j) + 0;
            iArr3[i] = (int) j12;
            int i2 = i + 1;
            long j13 = (j12 >>> 32) + (j10 * j3) + (((long) iArr3[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i2] = (int) j13;
            int i3 = i + 2;
            long j14 = (j13 >>> 32) + (j10 * j4) + (((long) iArr3[i3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i3] = (int) j14;
            int i4 = i + 3;
            long j15 = (j14 >>> 32) + (j10 * j5) + (((long) iArr3[i4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i4] = (int) j15;
            int i5 = i + 4;
            long j16 = (j15 >>> 32) + (j10 * j6) + (((long) iArr3[i5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i5] = (int) j16;
            int i6 = i + 5;
            long j17 = (j16 >>> 32) + (j10 * j9) + (((long) iArr3[i6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i6] = (int) j17;
            int i7 = i + 6;
            long j18 = (j17 >>> 32) + j8 + (((long) iArr3[i7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i7] = (int) j18;
            j8 = j18 >>> 32;
            i = i2;
            j = 4294967295L;
            j7 = j9;
            j2 = j11;
            j4 = j4;
            j3 = j3;
        }
        return (int) j8;
    }

    public static int getInstance(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        long j = (((long) i3) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr[i]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[i2] = (int) j;
        int i4 = i2 + 1;
        long j2 = (j >>> 32) + (((long) iArr[i + 1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[i4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[i4] = (int) j2;
        int i5 = i2 + 2;
        long j3 = (j2 >>> 32) + (((long) iArr[i + 2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[i5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[i5] = (int) j3;
        int i6 = i2 + 3;
        long j4 = (j3 >>> 32) + (((long) iArr[i + 3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[i6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[i6] = (int) j4;
        int i7 = i2 + 4;
        long j5 = (j4 >>> 32) + (((long) iArr[i + 4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[i7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[i7] = (int) j5;
        int i8 = i2 + 5;
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr2[i8]));
        iArr2[i8] = (int) j6;
        return (int) (j6 >>> 32);
    }

    public static void getInstance(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        int i = 12;
        int i2 = 5;
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
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j11 = ((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j12 = j6;
                long j13 = ((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j14 = j9 + (j10 * j);
                int i8 = (int) j14;
                iArr2[2] = (i8 << 1) | (i7 >>> 31);
                long j15 = j11 + (j14 >>> 32) + (j10 * j12);
                long j16 = j13 + (j15 >>> 32);
                long j17 = j15 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j18 = ((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j19 = j10;
                long j20 = (((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j16 >>> 32);
                long j21 = j16 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j22 = (((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j20 >>> 32);
                long j23 = j20 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j24 = j17 + (j18 * j);
                int i9 = (int) j24;
                iArr2[3] = (i9 << 1) | (i8 >>> 31);
                long j25 = j21 + (j24 >>> 32) + (j18 * j12);
                long j26 = j23 + (j25 >>> 32) + (j18 * j19);
                long j27 = j25 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j28 = j22 + (j26 >>> 32);
                long j29 = j26 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j30 = ((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j31 = j18;
                long j32 = (((long) iArr2[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j28 >>> 32);
                long j33 = j28 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j34 = (((long) iArr2[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j32 >>> 32);
                long j35 = j32 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j36 = j27 + (j30 * j);
                int i10 = (int) j36;
                iArr2[4] = (i10 << 1) | (i9 >>> 31);
                long j37 = j29 + (j36 >>> 32) + (j30 * j12);
                long j38 = j33 + (j37 >>> 32) + (j30 * j19);
                long j39 = j37 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j40 = j35 + (j38 >>> 32) + (j30 * j31);
                long j41 = j38 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j42 = j34 + (j40 >>> 32);
                long j43 = j40 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j44 = j30;
                long j45 = ((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j46 = j43;
                long j47 = (((long) iArr2[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j42 >>> 32);
                long j48 = InternalZipConstants.ZIP_64_SIZE_LIMIT & j47;
                long j49 = j39 + (j * j45);
                int i11 = (int) j49;
                iArr2[5] = (i11 << 1) | (i10 >>> 31);
                long j50 = j41 + (j49 >>> 32) + (j45 * j12);
                long j51 = j46 + (j50 >>> 32) + (j45 * j19);
                long j52 = (j42 & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j51 >>> 32) + (j45 * j31);
                long j53 = j48 + (j52 >>> 32) + (j45 * j44);
                long j54 = (((long) iArr2[10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j47 >>> 32) + (j53 >>> 32);
                int i12 = (int) j50;
                iArr2[6] = (i11 >>> 31) | (i12 << 1);
                int i13 = (int) j51;
                iArr2[7] = (i12 >>> 31) | (i13 << 1);
                int i14 = (int) j52;
                iArr2[8] = (i13 >>> 31) | (i14 << 1);
                int i15 = (int) j53;
                iArr2[9] = (i14 >>> 31) | (i15 << 1);
                int i16 = i15 >>> 31;
                int i17 = (int) j54;
                iArr2[10] = i16 | (i17 << 1);
                iArr2[11] = (i17 >>> 31) | ((iArr2[11] + ((int) (j54 >>> 32))) << 1);
                return;
            }
            i2 = i4;
            i3 = i6;
        }
    }

    public static void getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = j3;
        long j7 = ((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = ((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j9 = (j8 * j) + 0;
        iArr3[0] = (int) j9;
        char c = ' ';
        long j10 = (j9 >>> 32) + (j8 * j2);
        iArr3[1] = (int) j10;
        long j11 = (j10 >>> 32) + (j8 * j6);
        iArr3[2] = (int) j11;
        long j12 = (j11 >>> 32) + (j8 * j4);
        iArr3[3] = (int) j12;
        long j13 = (j12 >>> 32) + (j8 * j5);
        iArr3[4] = (int) j13;
        long j14 = (j13 >>> 32) + (j8 * j7);
        iArr3[5] = (int) j14;
        int i = (int) (j14 >>> 32);
        iArr3[6] = i;
        int i2 = 1;
        for (int i3 = 6; i2 < i3; i3 = 6) {
            long j15 = ((long) iArr[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            long j16 = (j15 * j) + (((long) iArr3[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
            long j17 = j;
            iArr3[i2] = (int) j16;
            int i4 = i2 + 1;
            long j18 = j2;
            long j19 = (j16 >>> c) + (j15 * j2) + (((long) iArr3[i4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i4] = (int) j19;
            int i5 = i2 + 2;
            long j20 = (j19 >>> 32) + (j15 * j6) + (((long) iArr3[i5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i5] = (int) j20;
            int i6 = i2 + 3;
            long j21 = (j20 >>> 32) + (j15 * j4) + (((long) iArr3[i6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i6] = (int) j21;
            int i7 = i2 + 4;
            long j22 = (j21 >>> 32) + (j15 * j5) + (((long) iArr3[i7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i7] = (int) j22;
            c = ' ';
            int i8 = i2 + 5;
            long j23 = (j22 >>> 32) + (j15 * j7) + (((long) iArr3[i8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i8] = (int) j23;
            iArr3[i2 + 6] = (int) (j23 >>> 32);
            j = j17;
            i2 = i4;
            j2 = j18;
        }
    }

    public static long getWarnings(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = (j * 4553) + (((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr3[0] = (int) j2;
        long j3 = ((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = (j2 >>> 32) + (j3 * 4553) + j + (((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[1] = (int) j4;
        long j5 = j4 >>> 32;
        long j6 = ((long) iArr[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = j5 + (j6 * 4553) + j3 + (((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[2] = (int) j7;
        long j8 = ((long) iArr[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j9 = (j7 >>> 32) + (j8 * 4553) + j6 + (((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[3] = (int) j9;
        long j10 = ((long) iArr[10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j11 = (j9 >>> 32) + (j10 * 4553) + j8 + (((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[4] = (int) j11;
        long j12 = ((long) iArr[11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j13 = (j11 >>> 32) + (4553 * j12) + j10 + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr2[5]));
        iArr3[5] = (int) j13;
        return (j13 >>> 32) + j12;
    }

    public static boolean init(int[] iArr) {
        for (int i = 0; i < 6; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean init(int[] iArr, int[] iArr2) {
        for (int i = 5; i >= 0; i--) {
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

    public static boolean init(int[] iArr, int[] iArr2, int[] iArr3) {
        boolean a = m2030a(iArr, 6, iArr2, 0);
        if (a) {
            m2029a(iArr, 6, iArr2, 0, iArr3, 0);
        } else {
            m2029a(iArr2, 0, iArr, 6, iArr3, 0);
        }
        return a;
    }

    public static boolean init(long[] jArr) {
        for (int i = 0; i < 3; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean init(long[] jArr, long[] jArr2) {
        for (int i = 2; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] init(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[6];
        int i = 0;
        while (bigInteger.signum() != 0) {
            iArr[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i++;
        }
        return iArr;
    }

    public static long[] cca_continue(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        long[] jArr = new long[3];
        int i = 0;
        while (bigInteger.signum() != 0) {
            jArr[i] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i++;
        }
        return jArr;
    }

    public static int getInstance(long j, int[] iArr) {
        long j2 = j & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = (j2 * 4553) + (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr[0] = (int) j3;
        long j4 = j >>> 32;
        long j5 = (j3 >>> 32) + (4553 * j4) + j2 + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr[1] = (int) j5;
        long j6 = (j5 >>> 32) + j4 + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr[2] = (int) j6;
        long j7 = (j6 >>> 32) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[3]));
        iArr[3] = (int) j7;
        if ((j7 >>> 32) == 0) {
            return 0;
        }
        for (int i = 4; i < 6; i++) {
            int i2 = i + 0;
            int i3 = iArr[i2] + 1;
            iArr[i2] = i3;
            if (i3 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static BigInteger configure(long[] jArr) {
        byte[] bArr = new byte[24];
        for (int i = 0; i < 3; i++) {
            long j = jArr[i];
            if (j != 0) {
                int i2 = (2 - i) << 3;
                setMinimumWidth.getInstance((int) (j >>> 32), bArr, i2);
                setMinimumWidth.getInstance((int) j, bArr, i2 + 4);
            }
        }
        return new BigInteger(1, bArr);
    }
}
