package com.didichuxing.omega.sdk.corelink.link;

import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.corelink.node.EventCommonNode;

public class DebugUploadLink {
    public static void track(Event event, boolean z) {
        EventCommonNode.track(event, z);
    }
}
