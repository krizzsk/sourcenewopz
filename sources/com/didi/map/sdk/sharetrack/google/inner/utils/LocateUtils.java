package com.didi.map.sdk.sharetrack.google.inner.utils;

import com.didi.common.map.model.GpsLocation;
import com.didi.common.map.model.LatLng;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;

public class LocateUtils {
    public static boolean locateCorrect(double d, double d2) {
        return (!equal(d, 0.0d) || !equal(d2, 0.0d)) && d2 <= 180.0d && d <= 90.0d && d2 >= -180.0d && d >= -90.0d;
    }

    public static boolean equal(double d, double d2) {
        return Math.abs(d - d2) < 1.0E-6d;
    }

    public static boolean locateCorrect(GpsLocation gpsLocation) {
        if (gpsLocation == null) {
            return false;
        }
        return locateCorrect(gpsLocation.latitude, gpsLocation.longitude);
    }

    public static boolean latLngEqual(LatLng latLng, LatLng latLng2) {
        return equal(latLng.latitude, latLng2.latitude) && equal(latLng.longitude, latLng2.longitude);
    }

    public static GpsLocation convertToGpsLocation(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        GpsLocation gpsLocation = new GpsLocation();
        gpsLocation.latitude = ((double) routeGuidanceGPSPoint.point.getLatitudeE6()) / 1000000.0d;
        gpsLocation.longitude = ((double) routeGuidanceGPSPoint.point.getLongitudeE6()) / 1000000.0d;
        gpsLocation.accuracy = routeGuidanceGPSPoint.accuracy;
        gpsLocation.direction = routeGuidanceGPSPoint.heading;
        gpsLocation.velocity = routeGuidanceGPSPoint.velocity;
        gpsLocation.time = routeGuidanceGPSPoint.timestamp;
        gpsLocation.provider = "match";
        gpsLocation.source = routeGuidanceGPSPoint.source;
        gpsLocation.localTime = System.currentTimeMillis();
        return gpsLocation;
    }
}
