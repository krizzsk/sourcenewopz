package com.didi.foundation.sdk.utils;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;

public class AppUtil {
    public static String getMetaData(Application application, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = SystemUtils.getApplicationInfo(application.getPackageManager(), application.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return bundle.getString(str);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
