package com.cardinalcommerce.p060a;

import java.math.BigInteger;

/* renamed from: com.cardinalcommerce.a.setCCAImageResource */
public final class setCCAImageResource {

    /* renamed from: a */
    static final int[] f2723a = {-977, -2, -1, -1, -1, -1, -1, -1};

    /* renamed from: b */
    private static int[] f2724b = {954529, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, -1, -1, -1, -1, -1, -1};

    /* renamed from: c */
    private static final int[] f2725c = {-954529, -1955, -2, -1, -1, -1, -1, -1, 1953, 2};

    public static void Cardinal(int[] iArr, int[] iArr2) {
        if (setNextFocusLeftId.cca_continue(setNextFocusLeftId.values(iArr, iArr, iArr2), iArr2) != 0 || (iArr2[7] == -1 && setNextFocusLeftId.configure(iArr2, f2723a))) {
            setDrawingCacheQuality.init(8, 977, iArr2);
        }
    }

    public static void Cardinal(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setNextFocusLeftId.getWarnings(iArr, iArr2, iArr3) != 0) {
            setDrawingCacheQuality.Cardinal(8, 977, iArr3);
        }
    }

    public static void configure(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.getInstance(8, iArr, iArr2) != 0 || (iArr2[7] == -1 && setNextFocusLeftId.configure(iArr2, f2723a))) {
            setDrawingCacheQuality.init(8, 977, iArr2);
        }
    }

    public static int[] configure(BigInteger bigInteger) {
        int[] Cardinal = setNextFocusLeftId.Cardinal(bigInteger);
        if (Cardinal[7] == -1 && setNextFocusLeftId.configure(Cardinal, f2723a)) {
            setNextFocusLeftId.getWarnings(f2723a, Cardinal);
        }
        return Cardinal;
    }

    public static void getInstance(int[] iArr, int[] iArr2) {
        if (setNextFocusLeftId.getInstance(iArr)) {
            setNextFocusLeftId.cca_continue(iArr2);
        } else {
            setNextFocusLeftId.getWarnings(f2723a, iArr, iArr2);
        }
    }

    public static void getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setNextFocusLeftId.getInstance(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && setNextFocusLeftId.configure(iArr3, f2723a))) {
            setDrawingCacheQuality.init(8, 977, iArr3);
        }
    }

    public static void init(int[] iArr, int[] iArr2) {
        if (setDrawingCacheQuality.Cardinal(8, iArr, 0, iArr2) != 0 || (iArr2[7] == -1 && setNextFocusLeftId.configure(iArr2, f2723a))) {
            setDrawingCacheQuality.init(8, 977, iArr2);
        }
    }

    public static void cca_continue(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArr4 = new int[16];
        setNextFocusLeftId.cca_continue(iArr, iArr2, iArr4);
        Cardinal(iArr4, iArr3);
    }

    public static void init(int[] iArr, int[] iArr2, int[] iArr3) {
        if (setNextFocusLeftId.init(iArr, iArr2, iArr3) != 0 || (iArr3[15] == -1 && setDrawingCacheQuality.init(16, iArr3, f2724b))) {
            int[] iArr4 = f2725c;
            if (setDrawingCacheQuality.configure(iArr4.length, iArr4, iArr3) != 0) {
                int length = f2725c.length;
                while (length < 16) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004a, code lost:
        if (r13 == false) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void configure(int r13, int[] r14) {
        /*
            r0 = 8
            if (r13 == 0) goto L_0x004c
            long r1 = (long) r13
            r3 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r1 = r1 & r3
            r5 = 977(0x3d1, double:4.827E-321)
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
            if (r3 != 0) goto L_0x0039
            goto L_0x004a
        L_0x0039:
            r1 = 3
        L_0x003a:
            if (r1 >= r0) goto L_0x0049
            int r2 = r1 + 0
            r3 = r14[r2]
            int r3 = r3 + r10
            r14[r2] = r3
            if (r3 == 0) goto L_0x0046
            goto L_0x004a
        L_0x0046:
            int r1 = r1 + 1
            goto L_0x003a
        L_0x0049:
            r13 = 1
        L_0x004a:
            if (r13 != 0) goto L_0x005a
        L_0x004c:
            r13 = 7
            r13 = r14[r13]
            r1 = -1
            if (r13 != r1) goto L_0x005f
            int[] r13 = f2723a
            boolean r13 = com.cardinalcommerce.p060a.setNextFocusLeftId.configure(r14, r13)
            if (r13 == 0) goto L_0x005f
        L_0x005a:
            r13 = 977(0x3d1, float:1.369E-42)
            com.cardinalcommerce.p060a.setDrawingCacheQuality.init((int) r0, (int) r13, (int[]) r14)
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setCCAImageResource.configure(int, int[]):void");
    }

    public static void cca_continue(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        setNextFocusLeftId.getSDKVersion(iArr, iArr3);
        Cardinal(iArr3, iArr2);
    }

    public static void configure(int[] iArr, int i, int[] iArr2) {
        int[] iArr3 = new int[16];
        setNextFocusLeftId.getSDKVersion(iArr, iArr3);
        while (true) {
            Cardinal(iArr3, iArr2);
            i--;
            if (i > 0) {
                setNextFocusLeftId.getSDKVersion(iArr2, iArr3);
            } else {
                return;
            }
        }
    }
}
