package com.datadog.android.core.internal.data.upload;

import com.datadog.android.core.configuration.UploadFrequency;
import com.datadog.android.core.internal.net.DataUploader;
import com.datadog.android.core.internal.net.info.NetworkInfoProvider;
import com.datadog.android.core.internal.persistence.DataReader;
import com.datadog.android.core.internal.system.SystemInfoProvider;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/datadog/android/core/internal/data/upload/DataUploadScheduler;", "Lcom/datadog/android/core/internal/data/upload/UploadScheduler;", "reader", "Lcom/datadog/android/core/internal/persistence/DataReader;", "dataUploader", "Lcom/datadog/android/core/internal/net/DataUploader;", "networkInfoProvider", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "systemInfoProvider", "Lcom/datadog/android/core/internal/system/SystemInfoProvider;", "uploadFrequency", "Lcom/datadog/android/core/configuration/UploadFrequency;", "scheduledThreadPoolExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "(Lcom/datadog/android/core/internal/persistence/DataReader;Lcom/datadog/android/core/internal/net/DataUploader;Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;Lcom/datadog/android/core/internal/system/SystemInfoProvider;Lcom/datadog/android/core/configuration/UploadFrequency;Ljava/util/concurrent/ScheduledThreadPoolExecutor;)V", "runnable", "Lcom/datadog/android/core/internal/data/upload/DataUploadRunnable;", "startScheduling", "", "stopScheduling", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DataUploadScheduler.kt */
public final class DataUploadScheduler implements UploadScheduler {

    /* renamed from: a */
    private final ScheduledThreadPoolExecutor f3464a;

    /* renamed from: b */
    private final DataUploadRunnable f3465b;

    public DataUploadScheduler(DataReader dataReader, DataUploader dataUploader, NetworkInfoProvider networkInfoProvider, SystemInfoProvider systemInfoProvider, UploadFrequency uploadFrequency, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        Intrinsics.checkNotNullParameter(dataReader, "reader");
        Intrinsics.checkNotNullParameter(dataUploader, "dataUploader");
        Intrinsics.checkNotNullParameter(networkInfoProvider, "networkInfoProvider");
        Intrinsics.checkNotNullParameter(systemInfoProvider, "systemInfoProvider");
        Intrinsics.checkNotNullParameter(uploadFrequency, "uploadFrequency");
        Intrinsics.checkNotNullParameter(scheduledThreadPoolExecutor, "scheduledThreadPoolExecutor");
        this.f3464a = scheduledThreadPoolExecutor;
        this.f3465b = new DataUploadRunnable(scheduledThreadPoolExecutor, dataReader, dataUploader, networkInfoProvider, systemInfoProvider, uploadFrequency);
    }

    public void startScheduling() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f3464a;
        DataUploadRunnable dataUploadRunnable = this.f3465b;
        scheduledThreadPoolExecutor.schedule(dataUploadRunnable, dataUploadRunnable.getCurrentDelayIntervalMs$dd_sdk_android_release(), TimeUnit.MILLISECONDS);
    }

    public void stopScheduling() {
        this.f3464a.remove(this.f3465b);
    }
}
