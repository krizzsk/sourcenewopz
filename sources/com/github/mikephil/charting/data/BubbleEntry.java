package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

public class BubbleEntry extends Entry {

    /* renamed from: a */
    private float f52358a = 0.0f;

    public BubbleEntry(float f, float f2, float f3) {
        super(f, f2);
        this.f52358a = f3;
    }

    public BubbleEntry(float f, float f2, float f3, Object obj) {
        super(f, f2, obj);
        this.f52358a = f3;
    }

    public BubbleEntry(float f, float f2, float f3, Drawable drawable) {
        super(f, f2, drawable);
        this.f52358a = f3;
    }

    public BubbleEntry(float f, float f2, float f3, Drawable drawable, Object obj) {
        super(f, f2, drawable, obj);
        this.f52358a = f3;
    }

    public BubbleEntry copy() {
        return new BubbleEntry(getX(), getY(), this.f52358a, getData());
    }

    public float getSize() {
        return this.f52358a;
    }

    public void setSize(float f) {
        this.f52358a = f;
    }
}
