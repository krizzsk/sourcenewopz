package com.didi.soda.web.tools;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardTool {
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
}
