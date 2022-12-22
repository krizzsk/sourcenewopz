package com.didi.unifiedPay.component.widget.loading;

import android.view.animation.Interpolator;

/* renamed from: com.didi.unifiedPay.component.widget.loading.c */
/* compiled from: LookupTableInterpolator */
abstract class C14474c implements Interpolator {

    /* renamed from: a */
    private final float[] f44531a;

    /* renamed from: b */
    private final float f44532b;

    public C14474c(float[] fArr) {
        this.f44531a = fArr;
        this.f44532b = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f44531a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f), fArr.length - 2);
        float f2 = this.f44532b;
        float f3 = (f - (((float) min) * f2)) / f2;
        float[] fArr2 = this.f44531a;
        return fArr2[min] + (f3 * (fArr2[min + 1] - fArr2[min]));
    }
}
