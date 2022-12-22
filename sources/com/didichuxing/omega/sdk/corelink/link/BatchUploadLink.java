package com.didichuxing.omega.sdk.corelink.link;

import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.corelink.node.EventCommonNode;

public class BatchUploadLink {
    public static void track(Event event, boolean z) {
        EventCommonNode.track(event, z);
    }
}
