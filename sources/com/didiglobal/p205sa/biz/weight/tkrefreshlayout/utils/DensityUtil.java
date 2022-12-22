package com.didiglobal.p205sa.biz.weight.tkrefreshlayout.utils;

import android.content.Context;

/* renamed from: com.didiglobal.sa.biz.weight.tkrefreshlayout.utils.DensityUtil */
public class DensityUtil {
    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
