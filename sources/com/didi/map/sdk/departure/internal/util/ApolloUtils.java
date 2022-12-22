package com.didi.map.sdk.departure.internal.util;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloUtils {

    /* renamed from: a */
    private static final String f28237a = "Name_pickup_point_global";

    /* renamed from: b */
    private static final String f28238b = "global_passenger_pin_need_adsorb_control";

    /* renamed from: c */
    private static final String f28239c = "vamos_departure_move_distance_limit";

    public static boolean isNeedAdsorbControlEnabled() {
        IToggle toggle = Apollo.getToggle(f28238b);
        if (!toggle.allow() || ((Integer) toggle.getExperiment().getParam("enable", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static int getNeedAdsorbControlMaxDistance() {
        IToggle toggle = Apollo.getToggle(f28238b);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("maxDistance", 10)).intValue();
        }
        return 10;
    }

    public static float getNeedAdsorbControlPercentage() {
        IToggle toggle = Apollo.getToggle(f28238b);
        if (toggle.allow()) {
            String str = (String) toggle.getExperiment().getParam("AdditionalPercentage", "0.05");
            if (!TextUtils.isEmpty(str)) {
                return Float.parseFloat(str);
            }
        }
        return 0.05f;
    }

    public static int getMoveDistanceLimit() {
        IToggle toggle = Apollo.getToggle(f28239c);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("distance", -1)).intValue();
        }
        return -1;
    }

    public static boolean getRecommendNameDisStrategy() {
        Apollo.getToggle(f28237a).allow();
        return true;
    }
}
