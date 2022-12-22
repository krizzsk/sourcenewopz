package com.dmap.navigation.jni.sub;

import com.didi.map.base.TrafficEventRoutePoint;
import com.dmap.navigation.jni.swig.TrafficEventPoint;

public class TrafficEventPointNative extends TrafficEventPoint {
    public TrafficEventPointNative(TrafficEventRoutePoint trafficEventRoutePoint) {
        setCoorIdx(trafficEventRoutePoint.coorIdx);
        setShapeOffset(trafficEventRoutePoint.shapeOffset);
    }
}
