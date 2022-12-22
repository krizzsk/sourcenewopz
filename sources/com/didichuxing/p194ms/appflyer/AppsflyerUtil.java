package com.didichuxing.p194ms.appflyer;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import java.util.HashMap;

/* renamed from: com.didichuxing.ms.appflyer.AppsflyerUtil */
public class AppsflyerUtil {
    private static final String APPSFLYER_CAMPAIGN_ID = "appsflyer_campaign_id";
    private static final String APPSFLYER_CAMPAIGN_NAME = "appsflyer_campaign_name";
    private static final String APPSFLYER_DEBUGGABLE = "appsflyer_debuggable";
    private static final String APPSFLYER_PREINSTALL_ENABLE = "appsflyer_preinstall_enable";
    private static final String DEFAULT_CAMPAIGN_ID = "DIDI";
    private static final String DEFAULT_CAMPAIGN_NAME = "Preinstall";
    private static HashMap<String, String> sHashMapMetaDataMap = new HashMap<>();

    public static boolean getAppsFlyerDebuggable(Application application) {
        try {
            return Boolean.valueOf(getMetaDataByKey(application, APPSFLYER_DEBUGGABLE)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean getPreinstallEnable(Application application) {
        try {
            return Boolean.valueOf(getMetaDataByKey(application, APPSFLYER_PREINSTALL_ENABLE)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getAppsFlyerCampaignName(Application application) {
        String metaDataByKey = getMetaDataByKey(application, APPSFLYER_CAMPAIGN_NAME);
        return TextUtils.isEmpty(metaDataByKey) ? DEFAULT_CAMPAIGN_NAME : metaDataByKey;
    }

    public static String getAppsFlyerCampaignId(Application application) {
        String metaDataByKey = getMetaDataByKey(application, APPSFLYER_CAMPAIGN_ID);
        return TextUtils.isEmpty(metaDataByKey) ? DEFAULT_CAMPAIGN_ID : metaDataByKey;
    }

    private static String getMetaDataByKey(Application application, String str) {
        Object obj;
        if (!TextUtils.isEmpty(sHashMapMetaDataMap.get(str))) {
            return sHashMapMetaDataMap.get(str);
        }
        String str2 = "";
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(application.getPackageManager(), application.getPackageName(), 16512);
            if (!(packageInfo.applicationInfo == null || packageInfo.applicationInfo.metaData == null || (obj = packageInfo.applicationInfo.metaData.get(str)) == null)) {
                str2 = obj.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sHashMapMetaDataMap.put(str, str2);
        return str2;
    }
}
