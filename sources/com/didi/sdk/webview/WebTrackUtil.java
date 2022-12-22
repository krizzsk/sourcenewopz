package com.didi.sdk.webview;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class WebTrackUtil {
    public static void trackError(int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_code", Integer.valueOf(i));
        hashMap.put("description", str);
        hashMap.put("failing_url", str2);
        OmegaSDKAdapter.trackEvent("tech_ibt_h5_load_error", (Map<String, Object>) hashMap);
    }
}
