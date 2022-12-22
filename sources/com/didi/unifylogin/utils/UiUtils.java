package com.didi.unifylogin.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;

public class UiUtils {

    /* renamed from: a */
    private static final String f44947a = "navigationBarBackground";

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

    public static int getNotchHeight(View view) {
        if (Build.VERSION.SDK_INT < 28 || view.getRootWindowInsets() == null || view.getRootWindowInsets().getDisplayCutout() == null) {
            return 0;
        }
        return dip2px(view.getContext(), (float) view.getRootWindowInsets().getDisplayCutout().getSafeInsetTop());
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
            return !TextUtils.isEmpty(str) ? Color.parseColor(str) : i;
        } catch (IllegalArgumentException unused) {
            return i;
        }
    }

    public static boolean checkDeviceHasNavigationBar(Context context) {
        return (ViewConfiguration.get(context).hasPermanentMenuKey() ^ true) & (KeyCharacterMap.deviceHasKey(4) ^ true);
    }

    public static int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean isNavigationBarExist(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (viewGroup.getChildAt(i).getId() != -1 && f44947a.equals(activity.getResources().getResourceEntryName(viewGroup.getChildAt(i).getId()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
