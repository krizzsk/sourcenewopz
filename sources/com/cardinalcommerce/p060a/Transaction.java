package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.Transaction */
public final class Transaction {

    /* renamed from: a */
    static final int[] f2487a = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};

    /* renamed from: b */
    private static final int[] f2488b = {361, 0, 0, 0, 0, 0, 0, 0, -19, -1, -1, -1, -1, -1, -1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK};

    public static void Cardinal(int[] iArr, int[] iArr2) {
        setDrawingCacheQuality.Cardinal(8, iArr, 0, iArr2);
        if (setNextFocusLeftId.configure(iArr2, f2487a)) {
            m1832a(iArr2);
        }
    }

    public static void Cardinal(int[] iArr, int[] iArr2, int[] iArr3) {
        setNextFocusLeftId.getInstance(iArr, iArr2, iArr3);
        if (setNextFocusLeftId.configure(iArr3, f2487a)) {
            m1832a(iArr3);
        }
    }

    public static void configure(int[] iArr, int[] iArr2) {
        int i = iArr[7];
        setDrawingCacheQuality.init(iArr, i, iArr2);
        int i2 = iArr2[7];
        iArr2[7] = (Integer.MAX_VALUE & i2) + setDrawingCacheQuality.getInstance(7, ((setNextFocusLeftId.cca_continue(iArr, iArr2) << 1) + ((i2 >>> 31) - (i >>> 31))) * 19, iArr2);
        if (setNextFocusLeftId.configure(iArr2, f2487a)) {
            m1832a(iArr2);
        }
    }

    public static void getInstance(int[] iArr, int[] iArr2) {
        setDrawingCacheQuality.getInstance(8, iArr, iArr2);
        if (setNextFocusLeftId.configure(iArr2, f2487a)) {
            m1832a(iArr2);
        }
    }

    public static void init(int i, int[] iArr) {
        int i2 = iArr[7];
        iArr[7] = (i2 & Integer.MAX_VALUE) + setDrawingCacheQuality.getInstance(7, ((i << 1) | (i2 >>> 31)) * 19, iArr);
        if (setNextFocusLeftId.configure(iArr, f2487a)) {
            m1832a(iArr);
        }
    }

    public static void init(int[] iArr, int[] iArr2) {
        if (setNextFocusLeftId.getInstance(iArr)) {
            setNextFocusLeftId.cca_continue(iArr2);
        } else {
            setNextFocusLeftId.getWarnings(f2487a, iArr, iArr2);
        }
    }

    public static int[] init(BigInteger bigInteger) {
        int[] Cardinal = setNextFocusLeftId.Cardinal(bigInteger);
        while (setNextFocusLeftId.configure(Cardinal, f2487a)) {
            setNextFocusLeftId.getWarnings(f2487a, Cardinal);
        }
        return Cardinal;
    }

    public static void init(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[16];
        setNextFocusLeftId.cca_continue(iArr, iArr2, iArr4);
        configure(iArr4, iArr3);
    }

    public static void configure(int[] iArr, int[] iArr2, int[] iArr3) {
        int i;
        setNextFocusLeftId.init(iArr, iArr2, iArr3);
        if (setDrawingCacheQuality.init(16, iArr3, f2488b)) {
            int i2 = 0;
            long j = (((long) iArr3[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) f2488b[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr3[0] = (int) j;
            long j2 = j >> 32;
            if (j2 != 0) {
                int i3 = 1;
                while (true) {
                    i = -1;
                    if (i3 >= 8) {
                        break;
                    }
                    int i4 = iArr3[i3] - 1;
                    iArr3[i3] = i4;
                    if (i4 != -1) {
                        i = 0;
                        break;
                    }
                    i3++;
                }
                j2 = (long) i;
            }
            long j3 = j2 + (((long) iArr3[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 19;
            iArr3[8] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                int i5 = 9;
                while (true) {
                    if (i5 >= 15) {
                        i2 = 1;
                        break;
                    }
                    int i6 = iArr3[i5] + 1;
                    iArr3[i5] = i6;
                    if (i6 != 0) {
                        break;
                    }
                    i5++;
                }
                j4 = (long) i2;
            }
            iArr3[15] = (int) (j4 + ((((long) iArr3[15]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) (f2488b[15] + 1)))));
        }
    }

    public static void cca_continue(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        setNextFocusLeftId.getSDKVersion(iArr, iArr3);
        configure(iArr3, iArr2);
    }

    public static void configure(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[16];
        setNextFocusLeftId.getSDKVersion(iArr, iArr3);
        while (true) {
            configure(iArr3, iArr2);
            i--;
            if (i > 0) {
                setNextFocusLeftId.getSDKVersion(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setNextFocusLeftId.getWarnings(iArr, iArr2, iArr3) != 0) {
            int i = 0;
            long j = (((long) iArr3[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - 19;
            iArr3[0] = (int) j;
            long j2 = j >> 32;
            if (j2 != 0) {
                int i2 = 1;
                while (true) {
                    if (i2 >= 7) {
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
                j2 = (long) i;
            }
            iArr3[7] = (int) (j2 + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr3[7])) + 2147483648L);
        }
    }

    /* renamed from: a */
    private static int m1832a(int[] iArr) {
        int i = 0;
        long j = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 19;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            int i2 = 1;
            while (true) {
                if (i2 >= 7) {
                    i = 1;
                    break;
                }
                int i3 = iArr[i2] + 1;
                iArr[i2] = i3;
                if (i3 != 0) {
                    break;
                }
                i2++;
            }
            j2 = (long) i;
        }
        long j3 = j2 + ((InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[7])) - 2147483648L);
        iArr[7] = (int) j3;
        return (int) (j3 >> 32);
    }
}
