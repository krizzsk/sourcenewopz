package com.didi.component.business.util;

import com.didi.component.common.util.GLog;
import com.didi.reactive.tracker.EventTracker;
import com.didi.sdk.app.BusinessContext;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class GlobalOmegaUtils {
    public static void setOmegaDebugMode(boolean z) {
        OmegaSDK.setDebugModel(z);
    }

    public static void trackEvent(String str) {
        GLog.m7964d("trackEvent:" + str);
        m7707a(str, (String) null, (Map<String, Object>) null);
    }

    public static void trackEvent(String str, String str2) {
        GLog.m7964d("trackEvent:" + str);
        m7707a(str, str2, (Map<String, Object>) null);
    }

    public static void trackEvent(String str, String str2, Map<String, Object> map) {
        GLog.m7964d("trackEvent:" + str);
        m7707a(str, str2, map);
    }

    /* renamed from: a */
    private static void m7707a(String str, String str2, Map<String, Object> map) {
        if (EventTracker.isInitialized()) {
            EventTracker.trackEvent(str, map);
        } else {
            OmegaSDKAdapter.trackEvent(str, str2, map);
        }
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        GLog.m7964d("trackEvent:" + str);
        m7707a(str, (String) null, map);
    }

    public static void trackEvent(String str, String str2, String str3) {
        GLog.m7964d("trackEvent:" + str + ",key=" + str2 + ",value=" + str3);
        HashMap hashMap = new HashMap();
        hashMap.put(str2, str3);
        m7707a(str, (String) null, hashMap);
    }

    public static void putGlobal(String str, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("putGlobal:");
        sb.append(str);
        sb.append(", value: ");
        sb.append(obj != null ? obj.toString() : " is null");
        GLog.m7964d(sb.toString());
        OmegaSDK.putGlobalKV(str, obj);
    }

    public static void removeGlobal(String str) {
        GLog.m7964d("removeGlobal:" + str);
        OmegaSDK.removeGlobalKV(str);
    }

    public static void startSession() {
        OmegaSDK.startSession();
    }

    public static void stopSession() {
        OmegaSDK.stopSession();
    }

    public static void setBusinessId(BusinessContext businessContext) {
        putGlobal("g_BizId", BusinessDataUtil.getProductId());
    }

    public static void setOrderType(int i) {
        putGlobal("order_type", Integer.valueOf(i));
    }

    public static void removeOrderType() {
        removeGlobal("order_type");
    }

    public static void sendOrderParamsEstimateNull() {
        removeGlobal("send_order_params_estimate_null");
    }
}
