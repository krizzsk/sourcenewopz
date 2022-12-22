package com.didi.global.map.animation.anim;

public class RippleAnimParam {
    public static final String TAG = RippleAnimParam.class.getSimpleName();

    /* renamed from: a */
    private int f22720a;

    /* renamed from: b */
    private int f22721b;

    /* renamed from: c */
    private int f22722c;

    /* renamed from: d */
    private int f22723d;

    /* renamed from: e */
    private int f22724e;

    /* renamed from: a */
    private int m16355a(int i, int i2) {
        if (i2 >= 255) {
            i2 = 255;
        } else if (i2 <= 0) {
            i2 = 0;
        }
        return (i & 16777215) | (i2 << 24);
    }

    public RippleAnimParam(int i, int i2, int i3, int i4, int i5) {
        this.f22721b = m16355a(i, i3);
        this.f22720a = m16355a(i2, i3);
        this.f22724e = i3;
        this.f22723d = i4;
        this.f22722c = i5;
    }

    public RippleAnimParam() {
    }

    public int getStrokeWidth() {
        return this.f22722c;
    }

    public void setStrokeWidth(int i) {
        this.f22722c = i;
    }

    public int getFillColor() {
        return this.f22721b;
    }

    public void setFillColor(int i) {
        this.f22721b = m16355a(i, this.f22724e);
    }

    public int getStrokeColor() {
        return this.f22720a;
    }

    public void setStrokeColor(int i) {
        this.f22720a = m16355a(i, this.f22724e);
    }

    public int getAlpha() {
        return this.f22724e;
    }

    public void setAlpha(int i) {
        this.f22724e = i;
    }

    public int getRadius() {
        return this.f22723d;
    }

    public void setRadius(int i) {
        this.f22723d = i;
    }

    public String toString() {
        return "RippleAnimParam{,StrokeColor = " + String.format("0x%08X", new Object[]{Integer.valueOf(this.f22720a)}) + ",FillColor = " + String.format("0x%08X", new Object[]{Integer.valueOf(this.f22721b)}) + ",Alpha = " + String.format("0x%02X", new Object[]{Integer.valueOf(this.f22724e)}) + ",Radius = " + this.f22723d + ",StrokeWidth = " + this.f22722c + "}";
    }
}
