package com.didi.map.core.animation;

import android.view.animation.Interpolator;

public class MapAlphaAnimation extends MapAnimation {

    /* renamed from: a */
    private float f24707a = 0.0f;

    /* renamed from: b */
    private float f24708b = 0.0f;

    public MapAlphaAnimation(float f, float f2) {
        this.f24707a = f;
        this.f24708b = f2;
    }

    /* access modifiers changed from: protected */
    public void performAnimation(float f, Interpolator interpolator) {
        float interpolation = this.f24707a + ((this.f24708b - this.f24707a) * interpolator.getInterpolation(f));
        if (this.animationProperty != null) {
            this.animationProperty.setAlpha(interpolation);
        }
    }
}
