package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setAccessibilityTraversalAfter */
public abstract class setAccessibilityTraversalAfter {
    /* renamed from: a */
    private static void m1944a(int[] iArr, int i, int[] iArr2, int[] iArr3) {
        if (i < 0) {
            setDrawingCacheQuality.cca_continue(iArr.length, iArr2, iArr, iArr3);
        } else {
            System.arraycopy(iArr2, 0, iArr3, 0, iArr.length);
        }
    }

    public static void getInstance(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        if (!setDrawingCacheQuality.init(length, iArr2)) {
            int i = 0;
            if (setDrawingCacheQuality.configure(length, iArr2)) {
                System.arraycopy(iArr2, 0, iArr3, 0, length);
                return;
            }
            int[] iArr4 = new int[length];
            System.arraycopy(iArr2, 0, iArr4, 0, length);
            int[] iArr5 = new int[length];
            iArr5[0] = 1;
            int a = (1 & iArr4[0]) == 0 ? m1943a(iArr, iArr4, length, iArr5, 0) : 0;
            if (setDrawingCacheQuality.configure(length, iArr4)) {
                m1944a(iArr, a, iArr5, iArr3);
                return;
            }
            int[] iArr6 = new int[length];
            System.arraycopy(iArr, 0, iArr6, 0, length);
            int[] iArr7 = new int[length];
            int i2 = length;
            while (true) {
                int i3 = i2 - 1;
                if (iArr4[i3] == 0 && iArr6[i3] == 0) {
                    i2--;
                } else if (setDrawingCacheQuality.init(i2, iArr4, iArr6)) {
                    setDrawingCacheQuality.cca_continue(i2, iArr6, iArr4);
                    a = m1943a(iArr, iArr4, i2, iArr5, a + (setDrawingCacheQuality.cca_continue(length, iArr7, iArr5) - i));
                    if (setDrawingCacheQuality.configure(i2, iArr4)) {
                        m1944a(iArr, a, iArr5, iArr3);
                        return;
                    }
                } else {
                    setDrawingCacheQuality.cca_continue(i2, iArr4, iArr6);
                    i = m1943a(iArr, iArr6, i2, iArr7, i + (setDrawingCacheQuality.cca_continue(length, iArr5, iArr7) - a));
                    if (setDrawingCacheQuality.configure(i2, iArr6)) {
                        m1944a(iArr, i, iArr7, iArr3);
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("'x' cannot be 0");
        }
    }

    /* renamed from: a */
    private static int m1943a(int[] iArr, int[] iArr2, int i, int[] iArr3, int i2) {
        int length = iArr.length;
        int i3 = 0;
        while (iArr2[0] == 0) {
            int i4 = i;
            int i5 = 0;
            while (true) {
                i4--;
                if (i4 < 0) {
                    break;
                }
                int i6 = iArr2[i4];
                iArr2[i4] = i5;
                i5 = i6;
            }
            i3 += 32;
        }
        int i7 = iArr2[0];
        int i8 = 0;
        while ((i7 & 1) == 0) {
            i7 >>>= 1;
            i8++;
        }
        if (i8 > 0) {
            int i9 = 0;
            while (true) {
                i--;
                if (i < 0) {
                    break;
                }
                int i10 = iArr2[i];
                iArr2[i] = (i9 << (-i8)) | (i10 >>> i8);
                i9 = i10;
            }
            i3 += i8;
        }
        for (int i11 = 0; i11 < i3; i11++) {
            if ((iArr3[0] & 1) != 0) {
                i2 += i2 < 0 ? setDrawingCacheQuality.configure(length, iArr, iArr3) : setDrawingCacheQuality.cca_continue(length, iArr, iArr3);
            }
            setDrawingCacheQuality.init(length, iArr3, i2);
        }
        return i2;
    }
}
