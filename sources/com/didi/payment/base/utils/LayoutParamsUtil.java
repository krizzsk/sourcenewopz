package com.didi.payment.base.utils;

import android.view.View;
import android.view.ViewGroup;

public class LayoutParamsUtil {
    public static final int VALUE_ORIGIN = -9999;

    public static void resetLayoutMargin(View view, int i, int i2, int i3, int i4) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (i != -9999) {
                    marginLayoutParams.leftMargin = i;
                }
                if (i2 != -9999) {
                    marginLayoutParams.topMargin = i2;
                }
                if (i3 != -9999) {
                    marginLayoutParams.rightMargin = i3;
                }
                if (i4 != -9999) {
                    marginLayoutParams.bottomMargin = i4;
                }
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public static void resetLayoutMarginInH(View view, int i, int i2) {
        resetLayoutMargin(view, i, -9999, i2, -9999);
    }

    public static void resetLayoutMarginInV(View view, int i, int i2) {
        resetLayoutMargin(view, -9999, i, -9999, i2);
    }

    public static void resetLayoutWH(View view, int i, int i2) {
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (i != -9999) {
                layoutParams.width = i;
            }
            if (i2 != -9999) {
                layoutParams.height = i2;
            }
            view.setLayoutParams(layoutParams);
        }
    }
}
