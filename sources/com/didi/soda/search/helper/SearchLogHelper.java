package com.didi.soda.search.helper;

import com.didi.soda.customer.foundation.log.RecordTracker;
import java.util.HashMap;

public class SearchLogHelper {

    /* renamed from: a */
    private static final String f43765a = "SearchLogHelper";

    public static void info(String str, String str2) {
        RecordTracker.Builder.create().setTag(str).setLogModule("m-search|").setMessage(str2).build().info();
    }

    public static void setLogTracker(String str, String str2, HashMap<String, Object> hashMap) {
        RecordTracker.Builder logCategory = RecordTracker.Builder.create().setTag(f43765a).setLogModule("m-search|").setMessage(str).setLogCategory(str2);
        for (String next : hashMap.keySet()) {
            logCategory.setOtherParam(next, hashMap.get(next));
        }
        logCategory.build().info();
    }
}
