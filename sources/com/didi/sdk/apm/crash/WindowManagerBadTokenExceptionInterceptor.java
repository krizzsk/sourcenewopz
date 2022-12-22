package com.didi.sdk.apm.crash;

import android.util.Log;
import android.view.WindowManager;

public class WindowManagerBadTokenExceptionInterceptor extends CrashInterceptor {

    /* renamed from: a */
    private static final String f35009a = "WindowManagerBadTokenExceptionInterceptor";

    public boolean intercept(Thread thread, Throwable th) {
        try {
            if (!(th instanceof WindowManager.BadTokenException) || !isMatchSpecialExceptionMsg(th, "Unable to add window") || !isMatchSpecialStackTraceElementByRegex(th, "android.app.ActivityThread", "-wrap.+|access\\$.+")) {
                return false;
            }
            Log.e(f35009a, "intercept this exception,this error message is =====> Unable to add window -- token android.os.BinderProxy is not valid; is your activity running");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void doCrashStrategy(Thread thread, Throwable th) {
        Log.e(f35009a, "doCrashStrategy", th);
        closeApp();
    }
}
