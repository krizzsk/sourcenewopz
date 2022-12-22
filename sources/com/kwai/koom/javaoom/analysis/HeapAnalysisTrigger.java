package com.kwai.koom.javaoom.analysis;

import android.app.Application;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.common.KTrigger;
import com.kwai.koom.javaoom.common.KTriggerStrategy;
import com.kwai.koom.javaoom.monitor.TriggerReason;
import com.kwai.koom.javaoom.report.HeapAnalyzeReporter;

public class HeapAnalysisTrigger implements KTrigger {

    /* renamed from: a */
    private static final String f55541a = "HeapAnalysisTrigger";

    /* renamed from: b */
    private HeapAnalysisListener f55542b;

    /* renamed from: c */
    private boolean f55543c;

    /* renamed from: d */
    private KTriggerStrategy f55544d;

    /* renamed from: e */
    private volatile boolean f55545e;

    /* renamed from: f */
    private TriggerReason f55546f;

    public void stopTrack() {
    }

    public void setHeapAnalysisListener(HeapAnalysisListener heapAnalysisListener) {
        this.f55542b = heapAnalysisListener;
    }

    public void startTrack() {
        if (strategy() == KTriggerStrategy.RIGHT_NOW) {
            trigger(TriggerReason.analysisReason(TriggerReason.AnalysisReason.RIGHT_NOW));
        }
    }

    public void doAnalysis(Application application) {
        HeapAnalyzeService.runAnalysis(application, this.f55542b);
    }

    public void trigger(TriggerReason triggerReason) {
        if (!this.f55545e) {
            KLog.m40102i(f55541a, "reTrigger when foreground");
            this.f55546f = triggerReason;
            return;
        }
        KLog.m40102i(f55541a, "trigger reason:" + triggerReason.analysisReason);
        if (this.f55543c) {
            KLog.m40102i(f55541a, "Only once trigger!");
            return;
        }
        this.f55543c = true;
        HeapAnalyzeReporter.addAnalysisReason(triggerReason.analysisReason);
        if (triggerReason.analysisReason == TriggerReason.AnalysisReason.REANALYSIS) {
            HeapAnalyzeReporter.recordReanalysis();
        }
        HeapAnalysisListener heapAnalysisListener = this.f55542b;
        if (heapAnalysisListener != null) {
            heapAnalysisListener.onHeapAnalysisTrigger();
        }
        try {
            doAnalysis(KGlobalConfig.getApplication());
        } catch (Exception e) {
            KLog.m40101e(f55541a, "doAnalysis failed");
            e.printStackTrace();
            HeapAnalysisListener heapAnalysisListener2 = this.f55542b;
            if (heapAnalysisListener2 != null) {
                heapAnalysisListener2.onHeapAnalyzeFailed();
            }
        }
    }

    public void setStrategy(KTriggerStrategy kTriggerStrategy) {
        this.f55544d = kTriggerStrategy;
    }

    public KTriggerStrategy strategy() {
        KTriggerStrategy kTriggerStrategy = this.f55544d;
        if (kTriggerStrategy != null) {
            return kTriggerStrategy;
        }
        return KTriggerStrategy.RIGHT_NOW;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onBackground() {
        KLog.m40102i(f55541a, "onBackground");
        this.f55545e = false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onForeground() {
        KLog.m40102i(f55541a, "onForeground");
        this.f55545e = true;
        TriggerReason triggerReason = this.f55546f;
        if (triggerReason != null) {
            this.f55546f = null;
            trigger(triggerReason);
        }
    }
}
