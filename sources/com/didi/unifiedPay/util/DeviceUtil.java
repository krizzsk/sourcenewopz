package com.didi.unifiedPay.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Process;
import java.net.URLDecoder;
import java.util.List;

public class DeviceUtil {
    public static String getPackageName(Context context) {
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return "";
    }

    public static boolean isSchemeSupport(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setData(Uri.parse(URLDecoder.decode(str)));
            intent.setAction("android.intent.action.VIEW");
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            LogUtil.m31684d("isSchemeSupport", e.toString());
            return false;
        }
    }
}
