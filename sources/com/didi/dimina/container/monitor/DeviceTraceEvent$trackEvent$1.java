package com.didi.dimina.container.monitor;

import com.didi.dimina.container.util.LogUtil;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: DeviceMonitor.kt */
final class DeviceTraceEvent$trackEvent$1 implements Runnable {
    final /* synthetic */ DeviceMonitor $deviceMonitor;
    final /* synthetic */ int $minaIndex;
    final /* synthetic */ PageProcessStat $pageProcessStat;
    final /* synthetic */ PerformanceDotType $type;

    DeviceTraceEvent$trackEvent$1(DeviceMonitor deviceMonitor, PageProcessStat pageProcessStat, PerformanceDotType performanceDotType, int i) {
        this.$deviceMonitor = deviceMonitor;
        this.$pageProcessStat = pageProcessStat;
        this.$type = performanceDotType;
        this.$minaIndex = i;
    }

    public final void run() {
        try {
            DeviceTraceEvent.INSTANCE.m12515a(this.$deviceMonitor, this.$pageProcessStat, this.$type, this.$minaIndex);
        } catch (Exception unused) {
            LogUtil.m13410e("DeviceTraceEvent", "trackEvent event: " + this.$type + " error");
        }
    }
}
