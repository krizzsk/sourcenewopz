package com.dmap.navigation.engine.p207a;

import com.didi.map.outer.model.LatLng;
import com.dmap.navigation.base.ctx.INaviContext;
import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.engine.core.INaviEngineVP;
import com.dmap.navigation.jni.sub.NaviLatLngNative;
import com.dmap.navigation.jni.sub.NaviLocationNative;
import com.dmap.navigation.jni.swig.BindNaviLocation;
import com.dmap.navigation.jni.swig.NaviEngineVP;
import com.dmap.navigation.jni.swig.NaviLatLngList;
import com.dmap.navigation.jni.swig.NaviOption;
import java.util.List;

/* renamed from: com.dmap.navigation.engine.a.p */
/* compiled from: NaviEngineVPImpl */
public final class C17405p implements INaviEngineVP {

    /* renamed from: a */
    private final NaviEngineVP f51842a = new NaviEngineVP();

    /* renamed from: b */
    private INaviContext f51843b;

    public C17405p(INaviContext iNaviContext) {
        this.f51843b = iNaviContext;
    }

    public final void init() {
        this.f51842a.init((NaviOption) this.f51843b.getNaviOption());
    }

    public final void setRoutePoints(List<LatLng> list) {
        NaviLatLngList naviLatLngList = new NaviLatLngList();
        if (list != null) {
            for (LatLng next : list) {
                naviLatLngList.add(new NaviLatLngNative(next.latitude, next.longitude));
            }
        }
        this.f51842a.setRoutePoints(naviLatLngList);
    }

    public final void destory() {
        this.f51842a.destory();
    }

    public final BindNaviLocation getMatchLocation(INaviLocation iNaviLocation) {
        return this.f51842a.getMatchLocation(new NaviLocationNative(iNaviLocation));
    }
}
