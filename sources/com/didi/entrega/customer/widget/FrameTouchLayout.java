package com.didi.entrega.customer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import com.didi.entrega.customer.widget.map.SodaMapView;
import java.util.List;
import java.util.Map;

public class FrameTouchLayout extends LinearLayout {

    /* renamed from: a */
    SodaMapView f20309a;

    /* renamed from: b */
    double f20310b = 0.0d;

    /* renamed from: c */
    boolean f20311c = false;

    /* renamed from: d */
    List<Map<String, Double>> f20312d;

    public FrameTouchLayout(Context context) {
        super(context);
    }

    public FrameTouchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FrameTouchLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SodaMapView getSodaMapView() {
        return this.f20309a;
    }

    public void setSodaMapView(SodaMapView sodaMapView) {
        this.f20309a = sodaMapView;
    }

    public double getMapTouchHeight() {
        return this.f20310b;
    }

    public void setMapTouchHeight(double d) {
        this.f20310b = d;
    }

    public void setScrolling(boolean z) {
        this.f20311c = z;
    }

    public void setHitFrames(List<Map<String, Double>> list) {
        this.f20312d = list;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f20309a == null || motionEvent.getY() >= ((float) DisplayUtils.dip2px(getContext(), (float) this.f20310b)) || this.f20311c || m14902a(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return this.f20309a.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private boolean m14902a(MotionEvent motionEvent) {
        List<Map<String, Double>> list = this.f20312d;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.f20312d.size(); i++) {
                Map map = this.f20312d.get(i);
                float f = 0.0f;
                int dip2px = DisplayUtils.dip2px(getContext(), map.get("x") == null ? 0.0f : ((Double) map.get("x")).floatValue());
                int dip2px2 = DisplayUtils.dip2px(getContext(), map.get(SameLayerRenderingUtil.KEY_COMP_Y) == null ? 0.0f : ((Double) map.get(SameLayerRenderingUtil.KEY_COMP_Y)).floatValue());
                int dip2px3 = DisplayUtils.dip2px(getContext(), map.get("width") == null ? 0.0f : ((Double) map.get("width")).floatValue());
                Context context = getContext();
                if (map.get("height") != null) {
                    f = ((Double) map.get("height")).floatValue();
                }
                int dip2px4 = DisplayUtils.dip2px(context, f);
                if (motionEvent.getY() > ((float) dip2px2) && motionEvent.getY() < ((float) (dip2px2 + dip2px4)) && motionEvent.getX() > ((float) dip2px) && motionEvent.getX() < ((float) (dip2px + dip2px3))) {
                    return true;
                }
            }
        }
        return false;
    }
}
