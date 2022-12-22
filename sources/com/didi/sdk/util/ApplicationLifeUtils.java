package com.didi.sdk.util;

import android.content.Context;

public class ApplicationLifeUtils {
    public static boolean isApplicationInit(Context context) {
        return ((Boolean) SPUtils.get(context, "application_init_flag", false)).booleanValue();
    }

    public static void setApplicationBeginInit(Context context) {
        SPUtils.put(context, "application_init_flag", true);
    }

    public static void setApplicationFinishInit(Context context) {
        SPUtils.put(context, "application_init_flag", false);
    }
}
