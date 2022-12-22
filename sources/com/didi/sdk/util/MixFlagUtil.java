package com.didi.sdk.util;

import android.content.Context;

public class MixFlagUtil {
    public static final String KEY_MIX_FLAG = "mix_flag";
    public static final int MIX_FLAG_HMS = 1;
    public static final int MIX_FLAG_HW_PRE_INSTALL = 16;

    public static int getMixFlag(Context context) {
        int i = AnalysisAPK.isGlobalHmsApk(context) ? 1 : 0;
        return AnalysisAPK.isGlobalHmsPreInstallApk(context) ? i | 16 : i;
    }
}
