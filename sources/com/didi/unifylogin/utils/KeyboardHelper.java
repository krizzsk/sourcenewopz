package com.didi.unifylogin.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardHelper {
    public static void showInputMethod(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 1);
    }

    public static void showInputMethodForce(Context context) {
        ((InputMethodManager) context.getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    public static void hideInputMethod(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
    }
}
