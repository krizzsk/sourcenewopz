package com.android.didi.bfflib.debug;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.didi.sdk.envsetbase.EnvPreferenceUtil;

public class BffDebugUtil {
    private static boolean isDebug;
    private static boolean isInited;
    private static Context sContext;

    public static void init(Context context) {
        if (context != null) {
            sContext = context.getApplicationContext();
            if (context.getApplicationInfo() != null) {
                setDebug(context.getApplicationContext().getApplicationInfo());
                isInited = true;
            }
        }
    }

    private static void setDebug(ApplicationInfo applicationInfo) {
        if (applicationInfo != null) {
            isDebug = (applicationInfo.flags & 2) != 0;
        }
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static boolean isInited() {
        return isInited;
    }

    public static boolean isMd5Open() {
        return EnvPreferenceUtil.getBooleanSafely(sContext, "bff_close_md5", true);
    }

    public static boolean isConcurrenceOpen() {
        return EnvPreferenceUtil.getBooleanSafely(sContext, "bff_close_concurrence", true);
    }
}
