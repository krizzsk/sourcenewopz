package com.airbnb.lottie.model;

import android.graphics.PointF;

public class CubicCurveData {

    /* renamed from: a */
    private final PointF f1368a;

    /* renamed from: b */
    private final PointF f1369b;

    /* renamed from: c */
    private final PointF f1370c;

    public CubicCurveData() {
        this.f1368a = new PointF();
        this.f1369b = new PointF();
        this.f1370c = new PointF();
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f1368a = pointF;
        this.f1369b = pointF2;
        this.f1370c = pointF3;
    }

    public void setControlPoint1(float f, float f2) {
        this.f1368a.set(f, f2);
    }

    public PointF getControlPoint1() {
        return this.f1368a;
    }

    public void setControlPoint2(float f, float f2) {
        this.f1369b.set(f, f2);
    }

    public PointF getControlPoint2() {
        return this.f1369b;
    }

    public void setVertex(float f, float f2) {
        this.f1370c.set(f, f2);
    }

    public PointF getVertex() {
        return this.f1370c;
    }
}
