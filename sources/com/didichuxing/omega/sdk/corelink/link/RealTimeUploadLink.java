package com.didichuxing.omega.sdk.corelink.link;

import com.didichuxing.omega.sdk.analysis.EventRealtimeQueue;
import com.didichuxing.omega.sdk.common.record.Event;

public class RealTimeUploadLink {
    public static void track(Event event) {
        EventRealtimeQueue.add(event);
    }
}
