package com.didi.unifylogin.utils;

import android.content.Context;
import android.text.TextUtils;

public class CommonUtils {
    public static boolean isBrazilApp(Context context) {
        if (context == null) {
            return false;
        }
        return TextUtils.equals(context.getPackageName(), "com.taxis99");
    }

    public static String deleteNonNum(String str) {
        if (str == null) {
            return "";
        }
        return str.replace(" ", "").replace(".", "").replace("-", "");
    }
}
