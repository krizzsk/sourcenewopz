package com.didichuxing.alpha.lag.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.didichuxing.alpha.lag.BlockCanaryInternals;
import java.util.List;

public class ProcessUtils {
    private static final Object sNameLock = new Object();
    private static volatile String sProcessName;

    private ProcessUtils() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static String myProcessName() {
        if (sProcessName != null) {
            return sProcessName;
        }
        synchronized (sNameLock) {
            if (sProcessName != null) {
                String str = sProcessName;
                return str;
            }
            sProcessName = obtainProcessName(BlockCanaryInternals.getContext().provideContext());
            String str2 = sProcessName;
            return str2;
        }
    }

    private static String obtainProcessName(Context context) {
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
