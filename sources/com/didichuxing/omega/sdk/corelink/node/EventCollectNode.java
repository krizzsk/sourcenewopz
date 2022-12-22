package com.didichuxing.omega.sdk.corelink.node;

import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.Event;
import java.util.List;

public class EventCollectNode {
    private static int eventCount;
    private static String filename;

    static void collectEvent(List<Event> list, Event event) {
        if (eventCount == 0 || !EventMMKVLocalizeNode.isValid()) {
            String recordName = EventRecordNameNode.getRecordName();
            filename = recordName;
            EventConsumerQueueNode.addTempRecordKey(recordName);
            EventMMKVLocalizeNode.create(filename);
        }
        if (event != null) {
            EventMMKVLocalizeNode.save(event);
        }
        if (OmegaConfig.DEBUG_MODEL && list != null && list.size() > 0) {
            for (Event save : list) {
                EventMMKVLocalizeNode.save(save);
            }
        }
        int i = eventCount + 1;
        eventCount = i;
        if (i >= OmegaConfig.EVENT_SEND_QUEUE_MAX_NUMBER || OmegaConfig.DEBUG_MODEL) {
            EventMMKVLocalizeNode.close();
            eventCount = 0;
            EventConsumerQueueNode.addRecordKey(filename);
            EventConsumerQueueNode.removeTempMkKey(filename);
            EventConsumerQueueNode.notifySend();
        }
    }
}
