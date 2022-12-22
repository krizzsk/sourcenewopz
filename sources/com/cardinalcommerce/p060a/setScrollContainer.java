package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setScrollContainer */
public abstract class setScrollContainer {
    public static long Cardinal(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = (j * 21389) + (((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr3[0] = (int) j2;
        long j3 = ((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = (j2 >>> 32) + (j3 * 21389) + j + (((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[1] = (int) j4;
        long j5 = j4 >>> 32;
        long j6 = ((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = j5 + (j6 * 21389) + j3 + (((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[2] = (int) j7;
        long j8 = ((long) iArr[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j9 = (j7 >>> 32) + (j8 * 21389) + j6 + (((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[3] = (int) j9;
        long j10 = ((long) iArr[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j11 = (j9 >>> 32) + (21389 * j10) + j8 + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr2[4]));
        iArr3[4] = (int) j11;
        return (j11 >>> 32) + j10;
    }

    public static boolean Cardinal(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 5; i++) {
            if (iArr[i] != 0) {
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
        long j5 = (j4 >>> 32) + (((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr3[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr3[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    public static boolean cca_continue(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
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

    public static int configure(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = ((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = 0;
        while (i < 5) {
            long j8 = ((long) iArr[i]) & j;
            long j9 = (j8 * j2) + (((long) iArr3[i]) & j) + 0;
            iArr3[i] = (int) j9;
            int i2 = i + 1;
            long j10 = j3;
            long j11 = (j9 >>> 32) + (j8 * j3) + (((long) iArr3[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i2] = (int) j11;
            int i3 = i + 2;
            long j12 = j4;
            long j13 = (j11 >>> 32) + (j8 * j4) + (((long) iArr3[i3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i3] = (int) j13;
            int i4 = i + 3;
            long j14 = (j13 >>> 32) + (j8 * j5) + (((long) iArr3[i4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i4] = (int) j14;
            int i5 = i + 4;
            long j15 = (j14 >>> 32) + (j8 * j6) + (((long) iArr3[i5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i5] = (int) j15;
            int i6 = i + 5;
            long j16 = (j15 >>> 32) + j7 + (((long) iArr3[i6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i6] = (int) j16;
            j7 = j16 >>> 32;
            i = i2;
            j = 4294967295L;
            j2 = j2;
            j3 = j10;
            j4 = j12;
        }
        return (int) j7;
    }

    public static boolean configure(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int getInstance(int[] iArr, int[] iArr2) {
        long j = ((((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT)) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
        iArr2[3] = (int) j4;
        long j5 = (j4 >> 32) + ((((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[4])));
        iArr2[4] = (int) j5;
        return (int) (j5 >> 32);
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
        return (int) (j5 >>> 32);
    }

    public static BigInteger getInstance(int[] iArr) {
        byte[] bArr = new byte[20];
        for (int i = 0; i < 5; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                setMinimumWidth.getInstance(i2, bArr, (4 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void getInstance(int[] iArr, int[] iArr2, int i) {
        iArr2[i] = iArr[0];
        iArr2[i + 1] = iArr[1];
        iArr2[i + 2] = iArr[2];
        iArr2[i + 3] = iArr[3];
        iArr2[i + 4] = iArr[4];
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
        return (int) (j5 >> 32);
    }

    public static void init(int[] iArr, int[] iArr2) {
        long j = ((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        int i = 10;
        int i2 = 4;
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
                long j11 = j;
                long j12 = ((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j13 = ((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j14 = j9 + (j10 * j11);
                int i8 = (int) j14;
                iArr2[2] = (i8 << 1) | (i7 >>> 31);
                long j15 = j12 + (j14 >>> 32) + (j10 * j6);
                long j16 = j13 + (j15 >>> 32);
                long j17 = j15 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j18 = ((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j19 = j10;
                long j20 = (((long) iArr2[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j16 >>> 32);
                long j21 = j16 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j22 = (((long) iArr2[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j20 >>> 32);
                long j23 = j20 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j24 = j17 + (j18 * j11);
                int i9 = (int) j24;
                iArr2[3] = (i9 << 1) | (i8 >>> 31);
                int i10 = i9 >>> 31;
                long j25 = j21 + (j24 >>> 32) + (j18 * j6);
                long j26 = j23 + (j25 >>> 32) + (j18 * j19);
                long j27 = j25 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j28 = j22 + (j26 >>> 32);
                long j29 = j26 & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j30 = ((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
                long j31 = (((long) iArr2[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j28 >>> 32);
                long j32 = InternalZipConstants.ZIP_64_SIZE_LIMIT & j31;
                long j33 = j27 + (j30 * j11);
                int i11 = (int) j33;
                iArr2[4] = i10 | (i11 << 1);
                long j34 = j29 + (j33 >>> 32) + (j6 * j30);
                long j35 = (j28 & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j34 >>> 32) + (j30 * j19);
                long j36 = j32 + (j35 >>> 32) + (j30 * j18);
                long j37 = (((long) iArr2[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (j31 >>> 32) + (j36 >>> 32);
                int i12 = (int) j34;
                iArr2[5] = (i11 >>> 31) | (i12 << 1);
                int i13 = (int) j35;
                iArr2[6] = (i13 << 1) | (i12 >>> 31);
                int i14 = i13 >>> 31;
                int i15 = (int) j36;
                iArr2[7] = i14 | (i15 << 1);
                int i16 = i15 >>> 31;
                int i17 = (int) j37;
                iArr2[8] = i16 | (i17 << 1);
                iArr2[9] = (i17 >>> 31) | ((iArr2[9] + ((int) (j37 >>> 32))) << 1);
                return;
            }
            i2 = i4;
            i3 = i6;
        }
    }

    public static void init(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) iArr2[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        int i = 1;
        long j2 = ((long) iArr2[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr2[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr2[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr2[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = j3;
        long j7 = ((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j8 = (j7 * j) + 0;
        iArr3[0] = (int) j8;
        char c = ' ';
        long j9 = (j8 >>> 32) + (j7 * j2);
        iArr3[1] = (int) j9;
        long j10 = (j9 >>> 32) + (j7 * j6);
        iArr3[2] = (int) j10;
        long j11 = (j10 >>> 32) + (j7 * j4);
        iArr3[3] = (int) j11;
        long j12 = (j11 >>> 32) + (j7 * j5);
        iArr3[4] = (int) j12;
        int i2 = (int) (j12 >>> 32);
        iArr3[5] = i2;
        for (int i3 = 5; i < i3; i3 = 5) {
            long j13 = ((long) iArr[i]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            long j14 = (j13 * j) + (((long) iArr3[i]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
            iArr3[i] = (int) j14;
            int i4 = i + 1;
            long j15 = j;
            long j16 = (j14 >>> c) + (j13 * j2) + (((long) iArr3[i4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i4] = (int) j16;
            int i5 = i + 2;
            long j17 = (j16 >>> 32) + (j13 * j6) + (((long) iArr3[i5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i5] = (int) j17;
            int i6 = i + 3;
            long j18 = (j17 >>> 32) + (j13 * j4) + (((long) iArr3[i6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i6] = (int) j18;
            c = ' ';
            int i7 = i + 4;
            long j19 = (j18 >>> 32) + (j13 * j5) + (((long) iArr3[i7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[i7] = (int) j19;
            iArr3[i + 5] = (int) (j19 >>> 32);
            i = i4;
            j = j15;
        }
    }

    public static boolean init(int[] iArr) {
        for (int i = 0; i < 5; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] configure(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 160) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[5];
        int i = 0;
        while (bigInteger.signum() != 0) {
            iArr[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i++;
        }
        return iArr;
    }

    public static int cca_continue(long j, int[] iArr) {
        long j2 = j & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = (j2 * 21389) + (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr[0] = (int) j3;
        long j4 = j >>> 32;
        long j5 = (j3 >>> 32) + (21389 * j4) + j2 + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr[1] = (int) j5;
        long j6 = (j5 >>> 32) + j4 + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr[2] = (int) j6;
        long j7 = (j6 >>> 32) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[3]));
        iArr[3] = (int) j7;
        if ((j7 >>> 32) == 0) {
            return 0;
        }
        for (int i = 4; i < 5; i++) {
            int i2 = i + 0;
            int i3 = iArr[i2] + 1;
            iArr[i2] = i3;
            if (i3 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int init(int i, int[] iArr) {
        long j = ((((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * 2147483649L) + (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 0;
        iArr[0] = (int) j;
        long j2 = (j >>> 32) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[1]));
        iArr[1] = (int) j2;
        if ((j2 >>> 32) == 0) {
            return 0;
        }
        for (int i2 = 2; i2 < 5; i2++) {
            int i3 = i2 + 0;
            int i4 = iArr[i3] + 1;
            iArr[i3] = i4;
            if (i4 != 0) {
                return 0;
            }
        }
        return 1;
    }
}
