package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setDrawingCacheQuality */
public abstract class setDrawingCacheQuality {
    public static int Cardinal(int i, int[] iArr, int i2, int[] iArr2) {
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            iArr2[i3] = (i2 >>> 31) | (i4 << 1);
            i3++;
            i2 = i4;
        }
        return i2 >>> 31;
    }

    public static BigInteger Cardinal(int i, int[] iArr) {
        byte[] bArr = new byte[(i << 2)];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                setMinimumWidth.getInstance(i3, bArr, ((i - 1) - i2) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static boolean Cardinal(int i, int[] iArr, int[] iArr2) {
        do {
            i--;
            if (i < 0) {
                return true;
            }
        } while (iArr[i] == iArr2[i]);
        return false;
    }

    public static int cca_continue(int i, int[] iArr, int[] iArr2) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = j + ((((long) iArr2[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[i2])));
            iArr2[i2] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    public static int cca_continue(int i, int[] iArr, int[] iArr2, int i2) {
        long j = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i2 + i3;
            long j2 = j + (((long) iArr[i3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr2[i4]));
            iArr2[i4] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static int cca_continue(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = j + (((long) iArr[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr2[i2]));
            iArr3[i2] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static int cca_continue(int[] iArr, int i, int[] iArr2) {
        int i2 = 16;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i << -9;
            }
            int i3 = iArr[i2 + 16];
            iArr2[i2] = (i << -9) | (i3 >>> 9);
            i = i3;
        }
    }

    public static int configure(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        long j = ((long) i2) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = 0;
        int i4 = 0;
        do {
            int i5 = i3 + i4;
            long j3 = j2 + ((((long) iArr[i4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * j) + (((long) iArr2[i5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr2[i5] = (int) j3;
            j2 = j3 >>> 32;
            i4++;
        } while (i4 < i);
        return (int) j2;
    }

    public static int configure(int i, int[] iArr, int[] iArr2) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = j + (((long) iArr[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr2[i2]));
            iArr2[i2] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static int configure(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = j + ((((long) iArr[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr2[i2])));
            iArr3[i2] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    public static long configure(int i, long[] jArr, long j) {
        int i2 = 0;
        while (i2 < i) {
            long j2 = jArr[i2];
            jArr[i2] = (j >>> -8) | (j2 << 8);
            i2++;
            j = j2;
        }
        return j >>> -8;
    }

    public static void configure(int i, int i2, int[] iArr, int i3, int[] iArr2) {
        int i4 = -(i2 & 1);
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = iArr2[i5];
            iArr2[i5] = i6 ^ ((iArr[i3 + i5] ^ i6) & i4);
        }
    }

    public static boolean configure(int i, int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i2 = 1; i2 < i; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int getInstance(int i, int i2, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((long) (-(i2 & 1))) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            long j3 = j2 + (((long) iArr[i3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[i3]) & j);
            iArr3[i3] = (int) j3;
            j2 = j3 >>> 32;
        }
        return (int) j2;
    }

    public static int getInstance(int i, int[] iArr, int i2) {
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            iArr[i3] = (i2 >>> -2) | (i4 << 2);
            i3++;
            i2 = i4;
        }
        return i2 >>> -2;
    }

    public static int getInstance(int i, int[] iArr, int[] iArr2) {
        int i2 = 0;
        while (i2 < i) {
            int i3 = iArr[i2] + 1;
            iArr2[i2] = i3;
            i2++;
            if (i3 != 0) {
                while (i2 < i) {
                    iArr2[i2] = iArr[i2];
                    i2++;
                }
                return 0;
            }
        }
        return 1;
    }

    public static int getInstance(int i, int[] iArr, int[] iArr2, int i2) {
        long j = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i2 + i3;
            long j2 = j + ((((long) iArr2[i4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[i3])));
            iArr2[i4] = (int) j2;
            j = j2 >> 32;
        }
        return (int) j;
    }

    public static int getInstance(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = j + (((long) iArr[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) iArr2[i2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr3[i2]));
            iArr3[i2] = (int) j2;
            j = j2 >>> 32;
        }
        return (int) j;
    }

    public static int init(int i, int[] iArr, int i2) {
        while (true) {
            i--;
            if (i < 0) {
                return i2 << 31;
            }
            int i3 = iArr[i];
            iArr[i] = (i2 << 31) | (i3 >>> 1);
            i2 = i3;
        }
    }

    public static int init(int i, int[] iArr, int i2, int[] iArr2) {
        int i3 = 0;
        while (i3 < i) {
            int i4 = iArr[i3];
            iArr2[i3] = (i2 >>> -3) | (i4 << 3);
            i3++;
            i2 = i4;
        }
        return i2 >>> -3;
    }

    public static int init(int[] iArr, int i, int[] iArr2) {
        int i2 = 0;
        while (i2 < 8) {
            int i3 = iArr[i2 + 8];
            iArr2[i2] = (i >>> 31) | (i3 << 1);
            i2++;
            i = i3;
        }
        return i >>> 31;
    }

    public static boolean init(int i, int[] iArr) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean init(int i, int[] iArr, int[] iArr2) {
        int i2;
        int i3;
        do {
            i--;
            if (i < 0) {
                break;
            }
            i2 = iArr[i] ^ Integer.MIN_VALUE;
            i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
        } while (i2 <= i3);
        return true;
    }

    public static int init(int i, int i2, int[] iArr) {
        long j = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (((long) i2) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr[0] = (int) j;
        long j2 = (j >>> 32) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[1])) + 1;
        iArr[1] = (int) j2;
        if ((j2 >>> 32) == 0) {
            return 0;
        }
        for (int i3 = 2; i3 < i; i3++) {
            int i4 = iArr[i3] + 1;
            iArr[i3] = i4;
            if (i4 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int getInstance(int i, int i2, int[] iArr, int i3) {
        long j = (((long) i2) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[i3]));
        iArr[i3] = (int) j;
        if ((j >>> 32) == 0) {
            return 0;
        }
        for (int i4 = i3 + 1; i4 < i; i4++) {
            int i5 = iArr[i4] + 1;
            iArr[i4] = i5;
            if (i5 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int getInstance(int i, int i2, int[] iArr) {
        long j = (((long) i2) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[0]));
        iArr[0] = (int) j;
        if ((j >>> 32) == 0) {
            return 0;
        }
        for (int i3 = 1; i3 < i; i3++) {
            int i4 = iArr[i3] + 1;
            iArr[i3] = i4;
            if (i4 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int[] cca_continue(int i, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
            throw new IllegalArgumentException();
        }
        int[] iArr = new int[((i + 31) >> 5)];
        int i2 = 0;
        while (bigInteger.signum() != 0) {
            iArr[i2] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i2++;
        }
        return iArr;
    }

    public static int Cardinal(int i, int i2, int[] iArr) {
        long j = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) i2) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
        iArr[0] = (int) j;
        long j2 = (j >> 32) + ((InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[1])) - 1);
        iArr[1] = (int) j2;
        if ((j2 >> 32) == 0) {
            return 0;
        }
        for (int i3 = 2; i3 < i; i3++) {
            int i4 = iArr[i3] - 1;
            iArr[i3] = i4;
            if (i4 != -1) {
                return 0;
            }
        }
        return -1;
    }
}
