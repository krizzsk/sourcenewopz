package com.didi.drouter.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;

public class SystemUtil {

    /* renamed from: a */
    private static Application f19276a;

    /* renamed from: b */
    private static String f19277b;

    public static Application getApplication() {
        return f19276a;
    }

    public static void setApplication(Application application) {
        if (application != null) {
            f19276a = application;
        }
    }

    public static String getProcessName() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (!TextUtils.isEmpty(f19277b)) {
            return f19277b;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            f19277b = Application.getProcessName();
        } else {
            try {
                f19277b = (String) Class.forName("android.app.ActivityThread").getDeclaredMethod(Build.VERSION.SDK_INT >= 18 ? "currentProcessName" : "currentPackageName", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception e) {
                SystemUtils.log(6, RouterLogger.NAME, "getProcessName exception: " + e.getMessage(), (Throwable) null, "com.didi.drouter.utils.SystemUtil", 60);
            }
        }
        if (!TextUtils.isEmpty(f19277b)) {
            return f19277b;
        }
        try {
            Application context = DRouter.getContext();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (!(activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null)) {
                for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                    if (next.pid == Process.myPid()) {
                        String str = next.processName;
                        f19277b = str;
                        return str;
                    }
                }
            }
            f19277b = context.getPackageName();
        } catch (Exception e2) {
            SystemUtils.log(6, RouterLogger.NAME, "getProcessName exception: " + e2.getMessage(), (Throwable) null, "com.didi.drouter.utils.SystemUtil", 83);
        }
        return f19277b;
    }

    public static String getAppName() {
        try {
            return DRouter.getContext().getString(DRouter.getContext().getApplicationInfo().labelRes);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0012, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String getPackageName() {
        /*
            java.lang.Class<com.didi.drouter.utils.SystemUtil> r0 = com.didi.drouter.utils.SystemUtil.class
            monitor-enter(r0)
            android.app.Application r1 = com.didi.drouter.api.DRouter.getContext()     // Catch:{ Exception -> 0x0010, all -> 0x000d }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x0010, all -> 0x000d }
            monitor-exit(r0)
            return r1
        L_0x000d:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0010:
            r1 = 0
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.drouter.utils.SystemUtil.getPackageName():java.lang.String");
    }
}
