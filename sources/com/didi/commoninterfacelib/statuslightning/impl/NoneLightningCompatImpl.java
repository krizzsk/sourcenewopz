package com.didi.commoninterfacelib.statuslightning.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.commoninterfacelib.statuslightning.ILightningCompat;

public class NoneLightningCompatImpl implements ILightningCompat {
    public void setLightStatusBar(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.getWindow().getDecorView().setSystemUiVisibility(9216);
        } else {
            setTranslucentForCoordinatorLayout(activity, 70);
        }
    }

    public static void setTranslucentForCoordinatorLayout(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            m7413a(activity);
        }
    }

    /* renamed from: a */
    private static void m7413a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().addFlags(Integer.MIN_VALUE);
            activity.getWindow().clearFlags(View.STATUS_BAR_TRANSIENT);
            activity.getWindow().setStatusBarColor(-16777216);
            return;
        }
        activity.getWindow().addFlags(View.STATUS_BAR_TRANSIENT);
    }

    /* renamed from: a */
    private static void m7414a(Activity activity, int i) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
        if (viewGroup.getChildCount() > 1) {
            viewGroup.getChildAt(1).setBackgroundColor(Color.argb(i, 0, 0, 0));
        } else {
            viewGroup.addView(m7415b(activity, i));
        }
    }

    /* renamed from: b */
    private static View m7415b(Activity activity, int i) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, m7412a((Context) activity)));
        view.setBackgroundColor(Color.argb(i, 0, 0, 0));
        return view;
    }

    /* renamed from: a */
    private static int m7412a(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }
}
