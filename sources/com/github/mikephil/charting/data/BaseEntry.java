package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;

public abstract class BaseEntry {

    /* renamed from: a */
    private float f52354a;

    /* renamed from: b */
    private Object f52355b;

    /* renamed from: c */
    private Drawable f52356c;

    public BaseEntry() {
        this.f52354a = 0.0f;
        this.f52355b = null;
        this.f52356c = null;
    }

    public BaseEntry(float f) {
        this.f52354a = 0.0f;
        this.f52355b = null;
        this.f52356c = null;
        this.f52354a = f;
    }

    public BaseEntry(float f, Object obj) {
        this(f);
        this.f52355b = obj;
    }

    public BaseEntry(float f, Drawable drawable) {
        this(f);
        this.f52356c = drawable;
    }

    public BaseEntry(float f, Drawable drawable, Object obj) {
        this(f);
        this.f52356c = drawable;
        this.f52355b = obj;
    }

    public float getY() {
        return this.f52354a;
    }

    public void setIcon(Drawable drawable) {
        this.f52356c = drawable;
    }

    public Drawable getIcon() {
        return this.f52356c;
    }

    public void setY(float f) {
        this.f52354a = f;
    }

    public Object getData() {
        return this.f52355b;
    }

    public void setData(Object obj) {
        this.f52355b = obj;
    }
}
