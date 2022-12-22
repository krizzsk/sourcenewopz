package com.didi.app.nova.support.util;

import android.content.Context;
import android.util.TypedValue;
import android.view.WindowManager;

public class DisplayUtils {

    /* renamed from: a */
    private static Integer f8544a;

    /* renamed from: b */
    private static Integer f8545b;

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float dip2pxInFloat(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float px2dipInFloat(Context context, float f) {
        return (f / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int px2sp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static float sp2px(Context context, float f) {
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static int getScreenWidth(Context context) {
        Integer num = f8544a;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        f8544a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        f8545b = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        return f8544a.intValue();
    }

    public static int getScreenHeight(Context context) {
        Integer num = f8545b;
        if (num != null) {
            return num.intValue();
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        f8544a = Integer.valueOf(windowManager.getDefaultDisplay().getWidth());
        Integer valueOf = Integer.valueOf(windowManager.getDefaultDisplay().getHeight());
        f8545b = valueOf;
        return valueOf.intValue();
    }
}
