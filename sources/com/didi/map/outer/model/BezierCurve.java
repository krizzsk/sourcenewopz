package com.didi.map.outer.model;

import com.didi.map.alpha.maps.internal.BezierCurveControl;

public class BezierCurve {

    /* renamed from: a */
    private BezierCurveOption f27878a;

    /* renamed from: b */
    private BezierCurveControl f27879b;

    /* renamed from: c */
    private String f27880c;

    public BezierCurve(BezierCurveOption bezierCurveOption, BezierCurveControl bezierCurveControl, String str) {
        this.f27878a = bezierCurveOption;
        this.f27879b = bezierCurveControl;
        this.f27880c = str;
    }

    public void update(float f) {
        this.f27879b.update(this.f27880c, f);
    }

    public void remove() {
        this.f27879b.remove(this.f27880c);
    }

    public String getId() {
        return this.f27880c;
    }
}
