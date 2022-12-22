package com.didi.map.google.util;

import com.didi.common.map.model.LatLng;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.map.sdk.nav.libc.common.GeoPoint;
import com.map.sdk.nav.libc.common.RouteGuidanceGPSPoint;
import java.util.List;
import java.util.Locale;

public class GoogleSyncTripLogUtil {
    public static String getLogDivider() {
        return "---------------";
    }

    public static String getOrderStageLogInfo(int i, boolean z) {
        return i == 3 ? z ? "等驾段" : "接驾段" : "送驾段";
    }

    public static String getLatLngLogInfo(LatLng latLng) {
        if (latLng == null) {
            return "";
        }
        return getFormatLog("%f,%f;", Double.valueOf(latLng.longitude), Double.valueOf(latLng.latitude));
    }

    public static String getLatLngsLogInfo(List<LatLng> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append(getFormatLog("%f,%f;", Double.valueOf(list.get(i).longitude), Double.valueOf(list.get(i).latitude)));
            if (i < list.size() - 1) {
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    public static String getGeoPointLogInfo(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return "";
        }
        return getFormatLog("[%d,%d]", Integer.valueOf(geoPoint.getLongitudeE6()), Integer.valueOf(geoPoint.getLatitudeE6()));
    }

    public static String getGeoPointsLogInfo(List<GeoPoint> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.append(getFormatLog("%f,%f;", Integer.valueOf(list.get(i).getLongitudeE6()), Integer.valueOf(list.get(i).getLatitudeE6())));
        }
        return stringBuffer.toString();
    }

    public static String getMatchResultLogInfo(RouteGuidanceGPSPoint routeGuidanceGPSPoint) {
        if (routeGuidanceGPSPoint == null) {
            return "绑路失败，RouteGuidanceGPSPoint为空";
        }
        if (routeGuidanceGPSPoint.point == null) {
            return "绑路失败，RouteGuidanceGPSPoint.point为空";
        }
        if (routeGuidanceGPSPoint.segmentIndex == -1) {
            return getFormatLog("绑路失败，segmentIndex == -1，point:(%d,%d)", Integer.valueOf(routeGuidanceGPSPoint.point.getLongitudeE6()), Integer.valueOf(routeGuidanceGPSPoint.point.getLatitudeE6()));
        }
        return getFormatLog("绑路成功:[segmentIndex:%d, point:(%d,%d), heading:%f]", Integer.valueOf(routeGuidanceGPSPoint.segmentIndex), Integer.valueOf(routeGuidanceGPSPoint.point.getLongitudeE6()), Integer.valueOf(routeGuidanceGPSPoint.point.getLatitudeE6()), Float.valueOf(routeGuidanceGPSPoint.heading));
    }

    public static String getOdPointsLogInfo(List<OdPoint> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).point != null) {
                stringBuffer.append(getFormatLog("%f,%f;", list.get(i).point.lng, list.get(i).point.lat));
            }
        }
        return stringBuffer.toString();
    }

    public static String getFormatLog(String str, Object... objArr) {
        return String.format(Locale.CHINA, str, objArr);
    }
}
