package com.didi.map.outer.model.animation;

import android.view.animation.Interpolator;
import com.didi.map.core.animation.MapAlphaAnimation;

public class AlphaAnimation extends Animation {

    /* renamed from: a */
    private float f28064a;

    /* renamed from: b */
    private float f28065b;

    public float getFromAlpha() {
        return this.f28064a;
    }

    public float getToAlpha() {
        return this.f28065b;
    }

    public AlphaAnimation(float f, float f2) {
        this.f28064a = f;
        this.f28065b = f2;
        if (this.animation == null) {
            this.animation = new MapAlphaAnimation(f, f2);
        }
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
