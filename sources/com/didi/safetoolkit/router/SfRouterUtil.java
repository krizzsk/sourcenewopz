package com.didi.safetoolkit.router;

import android.text.TextUtils;

public class SfRouterUtil {
    public static int parseInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str.trim());
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }
}
