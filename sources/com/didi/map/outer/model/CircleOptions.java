package com.didi.map.outer.model;

import android.os.Parcel;

public class CircleOptions {

    /* renamed from: a */
    private LatLng f27911a;

    /* renamed from: b */
    private double f27912b;

    /* renamed from: c */
    private float f27913c;

    /* renamed from: d */
    private int f27914d;

    /* renamed from: e */
    private int f27915e;

    /* renamed from: f */
    private float f27916f;

    /* renamed from: g */
    private boolean f27917g;

    /* renamed from: h */
    private boolean f27918h;

    /* renamed from: i */
    private boolean f27919i;

    public CircleOptions() {
        this.f27919i = false;
        this.f27911a = null;
        this.f27912b = 0.0d;
        this.f27913c = 1.0f;
        this.f27914d = -16777216;
        this.f27915e = 0;
        this.f27916f = 0.0f;
        this.f27917g = true;
        this.f27918h = false;
    }

    CircleOptions(Parcel parcel) {
        boolean z = false;
        this.f27919i = false;
        this.f27911a = new LatLng(parcel.readDouble(), parcel.readDouble());
        this.f27912b = parcel.readDouble();
        this.f27913c = parcel.readFloat();
        this.f27914d = parcel.readInt();
        this.f27915e = parcel.readInt();
        this.f27916f = parcel.readFloat();
        this.f27917g = parcel.readInt() == 1 ? true : z;
    }

    public CircleOptions center(LatLng latLng) {
        this.f27911a = latLng;
        return this;
    }

    public CircleOptions isDottedLine(boolean z) {
        this.f27918h = z;
        return this;
    }

    public CircleOptions radius(double d) {
        this.f27912b = d;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.f27913c = f;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.f27914d = i;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f27915e = i;
        return this;
    }

    public CircleOptions zIndex(float f) {
        this.f27916f = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f27917g = z;
        return this;
    }

    public CircleOptions mask(boolean z) {
        this.f27919i = z;
        return this;
    }

    public LatLng getCenter() {
        return this.f27911a;
    }

    public double getRadius() {
        return this.f27912b;
    }

    public float getStrokeWidth() {
        return this.f27913c;
    }

    public int getStrokeColor() {
        return this.f27914d;
    }

    public int getFillColor() {
        return this.f27915e;
    }

    public float getZIndex() {
        return this.f27916f;
    }

    public boolean isVisible() {
        return this.f27917g;
    }

    public boolean isDottedLine() {
        return this.f27918h;
    }

    public boolean isMask() {
        return this.f27919i;
    }
}
