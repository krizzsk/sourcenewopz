package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setCCAId */
public final class setCCAId {

    /* renamed from: a */
    static final int[] f2715a = {-1, -1, -2, -1, -1, -1};

    /* renamed from: b */
    private static int[] f2716b = {1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};

    /* renamed from: c */
    private static final int[] f2717c = {-1, -1, -3, -1, -2, -1, 1, 0, 2};

    public static void Cardinal(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.getInstance(6, iArr, iArr2) != 0 || (iArr2[5] == -1 && setKeepScreenOn.init(iArr2, f2715a))) {
            m1979a(iArr2);
        }
    }

    public static void getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setKeepScreenOn.cca_continue(iArr, iArr2, iArr3) != 0 || (iArr3[5] == -1 && setKeepScreenOn.init(iArr3, f2715a))) {
            m1979a(iArr3);
        }
    }

    public static void init(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.Cardinal(6, iArr, 0, iArr2) != 0 || (iArr2[5] == -1 && setKeepScreenOn.init(iArr2, f2715a))) {
            m1979a(iArr2);
        }
    }

    public static int[] init(BigInteger bigInteger) {
        int[] init = setKeepScreenOn.init(bigInteger);
        if (init[5] == -1 && setKeepScreenOn.init(init, f2715a)) {
            setKeepScreenOn.CardinalError(f2715a, init);
        }
        return init;
    }

    public static void init(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[12];
        setKeepScreenOn.getInstance(iArr, iArr2, iArr4);
        configure(iArr4, iArr3);
    }

    public static void configure(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setKeepScreenOn.configure(iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && setDrawingCacheQuality.init(12, iArr3, f2716b))) {
            int[] iArr4 = f2717c;
            if (setDrawingCacheQuality.configure(iArr4.length, iArr4, iArr3) != 0) {
                int length = f2717c.length;
                while (length < 12) {
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

    public static void cca_continue(int[] iArr, int[] iArr2) {
        if (setKeepScreenOn.init(iArr)) {
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            iArr2[4] = 0;
            iArr2[5] = 0;
            return;
        }
        setKeepScreenOn.cleanup(f2715a, iArr, iArr2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00b7, code lost:
        if (r16 == false) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void configure(int[] r26, int[] r27) {
        /*
            r0 = r27
            r1 = 6
            r2 = r26[r1]
            long r2 = (long) r2
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r4
            r6 = 7
            r6 = r26[r6]
            long r6 = (long) r6
            long r6 = r6 & r4
            r8 = 8
            r8 = r26[r8]
            long r8 = (long) r8
            long r8 = r8 & r4
            r10 = 9
            r10 = r26[r10]
            long r10 = (long) r10
            long r10 = r10 & r4
            r12 = 10
            r12 = r26[r12]
            long r12 = (long) r12
            long r12 = r12 & r4
            r14 = 11
            r14 = r26[r14]
            long r14 = (long) r14
            long r14 = r14 & r4
            long r12 = r12 + r2
            long r14 = r14 + r6
            r16 = 0
            r1 = r26[r16]
            r17 = r6
            long r6 = (long) r1
            long r6 = r6 & r4
            long r6 = r6 + r12
            r19 = 0
            long r6 = r6 + r19
            int r1 = (int) r6
            r21 = 32
            long r6 = r6 >> r21
            r22 = 1
            r23 = r1
            r1 = r26[r22]
            r24 = r2
            long r1 = (long) r1
            long r1 = r1 & r4
            long r1 = r1 + r14
            long r6 = r6 + r1
            int r1 = (int) r6
            r0[r22] = r1
            long r1 = r6 >> r21
            long r12 = r12 + r8
            long r14 = r14 + r10
            r3 = 2
            r6 = r26[r3]
            long r6 = (long) r6
            long r6 = r6 & r4
            long r6 = r6 + r12
            long r1 = r1 + r6
            long r6 = r1 & r4
            long r1 = r1 >> r21
            r8 = 3
            r9 = r26[r8]
            long r9 = (long) r9
            long r9 = r9 & r4
            long r9 = r9 + r14
            long r1 = r1 + r9
            int r9 = (int) r1
            r0[r8] = r9
            long r1 = r1 >> r21
            long r12 = r12 - r24
            long r14 = r14 - r17
            r9 = 4
            r10 = r26[r9]
            long r10 = (long) r10
            long r10 = r10 & r4
            long r10 = r10 + r12
            long r1 = r1 + r10
            int r10 = (int) r1
            r0[r9] = r10
            long r1 = r1 >> r21
            r9 = 5
            r10 = r26[r9]
            long r10 = (long) r10
            long r10 = r10 & r4
            long r10 = r10 + r14
            long r1 = r1 + r10
            int r10 = (int) r1
            r0[r9] = r10
            long r1 = r1 >> r21
            long r6 = r6 + r1
            r10 = r23
            long r10 = (long) r10
            long r10 = r10 & r4
            long r1 = r1 + r10
            int r10 = (int) r1
            r0[r16] = r10
            long r1 = r1 >> r21
            int r10 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r10 == 0) goto L_0x009d
            r10 = r0[r22]
            long r10 = (long) r10
            long r4 = r4 & r10
            long r1 = r1 + r4
            int r4 = (int) r1
            r0[r22] = r4
            long r1 = r1 >> r21
            long r6 = r6 + r1
        L_0x009d:
            int r1 = (int) r6
            r0[r3] = r1
            long r1 = r6 >> r21
            int r3 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r3 == 0) goto L_0x00b9
            r1 = 6
        L_0x00a7:
            if (r8 >= r1) goto L_0x00b5
            r2 = r0[r8]
            int r2 = r2 + 1
            r0[r8] = r2
            if (r2 == 0) goto L_0x00b2
            goto L_0x00b7
        L_0x00b2:
            int r8 = r8 + 1
            goto L_0x00a7
        L_0x00b5:
            r16 = 1
        L_0x00b7:
            if (r16 != 0) goto L_0x00c6
        L_0x00b9:
            r1 = r0[r9]
            r2 = -1
            if (r1 != r2) goto L_0x00c9
            int[] r1 = f2715a
            boolean r1 = com.cardinalcommerce.p060a.setKeepScreenOn.init((int[]) r0, (int[]) r1)
            if (r1 == 0) goto L_0x00c9
        L_0x00c6:
            m1979a(r27)
        L_0x00c9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setCCAId.configure(int[], int[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        if (r0 == false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void init(int r13, int[] r14) {
        /*
            r0 = 0
            r1 = 0
            r3 = 1
            if (r13 == 0) goto L_0x0033
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
            int r10 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r10 == 0) goto L_0x0026
            r10 = r14[r3]
            long r10 = (long) r10
            long r10 = r10 & r6
            long r8 = r8 + r10
            int r10 = (int) r8
            r14[r3] = r10
            long r8 = r8 >> r13
        L_0x0026:
            r10 = 2
            r11 = r14[r10]
            long r11 = (long) r11
            long r6 = r6 & r11
            long r6 = r6 + r4
            long r8 = r8 + r6
            int r4 = (int) r8
            r14[r10] = r4
            long r4 = r8 >> r13
            goto L_0x0034
        L_0x0033:
            r4 = r1
        L_0x0034:
            int r13 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r13 == 0) goto L_0x004a
            r13 = 3
        L_0x0039:
            r1 = 6
            if (r13 >= r1) goto L_0x0047
            r1 = r14[r13]
            int r1 = r1 + r3
            r14[r13] = r1
            if (r1 == 0) goto L_0x0044
            goto L_0x0048
        L_0x0044:
            int r13 = r13 + 1
            goto L_0x0039
        L_0x0047:
            r0 = 1
        L_0x0048:
            if (r0 != 0) goto L_0x0058
        L_0x004a:
            r13 = 5
            r13 = r14[r13]
            r0 = -1
            if (r13 != r0) goto L_0x005b
            int[] r13 = f2715a
            boolean r13 = com.cardinalcommerce.p060a.setKeepScreenOn.init((int[]) r14, (int[]) r13)
            if (r13 == 0) goto L_0x005b
        L_0x0058:
            m1979a(r14)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setCCAId.init(int, int[]):void");
    }

    public static void getInstance(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[12];
        setKeepScreenOn.getInstance(iArr, iArr3);
        configure(iArr3, iArr2);
    }

    public static void Cardinal(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[12];
        setKeepScreenOn.getInstance(iArr, iArr3);
        while (true) {
            configure(iArr3, iArr2);
            i--;
            if (i > 0) {
                setKeepScreenOn.getInstance(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setKeepScreenOn.cleanup(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - 1;
            iArr3[0] = (int) j;
            long j2 = j >> 32;
            if (j2 != 0) {
                long j3 = j2 + (((long) iArr3[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr3[1] = (int) j3;
                j2 = j3 >> 32;
            }
            long j4 = j2 + ((InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr3[2])) - 1);
            iArr3[2] = (int) j4;
            if ((j4 >> 32) != 0) {
                int i = 3;
                while (i < 6) {
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
    private static void m1979a(int[] iArr) {
        long j = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr[1] = (int) j3;
            j2 = j3 >> 32;
        }
        long j4 = j2 + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[2])) + 1;
        iArr[2] = (int) j4;
        if ((j4 >> 32) != 0) {
            int i = 3;
            while (i < 6) {
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
