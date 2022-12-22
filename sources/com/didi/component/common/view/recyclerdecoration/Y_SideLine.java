package com.didi.component.common.view.recyclerdecoration;

public class Y_SideLine {

    /* renamed from: a */
    private boolean f11917a = false;

    /* renamed from: b */
    private int f11918b;

    /* renamed from: c */
    private int f11919c;

    /* renamed from: d */
    private int f11920d;

    /* renamed from: e */
    private int f11921e;

    public Y_SideLine(boolean z, int i, int i2, int i3, int i4) {
        this.f11917a = z;
        this.f11918b = i;
        this.f11919c = i2;
        this.f11920d = i3;
        this.f11921e = i4;
    }

    public boolean isHave() {
        return this.f11917a;
    }

    public void setHave(boolean z) {
        this.f11917a = z;
    }

    public int getColor() {
        return this.f11918b;
    }

    public void setColor(int i) {
        this.f11918b = i;
    }

    public int getWidthPx() {
        return this.f11919c;
    }

    public void setWidthPx(int i) {
        this.f11919c = i;
    }

    public int getStartPaddingPx() {
        return this.f11920d;
    }

    public void setStartPaddingPx(int i) {
        this.f11920d = i;
    }

    public int getEndPaddingPx() {
        return this.f11921e;
    }

    public void setEndPaddingPx(int i) {
        this.f11921e = i;
    }
}
