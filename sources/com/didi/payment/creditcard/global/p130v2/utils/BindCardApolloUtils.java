package com.didi.payment.creditcard.global.p130v2.utils;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;

/* renamed from: com.didi.payment.creditcard.global.v2.utils.BindCardApolloUtils */
public class BindCardApolloUtils {
    public static boolean useNewVersion() {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle("Card_binding_Rides");
        if (toggle == null || !toggle.allow() || (experiment = toggle.getExperiment()) == null || ((Integer) experiment.getParam("newstyle", 0)).intValue() != 1) {
            return false;
        }
        return true;
    }
}
