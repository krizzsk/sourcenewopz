package com.didichuxing.omega.sdk.analysis;

import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.backend.BackendThread;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.perforence.RuntimeCheck;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.record.EventsRecord;
import com.didichuxing.omega.sdk.common.record.RecordFactory;
import com.didichuxing.omega.sdk.common.record.RecordStorage;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EventSendQueue {
    private static Queue<Event> eventQueue = new ConcurrentLinkedQueue();
    private static long maxSeq = 0;
    private static long minSeq = 0;

    public static void add(Event event) {
        eventQueue.add(event);
        long seq = event.getSeq();
        long j = minSeq;
        if (j == 0 || seq < j) {
            minSeq = seq;
        }
        long j2 = maxSeq;
        if (j2 == 0 || seq > j2) {
            maxSeq = seq;
        }
        if (!OmegaConfig.DEBUG_MODEL) {
            if (OmegaConfig.SWITCH_EVENT_PERSISTENT) {
                EventPersistentQueue.add(event);
            }
            if (eventQueue.size() >= OmegaConfig.EVENT_SEND_QUEUE_MAX_NUMBER) {
                sendAsyn();
            }
        }
    }

    public static int size() {
        return eventQueue.size();
    }

    public static void send() {
        EventsRecord dumpRecord = dumpRecord();
        if (dumpRecord != null) {
            RecordStorage.save(dumpRecord);
        }
    }

    public static void sendAsyn() {
        BackendThread.getInstance().wakeup();
    }

    public static synchronized EventsRecord dumpRecord() {
        List<Event> andSyncWithSendQueue;
        synchronized (EventSendQueue.class) {
            if (eventQueue.isEmpty()) {
                return null;
            }
            EventsRecord createEventsRecord = RecordFactory.createEventsRecord();
            createEventsRecord.put("seq", PersistentInfoCollector.getRecordSeqSync("s_seq"));
            Iterator it = eventQueue.iterator();
            while (it.hasNext()) {
                createEventsRecord.addEvent((Event) it.next());
                it.remove();
            }
            if (OmegaConfig.SWITCH_EVENT_PERSISTENT && !OmegaConfig.DEBUG_MODEL && (andSyncWithSendQueue = EventPersistentQueue.getAndSyncWithSendQueue(minSeq, maxSeq)) != null && andSyncWithSendQueue.size() > 0) {
                createEventsRecord.addAllEvents(andSyncWithSendQueue);
            }
            PersistentInfoCollector.saveLastSendEventSeq(RuntimeCheck.getProcessNameInMD5(), maxSeq);
            return createEventsRecord;
        }
    }

    public static void clear() {
        eventQueue.clear();
    }
}
