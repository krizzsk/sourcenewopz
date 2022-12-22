package com.didichuxing.omega.sdk.corelink.link;

import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.corelink.check.SeqCheckUtil;
import com.didichuxing.omega.sdk.corelink.node.EventAttrsFilterNode;
import com.didichuxing.omega.sdk.corelink.node.EventFilterNode;
import com.didichuxing.omega.sdk.corelink.node.EventGlobalAttrsNode;
import com.didichuxing.omega.sdk.corelink.node.EventSampleNode;
import com.didichuxing.omega.sdk.corelink.node.EventSeqNode;
import com.didichuxing.omega.sdk.corelink.node.EventSpecialNode;

public class CommonUploadLink {
    public static void track(Event event, float f) {
        String eventId = event.getEventId();
        if ((OmegaConfig.DEBUG_MODEL || !EventFilterNode.filter(event)) && !EventSpecialNode.filterS(event)) {
            boolean filterR = EventSpecialNode.filterR(event);
            EventSpecialNode.filterP(event);
            if (f >= 1.0f || EventSampleNode.isSampled(eventId, f)) {
                EventGlobalAttrsNode.addGlobalAttrs(event);
                EventAttrsFilterNode.attrsFilter(event);
                SeqCheckUtil.addEvent(event);
                EventSeqNode.addSeq(event);
                if (OmegaConfig.DEBUG_MODEL) {
                    DebugUploadLink.track(event, filterR);
                } else {
                    BatchUploadLink.track(event, filterR);
                }
                if (filterR) {
                    RealTimeUploadLink.track(event);
                }
            }
        }
    }
}
