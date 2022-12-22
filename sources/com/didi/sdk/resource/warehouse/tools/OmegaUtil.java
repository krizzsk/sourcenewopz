package com.didi.sdk.resource.warehouse.tools;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class OmegaUtil {
    public static void event(String str, Map<String, Object> map) {
        OmegaSDKAdapter.trackEvent(str, "", map);
    }

    public static void downloadUrlEvent(String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("retry_time", Integer.valueOf(i));
        event("tech_performance_online_image_download", hashMap);
    }

    public static void downloadUrlSuccessEvent(String str, int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("retry_time", Integer.valueOf(i));
        hashMap.put("spend_time", Long.valueOf(j));
        event("tech_performance_online_image_download_success", hashMap);
    }

    public static void downloadUrlFailEvent(String str, int i, long j, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("retry_time", Integer.valueOf(i));
        hashMap.put("spend_time", Long.valueOf(j));
        hashMap.put("exception", str2);
        event("tech_performance_online_image_download_fail", hashMap);
    }

    public static void loadUrlEvent(String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("is_cache", Integer.valueOf(z ? 1 : 0));
        event("tech_performance_online_image_load", hashMap);
    }

    public static void loadUrlIfNeedDownloadSuccessEvent(String str, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("spend_time", Long.valueOf(j));
        event("tech_performance_online_image_load_success", hashMap);
    }

    public static void loadUrlIfNeedDownloadFailEvent(String str, long j, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("spend_time", Long.valueOf(j));
        hashMap.put("exception", str2);
        event("tech_performance_online_image_load_fail", hashMap);
    }
}
