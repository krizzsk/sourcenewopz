package com.didichuxing.omega.sdk.corelink.node;

import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.record.Event;
import java.util.Map;

public class EventGlobalAttrsNode {
    public static void addGlobalAttrs(Event event) {
        Map<String, Object> globalAttrs = Tracker.getGlobalAttrs();
        if (globalAttrs != null) {
            event.putAllAttrs(globalAttrs);
        }
    }
}
