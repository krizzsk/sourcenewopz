package com.didichuxing.omega.sdk.corelink;

import android.content.Context;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.didichuxing.omega.sdk.corelink.check.SecurityCheckUtil;
import com.didichuxing.omega.sdk.corelink.check.SeqCheckUtil;
import com.didichuxing.omega.sdk.corelink.link.CommonUploadLink;
import com.didichuxing.omega.sdk.corelink.node.EventConsumerQueueNode;
import com.didichuxing.omega.sdk.corelink.node.EventProduceQueueNode;
import com.didichuxing.omega.sdk.corelink.node.EventRecordPathNode;
import com.didichuxing.omega.sdk.corelink.node.EventSendNode;

public class LinkManager {
    public static void init(Context context) {
        EventRecordPathNode.init(context);
        EventConsumerQueueNode.init();
        SeqCheckUtil.init();
        EventProduceQueueNode.init(context);
        EventSendNode.getInstance();
        SecurityCheckUtil.init(context);
    }

    public static void track(Event event, float f) {
        if (OmegaConfig.IS_INIT && OmegaConfig.SWITCH_EVENT) {
            if (event == null || event.getEventId() == null || event.getEventId().length() == 0) {
                OLog.m34763e("trackEvent fail! event is null.");
                return;
            }
            SecurityCheckUtil.addEvent(event);
            CommonUploadLink.track(event, f);
        }
    }
}
