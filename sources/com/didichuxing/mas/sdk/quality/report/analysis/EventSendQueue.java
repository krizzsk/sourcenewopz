package com.didichuxing.mas.sdk.quality.report.analysis;

import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.backend.BackendThread;
import com.didichuxing.mas.sdk.quality.report.collector.PersistentInfoCollector;
import com.didichuxing.mas.sdk.quality.report.perforence.RuntimeCheck;
import com.didichuxing.mas.sdk.quality.report.record.Event;
import com.didichuxing.mas.sdk.quality.report.record.EventsRecord;
import com.didichuxing.mas.sdk.quality.report.record.RecordFactory;
import com.didichuxing.mas.sdk.quality.report.record.RecordStorage;
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
        if (!MASConfig.DEBUG_MODEL) {
            if (MASConfig.SWITCH_EVENT_PERSISTENT) {
                EventPersistentQueue.add(event);
            }
            if (eventQueue.size() >= MASConfig.EVENT_SEND_QUEUE_MAX_NUMBER) {
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
            createEventsRecord.put("seq", PersistentInfoCollector.getRecordSeq("s_seq"));
            Iterator it = eventQueue.iterator();
            while (it.hasNext()) {
                createEventsRecord.addEvent((Event) it.next());
                it.remove();
            }
            if (MASConfig.SWITCH_EVENT_PERSISTENT && !MASConfig.DEBUG_MODEL && (andSyncWithSendQueue = EventPersistentQueue.getAndSyncWithSendQueue(minSeq, maxSeq)) != null && andSyncWithSendQueue.size() > 0) {
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
