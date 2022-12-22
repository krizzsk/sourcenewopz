package com.didichuxing.carsliding.anim;

import com.didi.common.map.model.LatLng;

public class RenderAnimUtils {
    public static float getReviseRotate(float f, float f2) {
        return ((double) (f - f2)) > 180.0d ? f2 + 360.0f : f2;
    }

    public static float getRotate(float f, float f2) {
        float f3 = f - f2;
        if (((double) f3) < -180.0d) {
            f3 += 360.0f;
        }
        return ((double) f3) > 180.0d ? f3 - 360.0f : f3;
    }

    public static float getAngel(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            return 0.0f;
        }
        return (float) (90.0d - ((Math.atan2(latLng2.latitude - latLng.latitude, latLng2.longitude - latLng.longitude) / 3.141592653589793d) * 180.0d));
    }
}
