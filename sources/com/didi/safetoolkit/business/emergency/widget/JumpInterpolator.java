package com.didi.safetoolkit.business.emergency.widget;

import android.view.animation.Interpolator;

public class JumpInterpolator implements Interpolator {

    /* renamed from: a */
    private final float f34346a;

    public JumpInterpolator(float f) {
        this.f34346a = Math.abs(f);
    }

    public float getInterpolation(float f) {
        float f2 = this.f34346a;
        if (f > f2) {
            return 0.0f;
        }
        return (float) Math.sin(((double) (f / f2)) * 3.141592653589793d);
    }
}
