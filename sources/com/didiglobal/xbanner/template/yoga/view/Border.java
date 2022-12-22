package com.didiglobal.xbanner.template.yoga.view;

public class Border {

    /* renamed from: a */
    private int f51538a;

    /* renamed from: b */
    private float f51539b;
    public boolean isEmpty = true;

    public void setBorderColor(int i) {
        this.isEmpty = false;
        this.f51538a = i;
    }

    public void setBorderWidth(float f) {
        this.isEmpty = false;
        this.f51539b = f;
    }

    public int getBorderColor() {
        return this.f51538a;
    }

    public float getBorderWidth() {
        return this.f51539b;
    }
}
