package com.didi.map.common.utils;

import android.graphics.Point;
import android.location.Location;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.model.LatLng;

public class TransformUtil {
    public static final double TRANSFORM_PARAM_LAT1 = 0.017453292519943295d;
    public static final double TRANSFORM_PARAM_LAT2 = 0.008726646259971648d;
    public static final double TRANSFORM_PARAM_LAT3 = 114.59155902616465d;
    public static final double TRANSFORM_PARAM_LON = 111319.49077777778d;

    /* renamed from: a */
    private static final int f24692a = 20037508;

    /* renamed from: b */
    private static final int f24693b = 30240971;

    /* renamed from: a */
    private static double m17572a(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static int client2ServerX(int i) {
        return i - f24692a;
    }

    public static int client2ServerY(int i) {
        return i - f24693b;
    }

    public static double clientX2Longitude(int i) {
        return ((double) (i - f24692a)) / 111319.49077777778d;
    }

    public static int longitude2ClientX(double d) {
        return (int) ((d * 111319.49077777778d) + 2.0037508E7d);
    }

    public static int server2ClientX(int i) {
        return i + f24692a;
    }

    public static int server2ClientY(int i) {
        return i + f24693b;
    }

    public static int latitude2ClientY(double d) {
        return (int) (((Math.log(Math.tan((d + 90.0d) * 0.008726646259971648d)) / 0.017453292519943295d) * 111319.49077777778d) + 3.0240971E7d);
    }

    public static double clientY2Latitude(int i) {
        return (Math.atan(Math.exp((((double) (i - f24693b)) / 111319.49077777778d) * 0.017453292519943295d)) * 114.59155902616465d) - 90.0d;
    }

    public static float distanceBetweenPoints(LatLng latLng, LatLng latLng2) {
        return (float) distanceBetween(latLng.latitude, latLng.longitude, latLng2.latitude, latLng2.longitude);
    }

    public static void distanceBetween(double d, double d2, double d3, double d4, float[] fArr) {
        if (fArr == null || fArr.length < 1) {
            throw new IllegalArgumentException("results is null or has length < 1");
        }
        Location.distanceBetween(d, d2, d3, d4, fArr);
        if (fArr.length > 1 && fArr[1] < 0.0f) {
            fArr[1] = fArr[1] + 360.0f;
        }
        fArr[0] = (float) distanceBetween(d, d2, d3, d4);
    }

    public static double distanceBetween(double d, double d2, double d3, double d4) {
        double a = m17572a(d3 - d);
        double a2 = m17572a(d4 - d2);
        double d5 = a / 2.0d;
        double d6 = a2 / 2.0d;
        double sin = (Math.sin(d5) * Math.sin(d5)) + (Math.sin(d6) * Math.sin(d6) * Math.cos(m17572a(d)) * Math.cos(m17572a(d3)));
        return Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * 6371.0d * 1000.0d;
    }

    public static double distanceBetween(LatLng latLng, LatLng latLng2) {
        return distanceBetween(latLng.latitude, latLng.longitude, latLng2.latitude, latLng2.longitude);
    }

    public static GeoPoint serverPointToGeoPoint(int i, int i2) {
        GeoPoint geoPoint = new GeoPoint();
        serverPointToGeoPoint(i, i2, geoPoint);
        return geoPoint;
    }

    public static void serverPointToGeoPoint(int i, int i2, GeoPoint geoPoint) {
        int server2ClientX = server2ClientX(i);
        geoPoint.setLatitudeE6((int) (clientY2Latitude(server2ClientY(i2)) * 1000000.0d));
        geoPoint.setLongitudeE6((int) (clientX2Longitude(server2ClientX) * 1000000.0d));
    }

    public static Point geoPointToServerPoint(GeoPoint geoPoint) {
        if (geoPoint != null) {
            return new Point(client2ServerX(longitude2ClientX(((double) geoPoint.getLongitudeE6()) / 1000000.0d)), client2ServerY(latitude2ClientY(((double) geoPoint.getLatitudeE6()) / 1000000.0d)));
        }
        throw new IllegalArgumentException("point is null");
    }

    public static Point latlngToServerPoint(LatLng latLng) {
        if (latLng != null) {
            return new Point(client2ServerX(longitude2ClientX(latLng.longitude)), client2ServerY(latitude2ClientY(latLng.latitude)));
        }
        throw new IllegalArgumentException("point is null");
    }

    public static double getDistanceForCircleRadius(LatLng latLng, LatLng latLng2) {
        DoublePoint DDMapPointForCoordinate = DDMapPointForCoordinate(latLng);
        DoublePoint DDMapPointForCoordinate2 = DDMapPointForCoordinate(latLng2);
        return Math.sqrt(Math.pow(DDMapPointForCoordinate.f24753x - DDMapPointForCoordinate2.f24753x, 2.0d) + Math.pow(DDMapPointForCoordinate.f24754y - DDMapPointForCoordinate2.f24754y, 2.0d));
    }

    public static DoublePoint DDMapPointForCoordinate(LatLng latLng) {
        DoublePoint doublePoint = new DoublePoint();
        doublePoint.f24753x = ((latLng.longitude + 180.0d) / 360.0d) * 2.68435456E8d;
        doublePoint.f24754y = ((180.0d - (Math.log(Math.tan((latLng.latitude + 90.0d) * 0.008726646259971648d)) / 0.017453292519943295d)) / 360.0d) * 2.68435456E8d;
        return doublePoint;
    }

    public static LatLng DDCoordinateForMapPoint(DoublePoint doublePoint) {
        return new LatLng((Math.atan(Math.exp((180.0d - ((doublePoint.f24754y * 360.0d) / 2.68435456E8d)) * 0.017453292519943295d)) / 0.008726646259971648d) - 90.0d, ((doublePoint.f24753x * 360.0d) / 2.68435456E8d) - 180.0d);
    }

    public static float getDirection(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0f;
        }
        float[] fArr = new float[10];
        distanceBetween(latLng.latitude, latLng.longitude, latLng2.latitude, latLng2.longitude, fArr);
        return fArr[1];
    }
}
