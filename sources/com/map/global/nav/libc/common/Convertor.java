package com.map.global.nav.libc.common;

import com.didi.common.map.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class Convertor {
    public static GeoPoint convertToGeoPoints(DMKMapPoint dMKMapPoint) {
        if (dMKMapPoint == null) {
            return null;
        }
        LatLng mercator2LatLng = MercatorUtil.mercator2LatLng(dMKMapPoint);
        GeoPoint geoPoint = new GeoPoint();
        geoPoint.setLatitudeE6((int) (mercator2LatLng.latitude * 1000000.0d));
        geoPoint.setLongitudeE6((int) (mercator2LatLng.longitude * 1000000.0d));
        return geoPoint;
    }

    public static DMKMapPoint convertFromGeoPoint(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        return MercatorUtil.latLng2Mercator(((double) geoPoint.getLongitudeE6()) / 1000000.0d, ((double) geoPoint.getLatitudeE6()) / 1000000.0d);
    }

    public static List<DMKMapPoint> convertFromGeoPoints(GeoPoint[] geoPointArr) {
        if (geoPointArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (GeoPoint convertFromGeoPoint : geoPointArr) {
            arrayList.add(convertFromGeoPoint(convertFromGeoPoint));
        }
        return arrayList;
    }

    public static RouteGuidanceGPSPoint convertFromDMKGPSPoint(DMKGPSPoint dMKGPSPoint) {
        if (dMKGPSPoint == null) {
            return null;
        }
        RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
        routeGuidanceGPSPoint.segmentIndex = dMKGPSPoint.segmentIndex;
        routeGuidanceGPSPoint.point = convertToGeoPoints(dMKGPSPoint.mapPoint);
        routeGuidanceGPSPoint.heading = dMKGPSPoint.heading;
        routeGuidanceGPSPoint.velocity = dMKGPSPoint.velocity;
        routeGuidanceGPSPoint.accuracy = dMKGPSPoint.locationAccuracy;
        routeGuidanceGPSPoint.timestamp = dMKGPSPoint.timestamp;
        routeGuidanceGPSPoint.source = dMKGPSPoint.source;
        routeGuidanceGPSPoint.shapeOffSet = dMKGPSPoint.segmentOffset;
        return routeGuidanceGPSPoint;
    }

    public static DMKGPSPoint convert2DMKGPSPoint(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        if (routeGuidanceGPSPoint == null) {
            return null;
        }
        DMKGPSPoint dMKGPSPoint = new DMKGPSPoint();
        dMKGPSPoint.segmentIndex = routeGuidanceGPSPoint.segmentIndex;
        dMKGPSPoint.mapPoint = convertFromGeoPoint(routeGuidanceGPSPoint.point);
        dMKGPSPoint.heading = routeGuidanceGPSPoint.heading;
        dMKGPSPoint.velocity = routeGuidanceGPSPoint.velocity;
        dMKGPSPoint.locationAccuracy = routeGuidanceGPSPoint.accuracy;
        dMKGPSPoint.timestamp = routeGuidanceGPSPoint.timestamp;
        dMKGPSPoint.source = routeGuidanceGPSPoint.source;
        dMKGPSPoint.segmentOffset = routeGuidanceGPSPoint.shapeOffSet;
        return dMKGPSPoint;
    }

    public static LatLng convert2LatLngFromGeoPoint(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        return new LatLng(((double) geoPoint.getLatitudeE6()) / 1000000.0d, ((double) geoPoint.getLongitudeE6()) / 1000000.0d);
    }
}
