package com.didi.hawaii.p118ar.utils;

import android.content.Context;

/* renamed from: com.didi.hawaii.ar.utils.DisplayUtils */
public class DisplayUtils {
    public static int dip2px(Context context, float f) {
        return context == null ? (int) f : (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
