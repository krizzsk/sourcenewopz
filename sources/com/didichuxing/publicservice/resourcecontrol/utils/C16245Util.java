package com.didichuxing.publicservice.resourcecontrol.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: com.didichuxing.publicservice.resourcecontrol.utils.Util */
public class C16245Util {
    public static boolean hasNavigationBar(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return false;
        }
        try {
            Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"qemu.hw.mainkeys"});
            if ("1".equals(str)) {
                return false;
            }
            if ("0".equals(str)) {
                return true;
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean checkDeviceShowNavigationBar(WindowManager windowManager, Activity activity) {
        int realHeight = getRealHeight(activity);
        if (realHeight == -1) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        if (realHeight - displayMetrics.heightPixels > 0) {
            return true;
        }
        return false;
    }

    public static int getRealHeight(Activity activity) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            defaultDisplay.getMetrics(displayMetrics);
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics2);
            } else {
                Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(defaultDisplay, new Object[]{displayMetrics2});
            }
            return displayMetrics2.heightPixels;
        } catch (Exception unused) {
            return -1;
        }
    }
}
