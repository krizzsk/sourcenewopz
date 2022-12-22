package com.didi.unifiedPay.util;

import com.didichuxing.foundation.net.http.HttpHeader;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class OmegaUtils {

    /* renamed from: a */
    private static final String f44600a = OmegaUtils.class.getSimpleName();

    public static void setOmegaDebugMode(boolean z) {
        OmegaSDK.setDebugModel(z);
    }

    public static void trackEvent(String str) {
        String str2 = f44600a;
        LogUtil.m31684d(str2, "trackEvent:" + str);
        OmegaSDKAdapter.trackEvent(str);
    }

    public static void trackEvent(String str, String str2) {
        String str3 = f44600a;
        LogUtil.m31684d(str3, "trackEvent:" + str);
        OmegaSDKAdapter.trackEvent(str, str2);
    }

    public static void trackEvent(String str, String str2, Map<String, Object> map) {
        String str3 = f44600a;
        LogUtil.m31684d(str3, "trackEvent:" + str);
        OmegaSDKAdapter.trackEvent(str, str2, map);
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        String str2 = f44600a;
        LogUtil.m31684d(str2, "trackEvent:" + str);
        OmegaSDKAdapter.trackEvent(str, map);
    }

    public static void trackEvent(String str, String str2, String str3) {
        String str4 = f44600a;
        LogUtil.m31684d(str4, "trackEvent:" + str);
        HashMap hashMap = new HashMap();
        hashMap.put(str2, str3);
        OmegaSDKAdapter.trackEvent(str, "", hashMap);
    }

    public static void putGlobal(String str, Object obj) {
        String str2 = f44600a;
        StringBuilder sb = new StringBuilder();
        sb.append("putGlobal:");
        sb.append(str);
        sb.append(", value: ");
        sb.append(obj != null ? obj.toString() : " is null");
        LogUtil.m31684d(str2, sb.toString());
        OmegaSDK.putGlobalKV(str, obj);
    }

    public static void removeGlobal(String str) {
        String str2 = f44600a;
        LogUtil.m31684d(str2, "removeGlobal:" + str);
        OmegaSDK.removeGlobalKV(str);
    }

    public static void startSession() {
        OmegaSDK.startSession();
    }

    public static void stopSession() {
        OmegaSDK.stopSession();
    }

    public static String getHeader(List<HttpHeader> list, String str) {
        if (!(list == null || list.size() == 0)) {
            ListIterator<HttpHeader> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                HttpHeader previous = listIterator.previous();
                if (previous.getName() != null && previous.getName().equalsIgnoreCase(str)) {
                    return previous.getValue();
                }
            }
        }
        return "";
    }
}
