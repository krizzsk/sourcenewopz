package com.didi.map.intl.commonwalkengine;

import com.didi.common.map.model.LatLng;
import com.map.global.nav.libc.common.DMKEventPoint;
import com.map.global.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0010J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH&J\"\u0010\u0007\u001a\u00020\u00032\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/map/intl/commonwalkengine/IWalkEngine;", "", "destroy", "", "getMatchPoint", "point", "Lcom/map/global/nav/libc/common/RouteGuidanceGPSPoint;", "setRoutePoints", "points", "", "Lcom/didi/common/map/model/LatLng;", "routeWayIndex", "", "setWalkEngineEventCallback", "callback", "Lcom/didi/map/intl/commonwalkengine/IWalkEngine$IWalkEngineEventCallback;", "IWalkEngineEventCallback", "commonWalkEngine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IWalkEngine.kt */
public interface IWalkEngine {

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/map/intl/commonwalkengine/IWalkEngine$IWalkEngineEventCallback;", "", "onMatched", "", "point", "Lcom/didi/common/map/model/LatLng;", "segmentIndex", "", "shapeOffset", "distanceOffset", "timeOffset", "eventPoint", "Lcom/map/global/nav/libc/common/DMKEventPoint;", "onOffRoute", "commonWalkEngine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IWalkEngine.kt */
    public interface IWalkEngineEventCallback {
        void onMatched(LatLng latLng, int i, int i2, int i3, int i4, DMKEventPoint dMKEventPoint);

        void onOffRoute();
    }

    void destroy();

    void getMatchPoint(RouteGuidanceGPSPoint routeGuidanceGPSPoint);

    void setRoutePoints(List<LatLng> list);

    void setRoutePoints(List<LatLng> list, int i);

    void setWalkEngineEventCallback(IWalkEngineEventCallback iWalkEngineEventCallback);
}
