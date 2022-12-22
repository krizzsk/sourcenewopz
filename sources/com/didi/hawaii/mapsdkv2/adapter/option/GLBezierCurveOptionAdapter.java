package com.didi.hawaii.mapsdkv2.adapter.option;

import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLBezierCuve;
import com.didi.map.outer.model.BezierCurveOption;

public final class GLBezierCurveOptionAdapter implements GLViewOptionAdapter<GLBezierCuve.Option, BezierCurveOption> {
    public GLBezierCuve.Option get(BezierCurveOption bezierCurveOption, GLViewManager gLViewManager) {
        GLBezierCuve.Option option = new GLBezierCuve.Option();
        option.setStartPoint(bezierCurveOption.getStartPoint());
        option.setEndPoint(bezierCurveOption.getEndPoint());
        option.setCurvature(bezierCurveOption.getCurvature());
        option.setmColor(bezierCurveOption.getmColor());
        option.setWidth(bezierCurveOption.getWidth());
        return option;
    }
}
