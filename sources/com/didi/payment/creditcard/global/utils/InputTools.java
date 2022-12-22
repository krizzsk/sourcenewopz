package com.didi.payment.creditcard.global.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class InputTools {
    public static void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        }
    }

    public static void showKeyboard(final View view) {
        if (view != null) {
            view.postDelayed(new Runnable() {
                public void run() {
                    View.this.requestFocus();
                    ((InputMethodManager) View.this.getContext().getSystemService("input_method")).showSoftInput(View.this, 1);
                }
            }, 200);
        }
    }

    public static boolean isKeyboardShowing(Activity activity) {
        int height = activity.getWindow().getDecorView().getHeight();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return height - rect.bottom != 0;
    }
}
