package com.didichuxing.foundation.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.lang.reflect.Field;
import java.util.List;

public abstract class ProcessUtil {
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

    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049 A[SYNTHETIC, Splitter:B:17:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f A[SYNTHETIC, Splitter:B:22:0x004f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getPackageName() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003f }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x003f }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003f }
            r4.<init>()     // Catch:{ Exception -> 0x003f }
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch:{ Exception -> 0x003f }
            int r5 = android.os.Process.myPid()     // Catch:{ Exception -> 0x003f }
            r4.append(r5)     // Catch:{ Exception -> 0x003f }
            java.lang.String r5 = "/cmdline"
            r4.append(r5)     // Catch:{ Exception -> 0x003f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x003f }
            r3.<init>(r4)     // Catch:{ Exception -> 0x003f }
            r2.<init>(r3)     // Catch:{ Exception -> 0x003f }
            r1.<init>(r2)     // Catch:{ Exception -> 0x003f }
            java.lang.String r0 = r1.readLine()     // Catch:{ Exception -> 0x0038, all -> 0x0036 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0038, all -> 0x0036 }
            r1.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0035:
            return r0
        L_0x0036:
            r0 = move-exception
            goto L_0x004d
        L_0x0038:
            r0 = r1
            goto L_0x003f
        L_0x003a:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x004d
        L_0x003f:
            int r1 = android.os.Process.myPid()     // Catch:{ all -> 0x003a }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x004c
            r0.close()     // Catch:{ IOException -> 0x004c }
        L_0x004c:
            return r1
        L_0x004d:
            if (r1 == 0) goto L_0x0052
            r1.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.foundation.util.ProcessUtil.getPackageName():java.lang.String");
    }

    private ProcessUtil() {
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
