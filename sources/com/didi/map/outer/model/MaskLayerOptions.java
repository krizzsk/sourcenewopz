package com.didi.map.outer.model;

public class MaskLayerOptions {

    /* renamed from: a */
    private int f27987a = 0;

    /* renamed from: b */
    private long f27988b = 0;

    /* renamed from: c */
    private int f27989c = 0;

    public MaskLayerOptions color(int i) {
        this.f27987a = i;
        return this;
    }

    public int getColor() {
        return this.f27987a;
    }

    public MaskLayerOptions animationDuration(long j) {
        this.f27988b = j;
        return this;
    }

    public long getAnimationDuration() {
        return this.f27988b;
    }

    public MaskLayerOptions zIndex(int i) {
        this.f27989c = i;
        return this;
    }

    public int getZIndex() {
        return this.f27989c;
    }
}
