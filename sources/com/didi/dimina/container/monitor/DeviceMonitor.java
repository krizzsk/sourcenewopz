package com.didi.dimina.container.monitor;

import android.os.Process;
import com.didi.dimina.container.util.PerformanceCanaryUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\bR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0004R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/dimina/container/monitor/DeviceMonitor;", "", "pagePath", "", "(Ljava/lang/String;)V", "appTotalMemory", "", "getAppTotalMemory", "()I", "batteryTemperature", "getBatteryTemperature", "()Ljava/lang/Integer;", "cpuTemperature", "getCpuTemperature", "cpuUsage", "", "getCpuUsage", "()F", "getPagePath", "()Ljava/lang/String;", "setPagePath", "power", "getPower", "()Ljava/lang/Float;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "container_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DeviceMonitor.kt */
public final class DeviceMonitor {

    /* renamed from: a */
    private String f16952a;

    public DeviceMonitor() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DeviceMonitor copy$default(DeviceMonitor deviceMonitor, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceMonitor.f16952a;
        }
        return deviceMonitor.copy(str);
    }

    public final String component1() {
        return this.f16952a;
    }

    public final DeviceMonitor copy(String str) {
        Intrinsics.checkParameterIsNotNull(str, "pagePath");
        return new DeviceMonitor(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof DeviceMonitor) && Intrinsics.areEqual((Object) this.f16952a, (Object) ((DeviceMonitor) obj).f16952a);
        }
        return true;
    }

    public int hashCode() {
        String str = this.f16952a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "DeviceMonitor(pagePath=" + this.f16952a + ")";
    }

    public DeviceMonitor(String str) {
        Intrinsics.checkParameterIsNotNull(str, "pagePath");
        this.f16952a = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceMonitor(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getPagePath() {
        return this.f16952a;
    }

    public final void setPagePath(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f16952a = str;
    }

    public final float getCpuUsage() {
        return PerformanceCanaryUtil.getCpuUsageRate(Process.myPid());
    }

    public final int getCpuTemperature() {
        return PerformanceCanaryUtil.INSTANCE.getCpuTemperature();
    }

    public final Float getPower() {
        return PerformanceCanaryUtil.getBattery();
    }

    public final Integer getBatteryTemperature() {
        return PerformanceCanaryUtil.getBatteryTemperature();
    }

    public final int getAppTotalMemory() {
        return PerformanceCanaryUtil.INSTANCE.getAppUsageMemory(Process.myPid());
    }
}
