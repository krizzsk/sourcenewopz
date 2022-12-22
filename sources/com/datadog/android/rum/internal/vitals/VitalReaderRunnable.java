package com.datadog.android.rum.internal.vitals;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/vitals/VitalReaderRunnable;", "Ljava/lang/Runnable;", "reader", "Lcom/datadog/android/rum/internal/vitals/VitalReader;", "observer", "Lcom/datadog/android/rum/internal/vitals/VitalObserver;", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "periodMs", "", "(Lcom/datadog/android/rum/internal/vitals/VitalReader;Lcom/datadog/android/rum/internal/vitals/VitalObserver;Ljava/util/concurrent/ScheduledExecutorService;J)V", "getExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "getObserver", "()Lcom/datadog/android/rum/internal/vitals/VitalObserver;", "getPeriodMs", "()J", "getReader", "()Lcom/datadog/android/rum/internal/vitals/VitalReader;", "run", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: VitalReaderRunnable.kt */
public final class VitalReaderRunnable implements Runnable {

    /* renamed from: a */
    private final VitalReader f3918a;

    /* renamed from: b */
    private final VitalObserver f3919b;

    /* renamed from: c */
    private final ScheduledExecutorService f3920c;

    /* renamed from: d */
    private final long f3921d;

    public VitalReaderRunnable(VitalReader vitalReader, VitalObserver vitalObserver, ScheduledExecutorService scheduledExecutorService, long j) {
        Intrinsics.checkNotNullParameter(vitalReader, "reader");
        Intrinsics.checkNotNullParameter(vitalObserver, "observer");
        Intrinsics.checkNotNullParameter(scheduledExecutorService, "executor");
        this.f3918a = vitalReader;
        this.f3919b = vitalObserver;
        this.f3920c = scheduledExecutorService;
        this.f3921d = j;
    }

    public final VitalReader getReader() {
        return this.f3918a;
    }

    public final VitalObserver getObserver() {
        return this.f3919b;
    }

    public final ScheduledExecutorService getExecutor() {
        return this.f3920c;
    }

    public final long getPeriodMs() {
        return this.f3921d;
    }

    public void run() {
        Double readVitalData = this.f3918a.readVitalData();
        if (readVitalData != null) {
            this.f3919b.onNewSample(readVitalData.doubleValue());
        }
        this.f3920c.schedule(this, this.f3921d, TimeUnit.MILLISECONDS);
    }
}
