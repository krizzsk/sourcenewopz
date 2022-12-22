package com.didi.sdk.apm.crash;

import android.util.Log;

public class SecurityExceptionInterceptor extends CrashInterceptor {

    /* renamed from: a */
    private static final String f35008a = "SecurityExceptionInterceptor";

    public boolean intercept(Thread thread, Throwable th) {
        try {
            return (th instanceof SecurityException) && isMatchSpecialExceptionMsg(th, "Unable to find app for caller") && isMatchSpecialStackTraceElement(th, "android.app.ActivityManagerProxy", "registerReceiver");
        } catch (Throwable unused) {
            return false;
        }
    }

    public void doCrashStrategy(Thread thread, Throwable th) {
        Log.e(f35008a, "doCrashStrategy", th);
        closeApp();
    }
}
