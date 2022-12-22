package com.didi.map.global.component;

import android.animation.TypeEvaluator;

public class IntArrayEvaluator implements TypeEvaluator<int[]> {

    /* renamed from: a */
    private int[] f17680a;

    public IntArrayEvaluator() {
    }

    public IntArrayEvaluator(int[] iArr) {
        this.f17680a = iArr;
    }

    public int[] evaluate(float f, int[] iArr, int[] iArr2) {
        int[] iArr3 = this.f17680a;
        if (iArr3 == null) {
            iArr3 = new int[iArr.length];
        }
        for (int i = 0; i < iArr3.length; i++) {
            int i2 = iArr[i];
            iArr3[i] = (int) (((float) i2) + (((float) (iArr2[i] - i2)) * f));
        }
        return iArr3;
    }
}
