package com.didi.sdk.apm.crash;

import android.text.TextUtils;
import android.util.Log;

public class PendingResultFinishInterceptor extends CrashInterceptor {

    /* renamed from: a */
    private static final String f35006a = "PendingResultFinishInterceptor";

    public boolean intercept(Thread thread, Throwable th) {
        try {
            if (!TextUtils.equals(thread.getName(), "queued-work-looper") || !(th instanceof IllegalStateException) || !isMatchSpecialExceptionMsg(th, "Broadcast already finished")) {
                return false;
            }
            Log.e(f35006a, "PendingResult#finish must be call once,after Hook PendingResult#finish may called several times, so catch this error!");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void doCrashStrategy(Thread thread, Throwable th) {
        Log.e(f35006a, "doCrashStrategy", th);
    }
}
