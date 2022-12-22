package com.didi.component.payentrance.utils;

import com.didi.component.business.util.GlobalOmegaUtils;

public class GlobalPayEntranceEventManager {
    public static final String KEY_PAS_UNPAIDCARD_FARE_CK = "pas_unpaidcard_fare_ck";

    public static void doEvent(String str) {
        GlobalOmegaUtils.trackEvent(str);
    }
}
