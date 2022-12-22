package com.didi.sdk.push;

import com.didi.sdk.push.PushRequestCallback;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PushOnRequestDispatcher {
    private static final int MAX_CALLBACK_COUNT = 50;
    private static final int PRUNE_COUNT = 30;
    private Runnable cleanupRunnable;
    private boolean cleanupRunning;
    /* access modifiers changed from: private */
    public final Map<Long, PushRequestCallback> map;
    private ExecutorService service;

    private PushOnRequestDispatcher() {
        this.map = new HashMap();
        this.cleanupRunning = false;
        this.cleanupRunnable = new Runnable() {
            /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
            /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0056 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r5 = this;
                L_0x0000:
                    com.didi.sdk.push.PushOnRequestDispatcher r0 = com.didi.sdk.push.PushOnRequestDispatcher.this
                    java.util.Map r0 = r0.map
                    int r0 = r0.size()
                    r1 = 50
                    if (r0 <= r1) goto L_0x0043
                    com.didi.sdk.push.PushOnRequestDispatcher r0 = com.didi.sdk.push.PushOnRequestDispatcher.this
                    java.util.Map r0 = r0.map
                    monitor-enter(r0)
                    com.didi.sdk.push.PushOnRequestDispatcher r1 = com.didi.sdk.push.PushOnRequestDispatcher.this     // Catch:{ all -> 0x0040 }
                    java.util.Map r1 = r1.map     // Catch:{ all -> 0x0040 }
                    java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x0040 }
                    java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0040 }
                    r2.<init>(r1)     // Catch:{ all -> 0x0040 }
                    java.util.Collections.sort(r2)     // Catch:{ all -> 0x0040 }
                    r1 = 0
                L_0x0028:
                    r3 = 30
                    if (r1 >= r3) goto L_0x003e
                    java.lang.Object r3 = r2.get(r1)     // Catch:{ all -> 0x0040 }
                    java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0040 }
                    com.didi.sdk.push.PushOnRequestDispatcher r4 = com.didi.sdk.push.PushOnRequestDispatcher.this     // Catch:{ all -> 0x0040 }
                    java.util.Map r4 = r4.map     // Catch:{ all -> 0x0040 }
                    r4.remove(r3)     // Catch:{ all -> 0x0040 }
                    int r1 = r1 + 1
                    goto L_0x0028
                L_0x003e:
                    monitor-exit(r0)     // Catch:{ all -> 0x0040 }
                    goto L_0x0000
                L_0x0040:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch:{ all -> 0x0040 }
                    throw r1
                L_0x0043:
                    com.didi.sdk.push.PushOnRequestDispatcher r0 = com.didi.sdk.push.PushOnRequestDispatcher.this
                    java.util.Map r0 = r0.map
                    monitor-enter(r0)
                    com.didi.sdk.push.PushOnRequestDispatcher r1 = com.didi.sdk.push.PushOnRequestDispatcher.this     // Catch:{ InterruptedException -> 0x0056 }
                    java.util.Map r1 = r1.map     // Catch:{ InterruptedException -> 0x0056 }
                    r1.wait()     // Catch:{ InterruptedException -> 0x0056 }
                    goto L_0x0056
                L_0x0054:
                    r1 = move-exception
                    goto L_0x0058
                L_0x0056:
                    monitor-exit(r0)     // Catch:{ all -> 0x0054 }
                    goto L_0x0000
                L_0x0058:
                    monitor-exit(r0)     // Catch:{ all -> 0x0054 }
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.push.PushOnRequestDispatcher.C129531.run():void");
            }
        };
        this.service = Executors.newCachedThreadPool();
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static PushOnRequestDispatcher INSTANCE = new PushOnRequestDispatcher();

        private SingletonHolder() {
        }
    }

    public static PushOnRequestDispatcher getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public void registerRequestCallback(byte[] bArr, PushRequestCallback pushRequestCallback) {
        if (bArr != null && pushRequestCallback != null) {
            long j = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong();
            if (j != 0) {
                synchronized (this.map) {
                    this.map.put(Long.valueOf(j), pushRequestCallback);
                    if (!this.cleanupRunning) {
                        this.cleanupRunning = true;
                        this.service.execute(this.cleanupRunnable);
                    }
                    if (this.map.size() > 50) {
                        this.map.notify();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void unregisterRequestCallback(byte[] bArr) {
        if (bArr != null) {
            synchronized (this.map) {
                this.map.remove(Long.valueOf(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong()));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatch(PushRequestCallback.CallbackInfo callbackInfo) {
        PushRequestCallback remove;
        long j = ByteBuffer.wrap(callbackInfo.seqId).order(ByteOrder.LITTLE_ENDIAN).getLong();
        synchronized (this.map) {
            remove = this.map.remove(Long.valueOf(j));
        }
        execute(remove, callbackInfo);
    }

    /* access modifiers changed from: package-private */
    public void execute(final PushRequestCallback pushRequestCallback, final PushRequestCallback.CallbackInfo callbackInfo) {
        if (pushRequestCallback != null && callbackInfo != null) {
            this.service.execute(new Runnable() {
                public void run() {
                    pushRequestCallback.onRequest(callbackInfo);
                }
            });
        }
    }
}
