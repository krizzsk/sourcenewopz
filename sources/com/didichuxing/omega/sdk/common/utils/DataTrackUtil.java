package com.didichuxing.omega.sdk.common.utils;

import com.didichuxing.omega.sdk.analysis.EventSendQueue;
import com.didichuxing.omega.sdk.analysis.Tracker;
import java.util.HashMap;

public class DataTrackUtil {

    public enum EventType {
        CRASH,
        ANR,
        NATIVE_CRASH,
        LAG
    }

    public static void trackDataEvent(EventType eventType, String str, boolean z) {
        String str2;
        if (eventType == EventType.CRASH) {
            str2 = "omg_crash_event";
        } else if (eventType == EventType.ANR) {
            str2 = "omg_anr_event";
        } else if (eventType == EventType.NATIVE_CRASH) {
            str2 = "omg_native_crash_event";
        } else {
            str2 = eventType == EventType.LAG ? "omg_lag_event" : null;
        }
        if (str2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("rid", str);
            hashMap.put("limit", Integer.valueOf(z ? 1 : 0));
            Tracker.trackEvent(str2, (String) null, hashMap);
            EventSendQueue.send();
        }
    }
}
