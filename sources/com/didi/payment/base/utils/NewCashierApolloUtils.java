package com.didi.payment.base.utils;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class NewCashierApolloUtils {
    public static boolean useNewCashier() {
        IToggle toggle = Apollo.getToggle("global_didipay_new_sdk");
        if (toggle == null || !toggle.allow() || !toggle.allow() || ((Integer) toggle.getExperiment().getParam("new", 1)).intValue() != 1) {
            return false;
        }
        return true;
    }
}
