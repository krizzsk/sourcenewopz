package com.didichuxing.omega.sdk.corelink.node;

import android.text.TextUtils;
import com.didichuxing.omega.sdk.analysis.Security;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.record.EventsRecord;
import com.didichuxing.omega.sdk.common.record.RecordFactory;
import com.didichuxing.omega.sdk.common.record.RecordStorage;
import com.didichuxing.omega.sdk.common.transport.FileTooLargeException;
import com.didichuxing.omega.sdk.corelink.check.SecurityCheckUtil;
import com.didichuxing.omega.sdk.corelink.check.SeqCheckUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EventSendNode extends Thread {
    private static final long VERY_SHORT_SLEEP_INTERVAL = 7000;
    private static boolean isFirstStart = true;
    private static volatile boolean isSendEvent = false;
    private static volatile boolean isUploading = false;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static EventSendNode instance = new EventSendNode();

        private SingletonHolder() {
        }
    }

    public static EventSendNode getInstance() {
        return SingletonHolder.instance;
    }

    private EventSendNode() {
        setName("OmegaSDK.EventSendThread");
        start();
    }

    public void wakeup() {
        isSendEvent = true;
        if (!isUploading) {
            interrupt();
        }
    }

    public void run() {
        while (true) {
            if (isFirstStart) {
                try {
                    Thread.sleep(VERY_SHORT_SLEEP_INTERVAL);
                    isFirstStart = false;
                } catch (InterruptedException unused) {
                } catch (Throwable th) {
                    isFirstStart = false;
                    throw th;
                }
                isFirstStart = false;
            }
            if (OmegaConfig.DEBUG_MODEL) {
                try {
                    Thread.sleep((long) OmegaConfig.SEND_EVENT_BACKEND_THREAD_RUN_INTERVAL);
                } catch (InterruptedException unused2) {
                }
            } else {
                isUploading = true;
                sendEvent();
                isUploading = false;
                if (!isSendEvent && !OmegaConfig.DEBUG_MODEL) {
                    try {
                        Thread.sleep((long) OmegaConfig.SEND_EVENT_BACKEND_THREAD_RUN_INTERVAL);
                    } catch (InterruptedException unused3) {
                    }
                }
                isSendEvent = false;
            }
        }
    }

    static void sendEvent() {
        try {
            String[] allMkKey = EventConsumerQueueNode.getAllMkKey();
            if (allMkKey == null) {
                return;
            }
            if (allMkKey.length > 0) {
                if (OmegaConfig.DEBUG_MODEL) {
                    allMkKey = getSortKey(allMkKey);
                }
                for (String sendEvent : allMkKey) {
                    sendEvent(sendEvent);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static void sendEvent(String str) {
        EventsRecord eventsRecord;
        long j = 0;
        try {
            EventMMKVLoadMessageNode.open(str);
            String[] allKeys = EventMMKVLoadMessageNode.allKeys();
            if (allKeys != null) {
                if (allKeys.length > 0) {
                    if (OmegaConfig.DEBUG_MODEL) {
                        allKeys = getSortKey(allKeys);
                    }
                    eventsRecord = RecordFactory.createEventsRecord();
                    for (String str2 : allKeys) {
                        if (!"seq".equals(str2)) {
                            String decodeString = EventMMKVLoadMessageNode.decodeString(str2);
                            if (!TextUtils.isEmpty(decodeString)) {
                                try {
                                    String decrypt = EventSecurityNode.decrypt(Security.getKey(), decodeString);
                                    if (!TextUtils.isEmpty(decrypt)) {
                                        Event fromJson = Event.fromJson(decrypt);
                                        if (fromJson != null) {
                                            eventsRecord.addEvent(fromJson);
                                        }
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        }
                    }
                    if (!OmegaConfig.DEBUG_MODEL) {
                        if (EventMMKVLoadMessageNode.containsKey("seq")) {
                            j = EventMMKVLoadMessageNode.decodeLong("seq");
                        } else {
                            j = EventMMKVLoadMessageNode.saveSeq();
                            SeqCheckUtil.markPackSeq(j);
                        }
                        eventsRecord.put("seq", Long.valueOf(j));
                    }
                    EventMMKVLoadMessageNode.close();
                    if (eventsRecord != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            EventUploadNode.sendRecord(eventsRecord, RecordStorage.packRecord(eventsRecord), str);
                        } catch (FileTooLargeException unused2) {
                            SecurityCheckUtil.sendMessageBigMonitorToDc(eventsRecord.getEvents());
                        } catch (Throwable unused3) {
                            return;
                        }
                        EventMMKVLoadMessageNode.removeMmkvFile(str);
                        SeqCheckUtil.checkSeq(j, System.currentTimeMillis() - currentTimeMillis);
                        return;
                    }
                    return;
                }
            }
            EventMMKVLoadMessageNode.close();
            EventMMKVLoadMessageNode.removeMmkvFile(str);
        } catch (Throwable unused4) {
            eventsRecord = null;
        }
    }

    private static String[] getSortKey(String[] strArr) {
        List asList = Arrays.asList(strArr);
        Collections.sort(asList);
        return (String[]) asList.toArray(new String[asList.size()]);
    }
}
