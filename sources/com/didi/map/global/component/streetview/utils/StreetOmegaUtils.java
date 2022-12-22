package com.didi.map.global.component.streetview.utils;

import android.text.TextUtils;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didi.map.sdk.env.PaxEnvironment;
import java.util.HashMap;

public class StreetOmegaUtils {
    public static void onStreetViewLoadTimeout(String str) {
        if (str != null && !str.equals("")) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str);
            hashMap.put("user_id", PaxEnvironment.getInstance().getUid());
            hashMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
            GlobalOmegaTracker.trackEvent("map_streetview_netovertime_sw", hashMap);
        }
    }

    public static void streetCheckNetworkTime(String str, int i) {
        if (str != null && !str.equals("")) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str);
            hashMap.put("user_id", PaxEnvironment.getInstance().getUid());
            hashMap.put("seconds", Double.valueOf(((double) i) / 1000.0d));
            GlobalOmegaTracker.trackEvent("map_streetview_checktime_en", hashMap);
        }
    }

    public static void streetViewLoadTime(String str, int i) {
        if (str != null && !str.equals("")) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", str);
            hashMap.put("user_id", PaxEnvironment.getInstance().getUid());
            hashMap.put("seconds", Double.valueOf(((double) i) / 1000.0d));
            GlobalOmegaTracker.trackEvent("map_streetview_loadtime_en", hashMap);
        }
    }

    public static void onStreetViewFeedConfirmClick(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_no", str);
        if (TextUtils.isEmpty(str2)) {
            str2 = "unknown";
        }
        hashMap.put("orderid", str2);
        GlobalOmegaTracker.trackEvent("ibt_gp_mapfromaddresserror_confirm_ck", hashMap);
    }

    public static void onStreetViewToFeedbackPageClick(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            str = "unknown";
        }
        hashMap.put("orderid", str);
        GlobalOmegaTracker.trackEvent("ibt_gp_mapfromaddressscene_error_ck", hashMap);
    }
}
