package com.didichuxing.mas.sdk.quality.report.perforence;

import android.content.ContentResolver;
import android.content.Context;
import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;

public class RuntimeCheck {
    private static Context sContext = null;
    private static boolean s_bIsMainProcess = false;
    private static String s_processName = "";
    private static String s_processNameInMD5 = "";

    public static void init(Context context) {
        sContext = context;
        try {
            String processName = getProcessName(context);
            s_processName = processName;
            if (processName.equals(context.getApplicationContext().getPackageName())) {
                s_bIsMainProcess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static ContentResolver getContentResolver() {
        Context context = sContext;
        if (context != null) {
            return context.getApplicationContext().getContentResolver();
        }
        throw new NullPointerException("sContext is null.");
    }

    static void CheckProcess() {
        if (!s_bIsMainProcess) {
            throw new RuntimeException("Must Run In MAS Service Process");
        }
    }

    public static boolean IsMainProcess() {
        return s_bIsMainProcess;
    }

    public static String getProcessName() {
        return s_processName;
    }

    public static String getProcessNameInMD5() {
        if (!TextUtils.isEmpty(s_processNameInMD5)) {
            return s_processNameInMD5;
        }
        return CommonUtil.getMD5(s_processName);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0046 A[SYNTHETIC, Splitter:B:23:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0068 A[Catch:{ all -> 0x0075 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getProcessName(android.content.Context r5) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x003e }
            java.lang.String r2 = "/proc/self/cmdline"
            r1.<init>(r2)     // Catch:{ all -> 0x003e }
            boolean r2 = r1.isDirectory()     // Catch:{ all -> 0x003e }
            if (r2 != 0) goto L_0x0038
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x003e }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x003e }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x003e }
            r4.<init>(r1)     // Catch:{ all -> 0x003e }
            r3.<init>(r4)     // Catch:{ all -> 0x003e }
            r2.<init>(r3)     // Catch:{ all -> 0x003e }
            java.lang.String r0 = r2.readLine()     // Catch:{ all -> 0x0036 }
            java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x0036 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0034
            r2.close()     // Catch:{ Exception -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0033:
            return r0
        L_0x0034:
            r0 = r2
            goto L_0x0038
        L_0x0036:
            r0 = move-exception
            goto L_0x0041
        L_0x0038:
            if (r0 == 0) goto L_0x004e
            r0.close()     // Catch:{ Exception -> 0x004a }
            goto L_0x004e
        L_0x003e:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0041:
            r0.printStackTrace()     // Catch:{ all -> 0x0080 }
            if (r2 == 0) goto L_0x004e
            r2.close()     // Catch:{ Exception -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004e:
            int r0 = android.os.Process.myPid()     // Catch:{ all -> 0x0075 }
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r5.getSystemService(r1)     // Catch:{ all -> 0x0075 }
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch:{ all -> 0x0075 }
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch:{ all -> 0x0075 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0075 }
        L_0x0062:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0075 }
            if (r2 == 0) goto L_0x0079
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0075 }
            android.app.ActivityManager$RunningAppProcessInfo r2 = (android.app.ActivityManager.RunningAppProcessInfo) r2     // Catch:{ all -> 0x0075 }
            int r3 = r2.pid     // Catch:{ all -> 0x0075 }
            if (r3 != r0) goto L_0x0062
            java.lang.String r5 = r2.processName     // Catch:{ all -> 0x0075 }
            return r5
        L_0x0075:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0079:
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo()
            java.lang.String r5 = r5.processName
            return r5
        L_0x0080:
            r5 = move-exception
            if (r2 == 0) goto L_0x008b
            r2.close()     // Catch:{ Exception -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r0 = move-exception
            r0.printStackTrace()
        L_0x008b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.mas.sdk.quality.report.perforence.RuntimeCheck.getProcessName(android.content.Context):java.lang.String");
    }

    public static String getApplicationId() {
        return sContext.getPackageName();
    }
}
