package com.didi.global.globalgenerickit.template.yoga.view;

public class Border {

    /* renamed from: a */
    private int f22243a;

    /* renamed from: b */
    private float f22244b;
    public boolean isEmpty = true;

    public void setBorderColor(int i) {
        this.isEmpty = false;
        this.f22243a = i;
    }

    public void setBorderWidth(float f) {
        this.isEmpty = false;
        this.f22244b = f;
    }

    public int getBorderColor() {
        return this.f22243a;
    }

    public float getBorderWidth() {
        return this.f22244b;
    }
}
