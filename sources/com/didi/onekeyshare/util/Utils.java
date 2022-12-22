package com.didi.onekeyshare.util;

import android.content.Context;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.util.Contants;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class Utils {

    public static class PlatformWrapInfo {
        public String packageName = "";
        public String unInstallToast = "";
    }

    public static boolean isAppInstalled(Context context, String str) {
        try {
            SystemUtils.getPackageInfo(context.getPackageManager(), str, 16384);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static PlatformWrapInfo getPlatformWrapInfo(Context context, SharePlatform sharePlatform) {
        PlatformWrapInfo platformWrapInfo = new PlatformWrapInfo();
        if (sharePlatform == SharePlatform.MESSENGER_PLATFORM) {
            platformWrapInfo.packageName = "com.facebook.orca";
            platformWrapInfo.unInstallToast = context.getResources().getString(R.string.tip_messsenger_not_install);
        } else if (sharePlatform == SharePlatform.WHATSAPP_PLATFORM) {
            platformWrapInfo.packageName = "com.whatsapp";
            platformWrapInfo.unInstallToast = context.getResources().getString(R.string.tip_whatsapp_not_install);
        } else if (sharePlatform == SharePlatform.LINE_PLATFORM) {
            platformWrapInfo.packageName = Contants.SHARE_INTENT_PACKAGE_NAME.PACKAGE_NAME_LINE;
            platformWrapInfo.unInstallToast = context.getResources().getString(R.string.tip_line_not_install);
        } else if (sharePlatform == SharePlatform.TWITTER_PLATFORM) {
            platformWrapInfo.packageName = Contants.SHARE_INTENT_PACKAGE_NAME.PACKAGE_NAME_TWITTER;
            platformWrapInfo.unInstallToast = context.getResources().getString(R.string.tip_twitter_not_install);
        }
        return platformWrapInfo;
    }
}
