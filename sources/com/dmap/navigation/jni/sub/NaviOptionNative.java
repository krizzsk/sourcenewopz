package com.dmap.navigation.jni.sub;

import com.dmap.navigation.base.ctx.INaviOptionExt;
import com.dmap.navigation.jni.swig.NaviOption;

public class NaviOptionNative extends NaviOption implements INaviOptionExt {

    /* renamed from: a */
    private boolean f52023a;

    /* renamed from: b */
    private boolean f52024b = false;

    /* renamed from: c */
    private boolean f52025c = false;

    /* renamed from: d */
    private boolean f52026d = false;

    /* renamed from: e */
    private boolean f52027e = true;

    /* renamed from: f */
    private boolean f52028f = true;

    /* renamed from: g */
    private float f52029g = 10.0f;

    /* renamed from: h */
    private int f52030h = 2;

    /* renamed from: i */
    private final C17412a f52031i;

    /* renamed from: j */
    private INaviOptionExt.OptionChangedListener f52032j;

    /* renamed from: k */
    private int f52033k = 99;

    public NaviOptionNative() {
        C17412a aVar = new C17412a();
        this.f52031i = aVar;
        setNaviRouteStrategy(aVar);
        setDispatchId("");
        setDispatchType(0);
    }

    public boolean isKeepTrafficEvent() {
        return this.f52023a;
    }

    public boolean isMandatory() {
        return this.f52024b;
    }

    public void setLaneHovGrayEnable(boolean z) {
        this.f52025c = z;
    }

    public void setKeepTrafficEvent(boolean z) {
        this.f52023a = z;
    }

    public boolean isLaneHovGrayEnable() {
        return this.f52025c;
    }

    public void setMandatory(boolean z) {
        this.f52024b = z;
    }

    public void setOptionChangedListener(INaviOptionExt.OptionChangedListener optionChangedListener) {
        this.f52032j = optionChangedListener;
    }

    public C17412a getNaviRouteStrategy() {
        return this.f52031i;
    }

    public boolean isGuideLineEnable() {
        return this.f52026d;
    }

    public void setGuideLineEnable(boolean z) {
        this.f52026d = z;
        m37051a(INaviOptionExt.KEY_GUIDE, String.valueOf(z));
    }

    public void setMainRouteVisible(boolean z) {
        this.f52027e = z;
        m37051a(INaviOptionExt.KEY_MAIN_ROUTE, String.valueOf(z));
    }

    public boolean isMainRouteVisible() {
        return this.f52027e;
    }

    public void setMainRouteBubbleVisible(boolean z) {
        this.f52028f = z;
        m37051a(INaviOptionExt.KEY_MAIN_ROUTE_BUBBLE, String.valueOf(z));
    }

    public boolean isMainRouteBubbleVisible() {
        return this.f52028f;
    }

    public void setMainRouteLineWidth(float f) {
        this.f52029g = f;
    }

    public float getMainRouteLineWidth() {
        return this.f52029g;
    }

    public int getNaviLocLevel() {
        return this.f52030h;
    }

    public void setNaviLocLevel(int i) {
        this.f52030h = i;
    }

    public void setVehicleZIndex(int i) {
        this.f52033k = i;
    }

    public int getVehicleZIndex() {
        return this.f52033k;
    }

    /* renamed from: a */
    private void m37051a(String str, String str2) {
        INaviOptionExt.OptionChangedListener optionChangedListener = this.f52032j;
        if (optionChangedListener != null) {
            optionChangedListener.onChanged(str, str2);
        }
    }
}
