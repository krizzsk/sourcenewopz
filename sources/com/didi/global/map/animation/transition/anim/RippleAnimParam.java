package com.didi.global.map.animation.transition.anim;

public class RippleAnimParam {
    public static final String TAG = RippleAnimParam.class.getSimpleName();

    /* renamed from: a */
    private int f22787a;

    /* renamed from: b */
    private int f22788b;

    /* renamed from: c */
    private int f22789c;

    /* renamed from: d */
    private int f22790d;

    /* renamed from: e */
    private int f22791e;

    /* renamed from: a */
    private int m16397a(int i, int i2) {
        if (i2 >= 255) {
            i2 = 255;
        } else if (i2 <= 0) {
            i2 = 0;
        }
        return (i & 16777215) | (i2 << 24);
    }

    public RippleAnimParam(int i, int i2, int i3, int i4, int i5) {
        this.f22788b = m16397a(i, i3);
        this.f22787a = m16397a(i2, i3);
        this.f22791e = i3;
        this.f22790d = i4;
        this.f22789c = i5;
    }

    public RippleAnimParam() {
    }

    public int getStrokeWidth() {
        return this.f22789c;
    }

    public void setStrokeWidth(int i) {
        this.f22789c = i;
    }

    public int getFillColor() {
        return this.f22788b;
    }

    public void setFillColor(int i) {
        this.f22788b = m16397a(i, this.f22791e);
    }

    public int getStrokeColor() {
        return this.f22787a;
    }

    public void setStrokeColor(int i) {
        this.f22787a = m16397a(i, this.f22791e);
    }

    public int getAlpha() {
        return this.f22791e;
    }

    public void setAlpha(int i) {
        this.f22791e = i;
    }

    public int getRadius() {
        return this.f22790d;
    }

    public void setRadius(int i) {
        this.f22790d = i;
    }

    public String toString() {
        return "RippleAnimParam{,StrokeColor = " + String.format("0x%08X", new Object[]{Integer.valueOf(this.f22787a)}) + ",FillColor = " + String.format("0x%08X", new Object[]{Integer.valueOf(this.f22788b)}) + ",Alpha = " + String.format("0x%02X", new Object[]{Integer.valueOf(this.f22791e)}) + ",Radius = " + this.f22790d + ",StrokeWidth = " + this.f22789c + "}";
    }
}
