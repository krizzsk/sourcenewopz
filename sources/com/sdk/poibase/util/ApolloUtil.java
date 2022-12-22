package com.sdk.poibase.util;

import android.content.Context;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloUtil {
    public static String getApolloDebugUrl(Context context) {
        IToggle toggle = Apollo.getToggle("android_passenger_global_sug_debug_url_global");
        if (!toggle.allow()) {
            return null;
        }
        if (Utils.isCanoeApp(context)) {
            return (String) toggle.getExperiment().getParam("global_canoe_sug_debug_url", "");
        }
        return (String) toggle.getExperiment().getParam("global_sug_debug_url", "");
    }
}
