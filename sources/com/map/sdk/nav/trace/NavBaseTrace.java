package com.map.sdk.nav.trace;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.driveromega.GlobalDriverOmega;
import com.map.sdk.nav.libc.common.Convertor;
import com.map.sdk.nav.libc.common.DMKGPSPoint;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.HashMap;

public class NavBaseTrace {
    /* renamed from: a */
    private static void m40145a(double d, double d2, double d3, double d4, double d5, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("point_yaw_lat", Double.valueOf(d));
        hashMap.put("point_yaw_lng", Double.valueOf(d2));
        hashMap.put("point_yaw_contral_lat", Double.valueOf(d3));
        hashMap.put("point_yaw_contral_lng", Double.valueOf(d4));
        hashMap.put("distance_yaw", Double.valueOf(d5));
        hashMap.put("yaw_strategy", Integer.valueOf(i));
        hashMap.put("route_id_ori", str);
        StringBuilder sb = new StringBuilder();
        for (Object next : hashMap.entrySet()) {
            sb.append(" " + next.toString() + " ");
        }
        DLog.m7384d("NavBaseTrace", "[traceYawPointDistanceInner] eventMap = " + sb.toString(), new Object[0]);
        GlobalDriverOmega.trackEvent("map_globalmap_yawdistance_bt", hashMap);
    }

    public static void traceYawPointDistance(DMKGPSPoint dMKGPSPoint, RouteGuidanceGPSPoint routeGuidanceGPSPoint, int i, String str) {
        double d;
        double d2;
        double d3;
        DMKGPSPoint dMKGPSPoint2 = dMKGPSPoint;
        RouteGuidanceGPSPoint routeGuidanceGPSPoint2 = routeGuidanceGPSPoint;
        if (dMKGPSPoint2 == null || dMKGPSPoint2.mapPoint == null) {
            DLog.m7384d("NavBaseTrace", "[traceYawPointDistance] sourceGpsPoint is null", new Object[0]);
            return;
        }
        RouteGuidanceGPSPoint convertFromDMKGPSPoint = Convertor.convertFromDMKGPSPoint(dMKGPSPoint);
        if (routeGuidanceGPSPoint2 == null || routeGuidanceGPSPoint2.point == null) {
            d = -1.0d;
            d3 = 0.0d;
            d2 = 0.0d;
        } else {
            double latitudeE6 = ((double) routeGuidanceGPSPoint2.point.getLatitudeE6()) / 1000000.0d;
            double longitudeE6 = ((double) routeGuidanceGPSPoint2.point.getLongitudeE6()) / 1000000.0d;
            d2 = longitudeE6;
            d3 = latitudeE6;
            d = DDSphericalUtil.computeDistanceBetween(new LatLng(latitudeE6, longitudeE6), new LatLng(((double) convertFromDMKGPSPoint.point.getLatitudeE6()) / 1000000.0d, ((double) convertFromDMKGPSPoint.point.getLongitudeE6()) / 1000000.0d));
        }
        m40145a(((double) convertFromDMKGPSPoint.point.getLatitudeE6()) / 1000000.0d, ((double) convertFromDMKGPSPoint.point.getLongitudeE6()) / 1000000.0d, d3, d2, d, i, str);
    }
}
