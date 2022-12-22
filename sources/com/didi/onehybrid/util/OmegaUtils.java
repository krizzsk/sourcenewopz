package com.didi.onehybrid.util;

import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public final class OmegaUtils {
    public static void offline_error(String str) {
        SystemUtils.log(3, "offline_http_length", str, (Throwable) null, "com.didi.onehybrid.util.OmegaUtils", 17);
        HashMap hashMap = new HashMap();
        hashMap.put("msg", str);
        OmegaSDKAdapter.trackEvent("offline_bundle_error", (Map<String, Object>) hashMap);
    }

    public static void offline_http_length(String str, int i) {
        SystemUtils.log(3, "offline_http_length", i + "", (Throwable) null, "com.didi.onehybrid.util.OmegaUtils", 26);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("length", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("offline_http_length", (Map<String, Object>) hashMap);
    }

    public static void offline_download_isSuccess(String str, boolean z, int i, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("isSuccess", Boolean.valueOf(z));
        hashMap.put("code", Integer.valueOf(i));
        hashMap.put("time", Long.valueOf(System.currentTimeMillis() - j));
        SystemUtils.log(3, "offline_download_time", z + " " + i + " " + j, (Throwable) null, "com.didi.onehybrid.util.OmegaUtils", 39);
        OmegaSDKAdapter.trackEvent("offline_download_time", (Map<String, Object>) hashMap);
    }

    public static void offline_update(boolean z, String str) {
        SystemUtils.log(3, "offline_update", str, (Throwable) null, "com.didi.onehybrid.util.OmegaUtils", 45);
        HashMap hashMap = new HashMap();
        hashMap.put("error", str);
        hashMap.put("isSucess", Boolean.valueOf(z));
        OmegaSDKAdapter.trackEvent("offline_update", (Map<String, Object>) hashMap);
    }

    public static void offline_url(String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("isOffline", Boolean.valueOf(z));
        OmegaSDKAdapter.trackEvent("offline_url", (Map<String, Object>) hashMap);
    }
}
