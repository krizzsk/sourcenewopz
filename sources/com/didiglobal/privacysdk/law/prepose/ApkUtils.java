package com.didiglobal.privacysdk.law.prepose;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;

public class ApkUtils {
    public static String getAppName(Context context) {
        try {
            return context.getResources().getString(SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
