package com.didi.map.intl.commonwalkengine.impl.navbase;

import com.didi.common.map.model.LatLng;
import com.map.global.nav.libc.common.DMKMatchResult;
import com.map.global.nav.libc.common.GeoPoint;
import com.map.global.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u000bH&J\u001e\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u001a\u0010\u000e\u001a\u00020\u00032\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010H&J\u001f\u0010\u0012\u001a\u00020\u00032\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014H&¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, mo175978d2 = {"Lcom/didi/map/intl/commonwalkengine/impl/navbase/INavBaseJniInterface;", "", "clear", "", "destroy", "distanceLeft", "", "gpsPoint", "Lcom/map/global/nav/libc/common/RouteGuidanceGPSPoint;", "distanceLeft2", "isOutWay", "", "matchResult", "Lcom/map/global/nav/libc/common/DMKMatchResult;", "setNextRoutePoints", "nextRoutePoints", "", "Lcom/didi/common/map/model/LatLng;", "setRoutePoints", "inputGpsPoint", "", "Lcom/map/global/nav/libc/common/GeoPoint;", "([Lcom/map/global/nav/libc/common/GeoPoint;)V", "commonWalkEngine_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: INavBaseJniInterface.kt */
public interface INavBaseJniInterface {
    void clear();

    void destroy();

    int distanceLeft(RouteGuidanceGPSPoint routeGuidanceGPSPoint);

    int distanceLeft2();

    boolean isOutWay();

    RouteGuidanceGPSPoint matchResult(RouteGuidanceGPSPoint routeGuidanceGPSPoint, DMKMatchResult dMKMatchResult);

    void setNextRoutePoints(List<LatLng> list);

    void setRoutePoints(GeoPoint[] geoPointArr);
}
