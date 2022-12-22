package com.didiglobal.xbanner.template.yoga.view;

public class Corner {

    /* renamed from: a */
    private float f51540a;

    /* renamed from: b */
    private float f51541b;

    /* renamed from: c */
    private float f51542c;

    /* renamed from: d */
    private float f51543d;

    public void setCorners(float f) {
        this.f51540a = f;
        this.f51541b = f;
        this.f51542c = f;
        this.f51543d = f;
    }

    public void setLeftTopCorner(float f) {
        this.f51540a = f;
    }

    public void setLeftBottomCorner(float f) {
        this.f51541b = f;
    }

    public void setRightTopCorner(float f) {
        this.f51542c = f;
    }

    public void setRightBottomCorner(float f) {
        this.f51543d = f;
    }

    public float getLeftTopCorner() {
        return this.f51540a;
    }

    public float getLeftBottomCorner() {
        return this.f51541b;
    }

    public float getRightTopCorner() {
        return this.f51542c;
    }

    public float getRightBottomCorner() {
        return this.f51543d;
    }
}
