package com.datadog.android.core.internal.lifecycle;

import android.content.Context;
import com.datadog.android.core.internal.lifecycle.ProcessLifecycleMonitor;
import com.datadog.android.core.internal.net.info.NetworkInfoProvider;
import com.datadog.android.core.internal.utils.WorkManagerUtilsKt;
import com.datadog.android.core.model.NetworkInfo;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, mo175978d2 = {"Lcom/datadog/android/core/internal/lifecycle/ProcessLifecycleCallback;", "Lcom/datadog/android/core/internal/lifecycle/ProcessLifecycleMonitor$Callback;", "networkInfoProvider", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "appContext", "Landroid/content/Context;", "(Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;Landroid/content/Context;)V", "contextWeakRef", "Ljava/lang/ref/WeakReference;", "getNetworkInfoProvider", "()Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "onPaused", "", "onResumed", "onStarted", "onStopped", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ProcessLifecycleCallback.kt */
public final class ProcessLifecycleCallback implements ProcessLifecycleMonitor.Callback {

    /* renamed from: a */
    private final NetworkInfoProvider f3467a;

    /* renamed from: b */
    private final WeakReference<Context> f3468b;

    public void onPaused() {
    }

    public void onResumed() {
    }

    public ProcessLifecycleCallback(NetworkInfoProvider networkInfoProvider, Context context) {
        Intrinsics.checkNotNullParameter(networkInfoProvider, "networkInfoProvider");
        Intrinsics.checkNotNullParameter(context, "appContext");
        this.f3467a = networkInfoProvider;
        this.f3468b = new WeakReference<>(context);
    }

    public final NetworkInfoProvider getNetworkInfoProvider() {
        return this.f3467a;
    }

    public void onStarted() {
        Context context = (Context) this.f3468b.get();
        if (context != null) {
            WorkManagerUtilsKt.cancelUploadWorker(context);
        }
    }

    public void onStopped() {
        Context context;
        if ((this.f3467a.getLatestNetworkInfo().getConnectivity() == NetworkInfo.Connectivity.NETWORK_NOT_CONNECTED) && (context = (Context) this.f3468b.get()) != null) {
            WorkManagerUtilsKt.triggerUploadWorker(context);
        }
    }
}
