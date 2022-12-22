package com.didi.travel.psnger.utils;

import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class OmegaUtils {
    public static void setOmegaDebugMode(boolean z) {
        OmegaSDK.setDebugModel(z);
    }

    public static void trackEvent(String str) {
        LogUtil.m31426d("trackEvent:" + str);
        OmegaSDKAdapter.trackEvent(str);
    }

    public static void trackEvent(String str, String str2) {
        LogUtil.m31426d("trackEvent:" + str);
        OmegaSDKAdapter.trackEvent(str, str2);
    }

    public static void trackEvent(String str, String str2, Map<String, Object> map) {
        LogUtil.m31426d("trackEvent:" + str);
        OmegaSDKAdapter.trackEvent(str, str2, map);
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        LogUtil.m31426d("trackEvent:" + str);
        OmegaSDKAdapter.trackEvent(str, map);
    }

    public static void trackEvent(String str, String str2, String str3) {
        LogUtil.m31426d("trackEvent:" + str);
        HashMap hashMap = new HashMap();
        hashMap.put(str2, str3);
        OmegaSDKAdapter.trackEvent(str, "", hashMap);
    }

    public static void putGlobal(String str, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("putGlobal:");
        sb.append(str);
        sb.append(", value: ");
        sb.append(obj != null ? obj.toString() : " is null");
        LogUtil.m31426d(sb.toString());
        OmegaSDK.putGlobalKV(str, obj);
    }

    public static void removeGlobal(String str) {
        LogUtil.m31426d("removeGlobal:" + str);
        OmegaSDK.removeGlobalKV(str);
    }

    public static void startSession() {
        OmegaSDK.startSession();
    }

    public static void stopSession() {
        OmegaSDK.stopSession();
    }
}
