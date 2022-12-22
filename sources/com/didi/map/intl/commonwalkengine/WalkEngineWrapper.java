package com.didi.map.intl.commonwalkengine;

import com.didi.common.map.model.LatLng;
import com.didi.map.intl.commonwalkengine.IWalkEngine;
import com.map.global.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.List;

public class WalkEngineWrapper implements IWalkEngine {

    /* renamed from: a */
    private IWalkEngine f27820a;

    public WalkEngineWrapper(WalkEngineType walkEngineType) {
        this.f27820a = WalkEngineFactory.getWalkEngine(walkEngineType);
    }

    public void setWalkEngineEventCallback(IWalkEngine.IWalkEngineEventCallback iWalkEngineEventCallback) {
        this.f27820a.setWalkEngineEventCallback(iWalkEngineEventCallback);
    }

    public void setRoutePoints(List<LatLng> list) {
        this.f27820a.setRoutePoints(list);
    }

    public void setRoutePoints(List<LatLng> list, int i) {
        this.f27820a.setRoutePoints(list, i);
    }

    public void getMatchPoint(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        this.f27820a.getMatchPoint(routeGuidanceGPSPoint);
    }

    public void destroy() {
        this.f27820a.destroy();
    }
}
