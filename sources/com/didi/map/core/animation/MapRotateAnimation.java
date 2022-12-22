package com.didi.map.core.animation;

import android.view.animation.Interpolator;

public class MapRotateAnimation extends MapAnimation {

    /* renamed from: a */
    private float f24714a = 0.0f;

    /* renamed from: b */
    private float f24715b = 0.0f;

    /* renamed from: c */
    private float f24716c = 0.0f;

    /* renamed from: d */
    private float f24717d = 0.0f;

    /* renamed from: e */
    private float f24718e = 0.0f;

    public MapRotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.f24714a = f;
        this.f24715b = f2;
        this.f24716c = f3;
        this.f24717d = f4;
        this.f24718e = f5;
    }

    /* access modifiers changed from: protected */
    public void performAnimation(float f, Interpolator interpolator) {
        float interpolation = this.f24714a + ((this.f24715b - this.f24714a) * interpolator.getInterpolation(f));
        if (this.animationProperty != null) {
            this.animationProperty.setRotate(interpolation, this.f24716c, this.f24717d, this.f24718e);
        }
    }
}
