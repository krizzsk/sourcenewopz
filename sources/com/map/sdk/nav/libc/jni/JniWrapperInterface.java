package com.map.sdk.nav.libc.jni;

import com.didi.common.map.model.LatLng;
import com.map.sdk.nav.libc.common.DMKEventPoint;
import com.map.sdk.nav.libc.common.DMKGPSPoint;
import com.map.sdk.nav.libc.common.DMKMatchResult;
import com.map.sdk.nav.libc.common.DMKMockConfig;
import com.map.sdk.nav.libc.common.GeoPoint;
import com.map.sdk.nav.libc.common.MapMatchType;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.ArrayList;
import java.util.List;

public interface JniWrapperInterface {
    void clear();

    void destroy();

    int distanceLeft(RouteGuidanceGPSPoint routeGuidanceGPSPoint);

    int distanceLeft2();

    RouteGuidanceGPSPoint findClosetPointToRoute(DMKGPSPoint dMKGPSPoint, boolean z);

    void getEventPointList(ArrayList<DMKEventPoint> arrayList);

    int getEventPointSize();

    MapMatchType getMapMatchType();

    boolean isOutWay();

    RouteGuidanceGPSPoint matchResult(RouteGuidanceGPSPoint routeGuidanceGPSPoint, DMKMatchResult dMKMatchResult);

    void setMockConfig(DMKMockConfig dMKMockConfig);

    void setNextRoutePoints(List<LatLng> list);

    void setRouteId(String str);

    void setRoutePoints(GeoPoint[] geoPointArr);
}
