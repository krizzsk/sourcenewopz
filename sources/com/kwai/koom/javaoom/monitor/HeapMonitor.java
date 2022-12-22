package com.kwai.koom.javaoom.monitor;

import com.kwai.koom.javaoom.common.KConstants;
import com.kwai.koom.javaoom.common.KGlobalConfig;
import com.kwai.koom.javaoom.common.KLog;
import com.kwai.koom.javaoom.monitor.TriggerReason;

public class HeapMonitor implements Monitor {

    /* renamed from: a */
    private static final String f55620a = "HeapMonitor";

    /* renamed from: b */
    private HeapThreshold f55621b;

    /* renamed from: c */
    private int f55622c = 0;

    /* renamed from: d */
    private HeapStatus f55623d;

    /* renamed from: e */
    private volatile boolean f55624e = false;

    public void setThreshold(Threshold threshold) {
        if (threshold instanceof HeapThreshold) {
            this.f55621b = (HeapThreshold) threshold;
            return;
        }
        throw new RuntimeException("Must be HeapThreshold!");
    }

    public TriggerReason getTriggerReason() {
        return TriggerReason.dumpReason(TriggerReason.DumpReason.HEAP_OVER_THRESHOLD);
    }

    public boolean isTrigger() {
        if (!this.f55624e) {
            return false;
        }
        HeapStatus a = m40110a();
        if (a.isOverMaxThreshold) {
            KLog.m40102i(f55620a, "heap used is over max ratio, force trigger and over times reset to 0");
            this.f55622c = 0;
            return true;
        }
        if (a.isOverThreshold) {
            KLog.m40102i(f55620a, "heap status used:" + (a.used / ((long) KConstants.Bytes.f55586MB)) + ", max:" + (a.max / ((long) KConstants.Bytes.f55586MB)) + ", last over times:" + this.f55622c);
            if (!this.f55621b.ascending()) {
                this.f55622c++;
            } else if (this.f55623d == null || a.used >= this.f55623d.used || a.isOverMaxThreshold) {
                this.f55622c++;
            } else {
                KLog.m40102i(f55620a, "heap status used is not ascending, and over times reset to 0");
                this.f55622c = 0;
            }
        } else {
            this.f55622c = 0;
        }
        this.f55623d = a;
        if (this.f55622c >= this.f55621b.overTimes()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private HeapStatus m40110a() {
        HeapStatus heapStatus = new HeapStatus();
        heapStatus.max = Runtime.getRuntime().maxMemory();
        heapStatus.used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        float f = (((float) heapStatus.used) * 100.0f) / ((float) heapStatus.max);
        boolean z = true;
        heapStatus.isOverThreshold = f > this.f55621b.value();
        if (f <= this.f55621b.maxValue()) {
            z = false;
        }
        heapStatus.isOverMaxThreshold = z;
        return heapStatus;
    }

    static class HeapStatus {
        boolean isOverMaxThreshold;
        boolean isOverThreshold;
        long max;
        long used;

        HeapStatus() {
        }
    }

    public MonitorType monitorType() {
        return MonitorType.HEAP;
    }

    public void start() {
        this.f55624e = true;
        if (this.f55621b == null) {
            this.f55621b = KGlobalConfig.getHeapThreshold();
        }
        KLog.m40102i(f55620a, "start HeapMonitor, HeapThreshold ratio:" + this.f55621b.value() + ", max over times: " + this.f55621b.overTimes());
    }

    public void stop() {
        KLog.m40102i(f55620a, "stop");
        this.f55624e = false;
    }

    public int pollInterval() {
        return this.f55621b.pollInterval();
    }
}
