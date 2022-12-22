package com.airbnb.lottie.value;

public class LottieFrameInfo<T> {

    /* renamed from: a */
    private float f1710a;

    /* renamed from: b */
    private float f1711b;

    /* renamed from: c */
    private T f1712c;

    /* renamed from: d */
    private T f1713d;

    /* renamed from: e */
    private float f1714e;

    /* renamed from: f */
    private float f1715f;

    /* renamed from: g */
    private float f1716g;

    public LottieFrameInfo<T> set(float f, float f2, T t, T t2, float f3, float f4, float f5) {
        this.f1710a = f;
        this.f1711b = f2;
        this.f1712c = t;
        this.f1713d = t2;
        this.f1714e = f3;
        this.f1715f = f4;
        this.f1716g = f5;
        return this;
    }

    public float getStartFrame() {
        return this.f1710a;
    }

    public float getEndFrame() {
        return this.f1711b;
    }

    public T getStartValue() {
        return this.f1712c;
    }

    public T getEndValue() {
        return this.f1713d;
    }

    public float getLinearKeyframeProgress() {
        return this.f1714e;
    }

    public float getInterpolatedKeyframeProgress() {
        return this.f1715f;
    }

    public float getOverallProgress() {
        return this.f1716g;
    }
}
