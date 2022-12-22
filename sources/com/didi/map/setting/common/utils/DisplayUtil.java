package com.didi.map.setting.common.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

public class DisplayUtil {
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void setStatusBar(Activity activity, int i, boolean z) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            window.getDecorView().setSystemUiVisibility(256);
            window.setStatusBarColor(i);
        } else if (Build.VERSION.SDK_INT >= 19) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags = 67108864 | attributes.flags;
        }
        if (Build.VERSION.SDK_INT >= 23 && z) {
            window.getDecorView().setSystemUiVisibility(8192);
        }
    }
}
