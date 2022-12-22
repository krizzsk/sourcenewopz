package com.didi.component.common.util;

import android.app.Activity;
import android.content.Context;

public class ActivityUtil {
    public static boolean isActivityDestroyed(Context context) {
        if (context == null) {
            return true;
        }
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing() || activity.isDestroyed()) {
            return true;
        }
        return false;
    }
}
