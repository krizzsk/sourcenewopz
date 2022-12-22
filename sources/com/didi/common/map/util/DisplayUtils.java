package com.didi.common.map.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class DisplayUtils {
    public static float getDensity(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static float getFontDensity(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().scaledDensity;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager(context).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static WindowManager getWindowManager(Context context) {
        if (context == null) {
            return null;
        }
        return (WindowManager) context.getSystemService("window");
    }

    public static int dp2px(Context context, float f) {
        return context == null ? (int) f : (int) ((getDensity(context) * f) + 0.5f);
    }

    public static int px2dp(Context context, float f) {
        return context == null ? (int) f : (int) ((f / getDensity(context)) + 0.5f);
    }

    public static int sp2px(Context context, float f) {
        return context == null ? (int) f : (int) ((getFontDensity(context) * f) + 0.5f);
    }

    public static int px2sp(Context context, float f) {
        return context == null ? (int) f : (int) ((f / getFontDensity(context)) + 0.5f);
    }

    public static int getWindowWidth(Context context) {
        if (context == null) {
            return 0;
        }
        return getDisplayMetrics(context).widthPixels;
    }

    public static int getWindowHeight(Context context) {
        if (context == null) {
            return 0;
        }
        return getDisplayMetrics(context).heightPixels;
    }

    public static int[] getViewSize(View view) {
        if (view == null) {
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }
}
