package com.didi.sdk.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.envsetbase.EnvPreferenceUtil;
import com.didi.sdk.nation.NationTypeUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;

public class DebugUtils {
    public static final int AUS = 3;
    public static final int BRZ = 4;
    public static final int GLOBAL = 0;
    public static final int JPN = 2;
    public static final int MEX = 1;
    public static boolean debug;

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    public static void setDebug(ApplicationInfo applicationInfo) {
        if (applicationInfo != null) {
            boolean z = (applicationInfo.flags & 2) != 0;
            debug = z;
            if (z) {
                OmegaSDKAdapter.trackEvent("global_debug_mode");
                SystemUtils.log(3, "DebugUtils", "DebugUtils in debug", (Throwable) null, "com.didi.sdk.util.DebugUtils", 38);
            }
        }
    }

    public static int getDebugCountry(Context context) {
        return EnvPreferenceUtil.getIntSafely(context, "key_h5_country_env", 0);
    }

    public static boolean isOnlie() {
        return !debug || NationTypeUtil.getNationComponentData().isReleaseEnvironment();
    }
}
