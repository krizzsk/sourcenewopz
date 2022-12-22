package com.didi.sdk.apm.crash;

import android.util.Log;

public class ReportSizeConfigurationInterceptor extends CrashInterceptor {

    /* renamed from: a */
    private static final String f35007a = "ReportSizeConfigurationInterceptor";

    public boolean intercept(Thread thread, Throwable th) {
        try {
            if (th instanceof IllegalArgumentException) {
                if (!isMatchSpecialExceptionMsg(th, "ActivityRecord not found for: Token")) {
                    return false;
                }
                if (!isMatchSpecialStackTraceElement(th, "android.app.IActivityManager$Stub$Proxy", "reportSizeConfigurations") && !isMatchSpecialStackTraceElement(th, "android.app.ActivityManagerProxy", "reportSizeConfigurations")) {
                    return false;
                }
                return true;
            } else if (!(th instanceof NullPointerException) || !isMatchSpecialExceptionMsg(th, "android.content.res.Resources android.app.Activity.getResources()") || !isMatchSpecialStackTraceElement(th, "android.app.ActivityThread", "reportSizeConfigurations")) {
                return false;
            } else {
                return true;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public void doCrashStrategy(Thread thread, Throwable th) {
        Log.e(f35007a, "doCrashStrategy", th);
        closeApp();
    }
}
