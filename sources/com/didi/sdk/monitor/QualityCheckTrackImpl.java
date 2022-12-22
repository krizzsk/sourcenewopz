package com.didi.sdk.monitor;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class QualityCheckTrackImpl extends AbsQualityCheckTrack {
    public static void trackError(String str, int i, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("m_tag", str);
        hashMap.put("m_scene", Integer.valueOf(i));
        if (map == null || map.isEmpty()) {
            hashMap.put("m_ext", "");
        } else {
            hashMap.put("m_ext", new Gson().toJson((Object) map));
        }
        OmegaSDKAdapter.trackEvent("ibt_monitor_scene_ck", (Map<String, Object>) hashMap);
    }
}
