package com.didichuxing.mas.sdk.quality.collect.lag.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.didichuxing.mas.sdk.quality.collect.lag.BlockCanaryInternals;
import java.util.List;

public class ProcessUtils {

    /* renamed from: a */
    private static volatile String f48148a;

    /* renamed from: b */
    private static final Object f48149b = new Object();

    private ProcessUtils() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static String myProcessName() {
        if (f48148a != null) {
            return f48148a;
        }
        synchronized (f48149b) {
            if (f48148a != null) {
                String str = f48148a;
                return str;
            }
            f48148a = m34333a(BlockCanaryInternals.getContext().provideContext());
            String str2 = f48148a;
            return str2;
        }
    }

    /* renamed from: a */
    private static String m34333a(Context context) {
        int myPid = Process.myPid();
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                    if (next != null && next.pid == myPid) {
                        return next.processName;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
