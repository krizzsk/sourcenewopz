package com.didi.map.google.util;

import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.SecRouteInfo;
import com.didi.map.sdk.proto.driver_gl.TrafficItem;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class DUtils {
    public static int getColorWithAlpha(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
    }

    public static int crColorBlend(float f, int i, int i2) {
        float f2 = 1.0f - f;
        return Color.rgb((int) ((((float) Color.red(i2)) * f2) + (((float) Color.red(i)) * f)), (int) ((((float) Color.green(i2)) * f2) + (((float) Color.green(i)) * f)), (int) ((f2 * ((float) Color.blue(i2))) + (f * ((float) Color.blue(i)))));
    }

    public static DoublePoint getLocation(Context context) {
        try {
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(context);
            if (lastKnownLocation != null) {
                return new DoublePoint.Builder().dlat(Double.valueOf(lastKnownLocation.getLatitude())).dlng(Double.valueOf(lastKnownLocation.getLongitude())).lat(Float.valueOf((float) lastKnownLocation.getLatitude())).lng(Float.valueOf((float) lastKnownLocation.getLongitude())).accuracy(Double.valueOf((double) lastKnownLocation.getAccuracy())).gpsTimestamp(Long.valueOf(lastKnownLocation.getTime())).build();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkSecRouteInfoValid(SecRouteInfo secRouteInfo) {
        if (secRouteInfo == null || secRouteInfo.point == null || !LatLngUtils.locateCorrect(secRouteInfo.point.lat.doubleValue(), secRouteInfo.point.lng.doubleValue()) || secRouteInfo.route == null || secRouteInfo.route.routeId == null || secRouteInfo.route.routePoints == null || secRouteInfo.route.routePoints.base == null || secRouteInfo.route.routePoints.dlats == null || secRouteInfo.route.routePoints.dlngs == null) {
            return false;
        }
        return true;
    }

    public static boolean isSameTraffics(List<TrafficItem> list, List<TrafficItem> list2) {
        if (CollectionUtil.isEmpty((Collection<?>) list) && CollectionUtil.isEmpty((Collection<?>) list2)) {
            return true;
        }
        if (!CollectionUtil.isEmpty((Collection<?>) list) && !CollectionUtil.isEmpty((Collection<?>) list2) && list.size() == list2.size()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TrafficItem trafficItem = list.get(i);
                TrafficItem trafficItem2 = list2.get(i);
                if (Objects.equals(trafficItem.startIndex, trafficItem2.startIndex) && Objects.equals(trafficItem.endIndex, trafficItem2.endIndex)) {
                    return true;
                }
            }
        }
        return false;
    }
}
