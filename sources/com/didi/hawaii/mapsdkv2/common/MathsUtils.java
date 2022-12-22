package com.didi.hawaii.mapsdkv2.common;

import android.graphics.Color;
import android.graphics.Rect;
import com.didi.map.outer.model.LatLng;

public final class MathsUtils {

    /* renamed from: a */
    private static final double f23784a = 6370856.0d;

    /* renamed from: b */
    private static final int f23785b = 256;

    /* renamed from: c */
    private static final int f23786c = 40076000;

    /* renamed from: d */
    private static final double f23787d = Math.log(2.0d);

    /* renamed from: e */
    private static final double f23788e = (22.0d - (Math.log(4.0d) / f23787d));

    private MathsUtils() {
    }

    public static Rect boundingBoxE6(LatLng[] latLngArr, int i, int i2) {
        if (latLngArr == null || latLngArr.length == 0) {
            return new Rect(0, 0, 0, 0);
        }
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MIN_VALUE;
        while (i < i2) {
            double d = latLngArr[i].longitude;
            int i7 = (int) (latLngArr[i].latitude * 1000000.0d);
            int i8 = (int) (d * 1000000.0d);
            if (i7 > i5) {
                i5 = i7;
            }
            if (i7 < i4) {
                i4 = i7;
            }
            if (i8 > i6) {
                i6 = i8;
            }
            if (i8 < i3) {
                i3 = i8;
            }
            i++;
        }
        return new Rect(i3, i5, i6, i4);
    }

    public static double[] calculateEqualLatitudePoint(double d, double d2, double d3) {
        double[] dArr = new double[2];
        dArr[1] = d2;
        dArr[0] = d + Math.toDegrees(d3 / (Math.cos(Math.toRadians(d2)) * f23784a));
        return dArr;
    }

    public static int mixedColorWithAlpha(float f, int i) {
        return Color.argb((int) (((f * ((float) Color.alpha(i))) / 255.0f) * 255.0f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public static double metersPerPixel(double d, double d2) {
        return (4.0076E7d / (Math.pow(2.0d, d) * 256.0d)) * Math.cos((d2 * 3.141592653589793d) / 180.0d);
    }

    public static double getScaleLevel(double d) {
        return f23788e + (Math.log(d) / f23787d);
    }

    public static double getScale(double d) {
        return 4.0d / Math.pow(2.0d, 22.0d - d);
    }
}
