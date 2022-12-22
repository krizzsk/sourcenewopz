package com.didi.soda.customer.foundation.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public final class UiUtil {
    private UiUtil() {
    }

    public static void doMeasure(View view) {
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i3 = 1073741824;
        int i4 = 0;
        if (layoutParams.width == -2) {
            i2 = 0;
            i = 0;
        } else {
            i2 = layoutParams.width;
            i = 1073741824;
        }
        if (layoutParams.height == -2) {
            i3 = 0;
        } else {
            i4 = layoutParams.height;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(i2, i), View.MeasureSpec.makeMeasureSpec(i4, i3));
    }

    public static int getVirtualBarHeight(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", new Class[]{DisplayMetrics.class}).invoke(defaultDisplay, new Object[]{displayMetrics});
            return displayMetrics.heightPixels - defaultDisplay.getHeight();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getStatusBar(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }
}
