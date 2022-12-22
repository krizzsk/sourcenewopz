package com.didi.sofa.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.lang.reflect.Field;
import java.util.List;

public abstract class ProcessUtils {
    public static boolean isBackground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.processName.equals(context.getPackageName())) {
                if (next.importance != 100) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static boolean isRunningInForeground(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return LollipopRunningProcessCompat.isRunningInForeground(context);
        }
        return RunningProcessCompat.isRunningInForeground(context);
    }

    public static boolean isMainProcess(Context context) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
                return false;
            }
            int myPid = Process.myPid();
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (packageName.equals(next.processName)) {
                    if (myPid == next.pid) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private ProcessUtils() {
    }

    private static class RunningProcessCompat {
        private RunningProcessCompat() {
        }

        public static boolean isRunningInForeground(Context context) {
            try {
                List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
                if (runningTasks != null) {
                    if (!runningTasks.isEmpty()) {
                        return runningTasks.get(0).topActivity.getPackageName().equals(context.getPackageName());
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
    }

    private static final class LollipopRunningProcessCompat extends RunningProcessCompat {
        private LollipopRunningProcessCompat() {
            super();
        }

        public static boolean isRunningInForeground(Context context) {
            try {
                Field declaredField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    if (!runningAppProcesses.isEmpty()) {
                        String packageName = context.getPackageName();
                        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                            if (next.importance == 100 && next.importanceReasonCode == 0) {
                                try {
                                    Integer valueOf = Integer.valueOf(declaredField.getInt(next));
                                    if (valueOf != null && valueOf.intValue() == 2 && next.pkgList != null && next.pkgList.length > 0) {
                                        return next.pkgList[0].equals(packageName);
                                    }
                                } catch (Exception unused) {
                                    continue;
                                }
                            }
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            return false;
        }
    }
}
