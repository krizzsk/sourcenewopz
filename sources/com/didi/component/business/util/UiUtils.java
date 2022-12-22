package com.didi.component.business.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.travel.psnger.utils.TextUtil;

public class UiUtils {
    public static int getWindowWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getWindowHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getScreenHeight(Activity activity) {
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.y;
    }

    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.y;
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.x;
    }

    public static int getNotchHeight(View view) {
        if (Build.VERSION.SDK_INT < 28 || view.getRootWindowInsets() == null || view.getRootWindowInsets().getDisplayCutout() == null) {
            return 0;
        }
        return view.getRootWindowInsets().getDisplayCutout().getSafeInsetTop();
    }

    public static int getStatusBarHeight(Context context) {
        if (context == null) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 60;
    }

    public static int dip2px(Context context, float f) {
        return context == null ? (int) f : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return context == null ? (int) f : (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int[] getViewLocation(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr;
    }

    public static boolean isOverFlowTextView(TextView textView) {
        Layout layout = textView.getLayout();
        if (layout == null || layout.getEllipsisCount(layout.getLineCount() - 1) <= 0) {
            return false;
        }
        return true;
    }

    public static int[] getLocationOnScreen(View view, View view2) {
        int[] iArr = new int[2];
        if (!(view2 == null || view == null)) {
            view2.getLocationOnScreen(iArr);
            if (iArr[0] == 0 || iArr[1] == 0) {
                Rect rect = new Rect();
                view.getGlobalVisibleRect(rect);
                iArr[0] = rect.left;
                iArr[1] = rect.top;
            }
        }
        return iArr;
    }

    public static int parseColor(String str, int i) {
        try {
            return !TextUtil.isEmpty(str) ? Color.parseColor(str) : i;
        } catch (IllegalArgumentException unused) {
            return i;
        }
    }

    public static int parseColor(String str, String str2) {
        if (str == null) {
            str = str2;
        }
        try {
            return Color.parseColor(str);
        } catch (IllegalArgumentException unused) {
            return Color.parseColor(str2);
        }
    }

    public static boolean checkDeviceHasNavigationBar(Context context) {
        return (ViewConfiguration.get(context).hasPermanentMenuKey() ^ true) & (KeyCharacterMap.deviceHasKey(4) ^ true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r3 = r3.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getNavigationBarHeight(android.content.Context r3) {
        /*
            boolean r0 = checkDeviceHasNavigationBar(r3)
            if (r0 == 0) goto L_0x001b
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r0 = "navigation_bar_height"
            java.lang.String r1 = "dimen"
            java.lang.String r2 = "android"
            int r0 = r3.getIdentifier(r0, r1, r2)
            if (r0 <= 0) goto L_0x001b
            int r3 = r3.getDimensionPixelSize(r0)
            goto L_0x001c
        L_0x001b:
            r3 = 0
        L_0x001c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.business.util.UiUtils.getNavigationBarHeight(android.content.Context):int");
    }

    public static boolean isNavigationBarShow(Activity activity) {
        if (Build.VERSION.SDK_INT >= 17) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            Point point = new Point();
            Point point2 = new Point();
            defaultDisplay.getSize(point);
            defaultDisplay.getRealSize(point2);
            int i = point2.y;
            int i2 = point.y;
            if (point2.y != point.y) {
                return true;
            }
            return false;
        }
        return !ViewConfiguration.get(activity).hasPermanentMenuKey() && !KeyCharacterMap.deviceHasKey(4);
    }
}
