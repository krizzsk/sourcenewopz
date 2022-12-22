package com.didi.travel.psnger.bff;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class BffUtils {
    public static boolean isBffStageNewFifth() {
        IToggle toggle = Apollo.getToggle("global_bff_passenger_newFifth_period_toggle");
        return toggle != null && toggle.allow();
    }
}
