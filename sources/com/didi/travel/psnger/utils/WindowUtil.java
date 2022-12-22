package com.didi.travel.psnger.utils;

import android.app.ActivityManager;
import android.content.Context;
import com.didi.sdk.util.SystemUtil;
import com.didi.travel.psnger.AppLifecycleManager;

public class WindowUtil {
    public static String getScreenPixels() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(SystemUtil.getScreenWidth());
        stringBuffer.append("*");
        stringBuffer.append(SystemUtil.getScreenHeight());
        return stringBuffer.toString();
    }

    public static String getTopActivityName(Context context) {
        try {
            return ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isAppFront(Context context) {
        return AppLifecycleManager.getInstance().isAppFront();
    }
}
