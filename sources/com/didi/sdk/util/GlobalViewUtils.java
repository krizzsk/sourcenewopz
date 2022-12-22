package com.didi.sdk.util;

import android.content.Context;

public class GlobalViewUtils {
    public static int dipToPx(Context context, int i) {
        return (int) (((double) (((float) i) * context.getResources().getDisplayMetrics().density)) + 0.5d);
    }
}
