package com.didi.map.alpha.maps.internal;

import com.didi.map.outer.model.BezierCurve;
import com.didi.map.outer.model.BezierCurveOption;

public class BezierCurveControl {

    /* renamed from: a */
    private IBezierCurveDelegate f24456a;

    public BezierCurveControl(IBezierCurveDelegate iBezierCurveDelegate) {
        this.f24456a = iBezierCurveDelegate;
    }

    public BezierCurve addBezierCurve(BezierCurveOption bezierCurveOption) {
        return this.f24456a.addBezierCurve(bezierCurveOption, this);
    }

    public void update(String str, float f) {
        this.f24456a.update(str, f);
    }

    public void remove(String str) {
        this.f24456a.remove(str);
    }

    public void clearBezierCurves() {
        this.f24456a.clearBezierCurves();
    }
}
