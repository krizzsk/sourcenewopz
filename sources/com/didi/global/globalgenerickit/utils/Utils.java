package com.didi.global.globalgenerickit.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;

public class Utils {
    public static boolean isDebug(Context context) {
        ApplicationInfo applicationInfo;
        if (context == null || (applicationInfo = context.getApplicationContext().getApplicationInfo()) == null || (applicationInfo.flags & 2) == 0) {
            return false;
        }
        return true;
    }
}
