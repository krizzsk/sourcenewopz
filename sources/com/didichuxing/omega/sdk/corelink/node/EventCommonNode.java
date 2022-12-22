package com.didichuxing.omega.sdk.corelink.node;

import com.didichuxing.omega.sdk.analysis.EventSendQueue;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.threadpool.ThreadTaskObject;

public class EventCommonNode {
    public static void track(final Event event, boolean z) {
        if (OmegaConfig.SWITCH_OMEGA_TRACKER_NEWEDITION) {
            EventProduceQueueNode.add(event);
            return;
        }
        C160061 r0 = new Runnable() {
            public void run() {
                EventSendQueue.add(event);
            }
        };
        if (z) {
            r0.run();
        } else {
            ThreadTaskObject.execute(r0);
        }
    }
}
