package com.didi.map.global.component.myLocation.apollo;

import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloUtils {
    public static final String PASSENGER_LOCATION_ACCURACYCIRCLE_CONTROL = "global_accuracycircle_control";

    public static ApolloParamsAccuracyCircle getLocationAccuracyCircleArgs() {
        IToggle toggle = Apollo.getToggle(PASSENGER_LOCATION_ACCURACYCIRCLE_CONTROL);
        if (!toggle.allow()) {
            return null;
        }
        IExperiment experiment = toggle.getExperiment();
        ApolloParamsAccuracyCircle apolloParamsAccuracyCircle = new ApolloParamsAccuracyCircle(((Integer) experiment.getParam("enable", 0)).intValue(), ((Integer) experiment.getParam("minCircleRadius", 0)).intValue(), ((Integer) experiment.getParam("maxCircleRadius", 0)).intValue());
        DLog.m7384d("MapGlobalApolloUtils", "getLocationAccuracyCircle params=" + apolloParamsAccuracyCircle, new Object[0]);
        return apolloParamsAccuracyCircle;
    }
}
