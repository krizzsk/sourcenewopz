package com.dmap.navigation.engine.p207a;

import com.didi.map.MapOmegaUtil;
import com.didichuxing.omega.sdk.Omega;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.dmap.navigation.engine.a.r */
/* compiled from: OmegaUtil */
public final class C17407r {
    public static void trackLoadSoStatusInfo(String str, String str2, String str3) {
        if (C17406q.isTrackInLoadLib()) {
            HashMap hashMap = new HashMap();
            hashMap.put("soName", str);
            hashMap.put("loadLocation", str2);
            hashMap.put("status", str3);
            Omega.trackEvent(MapOmegaUtil.OMEGA_NAVIGATION_LOAD_LIB, (Map<String, Object>) hashMap);
        }
    }
}
