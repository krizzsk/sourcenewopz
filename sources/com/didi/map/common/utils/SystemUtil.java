package com.didi.map.common.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Looper;
import android.util.DisplayMetrics;
import com.didi.map.alpha.adapt.MapUtil;

public class SystemUtil {
    public static final int SMALL_SCREEN_THRESHOLD = 400;

    /* renamed from: a */
    private static final int f24689a = 65537;

    /* renamed from: b */
    private static Context f24690b = null;

    /* renamed from: c */
    private static float f24691c = -1.0f;

    public static void setContext(Context context) {
        f24690b = context.getApplicationContext();
    }

    public static String obtainIMei() {
        return MapUtil.getIMei(f24690b);
    }

    public static float getDensity(Context context) {
        float f = f24691c;
        if (f > 0.0f) {
            return f;
        }
        if (f24690b == null) {
            f24690b = context.getApplicationContext();
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        f24691c = displayMetrics.density;
        return displayMetrics.density;
    }

    public static int getOpenglesVersion(Context context) {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null) {
            return deviceConfigurationInfo.reqGlEsVersion;
        }
        return 65537;
    }

    public static boolean isUIThread() {
        Thread thread = Looper.getMainLooper().getThread();
        if (thread == null) {
            Looper myLooper = Looper.myLooper();
            if (myLooper == null || myLooper != Looper.getMainLooper()) {
                return false;
            }
            return true;
        } else if (Thread.currentThread() == thread) {
            return true;
        } else {
            return false;
        }
    }

    public static float dip2px(Context context, float f) {
        if (context != null) {
            return (float) ((int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f));
        }
        return 0.0f;
    }
}
