package com.didi.dynamic.manager.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Process;
import com.didi.dynamic.manager.Module;
import com.didi.dynamic.manager.utils.SharedPreferencesWrapper;
import com.didi.sdk.apm.SystemUtils;
import java.util.List;

public class DownloadUtil {

    /* renamed from: a */
    private static final String f19352a = "dynamicDm";

    public static void setRequestTime(Context context, long j) {
        SharedPreferencesWrapper.Editor edit = SharedPreferencesWrapper.m14516of(context, f19352a, 0).edit();
        edit.putLong("dm_r_time", j);
        edit.apply();
    }

    public static long getRequestTime(Context context) {
        return SharedPreferencesWrapper.m14516of(context, f19352a, 0).getLong("dm_r_time", 0);
    }

    public static String getVersionName(Context context) {
        try {
            return SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            Log.m14494w("System.err", (Throwable) e);
            return "";
        }
    }

    public static String getVersionNameAndCode(Context context) {
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            return str + "_" + i;
        } catch (Exception e) {
            Log.m14494w("System.err", (Throwable) e);
            return "";
        }
    }

    public static boolean isMainProcess(Context context) {
        return context.getPackageName().equals(getProcessNameByPid(context, Process.myPid()));
    }

    public static String getProcessNameByPid(Context context, int i) {
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return null;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (i == next.pid) {
                    return next.processName;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void setDownloadPluginFailedReportFlag(Context context, Module module, boolean z) {
        if (isMainProcess(context)) {
            SharedPreferencesWrapper.Editor edit = SharedPreferencesWrapper.m14516of(context, f19352a, 0).edit();
            edit.putBoolean("dm_failed_report_" + module.moduleCode + "_" + module.version, z);
            edit.apply();
        }
    }

    public static boolean getDownloadPluginFailedReportFlag(Context context, Module module) {
        SharedPreferencesWrapper of = SharedPreferencesWrapper.m14516of(context, f19352a, 0);
        return of.getBoolean("dm_failed_report_" + module.moduleCode + "_" + module.version, false);
    }

    public static void setDownloadPluginSuccessReportFlag(Context context, Module module, boolean z) {
        if (isMainProcess(context)) {
            SharedPreferencesWrapper.Editor edit = SharedPreferencesWrapper.m14516of(context, f19352a, 0).edit();
            edit.putBoolean("dm_success_report_" + module.moduleCode + "_" + module.version, z);
            edit.apply();
        }
    }

    public static boolean getDownloadPluginSuccessReportFlag(Context context, Module module) {
        SharedPreferencesWrapper of = SharedPreferencesWrapper.m14516of(context, f19352a, 0);
        return of.getBoolean("dm_success_report_" + module.moduleCode + "_" + module.version, false);
    }

    public static void setUUID(Context context, String str) {
        if (isMainProcess(context)) {
            SharedPreferencesWrapper.Editor edit = SharedPreferencesWrapper.m14516of(context, f19352a, 0).edit();
            edit.putString("dm_uuid", str);
            edit.commitNow();
        }
    }

    public static String getUUID(Context context) {
        return SharedPreferencesWrapper.m14516of(context, f19352a, 0).getString("dm_uuid", "");
    }
}
