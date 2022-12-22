package com.didi.sdk.onehotpatch.commonstatic.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.didi.dynamic.manager.utils.DownloadUtil;
import com.didi.dynamic.manager.utils.Log;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.List;

public class UtilsHub {
    private static final int PROCESS_STATE_FOREGROUND = 1;
    private static final int PROCESS_STATE_NOT_FOUND = 0;
    private static final int PROCESS_STATE_OTHER = 2;
    private static String currentProcessName;
    private static String currentVersionName;
    private static Boolean isMainProcess;

    public static String getVersionNameAndCode(Context context) {
        try {
            String appVersionName = WsgSecInfo.appVersionName(context);
            int appVersionCode = WsgSecInfo.appVersionCode(context);
            return appVersionName + "_" + appVersionCode;
        } catch (Exception e) {
            Logger.warn(e);
            return "";
        }
    }

    public static String getVersionName(Context context) {
        try {
            if (currentVersionName != null) {
                return currentVersionName;
            }
            String appVersionName = WsgSecInfo.appVersionName(context);
            currentVersionName = appVersionName;
            return appVersionName;
        } catch (Exception e) {
            Logger.warn(e);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e A[SYNTHETIC, Splitter:B:24:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0049 A[Catch:{ IOException -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0054 A[SYNTHETIC, Splitter:B:34:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005f A[Catch:{ IOException -> 0x005b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getAppRandom(android.content.Context r4) {
        /*
            r0 = 0
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ IOException -> 0x0035, all -> 0x0032 }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0035, all -> 0x0032 }
            r1.<init>()     // Catch:{ IOException -> 0x0035, all -> 0x0032 }
            java.lang.String r2 = "hotpatch_random_matching_verify.txt"
            java.io.InputStream r0 = r4.open(r2)     // Catch:{ IOException -> 0x002d, all -> 0x0028 }
            org.apache.commons.p071io.IOUtils.copy((java.io.InputStream) r0, (java.io.OutputStream) r1)     // Catch:{ IOException -> 0x002d, all -> 0x0028 }
            java.lang.String r4 = r1.toString()     // Catch:{ IOException -> 0x002d, all -> 0x0028 }
            r1.flush()     // Catch:{ IOException -> 0x0023 }
            r1.close()     // Catch:{ IOException -> 0x0023 }
            if (r0 == 0) goto L_0x0027
            r0.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0027:
            return r4
        L_0x0028:
            r4 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x0052
        L_0x002d:
            r4 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L_0x0037
        L_0x0032:
            r4 = move-exception
            r1 = r0
            goto L_0x0052
        L_0x0035:
            r4 = move-exception
            r1 = r0
        L_0x0037:
            r4.printStackTrace()     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = ""
            if (r0 == 0) goto L_0x0047
            r0.flush()     // Catch:{ IOException -> 0x0045 }
            r0.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0047
        L_0x0045:
            r0 = move-exception
            goto L_0x004d
        L_0x0047:
            if (r1 == 0) goto L_0x0050
            r1.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0050
        L_0x004d:
            r0.printStackTrace()
        L_0x0050:
            return r4
        L_0x0051:
            r4 = move-exception
        L_0x0052:
            if (r0 == 0) goto L_0x005d
            r0.flush()     // Catch:{ IOException -> 0x005b }
            r0.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x005d
        L_0x005b:
            r0 = move-exception
            goto L_0x0063
        L_0x005d:
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ IOException -> 0x005b }
            goto L_0x0066
        L_0x0063:
            r0.printStackTrace()
        L_0x0066:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.commonstatic.util.UtilsHub.getAppRandom(android.content.Context):java.lang.String");
    }

    public static boolean isMainProcess(Context context) {
        Boolean bool = isMainProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        currentProcessName = DownloadUtil.getProcessNameByPid(context, Process.myPid());
        Boolean valueOf = Boolean.valueOf(WsgSecInfo.packageName(context).equals(currentProcessName));
        isMainProcess = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean isForegroundProcess(Context context) {
        return getProcessState(context, currentProcessName) == 1;
    }

    private static int getProcessState(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return 0;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (TextUtils.equals(next.processName, str)) {
                    if (next.importance != 100) {
                        return 2;
                    }
                    try {
                        if (((Integer) ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState").get(next)).intValue() <= 2) {
                            return 1;
                        }
                        return 2;
                    } catch (Throwable unused) {
                    }
                }
            }
            return 0;
        } catch (Throwable th) {
            Logger.warn(th);
        }
    }

    public static String dumpException(Throwable th) {
        if (th == null) {
            return "Throwable is null";
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        } catch (Throwable unused) {
            return Log.getStackTraceString(th);
        }
    }

    public static String getProcessName(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            return invoke instanceof String ? (String) invoke : "";
        } catch (Throwable unused) {
            return DownloadUtil.getProcessNameByPid(context, Process.myPid());
        }
    }
}
