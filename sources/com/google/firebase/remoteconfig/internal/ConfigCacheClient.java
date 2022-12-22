package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ConfigCacheClient {
    private static final Executor DIRECT_EXECUTOR = $$Lambda$_14QHG018Z6p13d3hzJuGTWnNeo.INSTANCE;
    static final long DISK_READ_TIMEOUT_IN_SECONDS = 5;
    private static final Map<String, ConfigCacheClient> clientInstances = new HashMap();
    private Task<ConfigContainer> cachedContainerTask = null;
    private final ExecutorService executorService;
    private final ConfigStorageClient storageClient;

    private ConfigCacheClient(ExecutorService executorService2, ConfigStorageClient configStorageClient) {
        this.executorService = executorService2;
        this.storageClient = configStorageClient;
    }

    public ConfigContainer getBlocking() {
        return getBlocking(5);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        return (com.google.firebase.remoteconfig.internal.ConfigContainer) await(get(), r7, java.util.concurrent.TimeUnit.SECONDS);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        com.didi.sdk.apm.SystemUtils.log(3, com.google.firebase.remoteconfig.FirebaseRemoteConfig.TAG, "Reading from storage file failed.", r7, "com.google.firebase.remoteconfig.internal.ConfigCacheClient", 104);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.remoteconfig.internal.ConfigContainer getBlocking(long r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.ConfigContainer> r0 = r6.cachedContainerTask     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.ConfigContainer> r0 = r6.cachedContainerTask     // Catch:{ all -> 0x0039 }
            boolean r0 = r0.isSuccessful()     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.ConfigContainer> r7 = r6.cachedContainerTask     // Catch:{ all -> 0x0039 }
            java.lang.Object r7 = r7.getResult()     // Catch:{ all -> 0x0039 }
            com.google.firebase.remoteconfig.internal.ConfigContainer r7 = (com.google.firebase.remoteconfig.internal.ConfigContainer) r7     // Catch:{ all -> 0x0039 }
            monitor-exit(r6)     // Catch:{ all -> 0x0039 }
            return r7
        L_0x0017:
            monitor-exit(r6)     // Catch:{ all -> 0x0039 }
            com.google.android.gms.tasks.Task r0 = r6.get()     // Catch:{ InterruptedException -> 0x0029, ExecutionException -> 0x0027, TimeoutException -> 0x0025 }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException -> 0x0029, ExecutionException -> 0x0027, TimeoutException -> 0x0025 }
            java.lang.Object r7 = await(r0, r7, r1)     // Catch:{ InterruptedException -> 0x0029, ExecutionException -> 0x0027, TimeoutException -> 0x0025 }
            com.google.firebase.remoteconfig.internal.ConfigContainer r7 = (com.google.firebase.remoteconfig.internal.ConfigContainer) r7     // Catch:{ InterruptedException -> 0x0029, ExecutionException -> 0x0027, TimeoutException -> 0x0025 }
            return r7
        L_0x0025:
            r7 = move-exception
            goto L_0x002a
        L_0x0027:
            r7 = move-exception
            goto L_0x002a
        L_0x0029:
            r7 = move-exception
        L_0x002a:
            r3 = r7
            java.lang.String r1 = "FirebaseRemoteConfig"
            java.lang.String r2 = "Reading from storage file failed."
            r0 = 3
            java.lang.String r4 = "com.google.firebase.remoteconfig.internal.ConfigCacheClient"
            r5 = 104(0x68, float:1.46E-43)
            com.didi.sdk.apm.SystemUtils.log(r0, r1, r2, r3, r4, r5)
            r7 = 0
            return r7
        L_0x0039:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0039 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigCacheClient.getBlocking(long):com.google.firebase.remoteconfig.internal.ConfigContainer");
    }

    public Task<ConfigContainer> put(ConfigContainer configContainer) {
        return put(configContainer, true);
    }

    public /* synthetic */ Void lambda$put$0$ConfigCacheClient(ConfigContainer configContainer) throws Exception {
        return this.storageClient.write(configContainer);
    }

    public Task<ConfigContainer> put(ConfigContainer configContainer, boolean z) {
        return Tasks.call(this.executorService, new Callable(configContainer) {
            public final /* synthetic */ ConfigContainer f$1;

            {
                this.f$1 = r2;
            }

            public final Object call() {
                return ConfigCacheClient.this.lambda$put$0$ConfigCacheClient(this.f$1);
            }
        }).onSuccessTask(this.executorService, new SuccessContinuation(z, configContainer) {
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ ConfigContainer f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final Task then(Object obj) {
                return ConfigCacheClient.this.lambda$put$1$ConfigCacheClient(this.f$1, this.f$2, (Void) obj);
            }
        });
    }

    public /* synthetic */ Task lambda$put$1$ConfigCacheClient(boolean z, ConfigContainer configContainer, Void voidR) throws Exception {
        if (z) {
            updateInMemoryConfigContainer(configContainer);
        }
        return Tasks.forResult(configContainer);
    }

    public synchronized Task<ConfigContainer> get() {
        if (this.cachedContainerTask == null || (this.cachedContainerTask.isComplete() && !this.cachedContainerTask.isSuccessful())) {
            ExecutorService executorService2 = this.executorService;
            ConfigStorageClient configStorageClient = this.storageClient;
            Objects.requireNonNull(configStorageClient);
            this.cachedContainerTask = Tasks.call(executorService2, new Callable() {
                public final Object call() {
                    return ConfigStorageClient.this.read();
                }
            });
        }
        return this.cachedContainerTask;
    }

    public void clear() {
        synchronized (this) {
            this.cachedContainerTask = Tasks.forResult(null);
        }
        this.storageClient.clear();
    }

    private synchronized void updateInMemoryConfigContainer(ConfigContainer configContainer) {
        this.cachedContainerTask = Tasks.forResult(configContainer);
    }

    /* access modifiers changed from: package-private */
    public synchronized Task<ConfigContainer> getCachedContainerTask() {
        return this.cachedContainerTask;
    }

    public static synchronized ConfigCacheClient getInstance(ExecutorService executorService2, ConfigStorageClient configStorageClient) {
        ConfigCacheClient configCacheClient;
        synchronized (ConfigCacheClient.class) {
            String fileName = configStorageClient.getFileName();
            if (!clientInstances.containsKey(fileName)) {
                clientInstances.put(fileName, new ConfigCacheClient(executorService2, configStorageClient));
            }
            configCacheClient = clientInstances.get(fileName);
        }
        return configCacheClient;
    }

    public static synchronized void clearInstancesForTest() {
        synchronized (ConfigCacheClient.class) {
            clientInstances.clear();
        }
    }

    private static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        AwaitListener awaitListener = new AwaitListener();
        task.addOnSuccessListener(DIRECT_EXECUTOR, (OnSuccessListener<? super TResult>) awaitListener);
        task.addOnFailureListener(DIRECT_EXECUTOR, (OnFailureListener) awaitListener);
        task.addOnCanceledListener(DIRECT_EXECUTOR, (OnCanceledListener) awaitListener);
        if (!awaitListener.await(j, timeUnit)) {
            throw new TimeoutException("Task await timed out.");
        } else if (task.isSuccessful()) {
            return task.getResult();
        } else {
            throw new ExecutionException(task.getException());
        }
    }

    private static class AwaitListener<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {
        private final CountDownLatch latch;

        private AwaitListener() {
            this.latch = new CountDownLatch(1);
        }

        public void onSuccess(TResult tresult) {
            this.latch.countDown();
        }

        public void onFailure(Exception exc) {
            this.latch.countDown();
        }

        public void onCanceled() {
            this.latch.countDown();
        }

        public void await() throws InterruptedException {
            this.latch.await();
        }

        public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.latch.await(j, timeUnit);
        }
    }
}
