package com.didi.common.map.model;

import com.didi.common.map.internal.IMapElementOptions;

public final class CircleOptions extends IMapElementOptions {
    public static final int DEFAULT_ACCURACY = 100;

    /* renamed from: a */
    private LatLng f10806a;

    /* renamed from: b */
    private double f10807b = 0.0d;

    /* renamed from: c */
    private float f10808c = -1.0f;

    /* renamed from: d */
    private int f10809d = -1;

    /* renamed from: e */
    private int f10810e = -1;

    /* renamed from: f */
    private int f10811f = 100;

    public CircleOptions center(LatLng latLng) {
        this.f10806a = latLng;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f10810e = i;
        return this;
    }

    public LatLng getCenter() {
        return this.f10806a;
    }

    public int getFillColor() {
        return this.f10810e;
    }

    public double getRadius() {
        return this.f10807b;
    }

    public int getStrokeColor() {
        return this.f10809d;
    }

    public float getStrokeWidth() {
        return this.f10808c;
    }

    public CircleOptions radius(double d) {
        this.f10807b = d;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.f10809d = i;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.f10808c = f;
        return this;
    }

    public int getAccuracy() {
        return this.f10811f;
    }

    public CircleOptions setAccuracy(int i) {
        this.f10811f = i;
        return this;
    }
}
