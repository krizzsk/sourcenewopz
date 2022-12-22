package com.didi.common.map.util;

import com.didi.common.map.model.LatLng;
import java.text.DecimalFormat;

public class LatLngUtils {

    /* renamed from: a */
    private static double f10947a = 0.01745329252d;

    /* renamed from: b */
    private static double f10948b = 6370693.5d;

    public static boolean isSameLatLng(LatLng latLng, LatLng latLng2) {
        return latLng != null && latLng2 != null && m7387a(latLng.latitude, latLng2.latitude) && m7387a(latLng.longitude, latLng2.longitude);
    }

    public static boolean isCompletedSameLatLng(LatLng latLng, LatLng latLng2) {
        return latLng != null && latLng2 != null && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude;
    }

    /* renamed from: a */
    private static boolean m7387a(double d, double d2) {
        return Math.abs(d - d2) <= 9.999999747378752E-6d;
    }

    public static double m2L(double d, double d2) {
        double cos = d / ((Math.cos((d2 * 3.141592653589793d) / 180.0d) * 2.003750834E7d) / 180.0d);
        try {
            return Double.valueOf(new DecimalFormat("#.0000").format(cos)).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return cos;
        }
    }

    public static boolean locateCorrect(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        return locateCorrect(latLng.latitude, latLng.longitude);
    }

    public static boolean locateCorrect(double d, double d2) {
        if ((!DDMathUtil.equal(d, 0.0d) || !DDMathUtil.equal(d2, 0.0d)) && d2 <= 180.0d && d <= 90.0d && d2 >= -180.0d && d >= -90.0d && !Double.isNaN(d) && !Double.isNaN(d2)) {
            return true;
        }
        return false;
    }
}
