package com.map.global.nav.libc.common;

import com.didi.common.map.model.LatLng;

public class MercatorUtil {

    /* renamed from: a */
    static double f55711a = 111319.49077777778d;

    /* renamed from: b */
    static double f55712b = 0.017453292519943295d;

    /* renamed from: c */
    static double f55713c = 0.008726646259971648d;

    public static LatLng mercator2LatLng(DMKMapPoint dMKMapPoint) {
        return new LatLng((Math.atan(Math.exp((dMKMapPoint.f55703y / 111319.49077777778d) * 0.017453292519943295d)) / 0.008726646259971648d) - 90.0d, dMKMapPoint.f55702x / 111319.49077777778d);
    }

    public static DMKMapPoint latLng2Mercator(double d, double d2) {
        DMKMapPoint dMKMapPoint = new DMKMapPoint();
        dMKMapPoint.f55702x = d * 111319.49077777778d;
        dMKMapPoint.f55703y = (Math.log(Math.tan((d2 + 90.0d) * 0.008726646259971648d)) / 0.017453292519943295d) * 111319.49077777778d;
        return dMKMapPoint;
    }

    public static GeoPoint mercator2GeoPoint(double d, double d2) {
        return new GeoPoint((int) (((Math.atan(Math.exp((d2 / 111319.49077777778d) * 0.017453292519943295d)) / 0.008726646259971648d) - 90.0d) * 1000000.0d), (int) ((d / 111319.49077777778d) * 1000000.0d));
    }
}
