package com.datadog.android.rum.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import com.datadog.android.core.configuration.Configuration;
import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.SdkFeature;
import com.datadog.android.core.internal.event.NoOpEventMapper;
import com.datadog.android.core.internal.net.DataUploader;
import com.datadog.android.core.internal.persistence.PersistenceStrategy;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.event.EventMapper;
import com.datadog.android.log.Logger;
import com.datadog.android.rum.internal.anr.ANRDetectorRunnable;
import com.datadog.android.rum.internal.domain.RumFilePersistenceStrategy;
import com.datadog.android.rum.internal.ndk.DatadogNdkCrashHandler;
import com.datadog.android.rum.internal.net.RumOkHttpUploaderV2;
import com.datadog.android.rum.internal.tracking.NoOpUserActionTrackingStrategy;
import com.datadog.android.rum.internal.tracking.UserActionTrackingStrategy;
import com.datadog.android.rum.internal.tracking.ViewTreeChangeTrackingStrategy;
import com.datadog.android.rum.internal.vitals.AggregatingVitalMonitor;
import com.datadog.android.rum.internal.vitals.CPUVitalReader;
import com.datadog.android.rum.internal.vitals.MemoryVitalReader;
import com.datadog.android.rum.internal.vitals.NoOpVitalMonitor;
import com.datadog.android.rum.internal.vitals.VitalFrameCallback;
import com.datadog.android.rum.internal.vitals.VitalMonitor;
import com.datadog.android.rum.internal.vitals.VitalObserver;
import com.datadog.android.rum.internal.vitals.VitalReader;
import com.datadog.android.rum.internal.vitals.VitalReaderRunnable;
import com.datadog.android.rum.tracking.NoOpTrackingStrategy;
import com.datadog.android.rum.tracking.NoOpViewTrackingStrategy;
import com.datadog.android.rum.tracking.TrackingStrategy;
import com.datadog.android.rum.tracking.ViewTrackingStrategy;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u001e\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0003H\u0016J\u0010\u0010W\u001a\u00020X2\u0006\u0010V\u001a\u00020\u0003H\u0016J\b\u0010Y\u001a\u00020ZH\u0002J\u0018\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0002J\b\u0010`\u001a\u00020ZH\u0002J\u0018\u0010a\u001a\u00020Z2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0003H\u0016J\b\u0010b\u001a\u00020ZH\u0016J\u0010\u0010c\u001a\u00020Z2\u0006\u0010d\u001a\u00020UH\u0002J\u0012\u0010e\u001a\u00020Z2\b\u0010d\u001a\u0004\u0018\u00010UH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001a\u0010.\u001a\u00020/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u0010*R \u00107\u001a\b\u0012\u0004\u0012\u00020\u000208X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u00101\"\u0004\bK\u00103R\u001a\u0010L\u001a\u00020MX.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006f"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/RumFeature;", "Lcom/datadog/android/core/internal/SdkFeature;", "", "Lcom/datadog/android/core/configuration/Configuration$Feature$RUM;", "()V", "VITAL_UPDATE_PERIOD_MS", "", "actionTrackingStrategy", "Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;", "getActionTrackingStrategy$dd_sdk_android_release", "()Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;", "setActionTrackingStrategy$dd_sdk_android_release", "(Lcom/datadog/android/rum/internal/tracking/UserActionTrackingStrategy;)V", "anrDetectorExecutorService", "Ljava/util/concurrent/ExecutorService;", "getAnrDetectorExecutorService$dd_sdk_android_release", "()Ljava/util/concurrent/ExecutorService;", "setAnrDetectorExecutorService$dd_sdk_android_release", "(Ljava/util/concurrent/ExecutorService;)V", "anrDetectorHandler", "Landroid/os/Handler;", "getAnrDetectorHandler$dd_sdk_android_release", "()Landroid/os/Handler;", "setAnrDetectorHandler$dd_sdk_android_release", "(Landroid/os/Handler;)V", "anrDetectorRunnable", "Lcom/datadog/android/rum/internal/anr/ANRDetectorRunnable;", "getAnrDetectorRunnable$dd_sdk_android_release", "()Lcom/datadog/android/rum/internal/anr/ANRDetectorRunnable;", "setAnrDetectorRunnable$dd_sdk_android_release", "(Lcom/datadog/android/rum/internal/anr/ANRDetectorRunnable;)V", "backgroundEventTracking", "", "getBackgroundEventTracking$dd_sdk_android_release", "()Z", "setBackgroundEventTracking$dd_sdk_android_release", "(Z)V", "cpuVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "getCpuVitalMonitor$dd_sdk_android_release", "()Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "setCpuVitalMonitor$dd_sdk_android_release", "(Lcom/datadog/android/rum/internal/vitals/VitalMonitor;)V", "frameRateVitalMonitor", "getFrameRateVitalMonitor$dd_sdk_android_release", "setFrameRateVitalMonitor$dd_sdk_android_release", "longTaskTrackingStrategy", "Lcom/datadog/android/rum/tracking/TrackingStrategy;", "getLongTaskTrackingStrategy$dd_sdk_android_release", "()Lcom/datadog/android/rum/tracking/TrackingStrategy;", "setLongTaskTrackingStrategy$dd_sdk_android_release", "(Lcom/datadog/android/rum/tracking/TrackingStrategy;)V", "memoryVitalMonitor", "getMemoryVitalMonitor$dd_sdk_android_release", "setMemoryVitalMonitor$dd_sdk_android_release", "rumEventMapper", "Lcom/datadog/android/event/EventMapper;", "getRumEventMapper$dd_sdk_android_release", "()Lcom/datadog/android/event/EventMapper;", "setRumEventMapper$dd_sdk_android_release", "(Lcom/datadog/android/event/EventMapper;)V", "samplingRate", "", "getSamplingRate$dd_sdk_android_release", "()F", "setSamplingRate$dd_sdk_android_release", "(F)V", "viewTrackingStrategy", "Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "getViewTrackingStrategy$dd_sdk_android_release", "()Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;", "setViewTrackingStrategy$dd_sdk_android_release", "(Lcom/datadog/android/rum/tracking/ViewTrackingStrategy;)V", "viewTreeTrackingStrategy", "getViewTreeTrackingStrategy$dd_sdk_android_release", "setViewTreeTrackingStrategy$dd_sdk_android_release", "vitalExecutorService", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "getVitalExecutorService$dd_sdk_android_release", "()Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "setVitalExecutorService$dd_sdk_android_release", "(Ljava/util/concurrent/ScheduledThreadPoolExecutor;)V", "createPersistenceStrategy", "Lcom/datadog/android/core/internal/persistence/PersistenceStrategy;", "context", "Landroid/content/Context;", "configuration", "createUploader", "Lcom/datadog/android/core/internal/net/DataUploader;", "initializeANRDetector", "", "initializeVitalMonitor", "vitalReader", "Lcom/datadog/android/rum/internal/vitals/VitalReader;", "vitalObserver", "Lcom/datadog/android/rum/internal/vitals/VitalObserver;", "initializeVitalMonitors", "onInitialize", "onStop", "registerTrackingStrategies", "appContext", "unregisterTrackingStrategies", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumFeature.kt */
public final class RumFeature extends SdkFeature<Object, Configuration.Feature.RUM> {
    public static final RumFeature INSTANCE = new RumFeature();

    /* renamed from: a */
    private static float f3669a = 0.0f;
    public static ExecutorService anrDetectorExecutorService = null;
    public static Handler anrDetectorHandler = null;
    public static ANRDetectorRunnable anrDetectorRunnable = null;

    /* renamed from: b */
    private static boolean f3670b = false;

    /* renamed from: c */
    private static ViewTrackingStrategy f3671c = new NoOpViewTrackingStrategy();

    /* renamed from: d */
    private static UserActionTrackingStrategy f3672d = new NoOpUserActionTrackingStrategy();

    /* renamed from: e */
    private static TrackingStrategy f3673e = new ViewTreeChangeTrackingStrategy();

    /* renamed from: f */
    private static EventMapper<Object> f3674f = new NoOpEventMapper();

    /* renamed from: g */
    private static TrackingStrategy f3675g = new NoOpTrackingStrategy();

    /* renamed from: h */
    private static VitalMonitor f3676h = new NoOpVitalMonitor();

    /* renamed from: i */
    private static VitalMonitor f3677i = new NoOpVitalMonitor();

    /* renamed from: j */
    private static VitalMonitor f3678j = new NoOpVitalMonitor();

    /* renamed from: k */
    private static final long f3679k = 100;
    public static ScheduledThreadPoolExecutor vitalExecutorService;

    private RumFeature() {
    }

    public final float getSamplingRate$dd_sdk_android_release() {
        return f3669a;
    }

    public final void setSamplingRate$dd_sdk_android_release(float f) {
        f3669a = f;
    }

    public final boolean getBackgroundEventTracking$dd_sdk_android_release() {
        return f3670b;
    }

    public final void setBackgroundEventTracking$dd_sdk_android_release(boolean z) {
        f3670b = z;
    }

    public final ViewTrackingStrategy getViewTrackingStrategy$dd_sdk_android_release() {
        return f3671c;
    }

    public final void setViewTrackingStrategy$dd_sdk_android_release(ViewTrackingStrategy viewTrackingStrategy) {
        Intrinsics.checkNotNullParameter(viewTrackingStrategy, "<set-?>");
        f3671c = viewTrackingStrategy;
    }

    public final UserActionTrackingStrategy getActionTrackingStrategy$dd_sdk_android_release() {
        return f3672d;
    }

    public final void setActionTrackingStrategy$dd_sdk_android_release(UserActionTrackingStrategy userActionTrackingStrategy) {
        Intrinsics.checkNotNullParameter(userActionTrackingStrategy, "<set-?>");
        f3672d = userActionTrackingStrategy;
    }

    public final TrackingStrategy getViewTreeTrackingStrategy$dd_sdk_android_release() {
        return f3673e;
    }

    public final void setViewTreeTrackingStrategy$dd_sdk_android_release(TrackingStrategy trackingStrategy) {
        Intrinsics.checkNotNullParameter(trackingStrategy, "<set-?>");
        f3673e = trackingStrategy;
    }

    public final EventMapper<Object> getRumEventMapper$dd_sdk_android_release() {
        return f3674f;
    }

    public final void setRumEventMapper$dd_sdk_android_release(EventMapper<Object> eventMapper) {
        Intrinsics.checkNotNullParameter(eventMapper, "<set-?>");
        f3674f = eventMapper;
    }

    public final TrackingStrategy getLongTaskTrackingStrategy$dd_sdk_android_release() {
        return f3675g;
    }

    public final void setLongTaskTrackingStrategy$dd_sdk_android_release(TrackingStrategy trackingStrategy) {
        Intrinsics.checkNotNullParameter(trackingStrategy, "<set-?>");
        f3675g = trackingStrategy;
    }

    public final VitalMonitor getCpuVitalMonitor$dd_sdk_android_release() {
        return f3676h;
    }

    public final void setCpuVitalMonitor$dd_sdk_android_release(VitalMonitor vitalMonitor) {
        Intrinsics.checkNotNullParameter(vitalMonitor, "<set-?>");
        f3676h = vitalMonitor;
    }

    public final VitalMonitor getMemoryVitalMonitor$dd_sdk_android_release() {
        return f3677i;
    }

    public final void setMemoryVitalMonitor$dd_sdk_android_release(VitalMonitor vitalMonitor) {
        Intrinsics.checkNotNullParameter(vitalMonitor, "<set-?>");
        f3677i = vitalMonitor;
    }

    public final VitalMonitor getFrameRateVitalMonitor$dd_sdk_android_release() {
        return f3678j;
    }

    public final void setFrameRateVitalMonitor$dd_sdk_android_release(VitalMonitor vitalMonitor) {
        Intrinsics.checkNotNullParameter(vitalMonitor, "<set-?>");
        f3678j = vitalMonitor;
    }

    public final ScheduledThreadPoolExecutor getVitalExecutorService$dd_sdk_android_release() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = vitalExecutorService;
        if (scheduledThreadPoolExecutor != null) {
            return scheduledThreadPoolExecutor;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vitalExecutorService");
        throw null;
    }

    public final void setVitalExecutorService$dd_sdk_android_release(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        Intrinsics.checkNotNullParameter(scheduledThreadPoolExecutor, "<set-?>");
        vitalExecutorService = scheduledThreadPoolExecutor;
    }

    public final ExecutorService getAnrDetectorExecutorService$dd_sdk_android_release() {
        ExecutorService executorService = anrDetectorExecutorService;
        if (executorService != null) {
            return executorService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("anrDetectorExecutorService");
        throw null;
    }

    public final void setAnrDetectorExecutorService$dd_sdk_android_release(ExecutorService executorService) {
        Intrinsics.checkNotNullParameter(executorService, "<set-?>");
        anrDetectorExecutorService = executorService;
    }

    public final ANRDetectorRunnable getAnrDetectorRunnable$dd_sdk_android_release() {
        ANRDetectorRunnable aNRDetectorRunnable = anrDetectorRunnable;
        if (aNRDetectorRunnable != null) {
            return aNRDetectorRunnable;
        }
        Intrinsics.throwUninitializedPropertyAccessException("anrDetectorRunnable");
        throw null;
    }

    public final void setAnrDetectorRunnable$dd_sdk_android_release(ANRDetectorRunnable aNRDetectorRunnable) {
        Intrinsics.checkNotNullParameter(aNRDetectorRunnable, "<set-?>");
        anrDetectorRunnable = aNRDetectorRunnable;
    }

    public final Handler getAnrDetectorHandler$dd_sdk_android_release() {
        Handler handler = anrDetectorHandler;
        if (handler != null) {
            return handler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("anrDetectorHandler");
        throw null;
    }

    public final void setAnrDetectorHandler$dd_sdk_android_release(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        anrDetectorHandler = handler;
    }

    public void onInitialize(Context context, Configuration.Feature.RUM rum) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rum, "configuration");
        f3669a = rum.getSamplingRate();
        f3670b = rum.getBackgroundEventTracking();
        f3674f = rum.getRumEventMapper();
        ViewTrackingStrategy viewTrackingStrategy = rum.getViewTrackingStrategy();
        if (viewTrackingStrategy != null) {
            INSTANCE.setViewTrackingStrategy$dd_sdk_android_release(viewTrackingStrategy);
        }
        UserActionTrackingStrategy userActionTrackingStrategy = rum.getUserActionTrackingStrategy();
        if (userActionTrackingStrategy != null) {
            INSTANCE.setActionTrackingStrategy$dd_sdk_android_release(userActionTrackingStrategy);
        }
        TrackingStrategy longTaskTrackingStrategy = rum.getLongTaskTrackingStrategy();
        if (longTaskTrackingStrategy != null) {
            INSTANCE.setLongTaskTrackingStrategy$dd_sdk_android_release(longTaskTrackingStrategy);
        }
        m2405a();
        m2408b();
        m2406a(context);
    }

    public void onStop() {
        m2409b((Context) CoreFeature.INSTANCE.getContextRef$dd_sdk_android_release().get());
        f3671c = new NoOpViewTrackingStrategy();
        f3672d = new NoOpUserActionTrackingStrategy();
        f3675g = new NoOpTrackingStrategy();
        f3674f = new NoOpEventMapper();
        f3676h = new NoOpVitalMonitor();
        f3677i = new NoOpVitalMonitor();
        f3678j = new NoOpVitalMonitor();
        getVitalExecutorService$dd_sdk_android_release().shutdownNow();
        getAnrDetectorExecutorService$dd_sdk_android_release().shutdownNow();
        getAnrDetectorRunnable$dd_sdk_android_release().stop();
    }

    public PersistenceStrategy<Object> createPersistenceStrategy(Context context, Configuration.Feature.RUM rum) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rum, "configuration");
        return new RumFilePersistenceStrategy(CoreFeature.INSTANCE.getTrackingConsentProvider$dd_sdk_android_release(), context, rum.getRumEventMapper(), CoreFeature.INSTANCE.getPersistenceExecutorService$dd_sdk_android_release(), RuntimeUtilsKt.getSdkLogger(), DatadogNdkCrashHandler.Companion.getLastViewEventFile$dd_sdk_android_release(context));
    }

    public DataUploader createUploader(Configuration.Feature.RUM rum) {
        Intrinsics.checkNotNullParameter(rum, "configuration");
        return new RumOkHttpUploaderV2(rum.getEndpointUrl(), CoreFeature.INSTANCE.getClientToken$dd_sdk_android_release(), CoreFeature.INSTANCE.getSourceName$dd_sdk_android_release(), CoreFeature.INSTANCE.getSdkVersion$dd_sdk_android_release(), CoreFeature.INSTANCE.getOkHttpClient$dd_sdk_android_release());
    }

    /* renamed from: a */
    private final void m2406a(Context context) {
        f3672d.register(context);
        f3671c.register(context);
        f3673e.register(context);
        f3675g.register(context);
    }

    /* renamed from: b */
    private final void m2409b(Context context) {
        f3672d.unregister(context);
        f3671c.unregister(context);
        f3673e.unregister(context);
        f3675g.unregister(context);
    }

    /* renamed from: a */
    private final void m2405a() {
        f3676h = new AggregatingVitalMonitor();
        f3677i = new AggregatingVitalMonitor();
        f3678j = new AggregatingVitalMonitor();
        setVitalExecutorService$dd_sdk_android_release(new ScheduledThreadPoolExecutor(1));
        m2407a(new CPUVitalReader((File) null, 1, (DefaultConstructorMarker) null), f3676h);
        m2407a(new MemoryVitalReader((File) null, 1, (DefaultConstructorMarker) null), f3677i);
        try {
            Choreographer.getInstance().postFrameCallback(new VitalFrameCallback(f3678j, RumFeature$initializeVitalMonitors$vitalFrameCallback$1.INSTANCE));
        } catch (IllegalStateException e) {
            Logger.e$default(RuntimeUtilsKt.getSdkLogger(), "Unable to initialize the Choreographer FrameCallback", e, (Map) null, 4, (Object) null);
            Logger.w$default(RuntimeUtilsKt.getDevLogger(), "It seems you initialized the SDK on a thread without a Looper: we won't be able to track your Views' refresh rate.", (Throwable) null, (Map) null, 6, (Object) null);
        }
    }

    /* renamed from: a */
    private final void m2407a(VitalReader vitalReader, VitalObserver vitalObserver) {
        getVitalExecutorService$dd_sdk_android_release().schedule(new VitalReaderRunnable(vitalReader, vitalObserver, getVitalExecutorService$dd_sdk_android_release(), 100), 100, TimeUnit.MILLISECONDS);
    }

    /* renamed from: b */
    private final void m2408b() {
        setAnrDetectorHandler$dd_sdk_android_release(new Handler(Looper.getMainLooper()));
        setAnrDetectorRunnable$dd_sdk_android_release(new ANRDetectorRunnable(getAnrDetectorHandler$dd_sdk_android_release(), 0, 0, 6, (DefaultConstructorMarker) null));
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        setAnrDetectorExecutorService$dd_sdk_android_release(newSingleThreadExecutor);
        getAnrDetectorExecutorService$dd_sdk_android_release().execute(getAnrDetectorRunnable$dd_sdk_android_release());
    }
}
