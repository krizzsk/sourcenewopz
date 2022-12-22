package com.datadog.android.rum.internal.vitals;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/vitals/AggregatingVitalMonitor;", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "()V", "lastKnownSample", "", "listeners", "", "Lcom/datadog/android/rum/internal/vitals/VitalListener;", "Lcom/datadog/android/rum/internal/vitals/VitalInfo;", "getLastSample", "notifyListener", "", "listener", "value", "notifyListeners", "onNewSample", "register", "unregister", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AggregatingVitalMonitor.kt */
public final class AggregatingVitalMonitor implements VitalMonitor {

    /* renamed from: a */
    private double f3895a = Double.NaN;

    /* renamed from: b */
    private final Map<VitalListener, VitalInfo> f3896b = new LinkedHashMap();

    public void onNewSample(double d) {
        this.f3895a = d;
        m2519a(d);
    }

    public double getLastSample() {
        return this.f3895a;
    }

    public void register(VitalListener vitalListener) {
        Intrinsics.checkNotNullParameter(vitalListener, "listener");
        double d = this.f3895a;
        synchronized (this.f3896b) {
            this.f3896b.put(vitalListener, VitalInfo.Companion.getEMPTY());
            Unit unit = Unit.INSTANCE;
        }
        if (!Double.isNaN(d)) {
            m2520a(vitalListener, d);
        }
    }

    public void unregister(VitalListener vitalListener) {
        Intrinsics.checkNotNullParameter(vitalListener, "listener");
        synchronized (this.f3896b) {
            VitalInfo remove = this.f3896b.remove(vitalListener);
        }
    }

    /* renamed from: a */
    private final void m2519a(double d) {
        synchronized (this.f3896b) {
            for (VitalListener a : this.f3896b.keySet()) {
                m2520a(a, d);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* renamed from: a */
    private final void m2520a(VitalListener vitalListener, double d) {
        VitalInfo vitalInfo = this.f3896b.get(vitalListener);
        if (vitalInfo == null) {
            vitalInfo = VitalInfo.Companion.getEMPTY();
        }
        int sampleCount = vitalInfo.getSampleCount() + 1;
        VitalInfo vitalInfo2 = new VitalInfo(sampleCount, Math.min(d, vitalInfo.getMinValue()), Math.max(d, vitalInfo.getMaxValue()), ((((double) vitalInfo.getSampleCount()) * vitalInfo.getMeanValue()) + d) / ((double) sampleCount));
        vitalListener.onVitalUpdate(vitalInfo2);
        synchronized (this.f3896b) {
            this.f3896b.put(vitalListener, vitalInfo2);
            Unit unit = Unit.INSTANCE;
        }
    }
}
