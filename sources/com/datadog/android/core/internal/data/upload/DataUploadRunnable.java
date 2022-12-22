package com.datadog.android.core.internal.data.upload;

import com.datadog.android.core.configuration.UploadFrequency;
import com.datadog.android.core.internal.net.DataUploader;
import com.datadog.android.core.internal.net.UploadStatus;
import com.datadog.android.core.internal.net.info.NetworkInfoProvider;
import com.datadog.android.core.internal.persistence.Batch;
import com.datadog.android.core.internal.persistence.DataReader;
import com.datadog.android.core.internal.system.SystemInfo;
import com.datadog.android.core.internal.system.SystemInfoProvider;
import com.datadog.android.core.model.NetworkInfo;
import java.util.Set;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u001cH\u0002R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, mo175978d2 = {"Lcom/datadog/android/core/internal/data/upload/DataUploadRunnable;", "Lcom/datadog/android/core/internal/data/upload/UploadRunnable;", "threadPoolExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "reader", "Lcom/datadog/android/core/internal/persistence/DataReader;", "dataUploader", "Lcom/datadog/android/core/internal/net/DataUploader;", "networkInfoProvider", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "systemInfoProvider", "Lcom/datadog/android/core/internal/system/SystemInfoProvider;", "uploadFrequency", "Lcom/datadog/android/core/configuration/UploadFrequency;", "(Ljava/util/concurrent/ScheduledThreadPoolExecutor;Lcom/datadog/android/core/internal/persistence/DataReader;Lcom/datadog/android/core/internal/net/DataUploader;Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;Lcom/datadog/android/core/internal/system/SystemInfoProvider;Lcom/datadog/android/core/configuration/UploadFrequency;)V", "currentDelayIntervalMs", "", "getCurrentDelayIntervalMs$dd_sdk_android_release", "()J", "setCurrentDelayIntervalMs$dd_sdk_android_release", "(J)V", "maxDelayMs", "getMaxDelayMs$dd_sdk_android_release", "setMaxDelayMs$dd_sdk_android_release", "minDelayMs", "getMinDelayMs$dd_sdk_android_release", "setMinDelayMs$dd_sdk_android_release", "consumeBatch", "", "batch", "Lcom/datadog/android/core/internal/persistence/Batch;", "decreaseInterval", "increaseInterval", "isNetworkAvailable", "", "isSystemReady", "run", "scheduleNextUpload", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DataUploadRunnable.kt */
public final class DataUploadRunnable implements UploadRunnable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DECREASE_PERCENT = 90;
    public static final int DEFAULT_DELAY_FACTOR = 5;
    public static final int INCREASE_PERCENT = 110;
    public static final int MAX_DELAY_FACTOR = 10;
    public static final int MIN_DELAY_FACTOR = 1;

    /* renamed from: i */
    private static final Set<UploadStatus> f3453i = SetsKt.setOf(UploadStatus.SUCCESS, UploadStatus.HTTP_REDIRECTION, UploadStatus.HTTP_CLIENT_ERROR, UploadStatus.UNKNOWN_ERROR, UploadStatus.INVALID_TOKEN_ERROR);

    /* renamed from: j */
    private static final Set<SystemInfo.BatteryStatus> f3454j = SetsKt.setOf(SystemInfo.BatteryStatus.CHARGING, SystemInfo.BatteryStatus.FULL);

    /* renamed from: k */
    private static final int f3455k = 10;

    /* renamed from: a */
    private final ScheduledThreadPoolExecutor f3456a;

    /* renamed from: b */
    private final DataReader f3457b;

    /* renamed from: c */
    private final DataUploader f3458c;

    /* renamed from: d */
    private final NetworkInfoProvider f3459d;

    /* renamed from: e */
    private final SystemInfoProvider f3460e;

    /* renamed from: f */
    private long f3461f;

    /* renamed from: g */
    private long f3462g;

    /* renamed from: h */
    private long f3463h;

    public DataUploadRunnable(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, DataReader dataReader, DataUploader dataUploader, NetworkInfoProvider networkInfoProvider, SystemInfoProvider systemInfoProvider, UploadFrequency uploadFrequency) {
        Intrinsics.checkNotNullParameter(scheduledThreadPoolExecutor, "threadPoolExecutor");
        Intrinsics.checkNotNullParameter(dataReader, "reader");
        Intrinsics.checkNotNullParameter(dataUploader, "dataUploader");
        Intrinsics.checkNotNullParameter(networkInfoProvider, "networkInfoProvider");
        Intrinsics.checkNotNullParameter(systemInfoProvider, "systemInfoProvider");
        Intrinsics.checkNotNullParameter(uploadFrequency, "uploadFrequency");
        this.f3456a = scheduledThreadPoolExecutor;
        this.f3457b = dataReader;
        this.f3458c = dataUploader;
        this.f3459d = networkInfoProvider;
        this.f3460e = systemInfoProvider;
        this.f3461f = ((long) 5) * uploadFrequency.getBaseStepMs$dd_sdk_android_release();
        this.f3462g = uploadFrequency.getBaseStepMs$dd_sdk_android_release() * 1;
        this.f3463h = ((long) 10) * uploadFrequency.getBaseStepMs$dd_sdk_android_release();
    }

    public final long getCurrentDelayIntervalMs$dd_sdk_android_release() {
        return this.f3461f;
    }

    public final void setCurrentDelayIntervalMs$dd_sdk_android_release(long j) {
        this.f3461f = j;
    }

    public final long getMinDelayMs$dd_sdk_android_release() {
        return this.f3462g;
    }

    public final void setMinDelayMs$dd_sdk_android_release(long j) {
        this.f3462g = j;
    }

    public final long getMaxDelayMs$dd_sdk_android_release() {
        return this.f3463h;
    }

    public final void setMaxDelayMs$dd_sdk_android_release(long j) {
        this.f3463h = j;
    }

    public void run() {
        Batch lockAndReadNext = (!m2311a() || !m2312b()) ? null : this.f3457b.lockAndReadNext();
        if (lockAndReadNext != null) {
            m2310a(lockAndReadNext);
        } else {
            m2315e();
        }
        m2313c();
    }

    /* renamed from: a */
    private final boolean m2311a() {
        return this.f3459d.getLatestNetworkInfo().getConnectivity() != NetworkInfo.Connectivity.NETWORK_NOT_CONNECTED;
    }

    /* renamed from: b */
    private final boolean m2312b() {
        SystemInfo latestSystemInfo = this.f3460e.getLatestSystemInfo();
        return (f3454j.contains(latestSystemInfo.getBatteryStatus()) || latestSystemInfo.getBatteryLevel() > 10) && !latestSystemInfo.getPowerSaveMode();
    }

    /* renamed from: c */
    private final void m2313c() {
        Runnable runnable = this;
        this.f3456a.remove(runnable);
        this.f3456a.schedule(runnable, this.f3461f, TimeUnit.MILLISECONDS);
    }

    /* renamed from: a */
    private final void m2310a(Batch batch) {
        if (this.f3458c.upload(batch.getData()).getShouldRetry()) {
            this.f3457b.release(batch);
            m2315e();
            return;
        }
        this.f3457b.drop(batch);
        m2314d();
    }

    /* renamed from: d */
    private final void m2314d() {
        this.f3461f = Math.max(this.f3462g, (this.f3461f * ((long) 90)) / ((long) 100));
    }

    /* renamed from: e */
    private final void m2315e() {
        this.f3461f = Math.min(this.f3463h, (this.f3461f * ((long) 110)) / ((long) 100));
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/datadog/android/core/internal/data/upload/DataUploadRunnable$Companion;", "", "()V", "DECREASE_PERCENT", "", "DEFAULT_DELAY_FACTOR", "INCREASE_PERCENT", "LOW_BATTERY_THRESHOLD", "MAX_DELAY_FACTOR", "MIN_DELAY_FACTOR", "batteryFullOrChargingStatus", "", "Lcom/datadog/android/core/internal/system/SystemInfo$BatteryStatus;", "droppableBatchStatus", "Lcom/datadog/android/core/internal/net/UploadStatus;", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DataUploadRunnable.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
