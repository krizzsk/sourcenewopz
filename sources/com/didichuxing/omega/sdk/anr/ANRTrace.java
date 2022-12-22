package com.didichuxing.omega.sdk.anr;

import android.content.Context;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.record.ANRRecord;
import com.didichuxing.omega.sdk.common.record.RecordFactory;
import com.didichuxing.omega.sdk.common.record.RecordStorage;
import com.didichuxing.omega.sdk.common.threadpool.ThreadPoolHelp;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.DataTrackUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import com.didichuxing.omega.sdk.common.utils.SavedState;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ANRTrace {
    private static final String ANR_TRACE_FILE_NAME = "/data/anr/traces.txt";
    /* access modifiers changed from: private */
    public static boolean isTracedNewAnrFileForMyApp = true;
    /* access modifiers changed from: private */
    public static ANRFileObserver mANRFileObserver;
    private static volatile AppState mAppState = AppState.FORCEGROUND;
    private static Context mContext;
    private static SavedState mSavedState;
    private static String mUploadNumKey;
    private static ExecutorService service;
    private String filterReg = "null";

    private enum AppState {
        FORCEGROUND,
        BACKGROUND
    }

    public static void start(Context context) {
        if (context == null) {
            OLog.m34763e("anr trace fail, context is null!");
        } else if (mContext == null) {
            mContext = context;
            mSavedState = new SavedState(context, "anrtrace");
            mUploadNumKey = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
            if (checkAnrTraceAvailable()) {
                ANRFileObserver aNRFileObserver = new ANRFileObserver(ANR_TRACE_FILE_NAME);
                mANRFileObserver = aNRFileObserver;
                aNRFileObserver.startWatching();
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean checkAnrTraceAvailable() {
        File file = new File(ANR_TRACE_FILE_NAME);
        if (!file.exists()) {
            return false;
        }
        return file.canRead();
    }

    public static synchronized void reportANR() {
        synchronized (ANRTrace.class) {
            mANRFileObserver.setMyAppAnr(false);
            if (checkAnrTraceAvailable() && mANRFileObserver.containMyAppStack()) {
                ANRRecord createANRRecord = RecordFactory.createANRRecord(ANR_TRACE_FILE_NAME);
                boolean isUpperLimitByDay = CommonUtil.isUpperLimitByDay("upper_limit_anr", OmegaConfig.UPPER_LIMIT_ANR_EVENT_PER_DAY);
                createANRRecord.takeLogCatWithAnrReason();
                DataTrackUtil.trackDataEvent(DataTrackUtil.EventType.ANR, createANRRecord.getRecordId(), isUpperLimitByDay);
                if (!isUpperLimitByDay) {
                    RecordStorage.save(createANRRecord);
                    CommonUtil.addUpperLimitByDay("upper_limit_anr");
                } else {
                    return;
                }
            }
            mANRFileObserver.setAnrProcessing(false);
        }
    }

    public static void restartObserver(final boolean z) {
        ANRFileObserver aNRFileObserver = mANRFileObserver;
        if (aNRFileObserver != null) {
            aNRFileObserver.stopWatching();
        }
        if (z) {
            isTracedNewAnrFileForMyApp = false;
        }
        ExecutorService executorService = service;
        if (executorService != null) {
            executorService.shutdownNow();
            service = null;
        }
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1, new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ANR_OBSERVER");
            }
        });
        service = newFixedThreadPool;
        newFixedThreadPool.submit(new Runnable() {
            public void run() {
                ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                if (ANRTrace.waitTraceFileCreated(3000)) {
                    ANRFileObserver unused = ANRTrace.mANRFileObserver = new ANRFileObserver(ANRTrace.ANR_TRACE_FILE_NAME);
                    ANRTrace.mANRFileObserver.setMyAppAnr(z);
                    ANRTrace.mANRFileObserver.startWatching();
                    new Timer(true).schedule(new TimerTask() {
                        public void run() {
                            if (!ANRTrace.isTracedNewAnrFileForMyApp && ANRTrace.checkAnrTraceAvailable()) {
                                ANRTrace.reportANR();
                            }
                        }
                    }, 1000);
                }
            }
        });
    }

    public static boolean waitTraceFileCreated(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(ANR_TRACE_FILE_NAME);
        while (System.currentTimeMillis() - currentTimeMillis < j) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (file.exists()) {
                return true;
            }
        }
        return false;
    }

    public static void setIsTracedNewAnrFileForMyApp(boolean z) {
        isTracedNewAnrFileForMyApp = z;
    }
}
