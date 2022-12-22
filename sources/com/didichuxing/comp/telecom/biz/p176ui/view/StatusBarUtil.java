package com.didichuxing.comp.telecom.biz.p176ui.view;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* renamed from: com.didichuxing.comp.telecom.biz.ui.view.StatusBarUtil */
public class StatusBarUtil {
    public static void immerse(Activity activity, Boolean bool) {
        if (activity != null && Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            if (Build.VERSION.SDK_INT >= 21) {
                window.clearFlags(View.STATUS_BAR_TRANSIENT);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
            }
            viewGroup.setSystemUiVisibility(viewGroup.getSystemUiVisibility() | 1024);
            if (bool != null) {
                m33248a(activity, bool.booleanValue());
            }
        }
    }

    /* renamed from: a */
    private static void m33248a(Activity activity, boolean z) {
        if (activity != null && Build.VERSION.SDK_INT >= 23) {
            View decorView = activity.getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? (systemUiVisibility & -257) | 8192 : (systemUiVisibility | 256) & -8193);
        }
    }
}
