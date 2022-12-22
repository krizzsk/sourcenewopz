package com.didi.common.map.adapter.googlemapadapter.util;

import android.content.Context;
import android.os.Build;
import android.util.TypedValue;

public class SystemUtil {
    public static int getScreenWidth(Context context) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static boolean hasFroyo() {
        return Build.VERSION.SDK_INT >= 8;
    }

    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static boolean hasHoneycomb() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static boolean hasHoneycombMR1() {
        return Build.VERSION.SDK_INT >= 12;
    }

    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static float lng2Pixel(Context context, double d, float f) {
        return (float) (((d + 180.0d) * (((double) TypedValue.applyDimension(1, 256.0f, context.getResources().getDisplayMetrics())) * Math.pow(2.0d, (double) f))) / 360.0d);
    }

    public static float pixel2Lng(Context context, double d, float f) {
        return (float) (((d * 360.0d) / (((double) TypedValue.applyDimension(1, 256.0f, context.getResources().getDisplayMetrics())) * Math.pow(2.0d, (double) f))) - 180.0d);
    }

    public static float lat2Pixel(Context context, double d, float f) {
        double sin = Math.sin((d * 3.141592653589793d) / 180.0d);
        return (float) (((double) TypedValue.applyDimension(1, 128.0f, context.getResources().getDisplayMetrics())) * Math.pow(2.0d, (double) f) * (1.0d - (Math.log((sin + 1.0d) / (1.0d - sin)) / 6.283185307179586d)));
    }

    public static float pixel2Lat(Context context, double d, float f) {
        double pow = Math.pow(2.718281828459045d, (1.0d - (d / (((double) TypedValue.applyDimension(1, 128.0f, context.getResources().getDisplayMetrics())) * Math.pow(2.0d, (double) f)))) * 6.283185307179586d);
        return (float) ((Math.asin((pow - 1.0d) / (pow + 1.0d)) * 180.0d) / 3.141592653589793d);
    }
}
