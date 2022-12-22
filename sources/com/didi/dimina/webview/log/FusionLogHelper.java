package com.didi.dimina.webview.log;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;

public class FusionLogHelper {
    public static boolean isFusionLogOpen(Context context) {
        return SystemUtils.getSharedPreferences(context, "fusionlogpref", 0).getBoolean("fusionlog", false);
    }
}
