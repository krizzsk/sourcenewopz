package com.didi.payment.creditcard.base.utils;

import android.content.Context;

public class PaymentTextUtil {
    public static String replaceAllSpace(String str) {
        return str == null ? "" : str.trim().replace(" ", "");
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
