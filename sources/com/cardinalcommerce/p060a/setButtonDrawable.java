package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setButtonDrawable */
public final class setButtonDrawable {

    /* renamed from: a */
    static final int[] f2708a = {-4553, -2, -1, -1, -1, -1};

    /* renamed from: b */
    private static int[] f2709b = {20729809, 9106, 1, 0, 0, 0, -9106, -3, -1, -1, -1, -1};

    /* renamed from: c */
    private static final int[] f2710c = {-20729809, -9107, -2, -1, -1, -1, 9105, 2};

    public static void Cardinal(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.getInstance(6, iArr, iArr2) != 0 || (iArr2[5] == -1 && setKeepScreenOn.init(iArr2, f2708a))) {
            setDrawingCacheQuality.init(6, 4553, iArr2);
        }
    }

    public static void Cardinal(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setKeepScreenOn.cca_continue(iArr, iArr2, iArr3) != 0 || (iArr3[5] == -1 && setKeepScreenOn.init(iArr3, f2708a))) {
            setDrawingCacheQuality.init(6, 4553, iArr3);
        }
    }

    public static void cca_continue(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.Cardinal(6, iArr, 0, iArr2) != 0 || (iArr2[5] == -1 && setKeepScreenOn.init(iArr2, f2708a))) {
            setDrawingCacheQuality.init(6, 4553, iArr2);
        }
    }

    public static int[] cca_continue(BigInteger bigInteger) {
        int[] init = setKeepScreenOn.init(bigInteger);
        if (init[5] == -1 && setKeepScreenOn.init(init, f2708a)) {
            setKeepScreenOn.CardinalError(f2708a, init);
        }
        return init;
    }

    public static void getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setKeepScreenOn.cleanup(iArr, iArr2, iArr3) != 0) {
            setDrawingCacheQuality.Cardinal(6, 4553, iArr3);
        }
    }

    public static void init(int[] iArr, int[] iArr2) {
        if (setKeepScreenOn.getInstance(setKeepScreenOn.getWarnings(iArr, iArr, iArr2), iArr2) != 0 || (iArr2[5] == -1 && setKeepScreenOn.init(iArr2, f2708a))) {
            setDrawingCacheQuality.init(6, 4553, iArr2);
        }
    }

    public static void configure(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[12];
        setKeepScreenOn.getInstance(iArr, iArr2, iArr4);
        init(iArr4, iArr3);
    }

    public static void init(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setKeepScreenOn.configure(iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && setDrawingCacheQuality.init(12, iArr3, f2709b))) {
            int[] iArr4 = f2710c;
            if (setDrawingCacheQuality.configure(iArr4.length, iArr4, iArr3) != 0) {
                int length = f2710c.length;
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

    public static void getInstance(int[] iArr, int[] iArr2) {
        if (setKeepScreenOn.init(iArr)) {
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            iArr2[4] = 0;
            iArr2[5] = 0;
            return;
        }
        setKeepScreenOn.cleanup(f2708a, iArr, iArr2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0049, code lost:
        if (r13 == false) goto L_0x004b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void getInstance(int r13, int[] r14) {
        /*
            r0 = 6
            if (r13 == 0) goto L_0x004b
            long r1 = (long) r13
            r3 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r1 = r1 & r3
            r5 = 4553(0x11c9, double:2.2495E-320)
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
            r13 = 5
            r13 = r14[r13]
            r1 = -1
            if (r13 != r1) goto L_0x005e
            int[] r13 = f2708a
            boolean r13 = com.cardinalcommerce.p060a.setKeepScreenOn.init((int[]) r14, (int[]) r13)
            if (r13 == 0) goto L_0x005e
        L_0x0059:
            r13 = 4553(0x11c9, float:6.38E-42)
            com.cardinalcommerce.p060a.setDrawingCacheQuality.init((int) r0, (int) r13, (int[]) r14)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setButtonDrawable.getInstance(int, int[]):void");
    }

    public static void configure(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[12];
        setKeepScreenOn.getInstance(iArr, iArr3);
        init(iArr3, iArr2);
    }

    public static void Cardinal(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[12];
        setKeepScreenOn.getInstance(iArr, iArr3);
        while (true) {
            init(iArr3, iArr2);
            i--;
            if (i > 0) {
                setKeepScreenOn.getInstance(iArr2, iArr3);
            } else {
                return;
            }
        }
    }
}
