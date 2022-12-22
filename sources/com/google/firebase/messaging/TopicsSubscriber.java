package com.google.firebase.messaging;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
class TopicsSubscriber {
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private final Context context;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final FirebaseMessaging firebaseMessaging;
    private final Metadata metadata;
    private final Map<String, ArrayDeque<TaskCompletionSource<Void>>> pendingOperations = new ArrayMap();
    private final GmsRpc rpc;
    private final TopicsStore store;
    private final ScheduledExecutorService syncExecutor;
    private boolean syncScheduledOrRunning = false;

    private TopicsSubscriber(FirebaseMessaging firebaseMessaging2, FirebaseInstallationsApi firebaseInstallationsApi2, Metadata metadata2, TopicsStore topicsStore, GmsRpc gmsRpc, Context context2, ScheduledExecutorService scheduledExecutorService) {
        this.firebaseMessaging = firebaseMessaging2;
        this.firebaseInstallationsApi = firebaseInstallationsApi2;
        this.metadata = metadata2;
        this.store = topicsStore;
        this.rpc = gmsRpc;
        this.context = context2;
        this.syncExecutor = scheduledExecutorService;
    }

    private void addToPendingOperations(TopicOperation topicOperation, TaskCompletionSource<Void> taskCompletionSource) {
        ArrayDeque arrayDeque;
        synchronized (this.pendingOperations) {
            String serialize = topicOperation.serialize();
            if (this.pendingOperations.containsKey(serialize)) {
                arrayDeque = this.pendingOperations.get(serialize);
            } else {
                ArrayDeque arrayDeque2 = new ArrayDeque();
                this.pendingOperations.put(serialize, arrayDeque2);
                arrayDeque = arrayDeque2;
            }
            arrayDeque.add(taskCompletionSource);
        }
    }

    private static <T> T awaitTask(Task<T> task) throws IOException {
        try {
            return Tasks.await(task, 30, TimeUnit.SECONDS);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e);
            }
        } catch (InterruptedException | TimeoutException e2) {
            throw new IOException("SERVICE_NOT_AVAILABLE", e2);
        }
    }

    private void blockingSubscribeToTopic(String str) throws IOException {
        awaitTask(this.rpc.subscribeToTopic((String) awaitTask(this.firebaseInstallationsApi.getId()), this.firebaseMessaging.blockingGetToken(), str));
    }

    private void blockingUnsubscribeFromTopic(String str) throws IOException {
        awaitTask(this.rpc.unsubscribeFromTopic((String) awaitTask(this.firebaseInstallationsApi.getId()), this.firebaseMessaging.blockingGetToken(), str));
    }

    static Task<TopicsSubscriber> createInstance(FirebaseMessaging firebaseMessaging2, FirebaseInstallationsApi firebaseInstallationsApi2, Metadata metadata2, GmsRpc gmsRpc, Context context2, ScheduledExecutorService scheduledExecutorService) {
        return Tasks.call(scheduledExecutorService, new TopicsSubscriber$$Lambda$0(context2, scheduledExecutorService, firebaseMessaging2, firebaseInstallationsApi2, metadata2, gmsRpc));
    }

    static boolean isDebugLogEnabled() {
        if (Log.isLoggable(Constants.TAG, 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable(Constants.TAG, 3))) {
            return true;
        }
        return false;
    }

    static final /* synthetic */ TopicsSubscriber lambda$createInstance$0$TopicsSubscriber(Context context2, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging2, FirebaseInstallationsApi firebaseInstallationsApi2, Metadata metadata2, GmsRpc gmsRpc) throws Exception {
        return new TopicsSubscriber(firebaseMessaging2, firebaseInstallationsApi2, metadata2, TopicsStore.getInstance(context2, scheduledExecutorService), gmsRpc, context2, scheduledExecutorService);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void markCompletePendingOperation(com.google.firebase.messaging.TopicOperation r5) {
        /*
            r4 = this;
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r0 = r4.pendingOperations
            monitor-enter(r0)
            java.lang.String r5 = r5.serialize()     // Catch:{ all -> 0x0032 }
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r4.pendingOperations     // Catch:{ all -> 0x0032 }
            boolean r1 = r1.containsKey(r5)     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0011:
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r4.pendingOperations     // Catch:{ all -> 0x0032 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0032 }
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch:{ all -> 0x0032 }
            java.lang.Object r2 = r1.poll()     // Catch:{ all -> 0x0032 }
            com.google.android.gms.tasks.TaskCompletionSource r2 = (com.google.android.gms.tasks.TaskCompletionSource) r2     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0025
            r3 = 0
            r2.setResult(r3)     // Catch:{ all -> 0x0032 }
        L_0x0025:
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0030
            java.util.Map<java.lang.String, java.util.ArrayDeque<com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>>> r1 = r4.pendingOperations     // Catch:{ all -> 0x0032 }
            r1.remove(r5)     // Catch:{ all -> 0x0032 }
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0032:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.markCompletePendingOperation(com.google.firebase.messaging.TopicOperation):void");
    }

    private void startSync() {
        if (!isSyncScheduledOrRunning()) {
            syncWithDelaySecondsInternal(0);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean hasPendingOperation() {
        return this.store.getNextTopicOperation() != null;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean isSyncScheduledOrRunning() {
        return this.syncScheduledOrRunning;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009e A[Catch:{ IOException -> 0x00d8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean performTopicOperation(com.google.firebase.messaging.TopicOperation r12) throws java.io.IOException {
        /*
            r11 = this;
            r0 = 0
            java.lang.String r1 = r12.getOperation()     // Catch:{ IOException -> 0x00d8 }
            int r2 = r1.hashCode()     // Catch:{ IOException -> 0x00d8 }
            r3 = 83
            r4 = 1
            if (r2 == r3) goto L_0x001d
            r3 = 85
            if (r2 == r3) goto L_0x0013
            goto L_0x0027
        L_0x0013:
            java.lang.String r2 = "U"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0027
            r1 = 1
            goto L_0x0028
        L_0x001d:
            java.lang.String r2 = "S"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0027
            r1 = 0
            goto L_0x0028
        L_0x0027:
            r1 = -1
        L_0x0028:
            java.lang.String r2 = " succeeded."
            if (r1 == 0) goto L_0x009e
            if (r1 == r4) goto L_0x0064
            boolean r1 = isDebugLogEnabled()     // Catch:{ IOException -> 0x00d8 }
            if (r1 == 0) goto L_0x00d7
            java.lang.String r6 = "FirebaseMessaging"
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ IOException -> 0x00d8 }
            java.lang.String r1 = java.lang.String.valueOf(r12)     // Catch:{ IOException -> 0x00d8 }
            int r1 = r1.length()     // Catch:{ IOException -> 0x00d8 }
            int r1 = r1 + 24
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d8 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x00d8 }
            java.lang.String r1 = "Unknown topic operation"
            r2.append(r1)     // Catch:{ IOException -> 0x00d8 }
            r2.append(r12)     // Catch:{ IOException -> 0x00d8 }
            java.lang.String r12 = "."
            r2.append(r12)     // Catch:{ IOException -> 0x00d8 }
            java.lang.String r7 = r2.toString()     // Catch:{ IOException -> 0x00d8 }
            r5 = 3
            r8 = 0
            java.lang.String r9 = "com.google.firebase.messaging.TopicsSubscriber"
            r10 = 9
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00d7
        L_0x0064:
            java.lang.String r1 = r12.getTopic()     // Catch:{ IOException -> 0x00d8 }
            r11.blockingUnsubscribeFromTopic(r1)     // Catch:{ IOException -> 0x00d8 }
            boolean r1 = isDebugLogEnabled()     // Catch:{ IOException -> 0x00d8 }
            if (r1 == 0) goto L_0x00d7
            java.lang.String r6 = "FirebaseMessaging"
            java.lang.String r12 = r12.getTopic()     // Catch:{ IOException -> 0x00d8 }
            java.lang.String r1 = java.lang.String.valueOf(r12)     // Catch:{ IOException -> 0x00d8 }
            int r1 = r1.length()     // Catch:{ IOException -> 0x00d8 }
            int r1 = r1 + 35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d8 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x00d8 }
            java.lang.String r1 = "Unsubscribe from topic: "
            r3.append(r1)     // Catch:{ IOException -> 0x00d8 }
            r3.append(r12)     // Catch:{ IOException -> 0x00d8 }
            r3.append(r2)     // Catch:{ IOException -> 0x00d8 }
            java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00d8 }
            r5 = 3
            r8 = 0
            java.lang.String r9 = "com.google.firebase.messaging.TopicsSubscriber"
            r10 = 4
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00d7
        L_0x009e:
            java.lang.String r1 = r12.getTopic()     // Catch:{ IOException -> 0x00d8 }
            r11.blockingSubscribeToTopic(r1)     // Catch:{ IOException -> 0x00d8 }
            boolean r1 = isDebugLogEnabled()     // Catch:{ IOException -> 0x00d8 }
            if (r1 == 0) goto L_0x00d7
            java.lang.String r6 = "FirebaseMessaging"
            java.lang.String r12 = r12.getTopic()     // Catch:{ IOException -> 0x00d8 }
            java.lang.String r1 = java.lang.String.valueOf(r12)     // Catch:{ IOException -> 0x00d8 }
            int r1 = r1.length()     // Catch:{ IOException -> 0x00d8 }
            int r1 = r1 + 31
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d8 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x00d8 }
            java.lang.String r1 = "Subscribe to topic: "
            r3.append(r1)     // Catch:{ IOException -> 0x00d8 }
            r3.append(r12)     // Catch:{ IOException -> 0x00d8 }
            r3.append(r2)     // Catch:{ IOException -> 0x00d8 }
            java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00d8 }
            r5 = 3
            r8 = 0
            java.lang.String r9 = "com.google.firebase.messaging.TopicsSubscriber"
            r10 = 7
            com.didi.sdk.apm.SystemUtils.log(r5, r6, r7, r8, r9, r10)     // Catch:{ IOException -> 0x00d8 }
        L_0x00d7:
            return r4
        L_0x00d8:
            r12 = move-exception
            java.lang.String r1 = r12.getMessage()
            java.lang.String r2 = "SERVICE_NOT_AVAILABLE"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0107
            java.lang.String r1 = r12.getMessage()
            java.lang.String r2 = "INTERNAL_SERVER_ERROR"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x00f2
            goto L_0x0107
        L_0x00f2:
            java.lang.String r1 = r12.getMessage()
            if (r1 != 0) goto L_0x0106
            r2 = 6
            r5 = 0
            r7 = 14
            java.lang.String r3 = "FirebaseMessaging"
            java.lang.String r4 = "Topic operation failed without exception message. Will retry Topic operation."
            java.lang.String r6 = "com.google.firebase.messaging.TopicsSubscriber"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
            return r0
        L_0x0106:
            throw r12
        L_0x0107:
            java.lang.String r12 = r12.getMessage()
            java.lang.String r1 = java.lang.String.valueOf(r12)
            int r1 = r1.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = r1 + 53
            r2.<init>(r1)
            java.lang.String r1 = "Topic operation failed: "
            r2.append(r1)
            r2.append(r12)
            java.lang.String r12 = ". Will retry Topic operation."
            r2.append(r12)
            java.lang.String r5 = r2.toString()
            r3 = 6
            r6 = 0
            r8 = 12
            java.lang.String r4 = "FirebaseMessaging"
            java.lang.String r7 = "com.google.firebase.messaging.TopicsSubscriber"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.performTopicOperation(com.google.firebase.messaging.TopicOperation):boolean");
    }

    /* access modifiers changed from: package-private */
    public void scheduleSyncTaskWithDelaySeconds(Runnable runnable, long j) {
        this.syncExecutor.schedule(runnable, j, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> scheduleTopicOperation(TopicOperation topicOperation) {
        this.store.addTopicOperation(topicOperation);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        addToPendingOperations(topicOperation, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    /* access modifiers changed from: package-private */
    public void startTopicsSyncIfNecessary() {
        if (hasPendingOperation()) {
            startSync();
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Void> subscribeToTopic(String str) {
        Task<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.subscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        if (performTopicOperation(r0) != false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean syncTopics() throws java.io.IOException {
        /*
            r7 = this;
        L_0x0000:
            monitor-enter(r7)
            com.google.firebase.messaging.TopicsStore r0 = r7.store     // Catch:{ all -> 0x0030 }
            com.google.firebase.messaging.TopicOperation r0 = r0.getNextTopicOperation()     // Catch:{ all -> 0x0030 }
            if (r0 != 0) goto L_0x001e
            boolean r0 = isDebugLogEnabled()     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x001b
            java.lang.String r2 = "FirebaseMessaging"
            java.lang.String r3 = "topic sync succeeded"
            r1 = 3
            r4 = 0
            java.lang.String r5 = "com.google.firebase.messaging.TopicsSubscriber"
            r6 = 7
            com.didi.sdk.apm.SystemUtils.log(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0030 }
        L_0x001b:
            monitor-exit(r7)     // Catch:{ all -> 0x0030 }
            r0 = 1
            return r0
        L_0x001e:
            monitor-exit(r7)     // Catch:{ all -> 0x0030 }
            boolean r1 = r7.performTopicOperation(r0)
            if (r1 != 0) goto L_0x0027
            r0 = 0
            return r0
        L_0x0027:
            com.google.firebase.messaging.TopicsStore r1 = r7.store
            r1.removeTopicOperation(r0)
            r7.markCompletePendingOperation(r0)
            goto L_0x0000
        L_0x0030:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0030 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.TopicsSubscriber.syncTopics():boolean");
    }

    /* access modifiers changed from: package-private */
    public void syncWithDelaySecondsInternal(long j) {
        scheduleSyncTaskWithDelaySeconds(new TopicsSyncTask(this, this.context, this.metadata, Math.min(Math.max(30, j + j), MAX_DELAY_SEC)), j);
        setSyncScheduledOrRunning(true);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> unsubscribeFromTopic(String str) {
        Task<Void> scheduleTopicOperation = scheduleTopicOperation(TopicOperation.unsubscribe(str));
        startTopicsSyncIfNecessary();
        return scheduleTopicOperation;
    }
}
