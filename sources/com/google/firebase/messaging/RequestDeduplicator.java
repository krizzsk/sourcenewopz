package com.google.firebase.messaging;

import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
class RequestDeduplicator {
    private final Executor executor;
    private final Map<String, Task<String>> getTokenRequests = new ArrayMap();

    /* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
    interface GetTokenRequest {
        Task<String> start();
    }

    RequestDeduplicator(Executor executor2) {
        this.executor = executor2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.android.gms.tasks.Task<java.lang.String> getOrStartGetTokenRequest(java.lang.String r9, com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.util.Map<java.lang.String, com.google.android.gms.tasks.Task<java.lang.String>> r0 = r8.getTokenRequests     // Catch:{ all -> 0x0078 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0078 }
            com.google.android.gms.tasks.Task r0 = (com.google.android.gms.tasks.Task) r0     // Catch:{ all -> 0x0078 }
            r1 = 3
            if (r0 == 0) goto L_0x0038
            java.lang.String r10 = "FirebaseMessaging"
            boolean r10 = android.util.Log.isLoggable(r10, r1)     // Catch:{ all -> 0x0078 }
            if (r10 == 0) goto L_0x0036
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0078 }
            java.lang.String r10 = "Joining ongoing request for: "
            int r1 = r9.length()     // Catch:{ all -> 0x0078 }
            if (r1 == 0) goto L_0x0026
            java.lang.String r9 = r10.concat(r9)     // Catch:{ all -> 0x0078 }
        L_0x0024:
            r3 = r9
            goto L_0x002c
        L_0x0026:
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x0078 }
            r9.<init>(r10)     // Catch:{ all -> 0x0078 }
            goto L_0x0024
        L_0x002c:
            java.lang.String r2 = "FirebaseMessaging"
            r1 = 3
            r4 = 0
            java.lang.String r5 = "com.google.firebase.messaging.RequestDeduplicator"
            r6 = 3
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0078 }
        L_0x0036:
            monitor-exit(r8)
            return r0
        L_0x0038:
            java.lang.String r0 = "FirebaseMessaging"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0062
            java.lang.String r0 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0078 }
            java.lang.String r1 = "Making new request for: "
            int r2 = r0.length()     // Catch:{ all -> 0x0078 }
            if (r2 == 0) goto L_0x0052
            java.lang.String r0 = r1.concat(r0)     // Catch:{ all -> 0x0078 }
        L_0x0050:
            r4 = r0
            goto L_0x0058
        L_0x0052:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0078 }
            r0.<init>(r1)     // Catch:{ all -> 0x0078 }
            goto L_0x0050
        L_0x0058:
            java.lang.String r3 = "FirebaseMessaging"
            r2 = 3
            r5 = 0
            java.lang.String r6 = "com.google.firebase.messaging.RequestDeduplicator"
            r7 = 5
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0078 }
        L_0x0062:
            com.google.android.gms.tasks.Task r10 = r10.start()     // Catch:{ all -> 0x0078 }
            java.util.concurrent.Executor r0 = r8.executor     // Catch:{ all -> 0x0078 }
            com.google.firebase.messaging.RequestDeduplicator$$Lambda$0 r1 = new com.google.firebase.messaging.RequestDeduplicator$$Lambda$0     // Catch:{ all -> 0x0078 }
            r1.<init>(r8, r9)     // Catch:{ all -> 0x0078 }
            com.google.android.gms.tasks.Task r10 = r10.continueWithTask(r0, r1)     // Catch:{ all -> 0x0078 }
            java.util.Map<java.lang.String, com.google.android.gms.tasks.Task<java.lang.String>> r0 = r8.getTokenRequests     // Catch:{ all -> 0x0078 }
            r0.put(r9, r10)     // Catch:{ all -> 0x0078 }
            monitor-exit(r8)
            return r10
        L_0x0078:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.RequestDeduplicator.getOrStartGetTokenRequest(java.lang.String, com.google.firebase.messaging.RequestDeduplicator$GetTokenRequest):com.google.android.gms.tasks.Task");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(String str, Task task) throws Exception {
        synchronized (this) {
            this.getTokenRequests.remove(str);
        }
        return task;
    }
}
