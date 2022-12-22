package com.didichuxing.security.challenge.track;

import android.content.Context;
import com.didi.security.device.PhoneTokenManager;
import com.didi.security.wireless.adapter.SecurityWrapper;
import com.didichuxing.security.challenge.BuildConfig;
import com.didichuxing.security.challenge.bean.ClgResponse;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class ClgTracker {
    public static final String EVENT_RECIVED = "pub_challenge_recived_bt";
    public static final String EVENT_RESULT = "pub_challenge_result_bt";
    public static final String EVENT_TEST = "pub_challenge_test_failed_bt";

    public static void track(Context context, String str, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("app_name", WsgSecInfo.packageName(context));
        map.put("app_version", WsgSecInfo.appVersionName(context));
        map.put("sdk_version", BuildConfig.VERSION_NAME);
        String str2 = null;
        try {
            str2 = PhoneTokenManager.getInstance().getDeviceId();
        } catch (Throwable unused) {
        }
        map.put(SecurityWrapper.WSG_DID_KEY_NAME, str2);
        OmegaSDKAdapter.trackEvent(str, map);
    }

    public static void trackTest(Context context, boolean z, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? "success" : "failed");
        if (str == null) {
            str = "";
        }
        hashMap.put("failed_info", str);
        track(context, EVENT_TEST, hashMap);
    }

    public static void trackReceived(Context context, ClgResponse clgResponse) {
        HashMap hashMap = new HashMap();
        if (clgResponse != null) {
            hashMap.put("api", clgResponse.url);
            if (clgResponse.data != null) {
                hashMap.put("args", clgResponse.data.args);
                hashMap.put("ch_id", clgResponse.data.chid);
                hashMap.put("func", clgResponse.data.func);
            }
        }
        track(context, EVENT_RECIVED, hashMap);
    }

    public static void trackResult(Context context, boolean z, String str, ClgResponse clgResponse, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", z ? "success" : "failed");
        if (str == null) {
            str = "";
        }
        hashMap.put("info", str);
        if (clgResponse != null) {
            hashMap.put("api", clgResponse.url);
            if (clgResponse.data != null) {
                hashMap.put("args", clgResponse.data.args);
                hashMap.put("ch_id", clgResponse.data.chid);
                hashMap.put("func", clgResponse.data.func);
            }
        }
        hashMap.put("time", Long.valueOf(j));
        track(context, EVENT_RESULT, hashMap);
    }

    public static void trackWafError(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("api", str);
        hashMap.put("status", "failed");
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("info", str2);
        track(context, EVENT_RESULT, hashMap);
    }

    public static void trackGetFixPartError(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("status", "failed");
        if (str == null) {
            str = "";
        }
        hashMap.put("info", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("number", str2);
        track(context, EVENT_RESULT, hashMap);
    }
}
