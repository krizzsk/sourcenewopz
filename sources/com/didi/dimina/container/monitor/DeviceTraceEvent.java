package com.didi.dimina.container.monitor;

import com.didi.dimina.container.mina.DMThreadPool;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.TraceUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J,\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/dimina/container/monitor/DeviceTraceEvent;", "", "()V", "TAG", "", "traceEventDeviceStat", "", "deviceMonitor", "Lcom/didi/dimina/container/monitor/DeviceMonitor;", "pageProcessStat", "Lcom/didi/dimina/container/monitor/PageProcessStat;", "type", "Lcom/didi/dimina/container/monitor/PerformanceDotType;", "minaIndex", "", "trackEvent", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DeviceMonitor.kt */
public final class DeviceTraceEvent {
    public static final DeviceTraceEvent INSTANCE = new DeviceTraceEvent();

    /* renamed from: a */
    private static final String f16953a = "DeviceTraceEvent";

    @JvmStatic
    public static final void trackEvent(int i, PerformanceDotType performanceDotType, DeviceMonitor deviceMonitor) {
        trackEvent$default(i, performanceDotType, deviceMonitor, (PageProcessStat) null, 8, (Object) null);
    }

    private DeviceTraceEvent() {
    }

    public static /* synthetic */ void trackEvent$default(int i, PerformanceDotType performanceDotType, DeviceMonitor deviceMonitor, PageProcessStat pageProcessStat, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            pageProcessStat = null;
        }
        trackEvent(i, performanceDotType, deviceMonitor, pageProcessStat);
    }

    @JvmStatic
    public static final void trackEvent(int i, PerformanceDotType performanceDotType, DeviceMonitor deviceMonitor, PageProcessStat pageProcessStat) {
        Intrinsics.checkParameterIsNotNull(performanceDotType, "type");
        Intrinsics.checkParameterIsNotNull(deviceMonitor, "deviceMonitor");
        DMThreadPool.post2HandlerThread(new DeviceTraceEvent$trackEvent$1(deviceMonitor, pageProcessStat, performanceDotType, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m12515a(DeviceMonitor deviceMonitor, PageProcessStat pageProcessStat, PerformanceDotType performanceDotType, int i) {
        float f;
        String valueOf = String.valueOf(deviceMonitor.getAppTotalMemory());
        Map hashMap = new HashMap();
        hashMap.put("power", String.valueOf(deviceMonitor.getPower()));
        hashMap.put("battery_temperature", String.valueOf(deviceMonitor.getBatteryTemperature()));
        hashMap.put("app_tool_memory", valueOf);
        hashMap.put("cpu_usage", String.valueOf(deviceMonitor.getCpuUsage()));
        hashMap.put("dot_type", performanceDotType.getType());
        hashMap.put("cpu_temperature", Integer.valueOf(deviceMonitor.getCpuTemperature()));
        CharSequence pagePath = deviceMonitor.getPagePath();
        if (pagePath.length() > 0) {
            List split$default = StringsKt.split$default(pagePath, new String[]{"?"}, false, 0, 6, (Object) null);
            if (!split$default.isEmpty()) {
                hashMap.put("page_path", split$default.get(0));
            }
        }
        if (pageProcessStat != null) {
            hashMap.put("memory_difference", String.valueOf(((long) deviceMonitor.getAppTotalMemory()) - Long.valueOf(pageProcessStat.getPageCreateMemory()).longValue()));
        }
        if (pageProcessStat != null) {
            float floatValue = Float.valueOf(pageProcessStat.getPageCreatePower()).floatValue();
            if (deviceMonitor.getPower() != null) {
                Float power = deviceMonitor.getPower();
                if (power == null) {
                    Intrinsics.throwNpe();
                }
                f = power.floatValue();
            } else {
                f = 0.0f;
            }
            if (floatValue != 0.0f) {
                hashMap.put("power_difference", String.valueOf(f - floatValue));
            }
        }
        if (pageProcessStat != null) {
            hashMap.put("stay_time", String.valueOf(System.currentTimeMillis() - pageProcessStat.getTimestamp()));
        }
        LogUtil.m13408d(f16953a, "trackEvent event: " + performanceDotType + " event: " + hashMap);
        TraceUtil.traceEventDeviceStat(i, hashMap);
    }
}
