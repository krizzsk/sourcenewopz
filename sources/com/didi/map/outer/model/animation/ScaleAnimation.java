package com.didi.map.outer.model.animation;

import android.view.animation.Interpolator;
import com.didi.map.core.animation.MapScaleAnimation;

public class ScaleAnimation extends Animation {

    /* renamed from: a */
    private float f28074a = 0.0f;

    /* renamed from: b */
    private float f28075b = 0.0f;

    /* renamed from: c */
    private float f28076c = 0.0f;

    /* renamed from: d */
    private float f28077d = 0.0f;

    public ScaleAnimation(float f, float f2, float f3, float f4) {
        this.f28074a = f;
        this.f28075b = f2;
        this.f28076c = f3;
        this.f28077d = f4;
        if (this.animation == null) {
            this.animation = new MapScaleAnimation(f, f2, f3, f4);
        }
    }

    public float getFromX() {
        return this.f28074a;
    }

    public float getToX() {
        return this.f28075b;
    }

    public float getFromY() {
        return this.f28076c;
    }

    public float getToY() {
        return this.f28077d;
    }

    public void setDuration(long j) {
        super.setDuration(j);
        if (this.animation != null) {
            this.animation.setDuration(j);
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        super.setInterpolator(interpolator);
        if (this.animation != null && interpolator != null) {
            this.animation.setInterpolator(interpolator);
        }
    }

    public void setDelay(long j) {
        super.setDelay(j);
        if (this.animation != null) {
            this.animation.setDelay(j);
        }
    }
}
