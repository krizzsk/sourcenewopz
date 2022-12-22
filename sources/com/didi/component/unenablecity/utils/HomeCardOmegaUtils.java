package com.didi.component.unenablecity.utils;

import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.GLog;
import java.util.HashMap;
import java.util.Map;

public class HomeCardOmegaUtils {
    public static final String CARD_ID_EDU = "edu_mandatory";
    public static final String CARD_ID_ORDER_BAN = "account_suspended";
    public static final String CARD_ID_UNOPEN_CITY = "city_unavailable";

    /* renamed from: a */
    private static final String f16213a = "ibt_gp_home_unavailablecard_sw";

    /* renamed from: b */
    private static final String f16214b = "ibt_gp_home_unavailablecard_ck";

    /* renamed from: c */
    private static final String f16215c = "card_id";

    public static void sendUnableCityCardSw(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("card_id", str);
        GlobalOmegaUtils.trackEvent(f16213a, (Map<String, Object>) hashMap);
        GLog.m7965d("FormOptionsOmegaUtil", "sendUnableCityCardSw " + str);
    }

    public static void sendUnableCityCardCk(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("card_id", str);
        GlobalOmegaUtils.trackEvent(f16214b, (Map<String, Object>) hashMap);
        GLog.m7965d("FormOptionsOmegaUtil", "sendUnableCityCardSw " + str);
    }
}
