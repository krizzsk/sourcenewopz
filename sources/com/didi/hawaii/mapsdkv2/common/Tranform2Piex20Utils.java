package com.didi.hawaii.mapsdkv2.common;

import com.didi.map.core.point.DoublePoint;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.model.LatLng;

public class Tranform2Piex20Utils {

    /* renamed from: a */
    private static final double f23789a = 0.017453292519943295d;

    /* renamed from: b */
    private static final double f23790b = 0.008726646259971648d;

    /* renamed from: c */
    private static final double f23791c = 2.68435456E8d;

    /* renamed from: d */
    private static double f23792d = 1.0d;

    public static void init(double d) {
        f23792d = d;
    }

    public static DoublePoint geo2PixelStandardScaleLevel(GeoPoint geoPoint, DoublePoint doublePoint) {
        double d = f23792d * f23791c;
        double d2 = d / 2.0d;
        double d3 = d / 360.0d;
        double longitudeE6 = ((((double) geoPoint.getLongitudeE6()) / 1000000.0d) * d3) + d2;
        double log = d2 + ((Math.log(Math.tan(((((double) geoPoint.getLatitudeE6()) / 1000000.0d) + 90.0d) * 0.008726646259971648d)) / 0.017453292519943295d) * d3);
        if (doublePoint == null) {
            doublePoint = new DoublePoint();
        }
        doublePoint.set(longitudeE6, log);
        return doublePoint;
    }

    public static DoublePoint latlng2PixelStandardScaleLevel(LatLng latLng, DoublePoint doublePoint) {
        if (latLng == null) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
        double d = f23792d * f23791c;
        double d2 = d / 2.0d;
        double d3 = d / 360.0d;
        double longitudeE6 = ((((double) geoPoint.getLongitudeE6()) / 1000000.0d) * d3) + d2;
        double log = d2 + ((Math.log(Math.tan(((((double) geoPoint.getLatitudeE6()) / 1000000.0d) + 90.0d) * 0.008726646259971648d)) / 0.017453292519943295d) * d3);
        if (doublePoint == null) {
            doublePoint = new DoublePoint();
        }
        doublePoint.set(longitudeE6, log);
        return doublePoint;
    }

    public static LatLng pixel20ToLatlng(DoublePoint doublePoint, LatLng latLng) {
        double d = f23792d * f23791c;
        double d2 = d / 2.0d;
        double d3 = d / 360.0d;
        double d4 = (doublePoint.f24753x - d2) / d3;
        double atan = (Math.atan(Math.pow(2.718281828459045d, ((doublePoint.f24754y - d2) / d3) * 0.017453292519943295d)) / 0.008726646259971648d) - 90.0d;
        if (latLng == null) {
            latLng = new LatLng(0.0d, 0.0d);
        }
        latLng.latitude = atan;
        latLng.longitude = d4;
        return latLng;
    }
}
