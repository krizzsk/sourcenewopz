package com.didichuxing.mas.sdk.quality.collect.cdnmonitor;

import android.content.Context;
import com.didichuxing.mas.sdk.quality.collect.cdnmonitor.config.CdnDetectConfig;
import com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detectionjob.DetectionJob;
import com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detectionjob.DetectionJobFetcher;
import com.didichuxing.mas.sdk.quality.collect.cdnmonitor.detector.CdnDetector;
import com.didichuxing.mas.sdk.quality.report.backend.AppStateMonitor;
import com.didichuxing.mas.sdk.quality.report.collector.LocaleCollector;
import com.didichuxing.mas.sdk.quality.report.collector.PersistentInfoCollector;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadPoolHelp;
import com.didichuxing.mas.sdk.quality.report.threadpool.ThreadTaskObject;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.List;
import java.util.Random;

public class CdnDetectAnalysis {

    /* renamed from: a */
    private static CdnDetectAnalysis f47735a;

    /* renamed from: b */
    private long f47736b = 0;

    private CdnDetectAnalysis() {
    }

    public static synchronized CdnDetectAnalysis getInstance() {
        CdnDetectAnalysis cdnDetectAnalysis;
        synchronized (CdnDetectAnalysis.class) {
            if (f47735a == null) {
                f47735a = new CdnDetectAnalysis();
            }
            cdnDetectAnalysis = f47735a;
        }
        return cdnDetectAnalysis;
    }

    public void start(Context context) {
        if (PersistentInfoCollector.ifNeedODAT("upper_limit_cdn_detect_oday")) {
            m34182b();
        }
        if (!CdnDetectConfig.detectCdnOnlyFirstStartPerDay) {
            m34180a();
        }
    }

    /* renamed from: a */
    private void m34180a() {
        AppStateMonitor.getInstance().registerAppStateListener(new AppStateMonitor.AppStateListener() {
            public void onInForeground() {
            }

            public void onInBackground() {
                if (!CdnDetectAnalysis.this.m34186c()) {
                    CdnDetectAnalysis.this.m34182b();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m34182b() {
        new ThreadTaskObject() {
            public void run() {
                ThreadPoolHelp.renameThread(Thread.currentThread(), getClass().getName());
                Thread.currentThread().setPriority(1);
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                CdnDetectAnalysis.this.m34187d();
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m34186c() {
        return System.currentTimeMillis() - this.f47736b < CdnDetectConfig.cdnDetectInterval;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m34187d() {
        if (!CdnDetectConfig.SWITCH_CDN_MONITOR) {
            OLog.m34418e("SWITCH_CDN_MONITOR is: " + CdnDetectConfig.SWITCH_CDN_MONITOR);
        } else if (m34188e()) {
            OLog.m34418e("uppder the limit: " + CdnDetectConfig.maxCdnDetectCount);
        } else {
            this.f47736b = System.currentTimeMillis();
            List<DetectionJob> f = m34189f();
            if (f.size() == 0) {
                OLog.m34418e("cdn url list is null or empty");
                return;
            }
            int a = m34179a(f);
            while (true) {
                int i = a - 1;
                if (a > 0) {
                    m34184b(f);
                    CommonUtil.addUpperLimitByDay("upper_limit_cdn_detect_overload");
                    a = i;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private int m34179a(List<DetectionJob> list) {
        return CdnDetectConfig.sampleCountCdnDetect > list.size() ? list.size() : CdnDetectConfig.sampleCountCdnDetect;
    }

    /* renamed from: e */
    private boolean m34188e() {
        return CommonUtil.isUpperLimitByDay("upper_limit_cdn_detect_overload", CdnDetectConfig.maxCdnDetectCount);
    }

    /* renamed from: f */
    private List<DetectionJob> m34189f() {
        return new DetectionJobFetcher().fetch().getCdnJobs();
    }

    /* renamed from: b */
    private void m34184b(List<DetectionJob> list) {
        DetectionJob detectionJob = list.get(new Random().nextInt(list.size()));
        List<String> ccc = detectionJob.getCcc();
        if (ccc.size() == 0 || ccc.contains(LocaleCollector.getCanonicalCountryCode())) {
            OmegaSDKAdapter.trackMasEvent("omg_cdn_monitor", (String) null, new CdnDetector(detectionJob.getUrl(), detectionJob.getMd5()).detect().toMap());
        }
    }
}
