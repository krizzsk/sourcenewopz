package com.didi.map.common.utils;

import android.graphics.Color;
import com.didi.map.core.base.impl.MapBoundaryFactory;
import com.didi.map.core.point.DoublePoint;
import com.didi.map.core.point.GeoPoint;
import com.didi.map.outer.model.LatLng;

public class MathBaseUtil {
    private static final float KSB_ALPHA_PIVOT_X = 0.3f;
    private static final float KSB_ALPHA_PIVOT_Y = 0.5f;
    private static final float KSB_MAX_ALPHA = 0.85f;
    private static final double PIXELS_PERLNG_DEGREE20 = 745654.0444444445d;
    private static final double PIXELS_PERLNG_RADIAN20 = 4.272282972352698E7d;
    private static final float VALUE = 0.5f;
    private static final int VALUE_1 = 1;
    private static final float VALUE_100 = 100.0f;
    private static final int VALUE_127 = 127;
    private static final int VALUE_197 = 197;
    private static final int VALUE_242 = 242;
    private static final float VALUE_25 = 25.0f;
    private static final int VALUE_253 = 253;
    private static final int VALUE_255 = 255;
    private static final int VALUE_38 = 38;
    private static final int VALUE_5 = 5;
    private static final int VALUE_63 = 63;
    private static final double WORLD_HALF_PIXELS20 = 1.34217728E8d;
    private static final double WORLD_PIXELS20 = 2.68435456E8d;

    public static double getScaleFrom20(int i) {
        return ((double) (1 << i)) / 1048576.0d;
    }

    public static boolean isValidPosition(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        return MapBoundaryFactory.getBoundary(2).contains((int) (latLng.longitude * 1000000.0d), (int) (latLng.latitude * 1000000.0d));
    }

    public static DoublePoint pixelToPixel20(DoublePoint doublePoint, double d) {
        DoublePoint doublePoint2 = new DoublePoint();
        doublePoint2.f24753x = doublePoint.f24753x / d;
        doublePoint2.f24754y = doublePoint.f24754y / d;
        return doublePoint2;
    }

    public static DoublePoint geoToPixel20(GeoPoint geoPoint) {
        double d;
        double d2 = 0.0d;
        if (geoPoint != null) {
            double min = Math.min(Math.max(Math.sin((((double) geoPoint.getLatitudeE6()) / 1000000.0d) * 0.017453292519943295d), -0.9999d), 0.9999d);
            double longitudeE6 = ((((double) geoPoint.getLongitudeE6()) / 1000000.0d) * PIXELS_PERLNG_DEGREE20) + WORLD_HALF_PIXELS20;
            d = (Math.log((min + 1.0d) / (1.0d - min)) * PIXELS_PERLNG_RADIAN20 * 0.5d) + WORLD_HALF_PIXELS20;
            d2 = longitudeE6;
        } else {
            d = 0.0d;
        }
        return new DoublePoint(d2, d);
    }

    public static int colorForValue(double d) {
        int argb = Color.argb(127, 253, 197, 63);
        int argb2 = Color.argb(255, 242, 38, 5);
        double sqrt = Math.sqrt(d > 1.0d ? 1.0d : d);
        if (sqrt >= 0.5d) {
            sqrt = ((sqrt - 0.30000001192092896d) * 0.5000000596046448d) + 0.5d;
        }
        int i = (int) (sqrt * 255.0d);
        Color.argb(i, 0, 0, 255);
        if (d <= 1.0d) {
            return Color.argb(i, Color.red(argb), Color.green(argb), Color.blue(argb));
        }
        if (d >= 5.0d) {
            return Color.argb(i, Color.red(argb2), Color.green(argb2), Color.blue(argb2));
        }
        float[] fArr = new float[3];
        float[] fArr2 = new float[3];
        Color.colorToHSV(argb, fArr);
        Color.colorToHSV(argb2, fArr2);
        return Color.HSVToColor(i, new float[]{(float) (((double) fArr[0]) + (((double) ((((float) ((int) ((((float) ((int) ((((d - 1.0d) * 1.0d) / 4.0d) * 100.0d))) / 25.0f) + 0.5f))) * 25.0f) / 100.0f)) * ((double) (fArr2[0] - fArr[0])))), (fArr[1] + fArr2[1]) * 0.5f, (fArr[2] + fArr2[2]) * 0.5f});
    }
}
