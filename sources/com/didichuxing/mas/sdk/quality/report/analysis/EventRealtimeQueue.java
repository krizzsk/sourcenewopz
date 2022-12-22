package com.didichuxing.mas.sdk.quality.report.analysis;

import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.backend.UploadStrategy;
import com.didichuxing.mas.sdk.quality.report.collector.CustomCollector;
import com.didichuxing.mas.sdk.quality.report.collector.LocaleCollector;
import com.didichuxing.mas.sdk.quality.report.collector.LocationCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PackageCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PersistentInfoCollector;
import com.didichuxing.mas.sdk.quality.report.collector.TimeCollector;
import com.didichuxing.mas.sdk.quality.report.record.Event;
import com.didichuxing.mas.sdk.quality.report.transport.HttpSender;
import com.didichuxing.mas.sdk.quality.report.utils.JsonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EventRealtimeQueue {
    /* access modifiers changed from: private */
    public static BlockingQueue<Event> blockingQueue = new LinkedBlockingQueue();
    private static volatile EventRealtimeThread mRealtimeThread;

    private static EventRealtimeThread getRealtimeThread() {
        if (mRealtimeThread == null) {
            synchronized (EventRealtimeQueue.class) {
                if (mRealtimeThread == null) {
                    mRealtimeThread = new EventRealtimeThread();
                }
            }
        }
        return mRealtimeThread;
    }

    private static void startRealtimeThread() {
        EventRealtimeThread realtimeThread = getRealtimeThread();
        try {
            if (!realtimeThread.isAlive()) {
                realtimeThread.start();
            }
        } catch (Throwable unused) {
        }
    }

    public static void postSync(Event event) throws IOException {
        String buildRealtimeJson = buildRealtimeJson(event);
        String realtimeUrl = UploadStrategy.getRealtimeUrl();
        HashMap hashMap = new HashMap();
        hashMap.put("e", event.getEventId());
        hashMap.put("ts", String.valueOf(event.getTs()));
        hashMap.put("oid", PersistentInfoCollector.getOmegaId());
        HttpSender.post(realtimeUrl, buildRealtimeJson, (Map<String, String>) hashMap, "RT_" + event.getEventId());
        PersistentInfoCollector.increaseAndSaveLastSendRealEventSeq();
    }

    public static void add(Event event) {
        blockingQueue.add(event);
        startRealtimeThread();
    }

    private static String buildRealtimeJson(Event event) {
        double[] location;
        HashMap hashMap = new HashMap();
        hashMap.put("e", event.getEventId());
        hashMap.put("ts", Long.valueOf(event.getTs()));
        hashMap.put("oid", PersistentInfoCollector.getOmegaId());
        hashMap.put("uid", CustomCollector.getUid());
        hashMap.put("an", MASConfig.CUSTOM_APP_NAME);
        String pkgName = PackageCollector.getPkgName();
        if (!MASConfig.CUSTOM_APP_NAME.equals(pkgName)) {
            hashMap.put("oan", pkgName);
        }
        hashMap.put("av", PackageCollector.getVN());
        hashMap.put("tc", Long.valueOf(CustomCollector.getTimeOffSet()));
        hashMap.put("cityid", Integer.valueOf(CustomCollector.getCityId()));
        hashMap.put("otn", 1);
        if (AnalysisDelegater.isAppAtFront() && LocationCollector.isNeedUploadLocation() && (location = LocationCollector.getLocation()) != null && location.length >= 2) {
            hashMap.put("lng", Double.valueOf(location[0]));
            hashMap.put("lat", Double.valueOf(location[1]));
        }
        String encryptedPhone = CustomCollector.getEncryptedPhone();
        if (encryptedPhone != null && !"".equals(encryptedPhone)) {
            hashMap.put("tn", encryptedPhone);
        }
        String canonicalCountryCode = LocaleCollector.getCanonicalCountryCode();
        if (canonicalCountryCode != null && !"".equals(canonicalCountryCode)) {
            hashMap.put("ccc", canonicalCountryCode);
        }
        hashMap.put("uo", Integer.valueOf(TimeCollector.getTimeZoneUtcOffset()));
        Map<String, Object> allAttrs = event.getAllAttrs();
        if (allAttrs != null) {
            hashMap.put("ex", allAttrs);
        }
        hashMap.put("seq", Long.valueOf(PersistentInfoCollector.getLastSendRealEventSeq()));
        return JsonUtil.map2Json(hashMap);
    }

    public static class EventRealtimeThread extends Thread {
        public EventRealtimeThread() {
            super("OmegaSDK.EventRealtimeThread");
        }

        public void run() {
            while (true) {
                try {
                    Event event = (Event) EventRealtimeQueue.blockingQueue.take();
                    if (event != null) {
                        EventRealtimeQueue.postSync(event);
                    }
                } catch (Throwable th) {
                    OLog.m34419e("EventRealtimeThread.error", th);
                }
            }
        }
    }
}
