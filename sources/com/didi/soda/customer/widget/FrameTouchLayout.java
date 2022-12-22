package com.didi.soda.customer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import com.didi.soda.customer.widget.map.SodaMapView;
import java.util.List;
import java.util.Map;

public class FrameTouchLayout extends LinearLayout {

    /* renamed from: a */
    SodaMapView f41536a;

    /* renamed from: b */
    double f41537b = 0.0d;

    /* renamed from: c */
    boolean f41538c = false;

    /* renamed from: d */
    List<Map<String, Double>> f41539d;

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
        return this.f41536a;
    }

    public void setSodaMapView(SodaMapView sodaMapView) {
        this.f41536a = sodaMapView;
    }

    public double getMapTouchHeight() {
        return this.f41537b;
    }

    public void setMapTouchHeight(double d) {
        this.f41537b = d;
    }

    public void setScrolling(boolean z) {
        this.f41538c = z;
    }

    public void setHitFrames(List<Map<String, Double>> list) {
        this.f41539d = list;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f41536a == null || motionEvent.getY() >= ((float) DisplayUtils.dip2px(getContext(), (float) this.f41537b)) || this.f41538c || m29374a(motionEvent)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return this.f41536a.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private boolean m29374a(MotionEvent motionEvent) {
        List<Map<String, Double>> list = this.f41539d;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.f41539d.size(); i++) {
                Map map = this.f41539d.get(i);
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
