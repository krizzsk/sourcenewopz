package com.didichuxing.xpanel.xcard.view;

public class Border {

    /* renamed from: a */
    private int f49638a;

    /* renamed from: b */
    private float f49639b;
    public boolean isEmpty = true;

    public void setBorderColor(int i) {
        this.isEmpty = false;
        this.f49638a = i;
    }

    public void setBorderWidth(float f) {
        this.isEmpty = false;
        this.f49639b = f;
    }

    public int getBorderColor() {
        return this.f49638a;
    }

    public float getBorderWidth() {
        return this.f49639b;
    }
}
