package com.didi.map.setting.common.utils;

import android.content.Context;

public class MapSettingViewUtils {
    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dp(Context context, float f) {
        return (int) (f / context.getResources().getDisplayMetrics().density);
    }
}
