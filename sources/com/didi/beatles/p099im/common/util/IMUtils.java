package com.didi.beatles.p099im.common.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import java.util.List;

/* renamed from: com.didi.beatles.im.common.util.IMUtils */
public class IMUtils {

    /* renamed from: a */
    private static long f9160a = 0;

    /* renamed from: b */
    private static long f9161b = 400;

    public static byte[] base64Encode(byte[] bArr) {
        return Base64.encode(bArr, 0);
    }

    public static byte[] base64Decode(byte[] bArr) {
        return Base64.decode(bArr, 0);
    }

    public static boolean isRunningForeground(Context context) {
        String packageName = context.getPackageName();
        String topActivityPackegeName = getTopActivityPackegeName(context);
        if (!TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(topActivityPackegeName)) {
            return topActivityPackegeName.equals(packageName);
        }
        return false;
    }

    public static String getTopActivityPackegeName(Context context) {
        ComponentName componentName;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null) {
            return null;
        }
        return componentName.getPackageName();
    }

    public static boolean getTopActivity(Activity activity, Class cls) {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) activity.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks == null || !runningTasks.get(0).topActivity.getClassName().equals(cls.getName())) {
            return false;
        }
        return true;
    }

    public static boolean isActivityInRunningList(Context context, Class cls) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(Integer.MAX_VALUE)) {
            if (runningTaskInfo.topActivity.getClassName().equals(cls.getName())) {
                return true;
            }
        }
        return false;
    }

    public static String getModel() {
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f9160a;
        if (0 < j && j < f9161b) {
            return true;
        }
        f9160a = currentTimeMillis;
        return false;
    }

    public static boolean isAppForeground() {
        try {
            Context context = IMCommonContextInfoHelper.getContext();
            if (context != null) {
                return isRunningForeground(context);
            }
            return false;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
