package com.didi.common.map.model.animation;

import com.didi.common.map.model.animation.Animation;

public class AlphaAnimation extends Animation {

    /* renamed from: a */
    private float f10905a;

    /* renamed from: b */
    private float f10906b;

    public AlphaAnimation(float f, float f2) {
        this.mType = Animation.AnimationType.ALPHA;
        this.f10905a = f;
        this.f10906b = f2;
    }

    public float getFromAlpha() {
        return this.f10905a;
    }

    public float getToAlpha() {
        return this.f10906b;
    }
}
