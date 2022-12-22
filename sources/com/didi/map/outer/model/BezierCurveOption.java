package com.didi.map.outer.model;

import android.graphics.Color;

public class BezierCurveOption {

    /* renamed from: a */
    private LatLng f27881a;

    /* renamed from: b */
    private LatLng f27882b;

    /* renamed from: c */
    private int f27883c = Color.argb(17, 0, 163, 255);

    /* renamed from: d */
    private float f27884d;

    /* renamed from: e */
    private float f27885e;

    public BezierCurveOption startLatlng(LatLng latLng) {
        this.f27881a = latLng;
        return this;
    }

    public BezierCurveOption endLatlng(LatLng latLng) {
        this.f27882b = latLng;
        return this;
    }

    public BezierCurveOption width(float f) {
        this.f27884d = f;
        return this;
    }

    public BezierCurveOption curvature(float f) {
        this.f27885e = f;
        return this;
    }

    public BezierCurveOption color(int i) {
        this.f27883c = i;
        return this;
    }

    public LatLng getStartPoint() {
        return this.f27881a;
    }

    public LatLng getEndPoint() {
        return this.f27882b;
    }

    public int getmColor() {
        return this.f27883c;
    }

    public float getWidth() {
        return this.f27884d;
    }

    public float getCurvature() {
        return this.f27885e;
    }
}
