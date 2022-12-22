package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setNextFocusLeftId */
public abstract class setNextFocusLeftId {
    public static int Cardinal(int[] iArr, int i, int[] iArr2, int i2, int i3) {
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
        long j6 = (j5 >>> 32) + (((long) iArr[i + 5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[i8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[i8] = (int) j6;
        int i9 = i2 + 6;
        long j7 = (j6 >>> 32) + (((long) iArr[i + 6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[i9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[i9] = (int) j7;
        int i10 = i2 + 7;
        long j8 = (j7 >>> 32) + (((long) iArr[i + 7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr2[i10]));
        iArr2[i10] = (int) j8;
        return (int) (j8 >>> 32);
    }

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
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[6] = (int) j7;
        long j8 = (j7 >>> 32) + (((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static BigInteger Cardinal(int[] iArr) {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 8; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                setMinimumWidth.getInstance(i2, bArr, (7 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static boolean Cardinal(int[] iArr, int[] iArr2) {
        for (int i = 7; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static int m2037a(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
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
        long j7 = (j6 >> 32) + ((((long) iArr[i + 6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[i2 + 6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[6] = (int) j7;
        long j8 = (j7 >> 32) + ((((long) iArr[i + 7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[i2 + 7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[7] = (int) j8;
        return (int) (j8 >> 32);
    }

    /* renamed from: a */
    private static boolean m2038a(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 7; i3 >= 0; i3--) {
            int i4 = iArr[i3 + 8] ^ Integer.MIN_VALUE;
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

    public static int cca_continue(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * 19) + (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >>> 32) + ((((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * 19) + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[1] = (int) j2;
        long j3 = (j2 >>> 32) + ((((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * 19) + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[2] = (int) j3;
        long j4 = (j3 >>> 32) + ((((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * 19) + (((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[3] = (int) j4;
        long j5 = (j4 >>> 32) + ((((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * 19) + (((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[4] = (int) j5;
        long j6 = (j5 >>> 32) + ((((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * 19) + (((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[5] = (int) j6;
        long j7 = (j6 >>> 32) + ((((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * 19) + (((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[6] = (int) j7;
        long j8 = (j7 >>> 32) + ((((long) iArr2[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * 19) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[7]));
        iArr2[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static void cca_continue(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
        iArr[7] = 0;
    }

    public static void cca_continue(int[] iArr, int[] iArr2, int i) {
        iArr2[i] = iArr[0];
        iArr2[i + 1] = iArr[1];
        iArr2[i + 2] = iArr[2];
        iArr2[i + 3] = iArr[3];
        iArr2[i + 4] = iArr[4];
        iArr2[i + 5] = iArr[5];
        iArr2[i + 6] = iArr[6];
        iArr2[i + 7] = iArr[7];
    }

    public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = j3;
        long j7 = ((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = ((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j9 = ((long) iArr2[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j10 = ((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j11 = (j10 * j) + 0;
        iArr3[0] = (int) j11;
        char c = ' ';
        long j12 = (j11 >>> 32) + (j10 * j2);
        iArr3[1] = (int) j12;
        long j13 = (j12 >>> 32) + (j10 * j6);
        iArr3[2] = (int) j13;
        long j14 = (j13 >>> 32) + (j10 * j4);
        iArr3[3] = (int) j14;
        long j15 = (j14 >>> 32) + (j10 * j5);
        iArr3[4] = (int) j15;
        long j16 = (j15 >>> 32) + (j10 * j7);
        iArr3[5] = (int) j16;
        long j17 = (j16 >>> 32) + (j10 * j8);
        iArr3[6] = (int) j17;
        long j18 = (j17 >>> 32) + (j10 * j9);
        iArr3[7] = (int) j18;
        int i = (int) (j18 >>> 32);
        iArr3[8] = i;
        int i2 = 1;
        for (int i3 = 8; i2 < i3; i3 = 8) {
            long j19 = ((long) iArr[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            long j20 = (j19 * j) + (((long) iArr3[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
            long j21 = j;
            iArr3[i2] = (int) j20;
            int i4 = i2 + 1;
            long j22 = j2;
            long j23 = (j20 >>> c) + (j19 * j2) + (((long) iArr3[i4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i4] = (int) j23;
            int i5 = i2 + 2;
            long j24 = (j23 >>> 32) + (j19 * j6) + (((long) iArr3[i5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i5] = (int) j24;
            int i6 = i2 + 3;
            long j25 = (j24 >>> 32) + (j19 * j4) + (((long) iArr3[i6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i6] = (int) j25;
            int i7 = i2 + 4;
            long j26 = (j25 >>> 32) + (j19 * j5) + (((long) iArr3[i7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i7] = (int) j26;
            int i8 = i2 + 5;
            long j27 = (j26 >>> 32) + (j19 * j7) + (((long) iArr3[i8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i8] = (int) j27;
            int i9 = i2 + 6;
            long j28 = (j27 >>> 32) + (j19 * j8) + (((long) iArr3[i9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i9] = (int) j28;
            c = ' ';
            int i10 = i2 + 7;
            long j29 = (j28 >>> 32) + (j19 * j9) + (((long) iArr3[i10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i10] = (int) j29;
            iArr3[i2 + 8] = (int) (j29 >>> 32);
            j = j21;
            i2 = i4;
            j2 = j22;
        }
    }

    public static void cleanup(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        int i = 0;
        int i2 = 7;
        int i3 = 16;
        while (true) {
            int i4 = i2 - 1;
            long j2 = ((long) iArr[i2 + 8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            long j3 = j2 * j2;
            int i5 = i3 - 1;
            iArr2[i5 + 16] = (i << 31) | ((int) (j3 >>> 33));
            i3 = i5 - 1;
            iArr2[i3 + 16] = (int) (j3 >>> 1);
            i = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = (((long) (i << 31)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) | (j4 >>> 33);
                iArr2[16] = (int) j4;
                int i6 = ((int) (j4 >>> 32)) & 1;
                long j6 = ((long) iArr[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j7 = ((long) iArr2[18]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j8 = j5 + (j6 * j);
                int i7 = (int) j8;
                iArr2[17] = (i7 << 1) | i6;
                long j9 = j7 + (j8 >>> 32);
                long j10 = ((long) iArr[10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j11 = ((long) iArr2[19]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j12 = ((long) iArr2[20]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j13 = j9 + (j10 * j);
                int i8 = (int) j13;
                iArr2[18] = (i8 << 1) | (i7 >>> 31);
                long j14 = j11 + (j13 >>> 32) + (j10 * j6);
                long j15 = j12 + (j14 >>> 32);
                long j16 = j14 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j17 = ((long) iArr[11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j18 = j10;
                long j19 = (((long) iArr2[21]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j15 >>> 32);
                long j20 = j19 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j21 = j16 + (j17 * j);
                int i9 = (int) j21;
                iArr2[19] = (i8 >>> 31) | (i9 << 1);
                long j22 = (j15 & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j21 >>> 32) + (j17 * j6);
                long j23 = j20 + (j22 >>> 32) + (j17 * j18);
                long j24 = j22 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j25 = (((long) iArr2[22]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j19 >>> 32) + (j23 >>> 32);
                long j26 = j23 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j27 = j;
                long j28 = ((long) iArr[12]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j29 = (((long) iArr2[23]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j25 >>> 32);
                long j30 = j25 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j31 = j17;
                long j32 = (((long) iArr2[24]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j29 >>> 32);
                long j33 = j29 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j34 = j24 + (j28 * j27);
                int i10 = (int) j34;
                iArr2[20] = (i10 << 1) | (i9 >>> 31);
                long j35 = j26 + (j34 >>> 32) + (j28 * j6);
                long j36 = j30 + (j35 >>> 32) + (j28 * j18);
                long j37 = j35 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j38 = j33 + (j36 >>> 32) + (j28 * j31);
                long j39 = j36 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j40 = j32 + (j38 >>> 32);
                long j41 = j38 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j42 = j28;
                long j43 = ((long) iArr[13]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j44 = j41;
                long j45 = (((long) iArr2[25]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j40 >>> 32);
                long j46 = j40 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j47 = (((long) iArr2[26]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j45 >>> 32);
                long j48 = j45 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j49 = j37 + (j43 * j27);
                int i11 = (int) j49;
                iArr2[21] = (i11 << 1) | (i10 >>> 31);
                long j50 = j39 + (j49 >>> 32) + (j43 * j6);
                long j51 = j44 + (j50 >>> 32) + (j43 * j18);
                long j52 = j50 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j53 = j46 + (j51 >>> 32) + (j43 * j31);
                long j54 = j51 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j55 = j48 + (j53 >>> 32) + (j43 * j42);
                long j56 = j53 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j57 = j47 + (j55 >>> 32);
                long j58 = j55 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j59 = j43;
                long j60 = ((long) iArr[14]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j61 = j58;
                long j62 = (((long) iArr2[27]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j57 >>> 32);
                long j63 = j57 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j64 = (((long) iArr2[28]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j62 >>> 32);
                long j65 = j62 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j66 = j52 + (j60 * j27);
                int i12 = (int) j66;
                iArr2[22] = (i11 >>> 31) | (i12 << 1);
                long j67 = j54 + (j66 >>> 32) + (j60 * j6);
                long j68 = j56 + (j67 >>> 32) + (j60 * j18);
                long j69 = j67 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j70 = j61 + (j68 >>> 32) + (j60 * j31);
                long j71 = j68 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j72 = j63 + (j70 >>> 32) + (j60 * j42);
                long j73 = j70 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j74 = j65 + (j72 >>> 32) + (j60 * j59);
                long j75 = j72 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j76 = j64 + (j74 >>> 32);
                long j77 = j74 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j78 = j60;
                long j79 = ((long) iArr[15]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j80 = j77;
                long j81 = (((long) iArr2[29]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j76 >>> 32);
                long j82 = j81 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j83 = j69 + (j79 * j27);
                int i13 = (int) j83;
                iArr2[23] = (i12 >>> 31) | (i13 << 1);
                long j84 = j71 + (j83 >>> 32) + (j6 * j79);
                long j85 = j73 + (j84 >>> 32) + (j79 * j18);
                long j86 = j75 + (j85 >>> 32) + (j79 * j31);
                long j87 = j80 + (j86 >>> 32) + (j79 * j42);
                long j88 = j87;
                long j89 = (j76 & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j87 >>> 32) + (j79 * j59);
                long j90 = j82 + (j89 >>> 32) + (j79 * j78);
                long j91 = (((long) iArr2[30]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j81 >>> 32) + (j90 >>> 32);
                int i14 = (int) j84;
                iArr2[24] = (i14 << 1) | (i13 >>> 31);
                int i15 = (int) j85;
                iArr2[25] = (i14 >>> 31) | (i15 << 1);
                int i16 = i15 >>> 31;
                int i17 = (int) j86;
                iArr2[26] = i16 | (i17 << 1);
                int i18 = (int) j88;
                iArr2[27] = (i17 >>> 31) | (i18 << 1);
                int i19 = (int) j89;
                iArr2[28] = (i18 >>> 31) | (i19 << 1);
                int i20 = (int) j90;
                iArr2[29] = (i19 >>> 31) | (i20 << 1);
                int i21 = (int) j91;
                iArr2[30] = (i20 >>> 31) | (i21 << 1);
                iArr2[31] = (i21 >>> 31) | ((iArr2[31] + ((int) (j91 >>> 32))) << 1);
                return;
            }
            i2 = i4;
        }
    }

    public static boolean configure(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 8; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean configure(int[] iArr, int[] iArr2) {
        for (int i = 7; i >= 0; i--) {
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

    public static boolean configure(int[] iArr, int[] iArr2, int[] iArr3) {
        boolean a = m2038a(iArr, 8, iArr2, 0);
        if (a) {
            m2037a(iArr, 8, iArr2, 0, iArr3, 0);
        } else {
            m2037a(iArr2, 0, iArr, 8, iArr3, 0);
        }
        return a;
    }

    public static boolean configure(long[] jArr) {
        for (int i = 0; i < 4; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int getInstance(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[16]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        int i = (int) j;
        iArr[8] = i;
        iArr2[16] = i;
        long j2 = (j >>> 32) + (((long) iArr[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[17]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        int i2 = (int) j2;
        iArr[9] = i2;
        iArr2[17] = i2;
        long j3 = (j2 >>> 32) + (((long) iArr[10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[18]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        int i3 = (int) j3;
        iArr[10] = i3;
        iArr2[18] = i3;
        long j4 = (j3 >>> 32) + (((long) iArr[11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[19]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        int i4 = (int) j4;
        iArr[11] = i4;
        iArr2[19] = i4;
        long j5 = (j4 >>> 32) + (((long) iArr[12]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[20]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        int i5 = (int) j5;
        iArr[12] = i5;
        iArr2[20] = i5;
        long j6 = (j5 >>> 32) + (((long) iArr[13]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[21]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        int i6 = (int) j6;
        iArr[13] = i6;
        iArr2[21] = i6;
        long j7 = (j6 >>> 32) + (((long) iArr[14]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[22]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        int i7 = (int) j7;
        iArr[14] = i7;
        iArr2[22] = i7;
        long j8 = (j7 >>> 32) + (((long) iArr[15]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr2[23]));
        int i8 = (int) j8;
        iArr[15] = i8;
        iArr2[23] = i8;
        return (int) (j8 >>> 32);
    }

    public static int getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
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
        long j8 = (j7 >>> 32) + (((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static boolean getInstance(int[] iArr) {
        for (int i = 0; i < 8; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void getSDKVersion(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        int i = 16;
        int i2 = 7;
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
                long j65 = j59 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j66 = (((long) iArr2[12]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j64 >>> 32);
                long j67 = j64 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j68 = j54 + (j62 * j);
                int i12 = (int) j68;
                iArr2[6] = (i12 << 1) | (i11 >>> 31);
                long j69 = j56 + (j68 >>> 32) + (j62 * j12);
                long j70 = j58 + (j69 >>> 32) + (j62 * j19);
                long j71 = j69 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j72 = j63 + (j70 >>> 32) + (j62 * j31);
                long j73 = j70 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j74 = j65 + (j72 >>> 32) + (j62 * j44);
                long j75 = j72 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j76 = j67 + (j74 >>> 32) + (j62 * j61);
                long j77 = j74 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j78 = j66 + (j76 >>> 32);
                long j79 = j76 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j80 = j62;
                long j81 = ((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j82 = j79;
                long j83 = (((long) iArr2[13]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j78 >>> 32);
                long j84 = InternalZipConstants.ZIP_64_SIZE_LIMIT & j83;
                long j85 = j71 + (j * j81);
                int i13 = (int) j85;
                iArr2[7] = (i12 >>> 31) | (i13 << 1);
                int i14 = i13 >>> 31;
                long j86 = j73 + (j85 >>> 32) + (j81 * j12);
                long j87 = j75 + (j86 >>> 32) + (j81 * j19);
                long j88 = j77 + (j87 >>> 32) + (j81 * j31);
                long j89 = j82 + (j88 >>> 32) + (j81 * j44);
                long j90 = j89;
                long j91 = (j78 & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j89 >>> 32) + (j81 * j61);
                long j92 = j84 + (j91 >>> 32) + (j81 * j80);
                long j93 = (((long) iArr2[14]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j83 >>> 32) + (j92 >>> 32);
                int i15 = (int) j86;
                iArr2[8] = i14 | (i15 << 1);
                int i16 = (int) j87;
                iArr2[9] = (i15 >>> 31) | (i16 << 1);
                int i17 = i16 >>> 31;
                int i18 = (int) j88;
                iArr2[10] = i17 | (i18 << 1);
                int i19 = (int) j90;
                iArr2[11] = (i18 >>> 31) | (i19 << 1);
                int i20 = (int) j91;
                iArr2[12] = (i19 >>> 31) | (i20 << 1);
                int i21 = i20 >>> 31;
                int i22 = (int) j92;
                iArr2[13] = i21 | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j93;
                iArr2[14] = i23 | (i24 << 1);
                iArr2[15] = (i24 >>> 31) | ((iArr2[15] + ((int) (j93 >>> 32))) << 1);
                return;
            }
            i2 = i4;
            i3 = i6;
        }
    }

    public static int getWarnings(int[] iArr, int[] iArr2) {
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
        long j6 = (j5 >> 32) + ((((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr2[5] = (int) j6;
        long j7 = (j6 >> 32) + ((((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr2[6] = (int) j7;
        long j8 = (j7 >> 32) + ((((long) iArr2[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[7])));
        iArr2[7] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static int getWarnings(int[] iArr, int[] iArr2, int[] iArr3) {
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
        long j8 = (j7 >> 32) + ((((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr2[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr3[7] = (int) j8;
        return (int) (j8 >> 32);
    }

    public static int init(int[] iArr, int[] iArr2) {
        long j = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >>> 32) + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[1] = (int) j2;
        long j3 = (j2 >>> 32) + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[2] = (int) j3;
        long j4 = (j3 >>> 32) + (((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[3] = (int) j4;
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[4] = (int) j5;
        long j6 = (j5 >>> 32) + (((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[5] = (int) j6;
        long j7 = (j6 >>> 32) + (((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr2[6] = (int) j7;
        long j8 = (j7 >>> 32) + (((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr2[7]));
        iArr2[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    public static int init(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = ((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = ((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = j2;
        long j9 = ((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j10 = ((long) iArr2[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j11 = 0;
        int i = 0;
        while (i < 8) {
            long j12 = j10;
            long j13 = ((long) iArr[i]) & j;
            long j14 = j7;
            long j15 = (j13 * j8) + (((long) iArr3[i]) & j) + 0;
            iArr3[i] = (int) j15;
            int i2 = i + 1;
            long j16 = j3;
            long j17 = (j15 >>> 32) + (j13 * j3) + (((long) iArr3[i2]) & j);
            iArr3[i2] = (int) j17;
            int i3 = i + 2;
            long j18 = (j17 >>> 32) + (j13 * j4) + (((long) iArr3[i3]) & j);
            iArr3[i3] = (int) j18;
            int i4 = i + 3;
            long j19 = (j18 >>> 32) + (j13 * j5) + (((long) iArr3[i4]) & j);
            iArr3[i4] = (int) j19;
            int i5 = i + 4;
            long j20 = (j19 >>> 32) + (j13 * j6) + (((long) iArr3[i5]) & j);
            iArr3[i5] = (int) j20;
            int i6 = i + 5;
            long j21 = (j20 >>> 32) + (j13 * j14) + (((long) iArr3[i6]) & j);
            iArr3[i6] = (int) j21;
            int i7 = i + 6;
            long j22 = (j21 >>> 32) + (j13 * j9) + (((long) iArr3[i7]) & j);
            iArr3[i7] = (int) j22;
            int i8 = i + 7;
            long j23 = (j22 >>> 32) + (j13 * j12) + (((long) iArr3[i8]) & j);
            iArr3[i8] = (int) j23;
            int i9 = i + 8;
            long j24 = (j23 >>> 32) + j11 + (((long) iArr3[i9]) & j);
            iArr3[i9] = (int) j24;
            j11 = j24 >>> 32;
            i = i2;
            j10 = j12;
            j7 = j14;
            j3 = j16;
            j = InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }
        return (int) j11;
    }

    public static boolean init(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 4; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean init(long[] jArr, long[] jArr2) {
        for (int i = 3; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static long values(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = (j * 977) + (((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr3[0] = (int) j2;
        long j3 = ((long) iArr[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = (j2 >>> 32) + (j3 * 977) + j + (((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[1] = (int) j4;
        long j5 = j4 >>> 32;
        long j6 = ((long) iArr[10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = j5 + (j6 * 977) + j3 + (((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[2] = (int) j7;
        long j8 = ((long) iArr[11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j9 = (j7 >>> 32) + (j8 * 977) + j6 + (((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[3] = (int) j9;
        long j10 = ((long) iArr[12]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j11 = (j9 >>> 32) + (j10 * 977) + j8 + (((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[4] = (int) j11;
        long j12 = ((long) iArr[13]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j13 = (j11 >>> 32) + (j12 * 977) + j10 + (((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[5] = (int) j13;
        long j14 = ((long) iArr[14]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j15 = (j13 >>> 32) + (j14 * 977) + j12 + (((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[6] = (int) j15;
        long j16 = ((long) iArr[15]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j17 = (j15 >>> 32) + (977 * j16) + j14 + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr2[7]));
        iArr3[7] = (int) j17;
        return (j17 >>> 32) + j16;
    }

    public static int[] Cardinal(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 256) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[8];
        int i = 0;
        while (bigInteger.signum() != 0) {
            iArr[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i++;
        }
        return iArr;
    }

    public static long[] cca_continue(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 256) {
            throw new IllegalArgumentException();
        }
        long[] jArr = new long[4];
        int i = 0;
        while (bigInteger.signum() != 0) {
            jArr[i] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
            i++;
        }
        return jArr;
    }

    public static int cca_continue(long j, int[] iArr) {
        long j2 = j & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = (j2 * 977) + (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr[0] = (int) j3;
        long j4 = j >>> 32;
        long j5 = (j3 >>> 32) + (977 * j4) + j2 + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr[1] = (int) j5;
        long j6 = (j5 >>> 32) + j4 + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr[2] = (int) j6;
        long j7 = (j6 >>> 32) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[3]));
        iArr[3] = (int) j7;
        if ((j7 >>> 32) == 0) {
            return 0;
        }
        for (int i = 4; i < 8; i++) {
            int i2 = i + 0;
            int i3 = iArr[i2] + 1;
            iArr[i2] = i3;
            if (i3 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static BigInteger cca_continue(long[] jArr) {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 4; i++) {
            long j = jArr[i];
            if (j != 0) {
                int i2 = (3 - i) << 3;
                setMinimumWidth.getInstance((int) (j >>> 32), bArr, i2);
                setMinimumWidth.getInstance((int) j, bArr, i2 + 4);
            }
        }
        return new BigInteger(1, bArr);
    }
}
