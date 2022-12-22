package com.didi.beatles.p099im.plugin.robot.utils;

import android.content.Context;
import android.view.View;

/* renamed from: com.didi.beatles.im.plugin.robot.utils.IMRobotViewUtil */
public class IMRobotViewUtil {
    private IMRobotViewUtil() {
    }

    public static void setVisibility(View view, int i) {
        if (view != null) {
            try {
                if (view.getVisibility() != i) {
                    view.setVisibility(i);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void hide(View... viewArr) {
        for (View hide : viewArr) {
            hide(hide);
        }
    }

    public static int dp2px(Context context, float f) {
        return Math.round((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dp(Context context, float f) {
        return Math.round(f / context.getResources().getDisplayMetrics().density);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static void hide(View view) {
        if (view != null && view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    public static void show(View... viewArr) {
        for (View show : viewArr) {
            show(show);
        }
    }

    public static void show(View view) {
        if (view != null && view.getVisibility() != 0) {
            view.setVisibility(0);
        }
    }
}
