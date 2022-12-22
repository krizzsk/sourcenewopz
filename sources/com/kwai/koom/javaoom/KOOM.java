package com.kwai.koom.javaoom;

import android.app.Application;
import com.kwai.koom.javaoom.analysis.HeapAnalysisTrigger;
import com.kwai.koom.javaoom.common.KConfig;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.dump.HeapDumpTrigger;
import com.kwai.koom.javaoom.report.HeapReportUploader;
import com.kwai.koom.javaoom.report.HprofUploader;

public class KOOM {

    /* renamed from: b */
    private static KOOM f55499b = null;

    /* renamed from: c */
    private static boolean f55500c = false;

    /* renamed from: d */
    private static final String f55501d = "koom";

    /* renamed from: a */
    private C20310a f55502a;

    private KOOM() {
    }

    private KOOM(Application application) {
        if (!f55500c) {
            init(application);
        }
        this.f55502a = new C20310a(application);
    }

    public static void init(Application application) {
        KLog.init(new KLog.DefaultLogger());
        if (f55500c) {
            KLog.m40102i(f55501d, "already init!");
            return;
        }
        f55500c = true;
        if (f55499b == null) {
            f55499b = new KOOM(application);
        }
        f55499b.start();
    }

    public static KOOM getInstance() {
        return f55499b;
    }

    public void start() {
        this.f55502a.mo164712a();
    }

    public void stop() {
        this.f55502a.mo164722b();
    }

    public void setProgressListener(KOOMProgressListener kOOMProgressListener) {
        this.f55502a.mo164714a(kOOMProgressListener);
    }

    public String getReportDir() {
        return this.f55502a.mo164723c();
    }

    public String getHprofDir() {
        return this.f55502a.mo164724d();
    }

    public boolean setRootDir(String str) {
        return this.f55502a.mo164721a(str);
    }

    public void setKConfig(KConfig kConfig) {
        this.f55502a.mo164716a(kConfig);
    }

    public void setHprofUploader(HprofUploader hprofUploader) {
        this.f55502a.mo164720a(hprofUploader);
    }

    public void setHeapReportUploader(HeapReportUploader heapReportUploader) {
        this.f55502a.mo164719a(heapReportUploader);
    }

    public void setHeapDumpTrigger(HeapDumpTrigger heapDumpTrigger) {
        this.f55502a.mo164718a(heapDumpTrigger);
    }

    public void setHeapAnalysisTrigger(HeapAnalysisTrigger heapAnalysisTrigger) {
        this.f55502a.mo164715a(heapAnalysisTrigger);
    }

    public void manualTrigger() {
        this.f55502a.mo164725e();
    }

    public void manualTriggerOnCrash() {
        this.f55502a.mo164726f();
    }

    public void setLogger(KLog.KLogger kLogger) {
        KLog.init(kLogger);
    }
}
