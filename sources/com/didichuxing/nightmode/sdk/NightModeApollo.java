package com.didichuxing.nightmode.sdk;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

class NightModeApollo {
    NightModeApollo() {
    }

    static int getTimeOffsetInMinutes() {
        IToggle toggle = Apollo.getToggle("global_night_mode_timeoffset");
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("android", 30)).intValue();
        }
        return 30;
    }
}
