package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setId */
public final class setId {

    /* renamed from: a */
    static final int[] f2806a = {-21389, -2, -1, -1, -1};

    /* renamed from: b */
    private static int[] f2807b = {457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1};

    /* renamed from: c */
    private static final int[] f2808c = {-457489321, -42779, -2, -1, -1, 42777, 2};

    public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setScrollContainer.getWarnings(iArr, iArr2, iArr3) != 0) {
            setDrawingCacheQuality.Cardinal(5, 21389, iArr3);
        }
    }

    public static void configure(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.Cardinal(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && setScrollContainer.cca_continue(iArr2, f2806a))) {
            setDrawingCacheQuality.init(5, 21389, iArr2);
        }
    }

    public static int[] configure(BigInteger bigInteger) {
        int[] configure = setScrollContainer.configure(bigInteger);
        if (configure[4] == -1 && setScrollContainer.cca_continue(configure, f2806a)) {
            setScrollContainer.getInstance(f2806a, configure);
        }
        return configure;
    }

    public static void getInstance(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.getInstance(5, iArr, iArr2) != 0 || (iArr2[4] == -1 && setScrollContainer.cca_continue(iArr2, f2806a))) {
            setDrawingCacheQuality.init(5, 21389, iArr2);
        }
    }

    public static void getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setScrollContainer.getInstance(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && setScrollContainer.cca_continue(iArr3, f2806a))) {
            setDrawingCacheQuality.init(5, 21389, iArr3);
        }
    }

    public static void init(int[] iArr, int[] iArr2) {
        if (setScrollContainer.cca_continue(setScrollContainer.Cardinal(iArr, iArr, iArr2), iArr2) != 0 || (iArr2[4] == -1 && setScrollContainer.cca_continue(iArr2, f2806a))) {
            setDrawingCacheQuality.init(5, 21389, iArr2);
        }
    }

    public static void init(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[10];
        setScrollContainer.init(iArr, iArr2, iArr4);
        init(iArr4, iArr3);
    }

    public static void configure(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setScrollContainer.configure(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && setDrawingCacheQuality.init(10, iArr3, f2807b))) {
            int[] iArr4 = f2808c;
            if (setDrawingCacheQuality.configure(iArr4.length, iArr4, iArr3) != 0) {
                int length = f2808c.length;
                while (length < 10) {
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

    public static void Cardinal(int[] iArr, int[] iArr2) {
        if (setScrollContainer.init(iArr)) {
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            iArr2[4] = 0;
            return;
        }
        setScrollContainer.getWarnings(f2806a, iArr, iArr2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0049, code lost:
        if (r13 == false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void getInstance(int r13, int[] r14) {
        /*
            r0 = 5
            if (r13 == 0) goto L_0x004b
            long r1 = (long) r13
            r3 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r1 = r1 & r3
            r5 = 21389(0x538d, double:1.05676E-319)
            long r5 = r5 * r1
            r13 = 0
            r7 = r14[r13]
            long r7 = (long) r7
            long r7 = r7 & r3
            long r5 = r5 + r7
            r7 = 0
            long r5 = r5 + r7
            int r9 = (int) r5
            r14[r13] = r9
            r9 = 32
            long r5 = r5 >>> r9
            r10 = 1
            r11 = r14[r10]
            long r11 = (long) r11
            long r11 = r11 & r3
            long r1 = r1 + r11
            long r5 = r5 + r1
            int r1 = (int) r5
            r14[r10] = r1
            long r1 = r5 >>> r9
            r5 = 2
            r6 = r14[r5]
            long r11 = (long) r6
            long r3 = r3 & r11
            long r1 = r1 + r3
            int r3 = (int) r1
            r14[r5] = r3
            long r1 = r1 >>> r9
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x0038
            goto L_0x0049
        L_0x0038:
            r1 = 3
        L_0x0039:
            if (r1 >= r0) goto L_0x0048
            int r2 = r1 + 0
            r3 = r14[r2]
            int r3 = r3 + r10
            r14[r2] = r3
            if (r3 == 0) goto L_0x0045
            goto L_0x0049
        L_0x0045:
            int r1 = r1 + 1
            goto L_0x0039
        L_0x0048:
            r13 = 1
        L_0x0049:
            if (r13 != 0) goto L_0x0059
        L_0x004b:
            r13 = 4
            r13 = r14[r13]
            r1 = -1
            if (r13 != r1) goto L_0x005e
            int[] r13 = f2806a
            boolean r13 = com.cardinalcommerce.p060a.setScrollContainer.cca_continue((int[]) r14, (int[]) r13)
            if (r13 == 0) goto L_0x005e
        L_0x0059:
            r13 = 21389(0x538d, float:2.9972E-41)
            com.cardinalcommerce.p060a.setDrawingCacheQuality.init((int) r0, (int) r13, (int[]) r14)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setId.getInstance(int, int[]):void");
    }

    public static void cca_continue(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[10];
        setScrollContainer.init(iArr, iArr3);
        init(iArr3, iArr2);
    }

    public static void init(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[10];
        setScrollContainer.init(iArr, iArr3);
        while (true) {
            init(iArr3, iArr2);
            i--;
            if (i > 0) {
                setScrollContainer.init(iArr2, iArr3);
            } else {
                return;
            }
        }
    }
}
