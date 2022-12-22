package com.didi.sdk.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.apollo.sdk.Apollo;
import java.lang.reflect.Field;

public class GlobalScreenFitHelper {

    /* renamed from: a */
    private static final String f37618a = "GlobalScreenFitHelper";

    /* renamed from: b */
    private static final int f37619b = 375;

    /* renamed from: c */
    private static float f37620c;

    /* renamed from: d */
    private static float f37621d;

    /* renamed from: e */
    private static boolean f37622e;

    /* renamed from: f */
    private static boolean f37623f;

    public static void startFitWholeApp(Context context) {
        if (!Apollo.getToggle("global_fit_screen", true).allow()) {
            SystemUtils.log(3, f37618a, "屏幕适配开关close ", (Throwable) null, "com.didi.sdk.util.GlobalScreenFitHelper", 53);
        } else if (!m26698b(context)) {
            SystemUtils.log(3, f37618a, "not reset pad ", (Throwable) null, "com.didi.sdk.util.GlobalScreenFitHelper", 57);
        } else {
            SystemUtils.log(3, f37618a, "屏幕适配开关open ", (Throwable) null, "com.didi.sdk.util.GlobalScreenFitHelper", 60);
            if (!f37623f) {
                startFitSingleContext(context);
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
                    public void onActivityDestroyed(Activity activity) {
                    }

                    public void onActivityPaused(Activity activity) {
                    }

                    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    }

                    public void onActivityStarted(Activity activity) {
                    }

                    public void onActivityStopped(Activity activity) {
                    }

                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        SystemUtils.log(3, GlobalScreenFitHelper.f37618a, "resetActivityDensity: " + activity.getComponentName(), (Throwable) null, "com.didi.sdk.util.GlobalScreenFitHelper$1", 68);
                        GlobalScreenFitHelper.m26697b(activity);
                    }

                    public void onActivityResumed(Activity activity) {
                        GlobalScreenFitHelper.m26697b(activity);
                    }
                });
                f37623f = true;
            }
        }
    }

    public static void startFitSingleContext(Context context) {
        if (context != null && m26698b(context)) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (f37621d == 0.0f) {
                f37620c = displayMetrics.density;
                f37621d = m26694a(context);
            }
            SystemUtils.log(3, f37618a, "startFit: sDefaultDensity = " + displayMetrics.density + " 修改后密度 = " + f37621d, (Throwable) null, "com.didi.sdk.util.GlobalScreenFitHelper", 117);
            displayMetrics.density = f37621d;
            displayMetrics.scaledDensity = f37621d;
            displayMetrics.densityDpi = (int) (f37621d * 160.0f);
            if (!f37622e) {
                m26695a((int) (f37621d * 160.0f));
            }
            f37622e = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m26697b(Activity activity) {
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        displayMetrics.density = f37621d;
        displayMetrics.scaledDensity = f37621d;
        displayMetrics.densityDpi = (int) (f37621d * 160.0f);
    }

    @Deprecated
    public static void endFit(Context context) {
        if (context != null && f37620c != 0.0f && m26698b(context) && f37622e) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            displayMetrics.scaledDensity = f37620c;
            displayMetrics.density = f37620c;
            displayMetrics.densityDpi = (int) (f37620c * 160.0f);
            m26695a((int) (f37620c * 160.0f));
            f37622e = false;
            SystemUtils.log(3, f37618a, "endFit: 恢复默认屏幕密度 = " + f37620c, (Throwable) null, "com.didi.sdk.util.GlobalScreenFitHelper", 151);
        }
    }

    /* renamed from: a */
    private static void m26695a(int i) {
        try {
            Field declaredField = Class.forName("android.graphics.Bitmap").getDeclaredField("sDefaultDensity");
            declaredField.setAccessible(true);
            declaredField.set((Object) null, Integer.valueOf(i));
            declaredField.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static float m26694a(Context context) {
        return ((float) context.getResources().getDisplayMetrics().widthPixels) / 375.0f;
    }

    /* renamed from: b */
    private static boolean m26698b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels < displayMetrics.heightPixels;
    }
}
