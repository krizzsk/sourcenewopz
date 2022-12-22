package com.didi.sdk.apm;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FullscreenOpaqueHelper {

    /* renamed from: a */
    private static final String f34941a = "FullscreenOpaqueHelper";

    public static void hookOnlyFullscreenOpaque(Activity activity) {
        if (activity != null && 26 == Build.VERSION.SDK_INT && m24702a(activity)) {
            boolean b = m24703b(activity);
            try {
                Log.d(f34941a, activity.getComponentName().getClassName() + "#onCreate fixOrientation when Oreo,result = " + b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static boolean m24702a(Activity activity) {
        boolean z;
        Exception e;
        try {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get((Object) null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", new Class[]{TypedArray.class});
            method.setAccessible(true);
            z = ((Boolean) method.invoke((Object) null, new Object[]{obtainStyledAttributes})).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            e.printStackTrace();
            return z;
        }
        return z;
    }

    /* renamed from: b */
    private static boolean m24703b(Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void hookSetRequestedOrientation(Activity activity, int i) {
        if (26 == Build.VERSION.SDK_INT && m24702a(activity)) {
            try {
                Log.d(f34941a, activity.getComponentName().getClassName() + "#requestedOrientation hooked in Oreo!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (activity != null) {
            activity.setRequestedOrientation(i);
        }
    }
}
