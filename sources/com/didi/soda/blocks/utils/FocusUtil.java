package com.didi.soda.blocks.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

public class FocusUtil {
    public static void requestFocus(final View view) {
        if (view != null) {
            view.post(new Runnable() {
                public void run() {
                    view.requestFocus();
                    KeyboardUtil.showKeyboard(view);
                }
            });
        }
    }

    public static void clearFocus(final View view) {
        if (view != null) {
            view.post(new Runnable() {
                public void run() {
                    FocusUtil.focusParent(view);
                    view.clearFocus();
                    KeyboardUtil.hideKeyboard(view);
                }
            });
        }
    }

    public static void clearFocus(Context context) {
        InputMethodManager inputMethodManager;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null && (inputMethodManager = (InputMethodManager) activity.getSystemService("input_method")) != null && inputMethodManager.isActive()) {
                clearFocus(activity.getCurrentFocus());
            }
        }
    }

    /* access modifiers changed from: private */
    public static void focusParent(View view) {
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (Build.VERSION.SDK_INT >= 26) {
                viewGroup.setDefaultFocusHighlightEnabled(false);
            }
            viewGroup.setFocusable(true);
            viewGroup.setFocusableInTouchMode(true);
            viewGroup.requestFocus();
        }
    }
}
