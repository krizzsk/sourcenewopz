package com.didi.global.ninja.utils;

import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class TrackEvent {
    public static void trackHit(String str, boolean z) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("key", str);
        hashMap.put("is_hit", Integer.valueOf(z ? 1 : 0));
        OmegaSDKAdapter.trackEvent("tech_ninja_protect_hit", (Map<String, Object>) hashMap);
    }

    public static void trackResume(String str) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("key", str);
        OmegaSDKAdapter.trackEvent("tech_ninja_protect_resume", (Map<String, Object>) hashMap);
    }
}
