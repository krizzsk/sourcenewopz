package com.didi.map.outer.model;

public class HeatDataNode {

    /* renamed from: a */
    private LatLng f27922a;

    /* renamed from: b */
    private double f27923b;

    public HeatDataNode(LatLng latLng, double d) {
        this.f27922a = latLng;
        this.f27923b = d;
    }

    public double getValue() {
        return this.f27923b;
    }

    public void setValue(double d) {
        this.f27923b = d;
    }

    public LatLng getPoint() {
        return this.f27922a;
    }

    public void setPoint(LatLng latLng) {
        this.f27922a = latLng;
    }
}
