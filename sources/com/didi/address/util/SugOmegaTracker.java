package com.didi.address.util;

import com.didi.map.global.model.omega.GlobalOmegaTracker;
import java.util.HashMap;

public class SugOmegaTracker {
    public static void trackRecCacheFallback(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("cache_list_len", Integer.valueOf(i));
        GlobalOmegaTracker.trackEvent("map_rec_cache_fallback", hashMap);
    }
}
