package com.didichuxing.omega.sdk.common.collector;

import android.app.ActivityManager;
import android.content.Context;

public class ProcessCollector {
    private static ActivityManager mActivityManager;
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
        mActivityManager = (ActivityManager) context.getSystemService("activity");
    }
}
