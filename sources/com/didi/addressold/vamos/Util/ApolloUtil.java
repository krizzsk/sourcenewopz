package com.didi.addressold.vamos.Util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloUtil {
    public static int SUG_SEARCH_INTERVAL = 500;
    public static boolean mShowCurrentLocationByPoiInfo = false;

    public static void initSugSearchInternalTime() {
        IToggle toggle = Apollo.getToggle("passenger_global_text_search_interval_time_test");
        if (toggle.allow()) {
            int intValue = ((Integer) toggle.getExperiment().getParam("interval_time", Integer.valueOf(SUG_SEARCH_INTERVAL))).intValue();
            SUG_SEARCH_INTERVAL = intValue;
            if (intValue < 500) {
                SUG_SEARCH_INTERVAL = 500;
            }
        }
    }
}
