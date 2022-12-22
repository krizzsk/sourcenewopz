package com.didi.component.groupform.utils;

import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.GLog;
import java.util.HashMap;
import java.util.Map;

public class GroupFormOmegaUtil {

    /* renamed from: a */
    private static final String f14051a = "gp_carconfirm_expandBtn_ck";

    /* renamed from: b */
    private static final String f14052b = "payment";

    /* renamed from: c */
    private static final String f14053c = "trace_id";

    /* renamed from: d */
    private static final String f14054d = "bubble_id";

    /* renamed from: e */
    private static final String f14055e = "rides";

    /* renamed from: f */
    private static final String f14056f = "dispatch_fee";

    /* renamed from: g */
    private static final String f14057g = "departure_time";

    /* renamed from: h */
    private static final String f14058h = "is_accessible_car";

    public static void sendFormOptionsClick(String str, String str2, String str3, int i, String str4, String str5, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("trace_id", str);
        hashMap.put("bubble_id", str2);
        hashMap.put("payment", str3);
        hashMap.put(f14055e, Integer.valueOf(i));
        hashMap.put("dispatch_fee", str4);
        hashMap.put("departure_time", str5);
        hashMap.put(f14058h, Integer.valueOf(i2));
        GlobalOmegaUtils.trackEvent(f14051a, (Map<String, Object>) hashMap);
        GLog.m7965d("GroupFormOmegaUtil", "sendFormOptionsClick " + str + "," + str2);
    }
}
