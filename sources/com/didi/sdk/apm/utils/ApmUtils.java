package com.didi.sdk.apm.utils;

import android.app.ActivityManager;
import android.content.Context;
import com.didichuxing.omega.sdk.Omega;
import java.util.List;

public class ApmUtils {
    public static boolean isAppForeground(Context context) {
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (runningTasks != null) {
                if (!runningTasks.isEmpty()) {
                    return runningTasks.get(0).topActivity.getPackageName().equals(context.getPackageName());
                }
            }
            return false;
        } catch (Throwable th) {
            Omega.trackError("AppForeground", th);
            return false;
        }
    }
}
