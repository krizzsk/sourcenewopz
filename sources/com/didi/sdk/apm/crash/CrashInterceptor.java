package com.didi.sdk.apm.crash;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

public abstract class CrashInterceptor {

    /* renamed from: a */
    private static final String f34999a = "CrashInterceptor";

    public abstract void doCrashStrategy(Thread thread, Throwable th);

    public abstract boolean intercept(Thread thread, Throwable th);

    /* access modifiers changed from: protected */
    public boolean isMatchSpecialExceptionMsg(Throwable th, String str) {
        return th != null && !TextUtils.isEmpty(th.getMessage()) && th.getMessage().contains(str);
    }

    /* access modifiers changed from: protected */
    public boolean isMatchSpecialStackTraceElement(Throwable th, String str, String str2) {
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        if (TextUtils.equals(str, stackTraceElement.getClassName()) && TextUtils.equals(str2, stackTraceElement.getMethodName())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isMatchSpecialCauseStackTraceElement(Throwable th, String str, String str2) {
        try {
            StackTraceElement[] stackTrace = th.getCause().getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        if (TextUtils.equals(str, stackTraceElement.getClassName()) && TextUtils.equals(str2, stackTraceElement.getMethodName())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isMatchSpecialStackTraceElementByRegex(Throwable th, String str, String str2) {
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        if (TextUtils.equals(str, stackTraceElement.getClassName()) && Pattern.matches(str2, stackTraceElement.getMethodName())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void closeApp() {
        Log.d(f34999a, "close app!");
        Process.killProcess(Process.myPid());
        System.exit(0);
    }
}
