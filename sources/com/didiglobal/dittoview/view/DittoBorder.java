package com.didiglobal.dittoview.view;

public class DittoBorder {

    /* renamed from: a */
    private int f49905a;

    /* renamed from: b */
    private float f49906b;
    public boolean isEmpty = true;

    public void setBorderColor(int i) {
        this.isEmpty = false;
        this.f49905a = i;
    }

    public void setBorderWidth(float f) {
        this.isEmpty = false;
        this.f49906b = f;
    }

    public int getBorderColor() {
        return this.f49905a;
    }

    public float getBorderWidth() {
        return this.f49906b;
    }
}
