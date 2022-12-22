package com.didi.map.google.util;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.proto.driver_gl.DiffGeoPoints;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.map.sdk.nav.libc.common.GeoPoint;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.ArrayList;
import java.util.List;

public class ConvertUtil {
    public static List<LatLng> getLatLngListFromDiffGeoPoints(DiffGeoPoints diffGeoPoints) {
        ArrayList arrayList = new ArrayList();
        if (!(diffGeoPoints == null || diffGeoPoints.base == null)) {
            double floatValue = (double) diffGeoPoints.base.lat.floatValue();
            double floatValue2 = (double) diffGeoPoints.base.lng.floatValue();
            arrayList.add(new LatLng(floatValue / 100000.0d, floatValue2 / 100000.0d));
            if (diffGeoPoints.dlats.size() == diffGeoPoints.dlngs.size()) {
                for (int i = 0; i < diffGeoPoints.dlats.size(); i++) {
                    floatValue += ((double) diffGeoPoints.dlats.get(i).intValue()) / 100.0d;
                    floatValue2 += ((double) diffGeoPoints.dlngs.get(i).intValue()) / 100.0d;
                    arrayList.add(new LatLng(floatValue / 100000.0d, floatValue2 / 100000.0d));
                }
            }
        }
        return arrayList;
    }

    public static RouteGuidanceGPSPoint tran2RouteGuidanceGPSPoint(LatLng latLng, int i) {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        routeGuidanceGPSPoint.point = wgs2Mercator(latLng.latitude, latLng.longitude);
        routeGuidanceGPSPoint.segmentIndex = -1;
        routeGuidanceGPSPoint.heading = (float) i;
        routeGuidanceGPSPoint.timestamp = System.currentTimeMillis();
        routeGuidanceGPSPoint.velocity = 3.0f;
        routeGuidanceGPSPoint.accuracy = 10;
        return routeGuidanceGPSPoint;
    }

    public static RouteGuidanceGPSPoint tran2RouteGuidanceGPSPoint(DoublePoint doublePoint, int i) {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        routeGuidanceGPSPoint.point = m19913a(new LatLng((double) doublePoint.lat.floatValue(), (double) doublePoint.lng.floatValue()));
        routeGuidanceGPSPoint.segmentIndex = -1;
        routeGuidanceGPSPoint.heading = (float) i;
        routeGuidanceGPSPoint.timestamp = doublePoint.gpsTimestamp.longValue();
        routeGuidanceGPSPoint.velocity = doublePoint.speed == null ? 0.0f : (float) doublePoint.speed.intValue();
        int i2 = 0;
        routeGuidanceGPSPoint.accuracy = doublePoint.accuracy == null ? 0 : doublePoint.accuracy.intValue();
        if (doublePoint.gpsSource != null) {
            i2 = doublePoint.gpsSource.getValue();
        }
        routeGuidanceGPSPoint.source = i2;
        return routeGuidanceGPSPoint;
    }

    public static RouteGuidanceGPSPoint tran2RouteGuidanceGPSPointWithLatLng(LatLng latLng, int i) {
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        routeGuidanceGPSPoint.point = m19913a(new LatLng(latLng.latitude, latLng.longitude));
        routeGuidanceGPSPoint.segmentIndex = -1;
        routeGuidanceGPSPoint.heading = (float) i;
        return routeGuidanceGPSPoint;
    }

    /* renamed from: a */
    private static GeoPoint m19913a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLatitudeE6((int) (latLng.latitude * 1000000.0d));
        geoPoint.setLongitudeE6((int) (latLng.longitude * 1000000.0d));
        return geoPoint;
    }

    public static GeoPoint wgs2Mercator(double d, double d2) {
        return new GeoPoint((int) (((Math.log(Math.tan(((d + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d), (int) ((d2 * 2.003750834E7d) / 180.0d));
    }

    public static LatLng mercator2wgs(int i, int i2) {
        return new LatLng(((Math.atan(Math.exp((((((double) i) / 2.003750834E7d) * 180.0d) * 3.141592653589793d) / 180.0d)) * 2.0d) - 1.5707963267948966d) * 57.29577951308232d, (((double) i2) / 2.003750834E7d) * 180.0d);
    }

    public static GeoPoint gcj2Mercator(double d, double d2) {
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLatitudeE6((int) ((Math.log(Math.tan((d + 90.0d) * 0.008726646259971648d)) / 0.017453292519943295d) * 111319.49077777778d));
        geoPoint.setLongitudeE6((int) (d2 * 111319.49077777778d));
        return geoPoint;
    }

    public static LatLng mercator2gcj(int i, int i2) {
        return new LatLng((Math.atan(Math.exp((((double) i) / 111319.49077777778d) * 0.017453292519943295d)) / 0.008726646259971648d) - 90.0d, ((double) i2) / 111319.49077777778d);
    }

    public static LatLng convertFromGeoPoint(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        return new LatLng(((double) geoPoint.getLatitudeE6()) / 1000000.0d, ((double) geoPoint.getLongitudeE6()) / 1000000.0d);
    }
}
