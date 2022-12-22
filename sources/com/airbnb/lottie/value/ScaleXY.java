package com.airbnb.lottie.value;

public class ScaleXY {

    /* renamed from: a */
    private float f1719a;

    /* renamed from: b */
    private float f1720b;

    public ScaleXY(float f, float f2) {
        this.f1719a = f;
        this.f1720b = f2;
    }

    public ScaleXY() {
        this(1.0f, 1.0f);
    }

    public float getScaleX() {
        return this.f1719a;
    }

    public float getScaleY() {
        return this.f1720b;
    }

    public void set(float f, float f2) {
        this.f1719a = f;
        this.f1720b = f2;
    }

    public boolean equals(float f, float f2) {
        return this.f1719a == f && this.f1720b == f2;
    }

    public String toString() {
        return getScaleX() + "x" + getScaleY();
    }
}
