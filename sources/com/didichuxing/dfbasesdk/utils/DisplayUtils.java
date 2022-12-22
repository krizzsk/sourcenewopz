package com.didichuxing.dfbasesdk.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import com.didichuxing.security.safecollector.WsgSecInfo;

public class DisplayUtils {
    public static DisplayMetrics getDisplayMetrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static float getDensity(Context context) {
        return getDisplayMetrics(context).density;
    }

    public static int getScreenWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    public static int getScreenOrientation(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * getDisplayMetrics(context).density) + 0.5f);
    }

    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / getDisplayMetrics(context).density) + 0.5f);
    }

    public static int px2sp(Context context, float f) {
        return (int) ((f / getDisplayMetrics(context).scaledDensity) + 0.5f);
    }

    public static int getWindowRotation(Window window) {
        return window.getWindowManager().getDefaultDisplay().getRotation();
    }

    public static int getStatusBar(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        return isFlymeOs4x() ? dimensionPixelSize * 2 : dimensionPixelSize;
    }

    public static boolean isFlymeOs4x() {
        if (!"4.4.4".equals(WsgSecInfo.osVersion())) {
            return false;
        }
        String str = Build.VERSION.INCREMENTAL;
        String str2 = Build.DISPLAY;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("Flyme_OS_4");
        }
        return str2.contains("Flyme OS 4");
    }

    public static boolean isPortrait(Context context) {
        return getScreenOrientation(context) == 1;
    }
}
