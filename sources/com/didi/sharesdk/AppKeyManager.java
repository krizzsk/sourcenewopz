package com.didi.sharesdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sdk.apm.SystemUtils;

public class AppKeyManager {
    private static final AppKeyManager INSTANCE = new AppKeyManager();

    public static AppKeyManager getManager() {
        return INSTANCE;
    }

    public String getKey(Context context, SharePlatform sharePlatform) {
        try {
            Bundle bundle = SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData;
            return bundle.getString(sharePlatform.platformName() + ".ApplicationId");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized String getAppName(Context context) {
        String string;
        synchronized (AppKeyManager.class) {
            try {
                string = context.getResources().getString(SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).applicationInfo.labelRes);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return string;
    }
}
