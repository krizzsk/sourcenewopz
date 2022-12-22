package com.sdk.poibase.util;

import com.didi.map.global.model.omega.GlobalOmegaTracker;
import java.util.HashMap;

public class OmegaUtil {
    public static void trackLocTrackCount(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put("app_version", str);
        hashMap.put("loc_count:", Integer.valueOf(i));
        GlobalOmegaTracker.trackEvent("global_passenger_poiinfo_loc_trck", hashMap);
    }
}
