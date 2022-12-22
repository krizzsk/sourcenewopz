package com.didi.map.alpha.maps.internal;

import com.didi.map.outer.model.BezierCurve;
import com.didi.map.outer.model.BezierCurveOption;

public interface IBezierCurveDelegate {
    BezierCurve addBezierCurve(BezierCurveOption bezierCurveOption, BezierCurveControl bezierCurveControl);

    void clearBezierCurves();

    void remove(String str);

    void update(String str, float f);
}
