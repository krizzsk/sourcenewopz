package com.didi.map.global.flow.scene.order.confirm.normal;

public class CircleParam {

    /* renamed from: a */
    private double f26634a;

    /* renamed from: b */
    private int f26635b;

    /* renamed from: c */
    private int f26636c;

    /* renamed from: d */
    private int f26637d;

    public CircleParam(double d, int i, int i2, int i3) {
        this.f26634a = d;
        this.f26635b = i;
        this.f26636c = i2;
        this.f26637d = i3;
    }

    public double getRadiusInMeters() {
        return this.f26634a;
    }

    public int getFillColor() {
        return this.f26635b;
    }

    public int getStrokeColor() {
        return this.f26636c;
    }

    public int getStrokeWidthInPixel() {
        return this.f26637d;
    }
}
