package com.didi.sdk.apm.crash;

import android.os.Build;
import android.util.Log;

public class FailureFromSystemMInterceptor extends CrashInterceptor {

    /* renamed from: a */
    private static final String f35002a = "FailureFromSystemMInterceptor";

    public boolean intercept(Thread thread, Throwable th) {
        try {
            if (Build.VERSION.SDK_INT != 23 || !(th instanceof RuntimeException) || !isMatchSpecialExceptionMsg(th, "Failure from system") || !isMatchSpecialStackTraceElement(th, "android.app.ContextImpl", "bindServiceCommon")) {
                return false;
            }
            Log.e(f35002a, "This Exception is only happen on Android OS M,and it is a considerable,so ignore this exception");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void doCrashStrategy(Thread thread, Throwable th) {
        Log.e(f35002a, "doCrashStrategy", th);
    }
}
