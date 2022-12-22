package com.didi.map.global.component.departure.apolllo;

import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class MapGlobalApolloUtils {
    public static ApolloParamsDeparture getDepartureApolloParams() {
        ApolloParamsDeparture apolloParamsDeparture = new ApolloParamsDeparture();
        apolloParamsDeparture.mNeedAdsorbMaxDistance = 10;
        apolloParamsDeparture.mNeedAdsorbPercentage = 0.05f;
        apolloParamsDeparture.mMoveDistanceLimit = -1;
        IToggle toggle = Apollo.getToggle("global_passenger_pin_need_adsorb_control");
        if (toggle.allow()) {
            boolean z = false;
            if (((Integer) toggle.getExperiment().getParam("enable", 0)).intValue() == 1) {
                z = true;
            }
            apolloParamsDeparture.isNeedAdsorbControlEnabled = z;
            apolloParamsDeparture.mNeedAdsorbMaxDistance = ((Integer) toggle.getExperiment().getParam("maxDistance", 10)).intValue();
            String str = (String) toggle.getExperiment().getParam("AdditionalPercentage", "0.05");
            if (!TextUtils.isEmpty(str)) {
                apolloParamsDeparture.mNeedAdsorbPercentage = Float.parseFloat(str);
            }
        }
        IToggle toggle2 = Apollo.getToggle("vamos_departure_move_distance_limit");
        if (toggle2.allow()) {
            apolloParamsDeparture.mMoveDistanceLimit = ((Integer) toggle2.getExperiment().getParam("distance", -1)).intValue();
        }
        return apolloParamsDeparture;
    }
}
