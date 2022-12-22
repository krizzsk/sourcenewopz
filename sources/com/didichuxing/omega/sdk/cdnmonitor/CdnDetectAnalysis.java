package com.didichuxing.omega.sdk.cdnmonitor;

import android.content.Context;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.cdnmonitor.config.CdnDetectConfig;
import com.didichuxing.omega.sdk.cdnmonitor.detectionjob.DetectionJob;
import com.didichuxing.omega.sdk.cdnmonitor.detectionjob.DetectionJobFetcher;
import com.didichuxing.omega.sdk.cdnmonitor.detector.CdnDetector;
import com.didichuxing.omega.sdk.common.backend.AppStateMonitor;
import com.didichuxing.omega.sdk.common.collector.LocaleCollector;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.threadpool.ThreadPoolHelp;
import com.didichuxing.omega.sdk.common.threadpool.ThreadTaskObject;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import com.didichuxing.omega.sdk.common.utils.OLog;
import java.util.List;
import java.util.Random;

public class CdnDetectAnalysis {
    private static CdnDetectAnalysis instance;
    private long lastDetectTime = 0;

    private CdnDetectAnalysis() {
    }

    public static synchronized CdnDetectAnalysis getInstance() {
        CdnDetectAnalysis cdnDetectAnalysis;
        synchronized (CdnDetectAnalysis.class) {
            if (instance == null) {
                instance = new CdnDetectAnalysis();
            }
            cdnDetectAnalysis = instance;
        }
        return cdnDetectAnalysis;
    }

    public void start(Context context) {
        if (PersistentInfoCollector.ifNeedODAT("upper_limit_cdn_detect_oday")) {
            doCdnDetectAsyc();
        }
        if (!CdnDetectConfig.detectCdnOnlyFirstStartPerDay) {
            registerCallbackOnAppStateChange();
        }
    }

    private void registerCallbackOnAppStateChange() {
        AppStateMonitor.getInstance().registerAppStateListener(new AppStateMonitor.AppStateListener() {
            public void onInForeground() {
            }

            public void onInBackground() {
                if (!CdnDetectAnalysis.this.detectionTooQuick()) {
                    CdnDetectAnalysis.this.doCdnDetectAsyc();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void doCdnDetectAsyc() {
        new ThreadTaskObject() {
            public void run() {
                ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                Thread.currentThread().setPriority(1);
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CdnDetectAnalysis.this.doCdnDetectSync();
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public boolean detectionTooQuick() {
        return System.currentTimeMillis() - this.lastDetectTime < CdnDetectConfig.cdnDetectInterval;
    }

    /* access modifiers changed from: private */
    public void doCdnDetectSync() {
        if (!CdnDetectConfig.SWITCH_CDN_MONITOR) {
            OLog.m34763e("SWITCH_CDN_MONITOR is: " + CdnDetectConfig.SWITCH_CDN_MONITOR);
        } else if (exceedMaxDetectionCountPerDay()) {
            OLog.m34763e("uppder the limit: " + CdnDetectConfig.maxCdnDetectCount);
        } else {
            this.lastDetectTime = System.currentTimeMillis();
            List<DetectionJob> detectionJobs = getDetectionJobs();
            if (detectionJobs.size() == 0) {
                OLog.m34763e("cdn url list is null or empty");
                return;
            }
            int detectCount = getDetectCount(detectionJobs);
            while (true) {
                int i = detectCount - 1;
                if (detectCount > 0) {
                    runCdnDetectionJobRandomly(detectionJobs);
                    CommonUtil.addUpperLimitByDay("upper_limit_cdn_detect_overload");
                    detectCount = i;
                } else {
                    return;
                }
            }
        }
    }

    private int getDetectCount(List<DetectionJob> list) {
        return CdnDetectConfig.sampleCountCdnDetect > list.size() ? list.size() : CdnDetectConfig.sampleCountCdnDetect;
    }

    private boolean exceedMaxDetectionCountPerDay() {
        return CommonUtil.isUpperLimitByDay("upper_limit_cdn_detect_overload", CdnDetectConfig.maxCdnDetectCount);
    }

    private List<DetectionJob> getDetectionJobs() {
        return new DetectionJobFetcher().fetch().getCdnJobs();
    }

    private void runCdnDetectionJobRandomly(List<DetectionJob> list) {
        DetectionJob detectionJob = list.get(new Random().nextInt(list.size()));
        List<String> ccc = detectionJob.getCcc();
        if (ccc.size() == 0 || ccc.contains(LocaleCollector.getCanonicalCountryCode())) {
            Tracker.trackEvent("omg_cdn_monitor", (String) null, new CdnDetector(detectionJob.getUrl(), detectionJob.getMd5()).detect().toMap());
        }
    }
}
