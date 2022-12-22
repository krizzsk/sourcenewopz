package com.didi.map.google.util;

import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.nav.car.AnimateNode;
import com.didi.map.sdk.nav.car.AnimationPartInterface;
import com.didi.map.sdk.nav.car.IMyLocationDelegate;
import com.didi.map.sdk.nav.inertia.IInertiaDelegate;
import com.didi.map.sdk.proto.driver_gl.DiffGeoPoints;
import com.didi.map.utils.MatchPointDisHandler;
import com.map.sdk.nav.libc.common.GeoPoint;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.ArrayList;
import java.util.List;

public class BizUtil {
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

    public static int animDistanceLeftCustomed(IMyLocationDelegate iMyLocationDelegate, MatchPointDisHandler matchPointDisHandler) {
        AnimateNode currentAnimNode;
        if (!(iMyLocationDelegate == null || iMyLocationDelegate.getCarMarker() == null || iMyLocationDelegate.getCarMarker().getPosition() == null || matchPointDisHandler == null || (currentAnimNode = iMyLocationDelegate.getCurrentAnimNode()) == null || currentAnimNode.index <= -1 || currentAnimNode.latLng == null)) {
            int computeDistanceBetween = (int) DDSphericalUtil.computeDistanceBetween(iMyLocationDelegate.getCarMarker().getPosition(), currentAnimNode.latLng);
            RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
            routeGuidanceGPSPoint.segmentIndex = currentAnimNode.index;
            routeGuidanceGPSPoint.shapeOffSet = currentAnimNode.offSet;
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLatitudeE6((int) (currentAnimNode.latLng.latitude * 1000000.0d));
            geoPoint.setLongitudeE6((int) (currentAnimNode.latLng.longitude * 1000000.0d));
            routeGuidanceGPSPoint.point = geoPoint;
            int distanceToTail = matchPointDisHandler.distanceToTail(routeGuidanceGPSPoint);
            AnimationPartInterface carAnimator = iMyLocationDelegate.getCarAnimator();
            String simpleName = carAnimator != null ? carAnimator.getClass().getSimpleName() : "unknown";
            DLog.m7384d("ccc", "|" + simpleName + "|carLng=" + iMyLocationDelegate.getCarMarker().getPosition().toString() + "|AnimateNodeLng=" + currentAnimNode.latLng.toString() + "|distance=" + computeDistanceBetween + "|distanceleft=" + distanceToTail, new Object[0]);
            if (distanceToTail >= 0 && computeDistanceBetween >= 0) {
                return computeDistanceBetween + distanceToTail;
            }
            DLog.m7384d("BizUtil", "nextSegmentDistanceLeft = %d , dx = %d", Integer.valueOf(distanceToTail), Integer.valueOf(computeDistanceBetween));
        }
        return -1;
    }

    public static int animDistanceLeft(IMyLocationDelegate iMyLocationDelegate, IInertiaDelegate iInertiaDelegate) {
        AnimateNode currentAnimNode;
        if (!(iMyLocationDelegate == null || iMyLocationDelegate.getCarMarker() == null || iMyLocationDelegate.getCarMarker().getPosition() == null || iInertiaDelegate == null || (currentAnimNode = iMyLocationDelegate.getCurrentAnimNode()) == null || currentAnimNode.index <= -1 || currentAnimNode.latLng == null)) {
            int computeDistanceBetween = (int) DDSphericalUtil.computeDistanceBetween(iMyLocationDelegate.getCarMarker().getPosition(), currentAnimNode.latLng);
            RouteGuidanceGPSPoint routeGuidanceGPSPoint = new RouteGuidanceGPSPoint();
            routeGuidanceGPSPoint.segmentIndex = currentAnimNode.index;
            routeGuidanceGPSPoint.shapeOffSet = currentAnimNode.offSet;
            GeoPoint geoPoint = new GeoPoint();
            geoPoint.setLatitudeE6((int) (currentAnimNode.latLng.latitude * 1000000.0d));
            geoPoint.setLongitudeE6((int) (currentAnimNode.latLng.longitude * 1000000.0d));
            routeGuidanceGPSPoint.point = geoPoint;
            int distanceLeft = iInertiaDelegate.distanceLeft(routeGuidanceGPSPoint);
            AnimationPartInterface carAnimator = iMyLocationDelegate.getCarAnimator();
            String simpleName = carAnimator != null ? carAnimator.getClass().getSimpleName() : "unknown";
            DLog.m7384d("ccc", "|" + simpleName + "|carLng=" + iMyLocationDelegate.getCarMarker().getPosition().toString() + "|AnimateNodeLng=" + currentAnimNode.latLng.toString() + "|distance=" + computeDistanceBetween + "|distanceleft=" + distanceLeft, new Object[0]);
            if (distanceLeft >= 0 && computeDistanceBetween >= 0) {
                return computeDistanceBetween + distanceLeft;
            }
            DLog.m7384d("BizUtil", "nextSegmentDistanceLeft = %d , dx = %d", Integer.valueOf(distanceLeft), Integer.valueOf(computeDistanceBetween));
        }
        return -1;
    }
}
