package com.didi.map.sdk.navtracker;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class TrackerOmegaUtil {
    public static final int CODE_CONTEXT_NULL = 105;
    public static final int CODE_COUNTRY_CODE_NULL = 107;
    public static final int CODE_EXCEPTION = 104;
    public static final int CODE_LOGIC_ERROR = 101;
    public static final int CODE_RESULT_NULL = 102;
    public static final int CODE_THREAD_POOL_NULL = 106;

    public static void trackOraFail(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_code", Integer.valueOf(i));
        hashMap.put("error_msg", "");
        OmegaSDKAdapter.trackEvent("tech_google_map_track_ora_fail", (Map<String, Object>) hashMap);
    }

    public static void trackOraFailWithMsg(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_code", Integer.valueOf(i));
        hashMap.put("error_msg", str);
        OmegaSDKAdapter.trackEvent("tech_google_map_track_ora_fail", (Map<String, Object>) hashMap);
    }
}
