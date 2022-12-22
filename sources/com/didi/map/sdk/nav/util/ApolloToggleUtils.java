package com.didi.map.sdk.nav.util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public final class ApolloToggleUtils {
    public static boolean isMockOnlineEvaluateEnabled() {
        IToggle toggle = Apollo.getToggle("global_sctx_mock_online_evaluate");
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static boolean is3DCarEnabled() {
        return Apollo.getToggle("global_passenger_sctx_3d_car_toggle").allow();
    }

    public static int get3DCarHeightInterval() {
        IToggle toggle = Apollo.getToggle("global_passenger_sctx_3d_car_toggle");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("height_interval", 20)).intValue();
        }
        return 20;
    }
}
