package com.didi.zxing.scan.util;

import android.app.Activity;
import android.os.Build;

public class ActivityCompatUtils {
    public static boolean isDestroyed(Activity activity) {
        return activity != null && (activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()));
    }
}
