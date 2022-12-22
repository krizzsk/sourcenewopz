package com.kwai.koom.javaoom.dump;

import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KHeapFile;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.common.KTrigger;
import com.kwai.koom.javaoom.common.KTriggerStrategy;
import com.kwai.koom.javaoom.common.KVData;
import com.kwai.koom.javaoom.monitor.HeapMonitor;
import com.kwai.koom.javaoom.monitor.MonitorManager;
import com.kwai.koom.javaoom.monitor.MonitorTriggerListener;
import com.kwai.koom.javaoom.monitor.MonitorType;
import com.kwai.koom.javaoom.monitor.TriggerReason;
import com.kwai.koom.javaoom.report.HeapAnalyzeReporter;

public class HeapDumpTrigger implements KTrigger {

    /* renamed from: a */
    private static final String f55610a = "HeapDumpTrigger";

    /* renamed from: b */
    private MonitorManager f55611b;

    /* renamed from: c */
    private HeapDumper f55612c = new ForkJvmHeapDumper();

    /* renamed from: d */
    private boolean f55613d;

    /* renamed from: e */
    private HeapDumpListener f55614e;

    public HeapDumpTrigger() {
        MonitorManager monitorManager = new MonitorManager();
        this.f55611b = monitorManager;
        monitorManager.addMonitor(new HeapMonitor());
    }

    public void setHeapDumper(HeapDumper heapDumper) {
        this.f55612c = heapDumper;
    }

    public void startTrack() {
        this.f55611b.start();
        this.f55611b.setTriggerListener(new MonitorTriggerListener() {
            public final boolean onTrigger(MonitorType monitorType, TriggerReason triggerReason) {
                return HeapDumpTrigger.this.m40109a(monitorType, triggerReason);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m40109a(MonitorType monitorType, TriggerReason triggerReason) {
        trigger(triggerReason);
        return true;
    }

    public void stopTrack() {
        this.f55611b.stop();
    }

    public void doHeapDump(TriggerReason.DumpReason dumpReason) {
        KLog.m40102i(f55610a, "doHeapDump");
        KHeapFile.getKHeapFile().buildFiles();
        HeapAnalyzeReporter.addDumpReason(dumpReason);
        HeapAnalyzeReporter.addDeviceRunningInfo();
        if (this.f55612c.dump(KHeapFile.getKHeapFile().hprof.path)) {
            this.f55614e.onHeapDumped(dumpReason);
            return;
        }
        KLog.m40101e(f55610a, "heap dump failed!");
        this.f55614e.onHeapDumpFailed();
        KHeapFile.delete();
    }

    public KTriggerStrategy strategy() {
        return KTriggerStrategy.RIGHT_NOW;
    }

    public void trigger(TriggerReason triggerReason) {
        if (this.f55613d) {
            KLog.m40101e(f55610a, "Only once trigger!");
            return;
        }
        this.f55613d = true;
        this.f55611b.stop();
        KLog.m40102i(f55610a, "trigger reason:" + triggerReason.dumpReason);
        HeapDumpListener heapDumpListener = this.f55614e;
        if (heapDumpListener != null) {
            heapDumpListener.onHeapDumpTrigger(triggerReason.dumpReason);
        }
        try {
            doHeapDump(triggerReason.dumpReason);
        } catch (Exception e) {
            KLog.m40101e(f55610a, "doHeapDump failed");
            e.printStackTrace();
            HeapDumpListener heapDumpListener2 = this.f55614e;
            if (heapDumpListener2 != null) {
                heapDumpListener2.onHeapDumpFailed();
            }
        }
        KVData.addTriggerTime(KGlobalConfig.getRunningInfoFetcher().appVersion());
    }

    public void setHeapDumpListener(HeapDumpListener heapDumpListener) {
        this.f55614e = heapDumpListener;
    }
}
