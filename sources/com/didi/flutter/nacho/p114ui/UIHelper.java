package com.didi.flutter.nacho.p114ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: com.didi.flutter.nacho.ui.UIHelper */
public class UIHelper {

    /* renamed from: a */
    private static int f21114a = 750;

    public static void setFlutterDesignWidth(int i) {
        f21114a = i;
    }

    public static Display getDisplay(Context context) {
        WindowManager windowManager;
        if (context instanceof Activity) {
            windowManager = ((Activity) context).getWindowManager();
        } else {
            windowManager = (WindowManager) context.getSystemService("window");
        }
        if (windowManager != null) {
            return windowManager.getDefaultDisplay();
        }
        return null;
    }

    public static int getScreenWidth(Context context) {
        Display display = getDisplay(context);
        if (display == null) {
            return 0;
        }
        Point point = new Point();
        display.getSize(point);
        return point.x;
    }

    public static float getScreenWidthInDp(Context context) {
        Display display = getDisplay(context);
        if (display == null) {
            return 0.0f;
        }
        Point point = new Point();
        display.getSize(point);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        return ((float) point.x) / displayMetrics.density;
    }

    public static float getScreenHeightInDp(Context context) {
        Display display = getDisplay(context);
        if (display == null) {
            return 0.0f;
        }
        Point point = new Point();
        display.getSize(point);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);
        return ((float) point.y) / displayMetrics.density;
    }

    public static int getScreenHeight(Context context) {
        Display display = getDisplay(context);
        if (display == null) {
            return 0;
        }
        Point point = new Point();
        display.getSize(point);
        return point.y;
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int flutterDesignPx2NativePx(Context context, float f) {
        Context applicationContext = context.getApplicationContext();
        if (context instanceof Activity) {
            applicationContext = ((Activity) context).getBaseContext();
        }
        return (int) (((f * ((float) applicationContext.getResources().getDisplayMetrics().widthPixels)) / ((float) f21114a)) + 0.5f);
    }
}
