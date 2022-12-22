package com.didi.soda.customer.foundation.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public final class KeyboardUtils {
    public static boolean sAutoHideWhenTouch = true;

    private KeyboardUtils() {
    }

    public static boolean hideSoftInput(Context context, View view) {
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        View currentFocus = ((Activity) context).getCurrentFocus();
        if (currentFocus != null) {
            view = currentFocus;
        }
        if (view != null) {
            return ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        return false;
    }

    public static boolean showSoftInput(Context context, View view) {
        if (context == null) {
            return false;
        }
        view.requestFocus();
        return ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 2);
    }

    public static boolean isSoftInputVisible(Activity activity) {
        return isSoftInputVisible(activity, 200);
    }

    public static boolean isSoftInputVisible(Activity activity, int i) {
        return m29208a(activity) >= i;
    }

    public static boolean isShouldHideInput(View view, MotionEvent motionEvent) {
        if (view == null || !(view instanceof EditText)) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int height = view.getHeight() + i2;
        int width = view.getWidth() + i;
        if (motionEvent.getX() <= ((float) i) || motionEvent.getX() >= ((float) width) || motionEvent.getY() <= ((float) i2) || motionEvent.getY() >= ((float) height)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static int m29208a(Activity activity) {
        View findViewById = activity.findViewById(16908290);
        Rect rect = new Rect();
        findViewById.getWindowVisibleDisplayFrame(rect);
        return findViewById.getRootView().getHeight() - rect.height();
    }
}
