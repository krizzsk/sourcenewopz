package com.didi.map.global.component.driveromega;

import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GlobalDriverOmega {

    /* renamed from: a */
    private static final String f25426a = "GlobalDriverOmega";

    /* renamed from: b */
    private static IGlobalDriverCommonOmegaFactory f25427b;

    /* renamed from: c */
    private static Set<String> f25428c = new HashSet();

    /* renamed from: d */
    private static String[] f25429d = {"map_d_locallightnavi_receivefailed_sw", "gd_raw_distance_res", "global_nav_night_mode_change", "map_start_fullnav_error_status", "map_driver_touch_count", "com_map_wlwlj", "com_map_wldzphsb_sw", "com_map_lxghsb", "gd_modeset_destnation_sug_home_ck", "google_map_usage", "map_global_driver_google_autoback", "map_d_didimap_tuneup_sw", "map_ck", "map_drag", "map_dblck", "map_pinchout", "map_pinchin", "map_dblFingerck", "map_pas_location_for_driv_sw"};

    public static void setFactory(IGlobalDriverCommonOmegaFactory iGlobalDriverCommonOmegaFactory) {
        f25427b = iGlobalDriverCommonOmegaFactory;
        DLog.m7384d(f25426a, " update factory: " + iGlobalDriverCommonOmegaFactory, new Object[0]);
    }

    public static IGlobalDriverCommonOmegaFactory getOmegaFactory() {
        return f25427b;
    }

    static {
        IToggle toggle = Apollo.getToggle("global_map_driver_deprecated_omega_toggle");
        if (toggle.allow()) {
            try {
                IExperiment experiment = toggle.getExperiment();
                if (experiment != null) {
                    for (String str : f25429d) {
                        if (((Integer) experiment.getParam(str, 0)).intValue() == 0) {
                            f25428c.add(str);
                        }
                    }
                }
            } catch (Exception e) {
                DLog.m7384d(f25426a, "static exc: " + e.getMessage(), new Object[0]);
            }
        }
    }

    public static void trackEvent(String str) {
        trackEvent(str, (Map<String, Object>) null);
    }

    public static void trackEvent(String str, Map<String, Object> map) {
        trackEvent(str, map, false);
    }

    public static void trackEvent(String str, Map<String, Object> map, boolean z) {
        IGlobalDriverCommonOmegaFactory iGlobalDriverCommonOmegaFactory;
        Set<String> set = f25428c;
        if (set == null || !set.contains(str)) {
            if (z && (iGlobalDriverCommonOmegaFactory = f25427b) != null) {
                iGlobalDriverCommonOmegaFactory.appendCommonParams(map);
            }
            OmegaSDKAdapter.trackEvent(str, map);
            return;
        }
        DLog.m7384d(f25426a, str + " is obsolete", new Object[0]);
    }
}
