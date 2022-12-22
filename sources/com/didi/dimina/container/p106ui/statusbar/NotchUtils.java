package com.didi.dimina.container.p106ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.TypedValue;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;

/* renamed from: com.didi.dimina.container.ui.statusbar.NotchUtils */
public class NotchUtils {

    /* renamed from: a */
    private static final String f17736a = "android.os.SystemProperties";

    /* renamed from: b */
    private static final String f17737b = "ro.miui.notch";

    /* renamed from: c */
    private static final String f17738c = "com.huawei.android.util.HwNotchSizeUtil";

    /* renamed from: d */
    private static final String f17739d = "android.util.FtFeature";

    /* renamed from: e */
    private static final String f17740e = "com.oppo.feature.screen.heteromorphism";

    public static boolean hasNotchScreen(Activity activity) {
        return activity != null && (m13236a((Context) activity) || m13240b((Context) activity) || m13242d(activity) || m13241c(activity) || m13235a(activity));
    }

    public static boolean hasNotchScreen(View view) {
        return view != null && (m13236a(view.getContext()) || m13240b(view.getContext()) || m13242d(view.getContext()) || m13241c(view.getContext()) || m13237a(view));
    }

    /* renamed from: a */
    private static boolean m13237a(View view) {
        return m13239b(view) != null;
    }

    /* renamed from: a */
    private static boolean m13235a(Activity activity) {
        return m13238b(activity) != null;
    }

    /* renamed from: b */
    private static DisplayCutout m13238b(Activity activity) {
        Window window;
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 28 || activity == null || (window = activity.getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }

    /* renamed from: b */
    private static DisplayCutout m13239b(View view) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 28 || view == null || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0052 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m13236a(android.content.Context r6) {
        /*
            com.didi.dimina.container.Dimina$Config r0 = com.didi.dimina.container.Dimina.getConfig()
            com.didi.dimina.container.Dimina$AdapterConfig r0 = r0.getAdapterConfig()
            com.didi.dimina.container.service.WsgService r0 = r0.getWsgService()
            r1 = 0
            java.lang.String r0 = r0.getBrand(r1)
            java.lang.String r1 = "Xiaomi"
            boolean r0 = r1.equals(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x004e
            java.lang.ClassLoader r6 = r6.getClassLoader()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            java.lang.String r0 = "android.os.SystemProperties"
            java.lang.Class r6 = r6.loadClass(r0)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            java.lang.String r0 = "getInt"
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r2] = r5     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            r4[r1] = r5     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            java.lang.reflect.Method r0 = r6.getMethod(r0, r4)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            java.lang.String r4 = "ro.miui.notch"
            r3[r2] = r4     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            r3[r1] = r4     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            java.lang.Object r6 = r0.invoke(r6, r3)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            int r6 = r6.intValue()     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x004e }
            goto L_0x004f
        L_0x004e:
            r6 = 0
        L_0x004f:
            if (r6 != r1) goto L_0x0052
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.statusbar.NotchUtils.m13236a(android.content.Context):boolean");
    }

    /* renamed from: b */
    private static boolean m13240b(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(f17738c);
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    /* renamed from: c */
    private static boolean m13241c(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(f17739d);
            return ((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{32})).booleanValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    /* renamed from: d */
    private static boolean m13242d(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature(f17740e);
        } catch (Exception unused) {
            return false;
        }
    }

    public static int getNotchHeight(Activity activity) {
        int statusBarHeight = ImmersionBar.getStatusBarHeight(activity);
        DisplayCutout b = m13238b(activity);
        if (Build.VERSION.SDK_INT < 28 || b == null) {
            int e = m13236a((Context) activity) ? m13243e(activity) : 0;
            if (m13240b((Context) activity)) {
                e = m13244f(activity)[1];
            }
            if (m13241c(activity) && (e = dp2px(activity, 32)) < statusBarHeight) {
                e = statusBarHeight;
            }
            if (!m13242d(activity)) {
                return e;
            }
            if (80 < statusBarHeight) {
                return statusBarHeight;
            }
            return 80;
        } else if (activity.getResources().getConfiguration().orientation == 1) {
            return b.getSafeInsetTop();
        } else {
            if (b.getSafeInsetLeft() == 0) {
                return b.getSafeInsetRight();
            }
            return b.getSafeInsetLeft();
        }
    }

    /* renamed from: e */
    private static int m13243e(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: f */
    private static int[] m13244f(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(f17738c);
            return (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return iArr;
        }
    }

    public static int dp2px(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }
}
