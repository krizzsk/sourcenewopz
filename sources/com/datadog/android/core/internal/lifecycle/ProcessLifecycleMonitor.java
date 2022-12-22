package com.datadog.android.core.internal.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006!"}, mo175978d2 = {"Lcom/datadog/android/core/internal/lifecycle/ProcessLifecycleMonitor;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "callback", "Lcom/datadog/android/core/internal/lifecycle/ProcessLifecycleMonitor$Callback;", "(Lcom/datadog/android/core/internal/lifecycle/ProcessLifecycleMonitor$Callback;)V", "activitiesResumedCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "getActivitiesResumedCounter", "()Ljava/util/concurrent/atomic/AtomicInteger;", "activitiesStartedCounter", "getActivitiesStartedCounter", "getCallback", "()Lcom/datadog/android/core/internal/lifecycle/ProcessLifecycleMonitor$Callback;", "wasPaused", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getWasPaused", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "wasStopped", "getWasStopped", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "Callback", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ProcessLifecycleMonitor.kt */
public final class ProcessLifecycleMonitor implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a */
    private final Callback f3469a;

    /* renamed from: b */
    private final AtomicInteger f3470b = new AtomicInteger(0);

    /* renamed from: c */
    private final AtomicInteger f3471c = new AtomicInteger(0);

    /* renamed from: d */
    private final AtomicBoolean f3472d = new AtomicBoolean(true);

    /* renamed from: e */
    private final AtomicBoolean f3473e = new AtomicBoolean(true);

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/core/internal/lifecycle/ProcessLifecycleMonitor$Callback;", "", "onPaused", "", "onResumed", "onStarted", "onStopped", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ProcessLifecycleMonitor.kt */
    public interface Callback {
        void onPaused();

        void onResumed();

        void onStarted();

        void onStopped();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    public ProcessLifecycleMonitor(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f3469a = callback;
    }

    public final Callback getCallback() {
        return this.f3469a;
    }

    public final AtomicInteger getActivitiesResumedCounter() {
        return this.f3470b;
    }

    public final AtomicInteger getActivitiesStartedCounter() {
        return this.f3471c;
    }

    public final AtomicBoolean getWasPaused() {
        return this.f3472d;
    }

    public final AtomicBoolean getWasStopped() {
        return this.f3473e;
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.f3470b.decrementAndGet() == 0 && !this.f3472d.getAndSet(true)) {
            this.f3469a.onPaused();
        }
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.f3471c.incrementAndGet() == 1 && this.f3473e.getAndSet(false)) {
            this.f3469a.onStarted();
        }
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.f3471c.decrementAndGet() == 0 && this.f3472d.get()) {
            this.f3469a.onStopped();
            this.f3473e.set(true);
        }
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.f3470b.incrementAndGet() == 1 && this.f3472d.getAndSet(false)) {
            this.f3469a.onResumed();
        }
    }
}
