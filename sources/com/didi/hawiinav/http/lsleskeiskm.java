package com.didi.hawiinav.http;

import com.didi.map.constant.StringConstant;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class lsleskeiskm {
    private static final String HAWAII_ANDROID_TRACK_LOAD_LIB = "hawaii_android_track_load_lib";
    private static final String HAWAII_OMEGA_LOAD_LIB = "map_navigation_load_lib_status";
    private static final String HW_NAVI_USE_STATISTIC_MALLOC = "hawaii_use_statistic_malloc";

    public static native void navSetUseStatisticMalloc(boolean z, int i, int i2);

    public static native byte[] skciopqnmqwpdmc(byte[] bArr);

    public static native byte[] zcmsdlfljwpkssd(byte[] bArr);

    static {
        try {
            System.loadLibrary(StringConstant.LIB_NAV);
            setUseStatisticMalloc();
            trackLoadInfo("libhawiinav.so", "lsleskeiskm", "success");
        } catch (Throwable th) {
            th.printStackTrace();
            trackLoadInfo("libhawiinav.so", "lsleskeiskm", "failed");
        }
    }

    public static void setUseStatisticMalloc() {
        IToggle toggle = Apollo.getToggle(HW_NAVI_USE_STATISTIC_MALLOC);
        boolean allow = toggle.allow();
        int i = 50;
        int i2 = 0;
        if (allow) {
            IExperiment experiment = toggle.getExperiment();
            i2 = ((Integer) experiment.getParam("isUseDLMallocApollo", 0)).intValue();
            i = ((Integer) experiment.getParam("initSpaceSizeApollo", 50)).intValue();
        }
        navSetUseStatisticMalloc(allow, i2, i);
    }

    private static void trackLoadInfo(String str, String str2, String str3) {
        if (Apollo.getToggle(HAWAII_ANDROID_TRACK_LOAD_LIB).allow()) {
            HashMap hashMap = new HashMap();
            hashMap.put("soName", str);
            hashMap.put("loadLocation", str2);
            hashMap.put("status", str3);
            OmegaSDKAdapter.trackEvent("map_navigation_load_lib_status", (Map<String, Object>) hashMap);
        }
    }
}
