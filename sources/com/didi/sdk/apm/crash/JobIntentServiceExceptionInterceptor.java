package com.didi.sdk.apm.crash;

import android.util.Log;

public class JobIntentServiceExceptionInterceptor extends CrashInterceptor {

    /* renamed from: a */
    private static final String f35004a = "JISExceptionInterceptor";

    public boolean intercept(Thread thread, Throwable th) {
        try {
            if (!(th instanceof RuntimeException) || !isMatchSpecialExceptionMsg(th, "An error occurred while executing doInBackground")) {
                return false;
            }
            Log.e(f35004a, "match An error occurred while executing doInBackground");
            if (isMatchSpecialCauseStackTraceElement(th, "android.app.job.JobParameters", "completeWork")) {
                Log.e(f35004a, "match androidx.core.app.JobIntentService1");
                return true;
            } else if (!isMatchSpecialCauseStackTraceElement(th, "android.app.job.JobParameters", "dequeueWork")) {
                return false;
            } else {
                Log.e(f35004a, "match androidx.core.app.JobIntentService2");
                return true;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public void doCrashStrategy(Thread thread, Throwable th) {
        Log.e(f35004a, "doCrashStrategy", th);
    }
}
