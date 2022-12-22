package com.didichuxing.xpanel.xcard.view;

public class Corner {

    /* renamed from: a */
    private float f49640a;

    /* renamed from: b */
    private float f49641b;

    /* renamed from: c */
    private float f49642c;

    /* renamed from: d */
    private float f49643d;

    public void setCorners(float f) {
        this.f49640a = f;
        this.f49641b = f;
        this.f49642c = f;
        this.f49643d = f;
    }

    public void setLeftTopCorner(float f) {
        this.f49640a = f;
    }

    public void setLeftBottomCorner(float f) {
        this.f49641b = f;
    }

    public void setRightTopCorner(float f) {
        this.f49642c = f;
    }

    public void setRightBottomCorner(float f) {
        this.f49643d = f;
    }

    public float getLeftTopCorner() {
        return this.f49640a;
    }

    public float getLeftBottomCorner() {
        return this.f49641b;
    }

    public float getRightTopCorner() {
        return this.f49642c;
    }

    public float getRightBottomCorner() {
        return this.f49643d;
    }
}
