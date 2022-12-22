package com.didi.map.core.animation;

import android.view.animation.Interpolator;

public class MapScaleAnimation extends MapAnimation {

    /* renamed from: a */
    private float f24719a = 0.0f;

    /* renamed from: b */
    private float f24720b = 0.0f;

    /* renamed from: c */
    private float f24721c = 0.0f;

    /* renamed from: d */
    private float f24722d = 0.0f;

    public MapScaleAnimation(float f, float f2, float f3, float f4) {
        this.f24719a = f;
        this.f24720b = f2;
        this.f24721c = f3;
        this.f24722d = f4;
    }

    /* access modifiers changed from: protected */
    public void performAnimation(float f, Interpolator interpolator) {
        if (f > 0.0f) {
            float f2 = this.f24720b - this.f24719a;
            float interpolation = interpolator.getInterpolation(f);
            float f3 = this.f24719a + (f2 * interpolation);
            float f4 = this.f24721c + ((this.f24722d - this.f24721c) * interpolation);
            if (this.animationProperty != null) {
                this.animationProperty.setScale(f3, f4);
            }
        }
    }
}
