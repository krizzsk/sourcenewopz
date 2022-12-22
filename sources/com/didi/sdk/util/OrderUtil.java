package com.didi.sdk.util;

import android.text.TextUtils;

public class OrderUtil {
    public static boolean isTaxiOrder(String str) {
        return TextUtils.equals(str, "dache");
    }
}
