package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setNextFocusDownId */
public abstract class setNextFocusDownId {
    public static int Cardinal(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = ((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = ((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = j2;
        long j9 = ((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j10 = 0;
        int i = 0;
        while (i < 7) {
            long j11 = j9;
            long j12 = ((long) iArr[i]) & j;
            long j13 = j7;
            long j14 = (j12 * j8) + (((long) iArr3[i]) & j) + 0;
            iArr3[i] = (int) j14;
            int i2 = i + 1;
            long j15 = j3;
            long j16 = (j14 >>> 32) + (j12 * j3) + (((long) iArr3[i2]) & j);
            iArr3[i2] = (int) j16;
            int i3 = i + 2;
            long j17 = (j16 >>> 32) + (j12 * j4) + (((long) iArr3[i3]) & j);
            iArr3[i3] = (int) j17;
            int i4 = i + 3;
            long j18 = (j17 >>> 32) + (j12 * j5) + (((long) iArr3[i4]) & j);
            iArr3[i4] = (int) j18;
            int i5 = i + 4;
            long j19 = (j18 >>> 32) + (j12 * j6) + (((long) iArr3[i5]) & j);
            iArr3[i5] = (int) j19;
            int i6 = i + 5;
            long j20 = (j19 >>> 32) + (j12 * j13) + (((long) iArr3[i6]) & j);
            iArr3[i6] = (int) j20;
            int i7 = i + 6;
            long j21 = (j20 >>> 32) + (j12 * j11) + (((long) iArr3[i7]) & j);
            iArr3[i7] = (int) j21;
            int i8 = i + 7;
            long j22 = (j21 >>> 32) + j10 + (((long) iArr3[i8]) & j);
            iArr3[i8] = (int) j22;
            j10 = j22 >>> 32;
            i = i2;
            j9 = j11;
            j7 = j13;
            j3 = j15;
            j = InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }
        return (int) j10;
    }

    public static boolean Cardinal(int[] iArr, int[] iArr2) {
        for (int i = 6; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int CardinalError(int[] iArr, int[] iArr2, int[] iArr3) {
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
        long j7 = (j6 >> 32) + ((((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[6] = (int) j7;
        return (int) (j7 >> 32);
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
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static boolean cca_continue(int[] iArr) {
        for (int i = 0; i < 7; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void configure(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = j3;
        long j7 = ((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = ((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j9 = ((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j10 = (j9 * j) + 0;
        iArr3[0] = (int) j10;
        char c = ' ';
        long j11 = (j10 >>> 32) + (j9 * j2);
        iArr3[1] = (int) j11;
        long j12 = (j11 >>> 32) + (j9 * j6);
        iArr3[2] = (int) j12;
        long j13 = (j12 >>> 32) + (j9 * j4);
        iArr3[3] = (int) j13;
        long j14 = (j13 >>> 32) + (j9 * j5);
        iArr3[4] = (int) j14;
        long j15 = (j14 >>> 32) + (j9 * j7);
        iArr3[5] = (int) j15;
        long j16 = (j15 >>> 32) + (j9 * j8);
        iArr3[6] = (int) j16;
        int i = (int) (j16 >>> 32);
        iArr3[7] = i;
        int i2 = 1;
        for (int i3 = 7; i2 < i3; i3 = 7) {
            long j17 = ((long) iArr[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            long j18 = (j17 * j) + (((long) iArr3[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
            long j19 = j;
            iArr3[i2] = (int) j18;
            int i4 = i2 + 1;
            long j20 = j2;
            long j21 = (j18 >>> c) + (j17 * j2) + (((long) iArr3[i4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i4] = (int) j21;
            int i5 = i2 + 2;
            long j22 = (j21 >>> 32) + (j17 * j6) + (((long) iArr3[i5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i5] = (int) j22;
            int i6 = i2 + 3;
            long j23 = (j22 >>> 32) + (j17 * j4) + (((long) iArr3[i6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i6] = (int) j23;
            int i7 = i2 + 4;
            long j24 = (j23 >>> 32) + (j17 * j5) + (((long) iArr3[i7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i7] = (int) j24;
            int i8 = i2 + 5;
            long j25 = (j24 >>> 32) + (j17 * j7) + (((long) iArr3[i8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i8] = (int) j25;
            c = ' ';
            int i9 = i2 + 6;
            long j26 = (j25 >>> 32) + (j17 * j8) + (((long) iArr3[i9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i9] = (int) j26;
            iArr3[i2 + 7] = (int) (j26 >>> 32);
            j = j19;
            i2 = i4;
            j2 = j20;
        }
    }

    public static boolean configure(int[] iArr, int[] iArr2) {
        for (int i = 6; i >= 0; i--) {
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

    public static long getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = (j * 6803) + (((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr3[0] = (int) j2;
        long j3 = ((long) iArr[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = (j2 >>> 32) + (j3 * 6803) + j + (((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[1] = (int) j4;
        long j5 = j4 >>> 32;
        long j6 = ((long) iArr[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = j5 + (j6 * 6803) + j3 + (((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[2] = (int) j7;
        long j8 = ((long) iArr[10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j9 = (j7 >>> 32) + (j8 * 6803) + j6 + (((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[3] = (int) j9;
        long j10 = ((long) iArr[11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j11 = (j9 >>> 32) + (j10 * 6803) + j8 + (((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[4] = (int) j11;
        long j12 = ((long) iArr[12]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j13 = (j11 >>> 32) + (j12 * 6803) + j10 + (((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[5] = (int) j13;
        long j14 = ((long) iArr[13]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j15 = (j13 >>> 32) + (6803 * j14) + j12 + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr2[6]));
        iArr3[6] = (int) j15;
        return (j15 >>> 32) + j14;
    }

    public static void getInstance(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        int i = 14;
        int i2 = 6;
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
                iArr2[3] = (i8 >>> 31) | (i9 << 1);
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
                long j48 = j42 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j49 = (((long) iArr2[10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j47 >>> 32);
                long j50 = j47 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j51 = j39 + (j45 * j);
                int i11 = (int) j51;
                iArr2[5] = (i11 << 1) | (i10 >>> 31);
                long j52 = j41 + (j51 >>> 32) + (j45 * j12);
                long j53 = j46 + (j52 >>> 32) + (j45 * j19);
                long j54 = j52 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j55 = j48 + (j53 >>> 32) + (j45 * j31);
                long j56 = j53 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j57 = j50 + (j55 >>> 32) + (j45 * j44);
                long j58 = j55 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j59 = j49 + (j57 >>> 32);
                long j60 = j57 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j61 = j45;
                long j62 = ((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j63 = j60;
                long j64 = (((long) iArr2[11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j59 >>> 32);
                long j65 = InternalZipConstants.ZIP_64_SIZE_LIMIT & j64;
                long j66 = j54 + (j * j62);
                int i12 = (int) j66;
                iArr2[6] = (i11 >>> 31) | (i12 << 1);
                int i13 = i12 >>> 31;
                long j67 = j56 + (j66 >>> 32) + (j62 * j12);
                long j68 = j58 + (j67 >>> 32) + (j62 * j19);
                long j69 = j63 + (j68 >>> 32) + (j62 * j31);
                long j70 = (j59 & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j69 >>> 32) + (j62 * j44);
                long j71 = j65 + (j70 >>> 32) + (j62 * j61);
                long j72 = (((long) iArr2[12]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j64 >>> 32) + (j71 >>> 32);
                int i14 = (int) j67;
                iArr2[7] = i13 | (i14 << 1);
                int i15 = (int) j68;
                iArr2[8] = (i14 >>> 31) | (i15 << 1);
                int i16 = (int) j69;
                iArr2[9] = (i15 >>> 31) | (i16 << 1);
                int i17 = i16 >>> 31;
                int i18 = (int) j70;
                iArr2[10] = i17 | (i18 << 1);
                int i19 = i18 >>> 31;
                int i20 = (int) j71;
                iArr2[11] = i19 | (i20 << 1);
                int i21 = i20 >>> 31;
                int i22 = (int) j72;
                iArr2[12] = i21 | (i22 << 1);
                iArr2[13] = (i22 >>> 31) | ((iArr2[13] + ((int) (j72 >>> 32))) << 1);
                return;
            }
            i2 = i4;
            i3 = i6;
        }
    }

    public static boolean getInstance(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 7; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int init(int[] iArr, int[] iArr2, int[] iArr3) {
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
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[6] = (int) j7;
        return (int) (j7 >>> 32);
    }

    public static BigInteger init(int[] iArr) {
        byte[] bArr = new byte[28];
        for (int i = 0; i < 7; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                setMinimumWidth.getInstance(i2, bArr, (6 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void init(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
    }

    public static void init(int[] iArr, int[] iArr2, int i) {
        iArr2[i] = iArr[0];
        iArr2[i + 1] = iArr[1];
        iArr2[i + 2] = iArr[2];
        iArr2[i + 3] = iArr[3];
        iArr2[i + 4] = iArr[4];
        iArr2[i + 5] = iArr[5];
        iArr2[i + 6] = iArr[6];
    }

    public static int[] configure(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 224) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[7];
        int i = 0;
        while (bigInteger.signum() != 0) {
            iArr[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i++;
        }
        return iArr;
    }

    public static int init(long j, int[] iArr) {
        long j2 = j & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = (j2 * 6803) + (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr[0] = (int) j3;
        long j4 = j >>> 32;
        long j5 = (j3 >>> 32) + (6803 * j4) + j2 + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr[1] = (int) j5;
        long j6 = (j5 >>> 32) + j4 + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr[2] = (int) j6;
        long j7 = (j6 >>> 32) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[3]));
        iArr[3] = (int) j7;
        if ((j7 >>> 32) == 0) {
            return 0;
        }
        for (int i = 4; i < 7; i++) {
            int i2 = i + 0;
            int i3 = iArr[i2] + 1;
            iArr[i2] = i3;
            if (i3 != 0) {
                return 0;
            }
        }
        return 1;
    }
}
