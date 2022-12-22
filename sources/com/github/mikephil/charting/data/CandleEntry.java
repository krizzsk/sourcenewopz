package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

public class CandleEntry extends Entry {

    /* renamed from: a */
    private float f52363a = 0.0f;

    /* renamed from: b */
    private float f52364b = 0.0f;

    /* renamed from: c */
    private float f52365c = 0.0f;

    /* renamed from: d */
    private float f52366d = 0.0f;

    public CandleEntry(float f, float f2, float f3, float f4, float f5) {
        super(f, (f2 + f3) / 2.0f);
        this.f52363a = f2;
        this.f52364b = f3;
        this.f52366d = f4;
        this.f52365c = f5;
    }

    public CandleEntry(float f, float f2, float f3, float f4, float f5, Object obj) {
        super(f, (f2 + f3) / 2.0f, obj);
        this.f52363a = f2;
        this.f52364b = f3;
        this.f52366d = f4;
        this.f52365c = f5;
    }

    public CandleEntry(float f, float f2, float f3, float f4, float f5, Drawable drawable) {
        super(f, (f2 + f3) / 2.0f, drawable);
        this.f52363a = f2;
        this.f52364b = f3;
        this.f52366d = f4;
        this.f52365c = f5;
    }

    public CandleEntry(float f, float f2, float f3, float f4, float f5, Drawable drawable, Object obj) {
        super(f, (f2 + f3) / 2.0f, drawable, obj);
        this.f52363a = f2;
        this.f52364b = f3;
        this.f52366d = f4;
        this.f52365c = f5;
    }

    public float getShadowRange() {
        return Math.abs(this.f52363a - this.f52364b);
    }

    public float getBodyRange() {
        return Math.abs(this.f52366d - this.f52365c);
    }

    public float getY() {
        return super.getY();
    }

    public CandleEntry copy() {
        return new CandleEntry(getX(), this.f52363a, this.f52364b, this.f52366d, this.f52365c, getData());
    }

    public float getHigh() {
        return this.f52363a;
    }

    public void setHigh(float f) {
        this.f52363a = f;
    }

    public float getLow() {
        return this.f52364b;
    }

    public void setLow(float f) {
        this.f52364b = f;
    }

    public float getClose() {
        return this.f52365c;
    }

    public void setClose(float f) {
        this.f52365c = f;
    }

    public float getOpen() {
        return this.f52366d;
    }

    public void setOpen(float f) {
        this.f52366d = f;
    }
}
