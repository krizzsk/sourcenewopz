package com.didi.soda.home.topgun.manager;

import com.didi.soda.customer.foundation.log.RecordTracker;
import java.util.HashMap;

public class HomeLogTrackerHelper {

    /* renamed from: a */
    private static final String f42993a = "HomeLogTrackerHelper";

    public static void setLogTracker(String str, String str2) {
        RecordTracker.Builder.create().setTag(f42993a).setLogModule("m-home|").setMessage(str).setLogCategory(str2).build().info();
    }

    public static void setLogTracker(String str, String str2, HashMap<String, Object> hashMap) {
        RecordTracker.Builder logCategory = RecordTracker.Builder.create().setTag(f42993a).setLogModule("m-home|").setMessage(str).setLogCategory(str2);
        for (String next : hashMap.keySet()) {
            logCategory.setOtherParam(next, hashMap.get(next));
        }
        logCategory.build().info();
    }
}
