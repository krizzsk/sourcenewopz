package com.didichuxing.omega.sdk.common.backend;

import android.content.Context;

public class BackendThread extends Thread {
    private static final long VERY_SHORT_SLEEP_INTERVAL = 15000;
    private static boolean isFirstStart = true;
    private static volatile boolean isUploading = false;
    private static Context mContext;
    private volatile boolean needShutdown;

    private BackendThread() {
        this.needShutdown = false;
        setName("OmegaSDK.BackendThread");
        setPriority(1);
        start();
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static BackendThread instance = new BackendThread();

        private SingletonHolder() {
        }
    }

    public static BackendThread getInstance() {
        return SingletonHolder.instance;
    }

    public void init(Context context) {
        mContext = context;
    }

    public void wakeup() {
        if (!isUploading) {
            interrupt();
        }
    }

    public void shutdown() {
        this.needShutdown = true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
        L_0x0000:
            boolean r0 = r4.needShutdown
            if (r0 != 0) goto L_0x005d
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.SWITCH_EVENT
            r1 = 0
            if (r0 != 0) goto L_0x0018
            isUploading = r1
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.DEBUG_MODEL
            if (r0 != 0) goto L_0x0000
            int r0 = com.didichuxing.omega.sdk.common.OmegaConfig.BACKEND_THREAD_RUN_INTERVAL     // Catch:{ InterruptedException -> 0x0016 }
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0016 }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0016 }
            goto L_0x0000
        L_0x0016:
            goto L_0x0000
        L_0x0018:
            boolean r0 = isFirstStart
            if (r0 == 0) goto L_0x0026
            r2 = 15000(0x3a98, double:7.411E-320)
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x0024 }
            isFirstStart = r1     // Catch:{ InterruptedException -> 0x0024 }
            goto L_0x0026
        L_0x0024:
            isFirstStart = r1
        L_0x0026:
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.DEBUG_MODEL
            if (r0 != 0) goto L_0x002e
            boolean r0 = isFirstStart
            if (r0 != 0) goto L_0x0000
        L_0x002e:
            r0 = 1
            isUploading = r0
            int r0 = com.didichuxing.omega.sdk.analysis.EventSendQueue.size()     // Catch:{ Exception -> 0x0052 }
            if (r0 <= 0) goto L_0x0040
            com.didichuxing.omega.sdk.common.record.EventsRecord r0 = com.didichuxing.omega.sdk.analysis.EventSendQueue.dumpRecord()     // Catch:{ Exception -> 0x0052 }
            if (r0 == 0) goto L_0x0040
            com.didichuxing.omega.sdk.common.record.RecordStorage.save(r0)     // Catch:{ Exception -> 0x0052 }
        L_0x0040:
            android.content.Context r0 = mContext     // Catch:{ Exception -> 0x0052 }
            com.didichuxing.omega.sdk.common.backend.UploadStrategy.upload(r0)     // Catch:{ Exception -> 0x0052 }
            isUploading = r1     // Catch:{ Exception -> 0x0052 }
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.DEBUG_MODEL     // Catch:{ Exception -> 0x0052 }
            if (r0 != 0) goto L_0x0000
            int r0 = com.didichuxing.omega.sdk.common.OmegaConfig.BACKEND_THREAD_RUN_INTERVAL     // Catch:{  }
            long r0 = (long) r0     // Catch:{  }
            java.lang.Thread.sleep(r0)     // Catch:{  }
            goto L_0x0000
        L_0x0052:
            r0 = move-exception
            java.lang.Throwable r0 = r0.getCause()
            java.lang.String r1 = "BackendThread"
            com.didichuxing.omega.sdk.common.utils.OLog.m34764e(r1, r0)
            goto L_0x0000
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.backend.BackendThread.run():void");
    }
}
