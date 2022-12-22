package com.didi.hawaii.mapsdkv2.adapter;

import android.util.Pair;
import com.didi.hawaii.mapsdkv2.adapter.option.GLBezierCurveOptionAdapter;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLBezierCuve;
import com.didi.map.alpha.maps.internal.BezierCurveControl;
import com.didi.map.alpha.maps.internal.IBezierCurveDelegate;
import com.didi.map.outer.model.BezierCurve;
import com.didi.map.outer.model.BezierCurveOption;
import java.util.Map;

public class BezireCurveDelegate extends C9003b implements IBezierCurveDelegate {
    public static final GLBezierCurveOptionAdapter ADAPTER = new GLBezierCurveOptionAdapter();

    public void clearBezierCurves() {
    }

    public BezireCurveDelegate(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map) {
        super(gLViewManager, map);
    }

    public BezierCurve addBezierCurve(BezierCurveOption bezierCurveOption, BezierCurveControl bezierCurveControl) {
        GLBezierCuve gLBezierCuve = new GLBezierCuve(this.viewManager, ADAPTER.get(bezierCurveOption, this.viewManager));
        BezierCurve bezierCurve = new BezierCurve(bezierCurveOption, bezierCurveControl, gLBezierCuve.getId());
        add(bezierCurve.getId(), bezierCurve, gLBezierCuve);
        return bezierCurve;
    }

    public void update(String str, float f) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.second instanceof GLBezierCuve)) {
            ((GLBezierCuve) a.second).setState(f);
        }
    }

    public void remove(String str) {
        super.remove(str);
    }
}
