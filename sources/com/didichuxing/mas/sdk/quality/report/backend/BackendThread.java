package com.didichuxing.mas.sdk.quality.report.backend;

import android.content.Context;
import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.analysis.EventSendQueue;
import com.didichuxing.mas.sdk.quality.report.record.EventsRecord;
import com.didichuxing.mas.sdk.quality.report.record.RecordStorage;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;

public class BackendThread extends Thread {
    private static final long VERY_SHORT_SLEEP_INTERVAL = 15000;
    private static boolean isFirstStart = true;
    private static volatile boolean isUploading = false;
    private static Context mContext;
    private volatile boolean needShutdown;

    private BackendThread() {
        this.needShutdown = false;
        setName("MAS.BackThread");
        setPriority(1);
        start();
    }

    private static final class SingletonHolder {
        /* access modifiers changed from: private */
        public static final BackendThread instance = new BackendThread();

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

    public void run() {
        EventsRecord dumpRecord;
        RecordStorage.saveNativeCrash(false);
        while (!this.needShutdown) {
            if (isFirstStart) {
                try {
                    Thread.sleep(15000);
                    isFirstStart = false;
                } catch (InterruptedException unused) {
                    isFirstStart = false;
                }
            }
            if (MASConfig.DEBUG_MODEL || !isFirstStart) {
                isUploading = true;
                try {
                    if (EventSendQueue.size() > 0 && (dumpRecord = EventSendQueue.dumpRecord()) != null) {
                        RecordStorage.save(dumpRecord);
                    }
                    UploadStrategy.upload();
                    isUploading = false;
                    if (!MASConfig.DEBUG_MODEL) {
                        try {
                            Thread.sleep((long) MASConfig.BACKEND_THREAD_RUN_INTERVAL);
                        } catch (InterruptedException unused2) {
                        }
                    }
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("async upload failed:");
                    sb.append(e.getMessage() == null ? "" : e.getMessage());
                    OLog.m34418e(sb.toString());
                }
            }
        }
    }
}
