package com.map.sdk.nav.hawaii;

import com.dmap.navigation.jni.swig.RGGPSPoint_t;
import com.dmap.navigation.jni.swig.RGMapRoutePoint_t;
import com.map.sdk.nav.libc.common.MercatorUtil;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;

public class HawaiiConvertor {
    public static RGGPSPoint_t convertRouteGuidanceGPSPoint2RGGPSPoint_t(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        if (routeGuidanceGPSPoint == null || routeGuidanceGPSPoint.point == null) {
            return null;
        }
        RGGPSPoint_t rGGPSPoint_t = new RGGPSPoint_t();
        RGMapRoutePoint_t rGMapRoutePoint_t = new RGMapRoutePoint_t();
        rGMapRoutePoint_t.setCoorIdx(-1);
        rGMapRoutePoint_t.setShapeOffset(-1.0d);
        rGMapRoutePoint_t.setGeoPoint(MercatorUtil.latLng2MercatorHawaii(((double) routeGuidanceGPSPoint.point.getLongitudeE6()) / 1000000.0d, ((double) routeGuidanceGPSPoint.point.getLatitudeE6()) / 1000000.0d));
        rGGPSPoint_t.setRouteMapPos(rGMapRoutePoint_t);
        rGGPSPoint_t.setHeading(routeGuidanceGPSPoint.heading);
        rGGPSPoint_t.setLocationAccuracy((float) routeGuidanceGPSPoint.accuracy);
        rGGPSPoint_t.setVelocity(routeGuidanceGPSPoint.velocity);
        rGGPSPoint_t.setTimestamp((int) routeGuidanceGPSPoint.timestamp);
        rGGPSPoint_t.setFlpBearing(0.0f);
        rGGPSPoint_t.setFlpConfidence(0.0f);
        rGGPSPoint_t.setFlpStatus(0);
        rGGPSPoint_t.setSource(0);
        rGGPSPoint_t.setGpsProvider(0);
        rGGPSPoint_t.setVdrConf(0);
        rGGPSPoint_t.setOrgLat(-1.0d);
        rGGPSPoint_t.setOrgLng(-1.0d);
        rGGPSPoint_t.setOrgDir(-1.0f);
        rGGPSPoint_t.setOrgAcc(-1.0f);
        rGGPSPoint_t.setSatNum(-1);
        return rGGPSPoint_t;
    }

    public static RouteGuidanceGPSPoint convertRGGPSPoint_t2RouteGuidanceGPSPoint(RGGPSPoint_t rGGPSPoint_t) {
        if (rGGPSPoint_t == null && rGGPSPoint_t.getRouteMapPos() != null && rGGPSPoint_t.getRouteMapPos().getGeoPoint() != null) {
            return null;
        }
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        routeGuidanceGPSPoint.point = MercatorUtil.mercator2GeoPoint(rGGPSPoint_t.getRouteMapPos().getGeoPoint().getLng(), rGGPSPoint_t.getRouteMapPos().getGeoPoint().getLat());
        routeGuidanceGPSPoint.accuracy = (int) rGGPSPoint_t.getLocationAccuracy();
        routeGuidanceGPSPoint.heading = rGGPSPoint_t.getHeading();
        routeGuidanceGPSPoint.segmentIndex = rGGPSPoint_t.getRouteMapPos().getCoorIdx();
        routeGuidanceGPSPoint.shapeOffSet = (int) rGGPSPoint_t.getRouteMapPos().getShapeOffset();
        routeGuidanceGPSPoint.timestamp = (long) rGGPSPoint_t.getTimestamp();
        routeGuidanceGPSPoint.velocity = rGGPSPoint_t.getVelocity();
        routeGuidanceGPSPoint.source = rGGPSPoint_t.getSource();
        routeGuidanceGPSPoint.originMatchPoint = routeGuidanceGPSPoint.copy();
        return routeGuidanceGPSPoint;
    }
}
