package com.didi.map.sdk.departure.internal.util;

import android.content.Context;

public class DimenUtil {
    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
