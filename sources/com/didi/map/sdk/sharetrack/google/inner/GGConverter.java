package com.didi.map.sdk.sharetrack.google.inner;

import com.didi.common.map.model.GpsLocation;
import com.map.sdk.nav.libc.common.GeoPoint;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;

public class GGConverter {
    public static RouteGuidanceGPSPoint convertFromDiDiLocation(GpsLocation gpsLocation) {
        if (gpsLocation == null) {
            return null;
        }
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        routeGuidanceGPSPoint.accuracy = gpsLocation.accuracy;
        routeGuidanceGPSPoint.heading = gpsLocation.direction;
        routeGuidanceGPSPoint.matchedStatus = 1;
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLatitudeE6((int) (gpsLocation.latitude * 1000000.0d));
        geoPoint.setLongitudeE6((int) (gpsLocation.longitude * 1000000.0d));
        routeGuidanceGPSPoint.point = geoPoint;
        routeGuidanceGPSPoint.segmentIndex = -1;
        routeGuidanceGPSPoint.shapeOffSet = 0;
        routeGuidanceGPSPoint.timestamp = gpsLocation.time / 1000;
        routeGuidanceGPSPoint.velocity = gpsLocation.velocity;
        routeGuidanceGPSPoint.source = gpsLocation.source;
        return routeGuidanceGPSPoint;
    }
}
