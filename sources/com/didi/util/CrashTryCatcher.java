package com.didi.util;

import android.util.Log;
import com.didi.hawaii.log.HWLog;
import com.didi.map.MapOmegaUtil;
import com.didi.map.common.ApolloHawaii;

public class CrashTryCatcher {
    public static final String OMEGA_CRASH = "hawaii_crash";

    public static void logCrash(Exception exc) {
        String stackTraceString = Log.getStackTraceString(exc == null ? new Exception() : exc);
        HWLog.m16761i(OMEGA_CRASH, stackTraceString);
        MapOmegaUtil.trackEvent(OMEGA_CRASH, stackTraceString);
        if (ApolloHawaii.isHawaiiLogCrashOpen()) {
            throw new RuntimeException(exc);
        }
    }
}
