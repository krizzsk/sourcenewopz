package com.didi.map.outer.model.animation;

import android.view.animation.Interpolator;
import com.didi.map.core.animation.MapRotateAnimation;

public class RotateAnimation extends Animation {

    /* renamed from: a */
    private float f28069a = 0.0f;

    /* renamed from: b */
    private float f28070b = 0.0f;

    /* renamed from: c */
    private float f28071c = 0.0f;

    /* renamed from: d */
    private float f28072d = 0.0f;

    /* renamed from: e */
    private float f28073e = 0.0f;

    public float getFromAngle() {
        return this.f28069a;
    }

    public float getToAngle() {
        return this.f28070b;
    }

    public RotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.f28069a = f;
        this.f28070b = f2;
        this.f28071c = f3;
        this.f28072d = f4;
        this.f28073e = f5;
        if (this.animation == null) {
            this.animation = new MapRotateAnimation(f, f2, f3, f4, f5);
        }
    }

    public void setDuration(long j) {
        super.setDuration(j);
        if (this.animation != null) {
            this.animation.setDuration(j);
        }
    }

    public void setDelay(long j) {
        super.setDelay(j);
        if (this.animation != null) {
            this.animation.setDelay(j);
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        super.setInterpolator(interpolator);
        if (this.animation != null && interpolator != null) {
            this.animation.setInterpolator(interpolator);
        }
    }
}
