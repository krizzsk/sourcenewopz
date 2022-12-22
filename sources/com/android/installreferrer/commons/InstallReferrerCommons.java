package com.android.installreferrer.commons;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;

public final class InstallReferrerCommons {
    public static void logVerbose(String str, String str2) {
        if (Log.isLoggable(str, 2)) {
            SystemUtils.log(2, str, str2, (Throwable) null, "com.android.installreferrer.commons.InstallReferrerCommons", 31);
        }
    }

    public static void logWarn(String str, String str2) {
        if (Log.isLoggable(str, 5)) {
            SystemUtils.log(5, str, str2, (Throwable) null, "com.android.installreferrer.commons.InstallReferrerCommons", 43);
        }
    }
}
