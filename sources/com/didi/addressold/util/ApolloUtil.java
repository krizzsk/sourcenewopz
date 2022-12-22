package com.didi.addressold.util;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

public class ApolloUtil {
    public static int SUG_SEARCH_INTERVAL = 500;
    public static boolean mDefaultStartUseReconmmend = true;
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

    public static boolean isHideInputMethod() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("android_passenger_global_sug_rec_ab");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null || ((Integer) experiment.getParam("isRecABTest", 0)).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static int getRecPageOptimizationParam() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("RecPage_Optimization_Test");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null) {
            return 0;
        }
        return ((Integer) experiment.getParam("allow_param", 0)).intValue();
    }

    public static boolean canSelectAddressByDragged() {
        int recPageOptimizationParam = getRecPageOptimizationParam();
        return true;
    }
}
