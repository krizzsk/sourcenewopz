package com.didi.common.map.util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class DynamicLayerApollo {

    /* renamed from: a */
    private static boolean f10946a = false;

    static {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("global_map_traffic_toggle_ab");
        if (toggle != null && toggle.allow() && (experiment = toggle.getExperiment()) != null) {
            boolean z = false;
            int intValue = ((Integer) experiment.getParam("isTreatment_group", 0)).intValue();
            DLog.m7384d("global_map_traffic_toggle_ab", "isTreatment_group" + intValue, new Object[0]);
            if (intValue == 1) {
                z = true;
            }
            f10946a = z;
        }
    }

    public static boolean isEnableHawaiiDynamicLayer() {
        return f10946a;
    }
}
