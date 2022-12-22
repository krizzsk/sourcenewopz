package com.didi.commoninterfacelib.statuslightning;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.didi.commoninterfacelib.statuslightning.impl.FlyMeLightningCompatImpl;
import com.didi.commoninterfacelib.statuslightning.impl.MIUILowerMLightningCompatImpl;
import com.didi.commoninterfacelib.statuslightning.impl.MIUIMLightningCompatImpl;
import com.didi.commoninterfacelib.statuslightning.impl.MLightningCompatImpl;
import com.didi.commoninterfacelib.statuslightning.impl.NoneLightningCompatImpl;
import com.taxis99.R;

public class StatusBarLightingCompat {

    /* renamed from: b */
    private static final ILightningCompat f10961b;

    /* renamed from: c */
    private static ILightnightLogging f10962c;

    /* renamed from: d */
    private static boolean f10963d;

    /* renamed from: e */
    private static int f10964e;

    /* renamed from: a */
    private final String f10965a = "statusLightCompat";

    /* renamed from: b */
    private static int[] m7407b(int i) {
        return new int[]{(16711680 & i) >> 16, (65280 & i) >> 8, i & 255};
    }

    public static boolean getLightStatusBar() {
        return f10963d;
    }

    public static int getStatusBarColor() {
        return f10964e;
    }

    static {
        if (C4521a.m7408a() && C4521a.m7411d()) {
            f10961b = new MIUIMLightningCompatImpl();
        } else if (C4521a.m7408a()) {
            f10961b = new MIUILowerMLightningCompatImpl();
        } else if (C4521a.m7410c()) {
            f10961b = new FlyMeLightningCompatImpl();
        } else if (C4521a.m7411d()) {
            f10961b = new MLightningCompatImpl();
        } else {
            f10961b = new NoneLightningCompatImpl();
        }
    }

    /* renamed from: a */
    private static void m7405a(String str, String str2) {
        if (getLightningLogging() != null) {
            getLightningLogging().log(str, str2);
        }
    }

    public static void setStatusBarBgLightning(Activity activity, boolean z) {
        if (activity != null) {
            f10961b.setLightStatusBar(activity, z);
        }
    }

    public static void setStatusBarBgLightning(Activity activity, boolean z, int i) {
        String name = getImpl() != null ? getImpl().getClass().getName() : null;
        m7405a("", name + ":Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT + "  Build.VERSION.INCREMENTAL:" + Build.VERSION.INCREMENTAL + " activity=" + activity);
        if (activity != null) {
            if (Build.VERSION.SDK_INT >= 21) {
                f10963d = z;
                f10964e = i;
                if (f10961b instanceof NoneLightningCompatImpl) {
                    activity.setTheme(R.style.GlobalActivity50);
                } else {
                    setStatusBarColor(activity, i);
                }
                f10961b.setLightStatusBar(activity, z);
                return;
            }
            setStatusBarColor(activity, i);
        }
    }

    public static void setStatusBarColor(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.clearFlags(View.STATUS_BAR_TRANSIENT);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
            return;
        }
        Window window2 = activity.getWindow();
        window2.clearFlags(View.STATUS_BAR_TRANSIENT);
        window2.getDecorView().setSystemUiVisibility(256);
    }

    public static void setStatusBarBgLightning(Activity activity, int i) {
        if (activity != null) {
            f10961b.setLightStatusBar(activity, m7406a(i));
        }
    }

    /* renamed from: a */
    private static boolean m7406a(int i) {
        int[] b = m7407b(i);
        if (((int) ((((double) b[0]) * 0.299d) + (((double) b[1]) * 0.587d) + (((double) b[2]) * 0.114d))) >= 192) {
            return true;
        }
        return false;
    }

    public static ILightningCompat getImpl() {
        return f10961b;
    }

    public static void setLightningLogging(ILightnightLogging iLightnightLogging) {
        f10962c = iLightnightLogging;
    }

    public static ILightnightLogging getLightningLogging() {
        return f10962c;
    }
}
