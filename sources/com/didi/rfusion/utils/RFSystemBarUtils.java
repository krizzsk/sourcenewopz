package com.didi.rfusion.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;

public class RFSystemBarUtils {

    /* renamed from: a */
    private static final int f33305a = 25;

    /* renamed from: b */
    private static int f33306b = -1;

    /* renamed from: c */
    private static final int f33307c = 1280;

    /* renamed from: d */
    private static final int f33308d = 5380;

    public static int getStatusBarHeight(Context context) {
        if (f33306b == -1) {
            m23427a(context);
        }
        return f33306b;
    }

    public static void translucentStatusBar(Activity activity) {
        translucentStatusBar(activity.getWindow());
    }

    public static void translucentStatusBar(Window window) {
        translucentStatusBar(window, 1073741824);
    }

    public static void translucentStatusBar(Activity activity, int i) {
        translucentStatusBar(activity.getWindow(), i);
    }

    public static void translucentStatusBar(Window window, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            window.getDecorView().setSystemUiVisibility(1280);
            window.clearFlags(View.STATUS_BAR_TRANSIENT);
            window.addFlags(Integer.MIN_VALUE);
            if (Build.VERSION.SDK_INT >= 23) {
                window.setStatusBarColor(0);
            } else {
                window.setStatusBarColor(i);
            }
        }
    }

    public static void immersiveStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().getDecorView().setSystemUiVisibility(5380);
        }
    }

    public static boolean setStatusBarLightMode(Activity activity) {
        if (activity != null && Build.VERSION.SDK_INT >= 23) {
            return m23428a(activity.getWindow(), true);
        }
        return false;
    }

    public static void setStatusBarColor(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().setStatusBarColor(activity.getResources().getColor(i));
        }
    }

    /* renamed from: a */
    private static boolean m23428a(Window window, boolean z) {
        window.getDecorView().setSystemUiVisibility(m23425a(window, z ? 8192 : 256));
        return true;
    }

    /* renamed from: a */
    private static int m23425a(Window window, int i) {
        return m23426a(window, m23426a(window, m23426a(window, m23426a(window, m23426a(window, m23426a(window, i, 1024), 4), 2), 4096), 1024), 512);
    }

    /* renamed from: a */
    private static int m23426a(Window window, int i, int i2) {
        return (window.getDecorView().getSystemUiVisibility() & i2) == i2 ? i | i2 : i;
    }

    public static boolean isTranslucentStatusBar(Activity activity) {
        if (isWindowTranslucent(activity)) {
            return true;
        }
        return isFlagUsed(activity, 1024);
    }

    public static boolean isWindowTranslucent(Activity activity) {
        if (Build.VERSION.SDK_INT < 19 || (activity.getWindow().getAttributes().flags & View.STATUS_BAR_TRANSIENT) != 67108864) {
            return false;
        }
        return true;
    }

    public static boolean isFlagUsed(Activity activity, int i) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & i) == i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m23427a(android.content.Context r4) {
        /*
            r0 = 0
            java.lang.String r1 = "com.android.internal.R$dimen"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0014 }
            java.lang.Object r2 = r1.newInstance()     // Catch:{ all -> 0x0014 }
            java.lang.String r3 = "status_bar_height"
            java.lang.reflect.Field r0 = r1.getField(r3)     // Catch:{ all -> 0x0012 }
            goto L_0x0019
        L_0x0012:
            r1 = move-exception
            goto L_0x0016
        L_0x0014:
            r1 = move-exception
            r2 = r0
        L_0x0016:
            r1.printStackTrace()
        L_0x0019:
            if (r0 == 0) goto L_0x0038
            if (r2 == 0) goto L_0x0038
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0034 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0034 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0034 }
            android.content.res.Resources r1 = r4.getResources()     // Catch:{ all -> 0x0034 }
            int r0 = r1.getDimensionPixelSize(r0)     // Catch:{ all -> 0x0034 }
            f33306b = r0     // Catch:{ all -> 0x0034 }
            goto L_0x0038
        L_0x0034:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0038:
            int r0 = f33306b
            if (r0 > 0) goto L_0x0044
            r0 = 1103626240(0x41c80000, float:25.0)
            int r4 = com.didi.app.nova.support.util.DisplayUtils.dip2px(r4, r0)
            f33306b = r4
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.utils.RFSystemBarUtils.m23427a(android.content.Context):void");
    }
}
