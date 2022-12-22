package com.cardinalcommerce.p060a;

/* renamed from: com.cardinalcommerce.a.setNextFocusRightId */
public abstract class setNextFocusRightId {
    public static void init(int[] iArr, int[] iArr2, int[] iArr3) {
        setKeepScreenOn.getInstance(iArr, iArr2, iArr3);
        setKeepScreenOn.Cardinal(iArr, iArr2, iArr3, 12);
        int configure = setKeepScreenOn.configure(iArr3, iArr3);
        boolean z = false;
        int instance = configure + setKeepScreenOn.getInstance(iArr3, 18, iArr3, 12, setKeepScreenOn.getInstance(iArr3, 0, iArr3, 6, 0) + configure);
        int[] iArr4 = new int[6];
        int[] iArr5 = new int[6];
        if (setKeepScreenOn.init(iArr, iArr, iArr4) != setKeepScreenOn.init(iArr2, iArr2, iArr5)) {
            z = true;
        }
        int[] iArr6 = new int[12];
        setKeepScreenOn.getInstance(iArr4, iArr5, iArr6);
        setDrawingCacheQuality.getInstance(24, instance + (z ? setDrawingCacheQuality.cca_continue(12, iArr6, iArr3, 6) : setDrawingCacheQuality.getInstance(12, iArr6, iArr3, 6)), iArr3, 18);
    }

    public static void Cardinal(int[] iArr, int[] iArr2) {
        setKeepScreenOn.getInstance(iArr, iArr2);
        setKeepScreenOn.cca_continue(iArr, iArr2);
        int configure = setKeepScreenOn.configure(iArr2, iArr2);
        int instance = configure + setKeepScreenOn.getInstance(iArr2, 18, iArr2, 12, setKeepScreenOn.getInstance(iArr2, 0, iArr2, 6, 0) + configure);
        int[] iArr3 = new int[6];
        setKeepScreenOn.init(iArr, iArr, iArr3);
        int[] iArr4 = new int[12];
        setKeepScreenOn.getInstance(iArr3, iArr4);
        setDrawingCacheQuality.getInstance(24, instance + setDrawingCacheQuality.getInstance(12, iArr4, iArr2, 6), iArr2, 18);
    }
}
