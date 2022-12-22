package com.didi.sdk.audiorecorder.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.Iterator;
import java.util.List;

public class ProcessUtil {
    public static boolean isTargetProcess(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> list;
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
        if (activityManager == null) {
            LogUtil.log("Failed to judge isTargetProcess(AMS is null)");
            return false;
        }
        String str2 = null;
        try {
            list = activityManager.getRunningAppProcesses();
        } catch (Exception unused) {
            list = null;
        }
        if (list == null || list.isEmpty()) {
            LogUtil.log("Failed to judge isTargetProcess (empty runningAppProcesses)");
            return false;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.pid == myPid) {
                str2 = next.processName;
                break;
            }
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        return true;
    }
}
