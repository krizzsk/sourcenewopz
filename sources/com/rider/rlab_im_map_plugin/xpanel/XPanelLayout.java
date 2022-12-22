package com.rider.rlab_im_map_plugin.xpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.common.map.util.DisplayUtils;
import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XPanelLayout extends FrameLayout {

    /* renamed from: a */
    private ViewGroup f55970a;

    /* renamed from: b */
    private Context f55971b;

    /* renamed from: c */
    private double f55972c = 0.0d;

    /* renamed from: d */
    private boolean f55973d = false;

    /* renamed from: e */
    private ArrayList<Map<String, Double>> f55974e = new ArrayList<>();

    /* renamed from: f */
    private double f55975f;

    /* renamed from: g */
    private boolean f55976g;

    /* renamed from: h */
    private boolean f55977h = false;

    public XPanelLayout(Context context) {
        super(context);
        m40305a(context);
    }

    public XPanelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m40305a(context);
    }

    public XPanelLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m40305a(context);
    }

    /* renamed from: a */
    private void m40305a(Context context) {
        this.f55971b = context;
        this.f55975f = (double) DisplayUtils.getWindowHeight(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewGroup viewGroup;
        boolean z = ((double) motionEvent.getY()) < this.f55975f - this.f55972c;
        boolean a = m40306a(motionEvent);
        if (!this.f55976g && (viewGroup = this.f55970a) != null && z && !this.f55973d && !a) {
            return viewGroup.dispatchTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 5 || motionEvent.getActionMasked() == 6) {
            motionEvent.setAction(3);
            return super.dispatchTouchEvent(motionEvent);
        } else if (!this.f55977h) {
            return super.dispatchTouchEvent(motionEvent);
        } else {
            motionEvent.setAction(3);
            return this.f55970a.dispatchTouchEvent(motionEvent);
        }
    }

    public void setMoveFlag(boolean z) {
        this.f55977h = z;
    }

    public void setSodaMapView(ViewGroup viewGroup) {
        this.f55970a = viewGroup;
    }

    /* renamed from: a */
    private boolean m40306a(MotionEvent motionEvent) {
        ArrayList<Map<String, Double>> arrayList = this.f55974e;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (int i = 0; i < this.f55974e.size(); i++) {
                Map map = this.f55974e.get(i);
                double doubleValue = ((Double) map.get("x")).doubleValue();
                double doubleValue2 = ((Double) map.get(SameLayerRenderingUtil.KEY_COMP_Y)).doubleValue();
                double doubleValue3 = ((Double) map.get("width")).doubleValue();
                double doubleValue4 = ((Double) map.get("height")).doubleValue();
                float dp2px = (float) DisplayUtils.dp2px(this.f55971b, (float) doubleValue);
                float dp2px2 = (float) DisplayUtils.dp2px(this.f55971b, (float) doubleValue2);
                float dp2px3 = (float) DisplayUtils.dp2px(this.f55971b, (float) doubleValue3);
                float dp2px4 = (float) DisplayUtils.dp2px(this.f55971b, (float) doubleValue4);
                if (motionEvent.getY() > dp2px2 && motionEvent.getY() < dp2px2 + dp2px4 && motionEvent.getX() > dp2px && motionEvent.getX() < dp2px + dp2px3) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setScrolling(Boolean bool) {
        this.f55973d = bool.booleanValue();
    }

    public void setMapTouchHeight(Double d) {
        this.f55972c = d.doubleValue();
    }

    public void setHitFrames(List<Map<String, Double>> list) {
        this.f55974e.clear();
        this.f55974e.addAll(list);
    }

    public void setNotHandling(boolean z) {
        this.f55976g = z;
    }
}
