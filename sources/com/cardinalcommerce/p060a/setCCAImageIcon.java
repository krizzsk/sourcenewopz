package com.cardinalcommerce.p060a;

import java.math.BigInteger;
import net.lingala.zip4j.util.InternalZipConstants;

/* renamed from: com.cardinalcommerce.a.setCCAImageIcon */
public final class setCCAImageIcon {

    /* renamed from: a */
    static final int[] f2720a = {1, 0, 0, -1, -1, -1, -1};

    /* renamed from: b */
    private static int[] f2721b = {1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};

    /* renamed from: c */
    private static final int[] f2722c = {-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};

    public static void Cardinal(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.getInstance(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && setNextFocusDownId.configure(iArr2, f2720a))) {
            m1980a(iArr2);
        }
    }

    public static void cca_continue(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.Cardinal(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && setNextFocusDownId.configure(iArr2, f2720a))) {
            m1980a(iArr2);
        }
    }

    public static void init(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setNextFocusDownId.cca_continue(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && setNextFocusDownId.configure(iArr3, f2720a))) {
            m1980a(iArr3);
        }
    }

    public static int[] getInstance(BigInteger bigInteger) {
        int[] configure = setNextFocusDownId.configure(bigInteger);
        if (configure[6] == -1 && setNextFocusDownId.configure(configure, f2720a)) {
            int[] iArr = f2720a;
            long j = ((((long) configure[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT)) + 0;
            configure[0] = (int) j;
            long j2 = (j >> 32) + ((((long) configure[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
            configure[1] = (int) j2;
            long j3 = (j2 >> 32) + ((((long) configure[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
            configure[2] = (int) j3;
            long j4 = (j3 >> 32) + ((((long) configure[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[3]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
            configure[3] = (int) j4;
            long j5 = (j4 >> 32) + ((((long) configure[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[4]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
            configure[4] = (int) j5;
            long j6 = (j5 >> 32) + ((((long) configure[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[5]) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
            configure[5] = (int) j6;
            configure[6] = (int) ((j6 >> 32) + ((((long) configure[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - (((long) iArr[6]) & InternalZipConstants.ZIP_64_SIZE_LIMIT)));
        }
        return configure;
    }

    public static void configure(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[14];
        setNextFocusDownId.configure(iArr, iArr2, iArr4);
        init(iArr4, iArr3);
    }

    public static void Cardinal(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setNextFocusDownId.Cardinal(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && setDrawingCacheQuality.init(14, iArr3, f2721b))) {
            int[] iArr4 = f2722c;
            if (setDrawingCacheQuality.configure(iArr4.length, iArr4, iArr3) != 0) {
                int length = f2722c.length;
                while (length < 14) {
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

    public static void getInstance(int[] iArr, int[] iArr2) {
        if (setNextFocusDownId.cca_continue(iArr)) {
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            iArr2[4] = 0;
            iArr2[5] = 0;
            iArr2[6] = 0;
            return;
        }
        setNextFocusDownId.CardinalError(f2720a, iArr, iArr2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00df, code lost:
        if (r11 == false) goto L_0x00e1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void init(int[] r30, int[] r31) {
        /*
            r0 = r31
            r1 = 10
            r1 = r30[r1]
            long r1 = (long) r1
            r3 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r1 = r1 & r3
            r5 = 11
            r5 = r30[r5]
            long r5 = (long) r5
            long r5 = r5 & r3
            r7 = 12
            r7 = r30[r7]
            long r7 = (long) r7
            long r7 = r7 & r3
            r9 = 13
            r9 = r30[r9]
            long r9 = (long) r9
            long r9 = r9 & r3
            r11 = 7
            r12 = r30[r11]
            long r12 = (long) r12
            long r12 = r12 & r3
            long r12 = r12 + r5
            r14 = 1
            long r12 = r12 - r14
            r16 = 8
            r11 = r30[r16]
            long r14 = (long) r11
            long r14 = r14 & r3
            long r14 = r14 + r7
            r11 = 9
            r11 = r30[r11]
            r17 = r7
            long r7 = (long) r11
            long r7 = r7 & r3
            long r7 = r7 + r9
            r11 = 0
            r19 = r9
            r9 = r30[r11]
            long r9 = (long) r9
            long r9 = r9 & r3
            long r9 = r9 - r12
            r21 = 0
            long r9 = r9 + r21
            long r23 = r9 & r3
            r16 = 32
            long r9 = r9 >> r16
            r25 = 1
            r11 = r30[r25]
            r26 = r5
            long r5 = (long) r11
            long r5 = r5 & r3
            long r5 = r5 - r14
            long r9 = r9 + r5
            int r5 = (int) r9
            r0[r25] = r5
            long r5 = r9 >> r16
            r9 = 2
            r10 = r30[r9]
            long r10 = (long) r10
            long r10 = r10 & r3
            long r10 = r10 - r7
            long r5 = r5 + r10
            int r10 = (int) r5
            r0[r9] = r10
            long r5 = r5 >> r16
            r10 = 3
            r11 = r30[r10]
            long r10 = (long) r11
            long r10 = r10 & r3
            long r10 = r10 + r12
            long r10 = r10 - r1
            long r5 = r5 + r10
            long r10 = r5 & r3
            long r5 = r5 >> r16
            r12 = 4
            r13 = r30[r12]
            r28 = r10
            long r9 = (long) r13
            long r9 = r9 & r3
            long r9 = r9 + r14
            long r9 = r9 - r26
            long r5 = r5 + r9
            int r9 = (int) r5
            r0[r12] = r9
            long r5 = r5 >> r16
            r9 = 5
            r10 = r30[r9]
            long r10 = (long) r10
            long r10 = r10 & r3
            long r10 = r10 + r7
            long r10 = r10 - r17
            long r5 = r5 + r10
            int r7 = (int) r5
            r0[r9] = r7
            long r5 = r5 >> r16
            r7 = 6
            r8 = r30[r7]
            long r8 = (long) r8
            long r8 = r8 & r3
            long r8 = r8 + r1
            long r8 = r8 - r19
            long r5 = r5 + r8
            int r1 = (int) r5
            r0[r7] = r1
            long r1 = r5 >> r16
            r5 = 1
            long r1 = r1 + r5
            long r10 = r28 + r1
            long r1 = r23 - r1
            int r5 = (int) r1
            r6 = 0
            r0[r6] = r5
            long r1 = r1 >> r16
            int r5 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r5 == 0) goto L_0x00c4
            r5 = r0[r25]
            long r8 = (long) r5
            long r8 = r8 & r3
            long r1 = r1 + r8
            int r5 = (int) r1
            r0[r25] = r5
            long r1 = r1 >> r16
            r5 = 2
            r8 = r0[r5]
            long r8 = (long) r8
            long r3 = r3 & r8
            long r1 = r1 + r3
            int r3 = (int) r1
            r0[r5] = r3
            long r1 = r1 >> r16
            long r10 = r10 + r1
        L_0x00c4:
            int r1 = (int) r10
            r2 = 3
            r0[r2] = r1
            long r1 = r10 >> r16
            int r3 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r3 == 0) goto L_0x00e1
            r1 = 7
        L_0x00cf:
            if (r12 >= r1) goto L_0x00de
            r2 = r0[r12]
            int r2 = r2 + 1
            r0[r12] = r2
            if (r2 == 0) goto L_0x00db
            r11 = 0
            goto L_0x00df
        L_0x00db:
            int r12 = r12 + 1
            goto L_0x00cf
        L_0x00de:
            r11 = 1
        L_0x00df:
            if (r11 != 0) goto L_0x00ee
        L_0x00e1:
            r1 = r0[r7]
            r2 = -1
            if (r1 != r2) goto L_0x00f1
            int[] r1 = f2720a
            boolean r1 = com.cardinalcommerce.p060a.setNextFocusDownId.configure(r0, r1)
            if (r1 == 0) goto L_0x00f1
        L_0x00ee:
            m1980a(r31)
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setCCAImageIcon.init(int[], int[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        if (r0 == false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void cca_continue(int r13, int[] r14) {
        /*
            r0 = 0
            r1 = 0
            r3 = 1
            if (r13 == 0) goto L_0x003d
            long r4 = (long) r13
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r6
            r13 = r14[r0]
            long r8 = (long) r13
            long r8 = r8 & r6
            long r8 = r8 - r4
            long r8 = r8 + r1
            int r13 = (int) r8
            r14[r0] = r13
            r13 = 32
            long r8 = r8 >> r13
            int r10 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r10 == 0) goto L_0x0030
            r10 = r14[r3]
            long r10 = (long) r10
            long r10 = r10 & r6
            long r8 = r8 + r10
            int r10 = (int) r8
            r14[r3] = r10
            long r8 = r8 >> r13
            r10 = 2
            r11 = r14[r10]
            long r11 = (long) r11
            long r11 = r11 & r6
            long r8 = r8 + r11
            int r11 = (int) r8
            r14[r10] = r11
            long r8 = r8 >> r13
        L_0x0030:
            r10 = 3
            r11 = r14[r10]
            long r11 = (long) r11
            long r6 = r6 & r11
            long r6 = r6 + r4
            long r8 = r8 + r6
            int r4 = (int) r8
            r14[r10] = r4
            long r4 = r8 >> r13
            goto L_0x003e
        L_0x003d:
            r4 = r1
        L_0x003e:
            int r13 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r13 == 0) goto L_0x0054
            r13 = 4
        L_0x0043:
            r1 = 7
            if (r13 >= r1) goto L_0x0051
            r1 = r14[r13]
            int r1 = r1 + r3
            r14[r13] = r1
            if (r1 == 0) goto L_0x004e
            goto L_0x0052
        L_0x004e:
            int r13 = r13 + 1
            goto L_0x0043
        L_0x0051:
            r0 = 1
        L_0x0052:
            if (r0 != 0) goto L_0x0062
        L_0x0054:
            r13 = 6
            r13 = r14[r13]
            r0 = -1
            if (r13 != r0) goto L_0x0065
            int[] r13 = f2720a
            boolean r13 = com.cardinalcommerce.p060a.setNextFocusDownId.configure(r14, r13)
            if (r13 == 0) goto L_0x0065
        L_0x0062:
            m1980a(r14)
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setCCAImageIcon.cca_continue(int, int[]):void");
    }

    public static void configure(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[14];
        setNextFocusDownId.getInstance(iArr, iArr3);
        init(iArr3, iArr2);
    }

    public static void cca_continue(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[14];
        setNextFocusDownId.getInstance(iArr, iArr3);
        while (true) {
            init(iArr3, iArr2);
            i--;
            if (i > 0) {
                setNextFocusDownId.getInstance(iArr2, iArr3);
            } else {
                return;
            }
        }
    }

    public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setNextFocusDownId.CardinalError(iArr, iArr2, iArr3) != 0) {
            long j = (((long) iArr3[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + 1;
            iArr3[0] = (int) j;
            long j2 = j >> 32;
            if (j2 != 0) {
                long j3 = j2 + (((long) iArr3[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr3[1] = (int) j3;
                long j4 = (j3 >> 32) + (((long) iArr3[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
                iArr3[2] = (int) j4;
                j2 = j4 >> 32;
            }
            long j5 = j2 + ((InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr3[3])) - 1);
            iArr3[3] = (int) j5;
            if ((j5 >> 32) != 0) {
                int i = 4;
                while (i < 7) {
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
    private static void m1980a(int[] iArr) {
        long j = (((long) iArr[0]) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (((long) iArr[1]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (((long) iArr[2]) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        long j5 = j2 + (InternalZipConstants.ZIP_64_SIZE_LIMIT & ((long) iArr[3])) + 1;
        iArr[3] = (int) j5;
        if ((j5 >> 32) != 0) {
            int i = 4;
            while (i < 7) {
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
