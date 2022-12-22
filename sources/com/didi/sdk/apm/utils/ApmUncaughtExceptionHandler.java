package com.didi.sdk.apm.utils;

import android.util.Log;
import com.didi.sdk.apm.crash.CrashInterceptor;
import com.didi.sdk.apm.crash.DeadObjectExceptionByStorageManagerInterceptor;
import com.didi.sdk.apm.crash.DeadSystemExceptionInterceptor;
import com.didi.sdk.apm.crash.FailureFromSystemMInterceptor;
import com.didi.sdk.apm.crash.FinalizerWatchdogDaemonInterceptor;
import com.didi.sdk.apm.crash.JobIntentServiceExceptionInterceptor;
import com.didi.sdk.apm.crash.PackageManagerDiedInterceptor;
import com.didi.sdk.apm.crash.PendingResultFinishInterceptor;
import com.didi.sdk.apm.crash.ReportSizeConfigurationInterceptor;
import com.didi.sdk.apm.crash.SecurityExceptionInterceptor;
import com.didi.sdk.apm.crash.WindowManagerBadTokenExceptionInterceptor;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

public class ApmUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private static final String f35054a = "ApmUncaughtExceptionHandler";

    /* renamed from: b */
    private static Thread.UncaughtExceptionHandler f35055b;

    /* renamed from: c */
    private static final List<CrashInterceptor> f35056c;

    static {
        ArrayList arrayList = new ArrayList();
        f35056c = arrayList;
        arrayList.add(new FinalizerWatchdogDaemonInterceptor());
        f35056c.add(new PendingResultFinishInterceptor());
        f35056c.add(new FailureFromSystemMInterceptor());
        f35056c.add(new ReportSizeConfigurationInterceptor());
        f35056c.add(new DeadObjectExceptionByStorageManagerInterceptor());
        f35056c.add(new WindowManagerBadTokenExceptionInterceptor());
        f35056c.add(new PackageManagerDiedInterceptor());
        f35056c.add(new DeadSystemExceptionInterceptor());
        f35056c.add(new SecurityExceptionInterceptor());
        f35056c.add(new JobIntentServiceExceptionInterceptor());
    }

    public void uncaughtException(Thread thread, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("uncaughtException and Thread is :");
        sb.append(thread);
        Log.e(f35054a, sb.toString() != null ? thread.toString() : "", th);
        for (CrashInterceptor next : f35056c) {
            if (next != null && next.intercept(thread, th)) {
                next.doCrashStrategy(thread, th);
                return;
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = f35055b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public static void init() {
        f35055b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new ApmUncaughtExceptionHandler());
    }
}
