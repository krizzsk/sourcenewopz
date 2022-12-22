package com.didi.util;

import com.didi.map.common.utils.TransformUtil;
import com.didi.map.outer.model.LatLng;

public class HawaiiMapUtil {
    public static double getDistance(LatLng latLng, LatLng latLng2) {
        return TransformUtil.getDistanceForCircleRadius(latLng, latLng2);
    }
}
