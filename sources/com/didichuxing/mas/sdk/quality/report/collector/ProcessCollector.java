package com.didichuxing.mas.sdk.quality.report.collector;

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
