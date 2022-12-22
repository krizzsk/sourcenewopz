package com.didichuxing.omega.sdk.analysis;

import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.backend.UploadStrategy;
import com.didichuxing.omega.sdk.common.collector.CustomCollector;
import com.didichuxing.omega.sdk.common.collector.PackageCollector;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didichuxing.omega.sdk.common.transport.HttpSender;
import com.didichuxing.omega.sdk.common.utils.JsonUtil;
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

    public static class EventRealtimeThread extends Thread {
        public EventRealtimeThread() {
            super("OmegaSDK.EventRealtimeThread");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:0|1|(2:3|8)(2:4|(2:6|10)(1:9))|7) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:7:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r1 = this;
            L_0x0000:
                boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.SWITCH_EVENT     // Catch:{ all -> 0x0000 }
                if (r0 != 0) goto L_0x0005
                goto L_0x0000
            L_0x0005:
                java.util.concurrent.BlockingQueue r0 = com.didichuxing.omega.sdk.analysis.EventRealtimeQueue.blockingQueue     // Catch:{ all -> 0x0000 }
                java.lang.Object r0 = r0.take()     // Catch:{ all -> 0x0000 }
                com.didichuxing.omega.sdk.common.record.Event r0 = (com.didichuxing.omega.sdk.common.record.Event) r0     // Catch:{ all -> 0x0000 }
                if (r0 == 0) goto L_0x0000
                com.didichuxing.omega.sdk.analysis.EventRealtimeQueue.postSync(r0)     // Catch:{ all -> 0x0000 }
                goto L_0x0000
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.analysis.EventRealtimeQueue.EventRealtimeThread.run():void");
        }
    }

    public static void postSync(Event event) throws IOException {
        String buildRealtimeJson = buildRealtimeJson(event);
        String realtimeUrl = UploadStrategy.getRealtimeUrl();
        HashMap hashMap = new HashMap();
        hashMap.put("e", event.getEventId());
        hashMap.put("ts", String.valueOf(event.getTs()));
        String omegaId = PersistentInfoCollector.getOmegaId();
        hashMap.put("oid", omegaId);
        Security.setHeaderCityIdEncrypt(hashMap, omegaId);
        HttpSender.post(realtimeUrl, buildRealtimeJson, (Map<String, String>) hashMap, "RT_" + event.getEventId());
        PersistentInfoCollector.increaseAndSaveLastSendRealEventSeq();
    }

    public static void add(Event event) {
        blockingQueue.add(event);
        startRealtimeThread();
    }

    private static String buildRealtimeJson(Event event) {
        HashMap hashMap = new HashMap();
        hashMap.put("e", event.getEventId());
        hashMap.put("ts", Long.valueOf(event.getTs()));
        hashMap.put("oid", PersistentInfoCollector.getOmegaId());
        hashMap.put("uid", CustomCollector.getUid());
        hashMap.put("an", OmegaConfig.CUSTOM_APP_NAME);
        String pkgName = PackageCollector.getPkgName();
        if (!OmegaConfig.CUSTOM_APP_NAME.equals(pkgName)) {
            hashMap.put("oan", pkgName);
        }
        hashMap.put("av", PackageCollector.getVN());
        hashMap.put("tc", Long.valueOf(OmegaConfig.CUSTOM_TIME_OFFSET));
        SystemTrack.buildRealtimeAttr(hashMap);
        Map<String, Object> allAttrs = event.getAllAttrs();
        if (allAttrs != null) {
            hashMap.put("ex", allAttrs);
        }
        hashMap.put("seq", Long.valueOf(PersistentInfoCollector.getLastSendRealEventSeq()));
        return JsonUtil.map2Json(hashMap);
    }
}
