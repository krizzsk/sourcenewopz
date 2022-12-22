package com.android.didi.safetoolkit.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class SoftInputUtil {
    private static final int DURATION = 100;

    private SoftInputUtil() {
    }

    public static void closeSoftInput(final Context context) {
        final View currentFocus = ((Activity) context).getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.postDelayed(new Runnable() {
                public void run() {
                    boolean unused = SoftInputUtil.hideInputMethod(context, currentFocus);
                }
            }, 100);
        }
    }

    public static void openSoftInput(final Context context) {
        final View currentFocus = ((Activity) context).getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.postDelayed(new Runnable() {
                public void run() {
                    boolean unused = SoftInputUtil.showInputMethod(context, currentFocus);
                }
            }, 100);
        }
    }

    /* access modifiers changed from: private */
    public static boolean hideInputMethod(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null || !inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean showInputMethod(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (context == null || view == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null || !inputMethodManager.showSoftInput(view, 0)) {
            return false;
        }
        return true;
    }

    public static boolean canHideInputMethod(Activity activity, MotionEvent motionEvent) {
        View currentFocus = activity.getCurrentFocus();
        return currentFocus == null || !currentFocus.hasWindowFocus() || !(currentFocus instanceof EditText) || !isTouchEventHitViewArea(currentFocus, motionEvent);
    }

    public static boolean isTouchEventHitViewArea(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new RectF((float) i, (float) i2, (float) (view.getWidth() + i), (float) (view.getHeight() + i2)).contains(motionEvent.getRawX(), motionEvent.getRawY());
    }
}
