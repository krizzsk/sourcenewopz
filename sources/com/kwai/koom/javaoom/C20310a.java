package com.kwai.koom.javaoom;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.kwai.koom.javaoom.KOOMEnableChecker;
import com.kwai.koom.javaoom.KOOMProgressListener;
import com.kwai.koom.javaoom.analysis.HeapAnalysisListener;
import com.kwai.koom.javaoom.analysis.HeapAnalysisTrigger;
import com.kwai.koom.javaoom.analysis.ReanalysisChecker;
import com.kwai.koom.javaoom.common.KConfig;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KHeapFile;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.common.KSoLoader;
import com.kwai.koom.javaoom.common.KUtils;
import com.kwai.koom.javaoom.dump.HeapDumpListener;
import com.kwai.koom.javaoom.dump.HeapDumpTrigger;
import com.kwai.koom.javaoom.monitor.TriggerReason;
import com.kwai.koom.javaoom.report.HeapReportUploader;
import com.kwai.koom.javaoom.report.HprofUploader;
import java.io.File;

/* renamed from: com.kwai.koom.javaoom.a */
/* compiled from: KOOMInternal */
class C20310a implements HeapAnalysisListener, HeapDumpListener {

    /* renamed from: a */
    private static final String f55505a = "KOOM";

    /* renamed from: b */
    private HeapDumpTrigger f55506b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public HeapAnalysisTrigger f55507c;

    /* renamed from: d */
    private KOOMProgressListener f55508d;

    /* renamed from: e */
    private Handler f55509e;

    /* renamed from: f */
    private boolean f55510f;

    /* renamed from: g */
    private HprofUploader f55511g;

    /* renamed from: h */
    private HeapReportUploader f55512h;

    private C20310a() {
    }

    public C20310a(Application application) {
        KUtils.startup();
        m40045a(application);
        this.f55506b = new HeapDumpTrigger();
        this.f55507c = new HeapAnalysisTrigger();
        new Handler(Looper.getMainLooper()).post(new KOOMInternal$1(this));
    }

    /* renamed from: a */
    private void m40045a(Application application) {
        KGlobalConfig.setApplication(application);
        KGlobalConfig.setKConfig(KConfig.defaultConfig());
    }

    /* renamed from: a */
    public void mo164716a(KConfig kConfig) {
        KGlobalConfig.setKConfig(kConfig);
    }

    /* renamed from: a */
    public void mo164712a() {
        HandlerThread handlerThread = new HandlerThread("koom");
        handlerThread.start();
        this.f55509e = new Handler(handlerThread.getLooper());
        m40049g();
    }

    /* renamed from: g */
    private void m40049g() {
        this.f55509e.postDelayed(new Runnable() {
            public final void run() {
                C20310a.this.m40050h();
            }
        }, 10000);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m40050h() {
        try {
            if (this.f55510f) {
                KLog.m40102i(f55505a, "already started!");
                return;
            }
            this.f55510f = true;
            this.f55506b.setHeapDumpListener(this);
            this.f55507c.setHeapAnalysisListener(this);
            if (KOOMEnableChecker.doCheck() != KOOMEnableChecker.Result.NORMAL) {
                KLog.m40101e(f55505a, "koom start failed, check result: " + KOOMEnableChecker.doCheck());
            } else if (new ReanalysisChecker().detectReanalysisFile() != null) {
                KLog.m40102i(f55505a, "detected reanalysis file");
                this.f55507c.trigger(TriggerReason.analysisReason(TriggerReason.AnalysisReason.REANALYSIS));
            } else {
                this.f55506b.startTrack();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo164722b() {
        HeapDumpTrigger heapDumpTrigger = this.f55506b;
        if (heapDumpTrigger != null) {
            heapDumpTrigger.stopTrack();
        }
        HeapAnalysisTrigger heapAnalysisTrigger = this.f55507c;
        if (heapAnalysisTrigger != null) {
            heapAnalysisTrigger.stopTrack();
        }
    }

    /* renamed from: a */
    public void mo164717a(KSoLoader kSoLoader) {
        KGlobalConfig.setSoLoader(kSoLoader);
    }

    /* renamed from: a */
    public boolean mo164721a(String str) {
        if (!new File(str).exists()) {
            return false;
        }
        KGlobalConfig.setRootDir(str);
        return true;
    }

    /* renamed from: c */
    public String mo164723c() {
        return KGlobalConfig.getReportDir();
    }

    /* renamed from: d */
    public String mo164724d() {
        return KGlobalConfig.getHprofDir();
    }

    /* renamed from: a */
    public void mo164718a(HeapDumpTrigger heapDumpTrigger) {
        this.f55506b = heapDumpTrigger;
    }

    /* renamed from: a */
    public void mo164715a(HeapAnalysisTrigger heapAnalysisTrigger) {
        this.f55507c = heapAnalysisTrigger;
    }

    /* renamed from: a */
    public void mo164714a(KOOMProgressListener kOOMProgressListener) {
        this.f55508d = kOOMProgressListener;
    }

    /* renamed from: a */
    public void mo164713a(KOOMProgressListener.Progress progress) {
        KOOMProgressListener kOOMProgressListener = this.f55508d;
        if (kOOMProgressListener != null) {
            kOOMProgressListener.onProgress(progress);
        }
    }

    public void onHeapDumpTrigger(TriggerReason.DumpReason dumpReason) {
        KLog.m40102i(f55505a, "onHeapDumpTrigger");
        mo164713a(KOOMProgressListener.Progress.HEAP_DUMP_START);
    }

    public void onHeapDumped(TriggerReason.DumpReason dumpReason) {
        KLog.m40102i(f55505a, "onHeapDumped");
        mo164713a(KOOMProgressListener.Progress.HEAP_DUMPED);
        if (dumpReason != TriggerReason.DumpReason.MANUAL_TRIGGER_ON_CRASH) {
            this.f55507c.startTrack();
        } else {
            KLog.m40102i(f55505a, "reanalysis next launch when trigger on crash");
        }
    }

    public void onHeapDumpFailed() {
        mo164713a(KOOMProgressListener.Progress.HEAP_DUMP_FAILED);
    }

    public void onHeapAnalysisTrigger() {
        KLog.m40102i(f55505a, "onHeapAnalysisTrigger");
        mo164713a(KOOMProgressListener.Progress.HEAP_ANALYSIS_START);
    }

    public void onHeapAnalyzed() {
        KLog.m40102i(f55505a, "onHeapAnalyzed");
        mo164713a(KOOMProgressListener.Progress.HEAP_ANALYSIS_DONE);
        m40048a(KHeapFile.getKHeapFile());
    }

    public void onHeapAnalyzeFailed() {
        mo164713a(KOOMProgressListener.Progress.HEAP_ANALYSIS_FAILED);
    }

    /* renamed from: a */
    private void m40048a(KHeapFile kHeapFile) {
        m40046a(kHeapFile.hprof);
        m40047a(kHeapFile.report);
    }

    /* renamed from: a */
    private void m40046a(KHeapFile.Hprof hprof) {
        HprofUploader hprofUploader = this.f55511g;
        if (hprofUploader != null) {
            hprofUploader.upload(hprof.file());
        }
        HprofUploader hprofUploader2 = this.f55511g;
        if (hprofUploader2 == null || hprofUploader2.deleteWhenUploaded()) {
            KLog.m40102i(f55505a, "delete " + hprof.path);
            hprof.delete();
        }
    }

    /* renamed from: a */
    private void m40047a(KHeapFile.Report report) {
        HeapReportUploader heapReportUploader = this.f55512h;
        if (heapReportUploader != null) {
            heapReportUploader.upload(report.file());
        }
        HeapReportUploader heapReportUploader2 = this.f55512h;
        if (heapReportUploader2 != null && heapReportUploader2.deleteWhenUploaded()) {
            KLog.m40102i(f55505a, "report delete");
            report.delete();
        }
    }

    /* renamed from: a */
    public void mo164720a(HprofUploader hprofUploader) {
        this.f55511g = hprofUploader;
    }

    /* renamed from: a */
    public void mo164719a(HeapReportUploader heapReportUploader) {
        this.f55512h = heapReportUploader;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m40051i() {
        if (!this.f55510f) {
            m40050h();
        }
        if (this.f55510f) {
            this.f55506b.trigger(TriggerReason.dumpReason(TriggerReason.DumpReason.MANUAL_TRIGGER));
        }
    }

    /* renamed from: e */
    public void mo164725e() {
        this.f55509e.post(new Runnable() {
            public final void run() {
                C20310a.this.m40051i();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m40052j() {
        if (!this.f55510f) {
            m40050h();
        }
        if (this.f55510f) {
            this.f55506b.trigger(TriggerReason.dumpReason(TriggerReason.DumpReason.MANUAL_TRIGGER_ON_CRASH));
        }
    }

    /* renamed from: f */
    public void mo164726f() {
        this.f55509e.post(new Runnable() {
            public final void run() {
                C20310a.this.m40052j();
            }
        });
    }
}
