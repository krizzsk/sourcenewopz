package com.didi.unifylogin.utils;

import android.content.Context;
import android.util.DisplayMetrics;

public class LoginDisplayMetrics {

    /* renamed from: a */
    private static final String f44926a = "LoginDisplayMetrics";

    /* renamed from: b */
    private static int f44927b;

    /* renamed from: c */
    private static float f44928c;

    public static int getWidth(Context context) {
        int i = f44927b;
        if (i > 0) {
            return i;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        LoginLog.write("LoginDisplayMetrics getWidthPixels:" + displayMetrics.widthPixels);
        return displayMetrics.widthPixels;
    }

    public static void setWidth(int i) {
        f44927b = i;
    }

    public static float getDensity(Context context) {
        if (f44928c <= 0.0f) {
            f44928c = context.getResources().getDisplayMetrics().density;
        }
        return f44928c;
    }
}
