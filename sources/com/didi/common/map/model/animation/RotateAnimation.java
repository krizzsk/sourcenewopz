package com.didi.common.map.model.animation;

import com.didi.common.map.model.animation.Animation;

public class RotateAnimation extends Animation {

    /* renamed from: a */
    private float f10910a = 0.0f;

    /* renamed from: b */
    private float f10911b = 0.0f;

    /* renamed from: c */
    private float f10912c = 0.0f;

    /* renamed from: d */
    private float f10913d = 0.0f;

    /* renamed from: e */
    private float f10914e = 0.0f;

    public RotateAnimation(float f, float f2, float f3, float f4, float f5) {
        this.mType = Animation.AnimationType.ROTATE;
        this.f10910a = f;
        this.f10911b = f2;
        this.f10912c = f3;
        this.f10913d = f4;
        this.f10914e = f5;
    }

    public float getFromDegree() {
        return this.f10910a;
    }

    public float getToDegree() {
        return this.f10911b;
    }

    public float getPivotX() {
        return this.f10912c;
    }

    public float getPivotY() {
        return this.f10913d;
    }

    public float getPivotZ() {
        return this.f10914e;
    }
}
