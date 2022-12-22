package com.didi.map.global.component.departure.fence;

import java.util.List;

public class FenceOptions {

    /* renamed from: a */
    private List<FencePolygon> f25141a;

    /* renamed from: b */
    private IFenceListener f25142b;

    /* renamed from: c */
    private int f25143c;

    /* renamed from: d */
    private int f25144d;

    /* renamed from: e */
    private float f25145e;

    /* renamed from: f */
    private double f25146f = -1.0d;

    /* renamed from: g */
    private int f25147g = 0;

    /* renamed from: h */
    private int f25148h = 0;

    public List<FencePolygon> getFences() {
        return this.f25141a;
    }

    public void setFences(List<FencePolygon> list) {
        this.f25141a = list;
    }

    public IFenceListener getFenceListener() {
        return this.f25142b;
    }

    public void setFenceListener(IFenceListener iFenceListener) {
        this.f25142b = iFenceListener;
    }

    public int getFillColor() {
        return this.f25143c;
    }

    public void setFillColor(int i) {
        this.f25143c = i;
    }

    public int getStrokeColor() {
        return this.f25144d;
    }

    public void setStrokeColor(int i) {
        this.f25144d = i;
    }

    public float getStrokeWidth() {
        return this.f25145e;
    }

    public void setStrokeWidth(float f) {
        this.f25145e = f;
    }

    public double getLimitZoom() {
        return this.f25146f;
    }

    public void setLimitZoom(double d) {
        this.f25146f = d;
    }

    public int getPolygonZIndex() {
        return this.f25147g;
    }

    public void setPolygonZIndex(int i) {
        this.f25147g = i;
    }

    public int getMarkerZIndex() {
        return this.f25148h;
    }

    public void setMarkerZIndex(int i) {
        this.f25148h = i;
    }
}
