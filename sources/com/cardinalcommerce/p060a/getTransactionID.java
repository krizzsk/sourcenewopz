package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.getTransactionID */
public final class getTransactionID {

    /* renamed from: a */
    static final int[] f2582a = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: b */
    private static int[] f2583b = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: c */
    private static final int[] f2584c = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    public static void Cardinal(int[] iArr, int[] iArr2) {
        int[] iArr3 = iArr2;
        long j = ((long) iArr[16]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j2 = ((long) iArr[17]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j3 = ((long) iArr[18]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j4 = ((long) iArr[19]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j5 = ((long) iArr[20]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j6 = ((long) iArr[21]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j7 = j4;
        long j8 = ((long) iArr[22]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j9 = j3;
        long j10 = ((long) iArr[23]) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        long j11 = j;
        long j12 = ((((long) iArr[12]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j5) - 1;
        long j13 = j5;
        long j14 = (((long) iArr[13]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j8;
        long j15 = (((long) iArr[14]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j8 + j10;
        long j16 = (((long) iArr[15]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j10;
        long j17 = j2 + j6;
        long j18 = j6 - j10;
        long j19 = j12 + j18;
        long j20 = j8 - j10;
        long j21 = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j19 + 0;
        iArr3[0] = (int) j21;
        long j22 = (j21 >> 32) + (((((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j10) - j12) + j14;
        iArr3[1] = (int) j22;
        long j23 = (j22 >> 32) + (((((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - j6) - j14) + j15;
        iArr3[2] = (int) j23;
        long j24 = (j23 >> 32) + ((((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - j15) + j16 + j19;
        iArr3[3] = (int) j24;
        long j25 = (j24 >> 32) + (((((((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j11) + j6) + j14) - j16) + j19;
        iArr3[4] = (int) j25;
        long j26 = (j25 >> 32) + ((((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - j11) + j14 + j15 + j17;
        iArr3[5] = (int) j26;
        long j27 = (j26 >> 32) + (((((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j9) - j2) + j15 + j16;
        iArr3[6] = (int) j27;
        long j28 = (j27 >> 32) + ((((((long) iArr[7]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j11) + j7) - j9) + j16;
        iArr3[7] = (int) j28;
        long j29 = (j28 >> 32) + (((((((long) iArr[8]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j11) + j2) + j13) - j7);
        iArr3[8] = (int) j29;
        long j30 = (j29 >> 32) + (((((long) iArr[9]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j9) - j13) + j17;
        iArr3[9] = (int) j30;
        long j31 = (j30 >> 32) + ((((((long) iArr[10]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j9) + j7) - j18) + j20;
        iArr3[10] = (int) j31;
        long j32 = (j31 >> 32) + ((((((long) iArr[11]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j7) + j13) - j20);
        iArr3[11] = (int) j32;
        configure((int) ((j32 >> 32) + 1), iArr3);
    }

    public static void cca_continue(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.Cardinal(12, iArr, 0, iArr2) != 0 || (iArr2[11] == -1 && setDrawingCacheQuality.init(12, iArr2, f2582a))) {
            m1905a(iArr2);
        }
    }

    public static int[] cca_continue(BigInteger bigInteger) {
        int[] cca_continue = setDrawingCacheQuality.cca_continue(384, bigInteger);
        if (cca_continue[11] == -1 && setDrawingCacheQuality.init(12, cca_continue, f2582a)) {
            setDrawingCacheQuality.cca_continue(12, f2582a, cca_continue);
        }
        return cca_continue;
    }

    public static void configure(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.getInstance(12, iArr, iArr2) != 0 || (iArr2[11] == -1 && setDrawingCacheQuality.init(12, iArr2, f2582a))) {
            m1905a(iArr2);
        }
    }

    public static void getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setDrawingCacheQuality.cca_continue(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && setDrawingCacheQuality.init(12, iArr3, f2582a))) {
            m1905a(iArr3);
        }
    }

    public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setDrawingCacheQuality.cca_continue(24, iArr, iArr2, iArr3) != 0 || (iArr3[23] == -1 && setDrawingCacheQuality.init(24, iArr3, f2583b))) {
            int[] iArr4 = f2584c;
            if (setDrawingCacheQuality.configure(iArr4.length, iArr4, iArr3) != 0) {
                int length = f2584c.length;
                while (length < 24) {
                    int i = iArr3[length] + 1;
                    iArr3[length] = i;
                    if (i == 0) {
                        length++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static void Cardinal(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[24];
        setNextFocusRightId.init(iArr, iArr2, iArr4);
        Cardinal(iArr4, iArr3);
    }

    public static void getInstance(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.init(12, iArr)) {
            for (int i = 0; i < 12; i++) {
                iArr2[i] = 0;
            }
            return;
        }
        setDrawingCacheQuality.configure(12, f2582a, iArr, iArr2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005f, code lost:
        if (r0 == false) goto L_0x0061;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void configure(int r13, int[] r14) {
        /*
            r0 = 0
            r1 = 0
            r3 = 1
            if (r13 == 0) goto L_0x0049
            long r4 = (long) r13
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r6
            r13 = r14[r0]
            long r8 = (long) r13
            long r8 = r8 & r6
            long r8 = r8 + r4
            long r8 = r8 + r1
            int r13 = (int) r8
            r14[r0] = r13
            r13 = 32
            long r8 = r8 >> r13
            r10 = r14[r3]
            long r10 = (long) r10
            long r10 = r10 & r6
            long r10 = r10 - r4
            long r8 = r8 + r10
            int r10 = (int) r8
            r14[r3] = r10
            long r8 = r8 >> r13
            int r10 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r10 == 0) goto L_0x0031
            r10 = 2
            r11 = r14[r10]
            long r11 = (long) r11
            long r11 = r11 & r6
            long r8 = r8 + r11
            int r11 = (int) r8
            r14[r10] = r11
            long r8 = r8 >> r13
        L_0x0031:
            r10 = 3
            r11 = r14[r10]
            long r11 = (long) r11
            long r11 = r11 & r6
            long r11 = r11 + r4
            long r8 = r8 + r11
            int r11 = (int) r8
            r14[r10] = r11
            long r8 = r8 >> r13
            r10 = 4
            r11 = r14[r10]
            long r11 = (long) r11
            long r6 = r6 & r11
            long r6 = r6 + r4
            long r8 = r8 + r6
            int r4 = (int) r8
            r14[r10] = r4
            long r4 = r8 >> r13
            goto L_0x004a
        L_0x0049:
            r4 = r1
        L_0x004a:
            r13 = 12
            int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r6 == 0) goto L_0x0061
            r1 = 5
        L_0x0051:
            if (r1 >= r13) goto L_0x005e
            r2 = r14[r1]
            int r2 = r2 + r3
            r14[r1] = r2
            if (r2 == 0) goto L_0x005b
            goto L_0x005f
        L_0x005b:
            int r1 = r1 + 1
            goto L_0x0051
        L_0x005e:
            r0 = 1
        L_0x005f:
            if (r0 != 0) goto L_0x0070
        L_0x0061:
            r0 = 11
            r0 = r14[r0]
            r1 = -1
            if (r0 != r1) goto L_0x0073
            int[] r0 = f2582a
            boolean r13 = com.cardinalcommerce.p060a.setDrawingCacheQuality.init((int) r13, (int[]) r14, (int[]) r0)
            if (r13 == 0) goto L_0x0073
        L_0x0070:
            m1905a(r14)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.getTransactionID.configure(int, int[]):void");
    }

    public static void init(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[24];
        setNextFocusRightId.Cardinal(iArr, iArr3);
        Cardinal(iArr3, iArr2);
    }

    public static void getInstance(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[24];
        setNextFocusRightId.Cardinal(iArr, iArr3);
        while (true) {
            Cardinal(iArr3, iArr2);
            i--;
            if (i > 0) {
                setNextFocusRightId.Cardinal(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    public static void init(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setDrawingCacheQuality.configure(12, iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - 1;
            iArr3[0] = (int) j;
            long j2 = (j >> 32) + (((long) iArr3[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 1;
            iArr3[1] = (int) j2;
            long j3 = j2 >> 32;
            if (j3 != 0) {
                long j4 = j3 + (((long) iArr3[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr3[2] = (int) j4;
                j3 = j4 >> 32;
            }
            long j5 = j3 + ((((long) iArr3[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - 1);
            iArr3[3] = (int) j5;
            long j6 = (j5 >> 32) + ((InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr3[4])) - 1);
            iArr3[4] = (int) j6;
            if ((j6 >> 32) != 0) {
                int i = 5;
                while (i < 12) {
                    int i2 = iArr3[i] - 1;
                    iArr3[i] = i2;
                    if (i2 == -1) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m1905a(int[] iArr) {
        long j = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 1;
        iArr[0] = (int) j;
        long j2 = (j >> 32) + ((((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - 1);
        iArr[1] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr[2] = (int) j4;
            j3 = j4 >> 32;
        }
        long j5 = j3 + (((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 1;
        iArr[3] = (int) j5;
        long j6 = (j5 >> 32) + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[4])) + 1;
        iArr[4] = (int) j6;
        if ((j6 >> 32) != 0) {
            int i = 5;
            while (i < 12) {
                int i2 = iArr[i] + 1;
                iArr[i] = i2;
                if (i2 == 0) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
