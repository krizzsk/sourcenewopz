package com.didi.map;

import android.os.SystemClock;
import com.didi.map.constant.OmegaEventConstant;
import com.didi.map.outer.model.LatLng;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class MapOmegaUtil {
    public static final String HW_SETSCALE_EXCEPTION = "map_setScale_exception";
    public static final String OMEGA_GL_EXCEPTION_HAPPEN = "gl_exception_happen";
    public static final String OMEGA_NAVIGATION_LOAD_LIB = "map_navigation_load_lib_status";
    public static final String OMEGA_SURFACE_CHANGED_TIMEOUT = "omega_surface_changed_timeout";
    public static final String OMEGA_TRACK_ABIS = "hawaii_abis_statistics";
    public static final String OMEGA_TRACK_MAP_CLICK = "map_icon_click";
    public static final String OMEGA_TRACK_MAP_GUARD = "map_guard_check";

    /* renamed from: a */
    private static final String f24442a = "hawaii_fly_line_check";

    private MapOmegaUtil() {
    }

    public static void trackEvent(String str) {
        OmegaSDKAdapter.trackEvent(str);
    }

    public static void trackEvent(String str, String str2) {
        OmegaSDKAdapter.trackEvent(str, str2);
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        OmegaSDKAdapter.trackEvent(str, map);
    }

    public static void trackEvent(String str, String str2, Map<String, Object> map) {
        OmegaSDKAdapter.trackEvent(str, str2, map);
    }

    public static void trackGLThread(HashMap hashMap) {
        OmegaSDKAdapter.trackEvent(OmegaEventConstant.HAWA_MAP_GLTHREAD_MONITOR, (Map<String, Object>) hashMap);
    }

    public static void flyLineCheck(long j, LatLng latLng, LatLng latLng2) {
        HashMap hashMap = new HashMap();
        hashMap.put("routeId", Long.valueOf(j));
        hashMap.put("start_point", latLng.toString());
        hashMap.put("end_point", latLng2.toString());
        trackEvent(f24442a, (Map<String, Object>) hashMap);
    }

    public static void trackLoadSoStatusInfo(String str, String str2, String str3) {
        if (MapApolloHawaii.isTrackInLoadLib()) {
            HashMap hashMap = new HashMap();
            hashMap.put("soName", str);
            hashMap.put("loadLocation", str2);
            hashMap.put("status", str3);
            OmegaSDKAdapter.trackEvent(OMEGA_NAVIGATION_LOAD_LIB, (Map<String, Object>) hashMap);
        }
    }

    public static void trackMapGuard(int i, int i2, int i3, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("crashNumMax", Integer.valueOf(i));
        hashMap.put("timeMax", Integer.valueOf(i2));
        hashMap.put("timeFirst", Integer.valueOf(i3));
        int i4 = 1;
        if (!z) {
            i4 = 0;
        }
        hashMap.put("isNeedProject", Integer.valueOf(i4));
        trackEvent(OMEGA_TRACK_MAP_GUARD, (Map<String, Object>) hashMap);
    }

    public static void surfaceChangedTimeout(Long l) {
        HashMap hashMap = new HashMap();
        hashMap.put("time", l);
        trackEvent(OMEGA_SURFACE_CHANGED_TIMEOUT, (Map<String, Object>) hashMap);
    }

    public static void trackMapIconClick(int i, int i2) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(str);
        sb.append(SystemClock.uptimeMillis());
        hashMap.put("timeStamp", sb.toString());
        hashMap.put("type", Integer.valueOf(i));
        if (i2 != -1) {
            str = "{ \"incident_id\":\"" + i2 + "\"}";
        }
        hashMap.put("param", str);
        trackEvent(OMEGA_TRACK_MAP_CLICK, (Map<String, Object>) hashMap);
    }

    public static void glExceptionHappen(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("exception_msg", str);
        trackEvent(OMEGA_GL_EXCEPTION_HAPPEN, (Map<String, Object>) hashMap);
    }

    public static void trackSetScaleException(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("exception", str);
        OmegaSDKAdapter.trackEvent(HW_SETSCALE_EXCEPTION, (Map<String, Object>) hashMap);
    }
}
