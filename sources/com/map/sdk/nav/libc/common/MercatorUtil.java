package com.map.sdk.nav.libc.common;

import com.didi.common.map.model.LatLng;
import com.dmap.navigation.jni.swig.RGGeoPoint_t;

public class MercatorUtil {
    static double kRadianToDegreeFactor1 = 0.017453292519943295d;
    static double kRadianToDegreeFactor2 = 0.008726646259971648d;
    static double kWGSToMercatorFactor = 111319.49077777778d;

    public static LatLng mercator2LatLng(DMKMapPoint dMKMapPoint) {
        return new LatLng((Math.atan(Math.exp((dMKMapPoint.f55725y / 111319.49077777778d) * 0.017453292519943295d)) / 0.008726646259971648d) - 90.0d, dMKMapPoint.f55724x / 111319.49077777778d);
    }

    public static DMKMapPoint latLng2Mercator(double d, double d2) {
        DMKMapPoint dMKMapPoint = new DMKMapPoint();
        dMKMapPoint.f55724x = d * 111319.49077777778d;
        dMKMapPoint.f55725y = (Math.log(Math.tan((d2 + 90.0d) * 0.008726646259971648d)) / 0.017453292519943295d) * 111319.49077777778d;
        return dMKMapPoint;
    }

    public static RGGeoPoint_t latLng2MercatorHawaii(double d, double d2) {
        RGGeoPoint_t rGGeoPoint_t = new RGGeoPoint_t();
        rGGeoPoint_t.setLng(d * 111319.49077777778d);
        rGGeoPoint_t.setLat((Math.log(Math.tan((d2 + 90.0d) * 0.008726646259971648d)) / 0.017453292519943295d) * 111319.49077777778d);
        return rGGeoPoint_t;
    }

    public static GeoPoint mercator2GeoPoint(double d, double d2) {
        return new GeoPoint((int) (((Math.atan(Math.exp((d2 / 111319.49077777778d) * 0.017453292519943295d)) / 0.008726646259971648d) - 90.0d) * 1000000.0d), (int) ((d / 111319.49077777778d) * 1000000.0d));
    }
}
