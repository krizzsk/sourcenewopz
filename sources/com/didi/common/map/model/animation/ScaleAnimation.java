package com.didi.common.map.model.animation;

import com.didi.common.map.model.animation.Animation;

public class ScaleAnimation extends Animation {

    /* renamed from: a */
    private float f10915a;

    /* renamed from: b */
    private float f10916b;

    /* renamed from: c */
    private float f10917c;

    /* renamed from: d */
    private float f10918d;

    public ScaleAnimation(float f, float f2, float f3, float f4) {
        this.mType = Animation.AnimationType.SCALE;
        this.f10915a = f;
        this.f10916b = f2;
        this.f10917c = f3;
        this.f10918d = f4;
    }

    public float getFromX() {
        return this.f10915a;
    }

    public float getToX() {
        return this.f10916b;
    }

    public float getFromY() {
        return this.f10917c;
    }

    public float getToY() {
        return this.f10918d;
    }
}
