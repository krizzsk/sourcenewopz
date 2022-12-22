package com.datadog.android.rum.internal.monitor;

import android.os.Handler;
import com.datadog.android.core.internal.net.FirstPartyHostDetector;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.time.TimeProvider;
import com.datadog.android.rum.RumActionType;
import com.datadog.android.rum.RumAttributes;
import com.datadog.android.rum.RumErrorSource;
import com.datadog.android.rum.RumMonitor;
import com.datadog.android.rum.RumResourceKind;
import com.datadog.android.rum.RumSessionListener;
import com.datadog.android.rum.internal.RumErrorSourceType;
import com.datadog.android.rum.internal.domain.Time;
import com.datadog.android.rum.internal.domain.TimeKt;
import com.datadog.android.rum.internal.domain.event.ResourceTiming;
import com.datadog.android.rum.internal.domain.scope.RumApplicationScope;
import com.datadog.android.rum.internal.domain.scope.RumRawEvent;
import com.datadog.android.rum.internal.domain.scope.RumScope;
import com.datadog.android.rum.internal.vitals.VitalMonitor;
import com.datadog.android.rum.model.ViewEvent;
import com.didi.sdk.util.GlobalCountryCode;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0001jBo\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019¢\u0006\u0002\u0010\u001aJ \u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J8\u00100\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0016J8\u00103\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010\u00042\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0016J\u0018\u00105\u001a\u00020*2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0004H\u0016J\u0018\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020*2\u0006\u0010>\u001a\u00020\u0004H\u0016J.\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020A2\u0006\u0010>\u001a\u00020\u00042\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0016J\r\u0010B\u001a\u00020*H\u0000¢\u0006\u0002\bCJ\u0018\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010@\u001a\u00020FH\u0016J\u0018\u0010G\u001a\u00020*2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010@\u001a\u00020FH\u0016J \u0010H\u001a\u0004\u0018\u00010I2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0002J \u0010J\u001a\u0004\u0018\u00010\u00042\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0002J\u001e\u0010K\u001a\u00020L2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0002J\u0015\u0010M\u001a\u00020*2\u0006\u0010N\u001a\u00020OH\u0000¢\u0006\u0002\bPJ\b\u0010Q\u001a\u00020*H\u0016J6\u0010R\u001a\u00020*2\u0006\u0010:\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u00042\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0016J.\u0010U\u001a\u00020*2\u0006\u0010@\u001a\u00020A2\u0006\u0010>\u001a\u00020\u00042\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0016J.\u0010V\u001a\u00020*2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u00042\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0016J\r\u0010W\u001a\u00020*H\u0000¢\u0006\u0002\bXJG\u0010Y\u001a\u00020*2\u0006\u0010:\u001a\u00020\u00042\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010\\\u001a\u0004\u0018\u0001072\u0006\u0010]\u001a\u00020^2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0016¢\u0006\u0002\u0010_JM\u0010`\u001a\u00020*2\u0006\u0010:\u001a\u00020\u00042\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0016¢\u0006\u0002\u0010aJ.\u0010b\u001a\u00020*2\u0006\u0010@\u001a\u00020A2\u0006\u0010>\u001a\u00020\u00042\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0016J\u001e\u0010b\u001a\u00020*2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0016J&\u0010c\u001a\u00020*2\u0006\u0010:\u001a\u00020\u000b2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b02H\u0016J \u0010d\u001a\u00020*2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010e\u001a\u0002072\u0006\u0010@\u001a\u00020fH\u0016J\u0010\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020LH\u0016J\u0010\u0010i\u001a\u00020*2\u0006\u0010:\u001a\u00020\u0004H\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006k"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/monitor/DatadogRumMonitor;", "Lcom/datadog/android/rum/RumMonitor;", "Lcom/datadog/android/rum/internal/monitor/AdvancedRumMonitor;", "applicationId", "", "samplingRate", "", "backgroundTrackingEnabled", "", "writer", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "", "handler", "Landroid/os/Handler;", "firstPartyHostDetector", "Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "cpuVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "memoryVitalMonitor", "frameRateVitalMonitor", "timeProvider", "Lcom/datadog/android/core/internal/time/TimeProvider;", "sessionListener", "Lcom/datadog/android/rum/RumSessionListener;", "executorService", "Ljava/util/concurrent/ExecutorService;", "(Ljava/lang/String;FZLcom/datadog/android/core/internal/persistence/DataWriter;Landroid/os/Handler;Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/core/internal/time/TimeProvider;Lcom/datadog/android/rum/RumSessionListener;Ljava/util/concurrent/ExecutorService;)V", "getBackgroundTrackingEnabled$dd_sdk_android_release", "()Z", "getHandler$dd_sdk_android_release", "()Landroid/os/Handler;", "keepAliveRunnable", "Ljava/lang/Runnable;", "getKeepAliveRunnable$dd_sdk_android_release", "()Ljava/lang/Runnable;", "rootScope", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "getRootScope$dd_sdk_android_release", "()Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "getSamplingRate$dd_sdk_android_release", "()F", "addCrash", "", "message", "source", "Lcom/datadog/android/rum/RumErrorSource;", "throwable", "", "addError", "attributes", "", "addErrorWithStacktrace", "stacktrace", "addLongTask", "durationNs", "", "target", "addResourceTiming", "key", "timing", "Lcom/datadog/android/rum/internal/domain/event/ResourceTiming;", "addTiming", "name", "addUserAction", "type", "Lcom/datadog/android/rum/RumActionType;", "drainExecutorService", "drainExecutorService$dd_sdk_android_release", "eventDropped", "viewId", "Lcom/datadog/android/rum/internal/monitor/EventType;", "eventSent", "getErrorSourceType", "Lcom/datadog/android/rum/internal/RumErrorSourceType;", "getErrorType", "getEventTime", "Lcom/datadog/android/rum/internal/domain/Time;", "handleEvent", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "handleEvent$dd_sdk_android_release", "resetSession", "startResource", "method", "url", "startUserAction", "startView", "stopKeepAliveCallback", "stopKeepAliveCallback$dd_sdk_android_release", "stopResource", "statusCode", "", "size", "kind", "Lcom/datadog/android/rum/RumResourceKind;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lcom/datadog/android/rum/RumResourceKind;Ljava/util/Map;)V", "stopResourceWithError", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/datadog/android/rum/RumErrorSource;Ljava/lang/Throwable;Ljava/util/Map;)V", "stopUserAction", "stopView", "updateViewLoadingTime", "loadingTimeInNs", "Lcom/datadog/android/rum/model/ViewEvent$LoadingType;", "viewTreeChanged", "eventTime", "waitForResourceTiming", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DatadogRumMonitor.kt */
public final class DatadogRumMonitor implements RumMonitor, AdvancedRumMonitor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final long f3858h = TimeUnit.MINUTES.toMillis(5);

    /* renamed from: a */
    private final float f3859a;

    /* renamed from: b */
    private final boolean f3860b;

    /* renamed from: c */
    private final DataWriter<Object> f3861c;

    /* renamed from: d */
    private final Handler f3862d;

    /* renamed from: e */
    private final ExecutorService f3863e;

    /* renamed from: f */
    private final RumScope f3864f;

    /* renamed from: g */
    private final Runnable f3865g;

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DatadogRumMonitor.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EventType.values().length];
            iArr[EventType.ACTION.ordinal()] = 1;
            iArr[EventType.RESOURCE.ordinal()] = 2;
            iArr[EventType.ERROR.ordinal()] = 3;
            iArr[EventType.LONG_TASK.ordinal()] = 4;
            iArr[EventType.FROZEN_FRAME.ordinal()] = 5;
            iArr[EventType.VIEW.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DatadogRumMonitor(String str, float f, boolean z, DataWriter<Object> dataWriter, Handler handler, FirstPartyHostDetector firstPartyHostDetector, VitalMonitor vitalMonitor, VitalMonitor vitalMonitor2, VitalMonitor vitalMonitor3, TimeProvider timeProvider, RumSessionListener rumSessionListener, ExecutorService executorService) {
        DataWriter<Object> dataWriter2 = dataWriter;
        Handler handler2 = handler;
        ExecutorService executorService2 = executorService;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "applicationId");
        Intrinsics.checkNotNullParameter(dataWriter2, "writer");
        Intrinsics.checkNotNullParameter(handler2, "handler");
        FirstPartyHostDetector firstPartyHostDetector2 = firstPartyHostDetector;
        Intrinsics.checkNotNullParameter(firstPartyHostDetector2, "firstPartyHostDetector");
        VitalMonitor vitalMonitor4 = vitalMonitor;
        Intrinsics.checkNotNullParameter(vitalMonitor4, "cpuVitalMonitor");
        VitalMonitor vitalMonitor5 = vitalMonitor2;
        Intrinsics.checkNotNullParameter(vitalMonitor5, "memoryVitalMonitor");
        VitalMonitor vitalMonitor6 = vitalMonitor3;
        Intrinsics.checkNotNullParameter(vitalMonitor6, "frameRateVitalMonitor");
        TimeProvider timeProvider2 = timeProvider;
        Intrinsics.checkNotNullParameter(timeProvider2, "timeProvider");
        Intrinsics.checkNotNullParameter(executorService2, "executorService");
        this.f3859a = f;
        boolean z2 = z;
        this.f3860b = z2;
        this.f3861c = dataWriter2;
        this.f3862d = handler2;
        this.f3863e = executorService2;
        this.f3864f = new RumApplicationScope(str2, f, z2, firstPartyHostDetector2, vitalMonitor4, vitalMonitor5, vitalMonitor6, timeProvider2, rumSessionListener);
        $$Lambda$DatadogRumMonitor$ilpnFeE0eTm3N4dGMXm7GBCYj8I r1 = new Runnable() {
            public final void run() {
                DatadogRumMonitor.m2497a(DatadogRumMonitor.this);
            }
        };
        this.f3865g = r1;
        this.f3862d.postDelayed(r1, f3858h);
    }

    public final float getSamplingRate$dd_sdk_android_release() {
        return this.f3859a;
    }

    public final boolean getBackgroundTrackingEnabled$dd_sdk_android_release() {
        return this.f3860b;
    }

    public final Handler getHandler$dd_sdk_android_release() {
        return this.f3862d;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DatadogRumMonitor(java.lang.String r16, float r17, boolean r18, com.datadog.android.core.internal.persistence.DataWriter r19, android.os.Handler r20, com.datadog.android.core.internal.net.FirstPartyHostDetector r21, com.datadog.android.rum.internal.vitals.VitalMonitor r22, com.datadog.android.rum.internal.vitals.VitalMonitor r23, com.datadog.android.rum.internal.vitals.VitalMonitor r24, com.datadog.android.core.internal.time.TimeProvider r25, com.datadog.android.rum.RumSessionListener r26, java.util.concurrent.ExecutorService r27, int r28, kotlin.jvm.internal.DefaultConstructorMarker r29) {
        /*
            r15 = this;
            r0 = r28
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0011
            java.util.concurrent.ExecutorService r0 = java.util.concurrent.Executors.newSingleThreadExecutor()
            java.lang.String r1 = "newSingleThreadExecutor()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r14 = r0
            goto L_0x0013
        L_0x0011:
            r14 = r27
        L_0x0013:
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.internal.monitor.DatadogRumMonitor.<init>(java.lang.String, float, boolean, com.datadog.android.core.internal.persistence.DataWriter, android.os.Handler, com.datadog.android.core.internal.net.FirstPartyHostDetector, com.datadog.android.rum.internal.vitals.VitalMonitor, com.datadog.android.rum.internal.vitals.VitalMonitor, com.datadog.android.rum.internal.vitals.VitalMonitor, com.datadog.android.core.internal.time.TimeProvider, com.datadog.android.rum.RumSessionListener, java.util.concurrent.ExecutorService, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final RumScope getRootScope$dd_sdk_android_release() {
        return this.f3864f;
    }

    public final Runnable getKeepAliveRunnable$dd_sdk_android_release() {
        return this.f3865g;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m2497a(DatadogRumMonitor datadogRumMonitor) {
        Intrinsics.checkNotNullParameter(datadogRumMonitor, "this$0");
        datadogRumMonitor.handleEvent$dd_sdk_android_release(new RumRawEvent.KeepAlive((Time) null, 1, (DefaultConstructorMarker) null));
    }

    public void startView(Object obj, String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, "attributes");
        handleEvent$dd_sdk_android_release(new RumRawEvent.StartView(obj, str, map, m2496a(map)));
    }

    public void stopView(Object obj, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(map, "attributes");
        handleEvent$dd_sdk_android_release(new RumRawEvent.StopView(obj, map, m2496a(map)));
    }

    public void addUserAction(RumActionType rumActionType, String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(rumActionType, "type");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, "attributes");
        handleEvent$dd_sdk_android_release(new RumRawEvent.StartAction(rumActionType, str, false, map, m2496a(map)));
    }

    public void startUserAction(RumActionType rumActionType, String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(rumActionType, "type");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, "attributes");
        handleEvent$dd_sdk_android_release(new RumRawEvent.StartAction(rumActionType, str, true, map, m2496a(map)));
    }

    public void stopUserAction(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "attributes");
        handleEvent$dd_sdk_android_release(new RumRawEvent.StopAction((RumActionType) null, (String) null, map, (Time) null, 8, (DefaultConstructorMarker) null));
    }

    public void stopUserAction(RumActionType rumActionType, String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(rumActionType, "type");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(map, "attributes");
        handleEvent$dd_sdk_android_release(new RumRawEvent.StopAction(rumActionType, str, map, m2496a(map)));
    }

    public void startResource(String str, String str2, String str3, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "method");
        Intrinsics.checkNotNullParameter(str3, "url");
        Intrinsics.checkNotNullParameter(map, "attributes");
        handleEvent$dd_sdk_android_release(new RumRawEvent.StartResource(str, str3, str2, map, m2496a(map)));
    }

    public void stopResource(String str, Integer num, Long l, RumResourceKind rumResourceKind, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(rumResourceKind, "kind");
        Intrinsics.checkNotNullParameter(map, "attributes");
        handleEvent$dd_sdk_android_release(new RumRawEvent.StopResource(str, num == null ? null : Long.valueOf((long) num.intValue()), l, rumResourceKind, map, m2496a(map)));
    }

    public void stopResourceWithError(String str, Integer num, String str2, RumErrorSource rumErrorSource, Throwable th, Map<String, ? extends Object> map) {
        Long l;
        String str3 = str;
        Intrinsics.checkNotNullParameter(str, "key");
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str2, "message");
        RumErrorSource rumErrorSource2 = rumErrorSource;
        Intrinsics.checkNotNullParameter(rumErrorSource, "source");
        Intrinsics.checkNotNullParameter(th, "throwable");
        Intrinsics.checkNotNullParameter(map, "attributes");
        if (num == null) {
            l = null;
        } else {
            l = Long.valueOf((long) num.intValue());
        }
        RumRawEvent stopResourceWithError = new RumRawEvent.StopResourceWithError(str, l, str2, rumErrorSource, th, map, (Time) null, 64, (DefaultConstructorMarker) null);
        handleEvent$dd_sdk_android_release(stopResourceWithError);
    }

    public void addError(String str, RumErrorSource rumErrorSource, Throwable th, Map<String, ? extends Object> map) {
        Map<String, ? extends Object> map2 = map;
        Intrinsics.checkNotNullParameter(str, "message");
        RumErrorSource rumErrorSource2 = rumErrorSource;
        Intrinsics.checkNotNullParameter(rumErrorSource2, "source");
        Intrinsics.checkNotNullParameter(map2, "attributes");
        handleEvent$dd_sdk_android_release(new RumRawEvent.AddError(str, rumErrorSource2, th, (String) null, false, map2, m2496a(map2), m2499b(map2), (RumErrorSourceType) null, 256, (DefaultConstructorMarker) null));
    }

    public void addErrorWithStacktrace(String str, RumErrorSource rumErrorSource, String str2, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(rumErrorSource, "source");
        Intrinsics.checkNotNullParameter(map, "attributes");
        Time a = m2496a(map);
        String b = m2499b(map);
        RumErrorSourceType c = m2500c(map);
        if (c == null) {
            c = RumErrorSourceType.ANDROID;
        }
        handleEvent$dd_sdk_android_release(new RumRawEvent.AddError(str, rumErrorSource, (Throwable) null, str2, false, map, a, b, c));
    }

    public void resetSession() {
        handleEvent$dd_sdk_android_release(new RumRawEvent.ResetSession((Time) null, 1, (DefaultConstructorMarker) null));
    }

    public void viewTreeChanged(Time time) {
        Intrinsics.checkNotNullParameter(time, "eventTime");
        handleEvent$dd_sdk_android_release(new RumRawEvent.ViewTreeChanged(time));
    }

    public void waitForResourceTiming(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        handleEvent$dd_sdk_android_release(new RumRawEvent.WaitForResourceTiming(str, (Time) null, 2, (DefaultConstructorMarker) null));
    }

    public void addResourceTiming(String str, ResourceTiming resourceTiming) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(resourceTiming, "timing");
        handleEvent$dd_sdk_android_release(new RumRawEvent.AddResourceTiming(str, resourceTiming, (Time) null, 4, (DefaultConstructorMarker) null));
    }

    public void addCrash(String str, RumErrorSource rumErrorSource, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(rumErrorSource, "source");
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "throwable");
        handleEvent$dd_sdk_android_release(new RumRawEvent.AddError(str, rumErrorSource, th2, (String) null, true, MapsKt.emptyMap(), (Time) null, (String) null, (RumErrorSourceType) null, 448, (DefaultConstructorMarker) null));
    }

    public void updateViewLoadingTime(Object obj, long j, ViewEvent.LoadingType loadingType) {
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(loadingType, "type");
        handleEvent$dd_sdk_android_release(new RumRawEvent.UpdateViewLoadingTime(obj, j, loadingType, (Time) null, 8, (DefaultConstructorMarker) null));
    }

    public void addTiming(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        handleEvent$dd_sdk_android_release(new RumRawEvent.AddCustomTiming(str, (Time) null, 2, (DefaultConstructorMarker) null));
    }

    public void addLongTask(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "target");
        handleEvent$dd_sdk_android_release(new RumRawEvent.AddLongTask(j, str, (Time) null, 4, (DefaultConstructorMarker) null));
    }

    public void eventSent(String str, EventType eventType) {
        Intrinsics.checkNotNullParameter(str, "viewId");
        Intrinsics.checkNotNullParameter(eventType, "type");
        int i = WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()];
        if (i == 1) {
            handleEvent$dd_sdk_android_release(new RumRawEvent.ActionSent(str, (Time) null, 2, (DefaultConstructorMarker) null));
        } else if (i == 2) {
            handleEvent$dd_sdk_android_release(new RumRawEvent.ResourceSent(str, (Time) null, 2, (DefaultConstructorMarker) null));
        } else if (i == 3) {
            handleEvent$dd_sdk_android_release(new RumRawEvent.ErrorSent(str, (Time) null, 2, (DefaultConstructorMarker) null));
        } else if (i == 4) {
            handleEvent$dd_sdk_android_release(new RumRawEvent.LongTaskSent(str, false, (Time) null, 4, (DefaultConstructorMarker) null));
        } else if (i == 5) {
            handleEvent$dd_sdk_android_release(new RumRawEvent.LongTaskSent(str, true, (Time) null, 4, (DefaultConstructorMarker) null));
        }
    }

    public void eventDropped(String str, EventType eventType) {
        Intrinsics.checkNotNullParameter(str, "viewId");
        Intrinsics.checkNotNullParameter(eventType, "type");
        int i = WhenMappings.$EnumSwitchMapping$0[eventType.ordinal()];
        if (i == 1) {
            handleEvent$dd_sdk_android_release(new RumRawEvent.ActionDropped(str, (Time) null, 2, (DefaultConstructorMarker) null));
        } else if (i == 2) {
            handleEvent$dd_sdk_android_release(new RumRawEvent.ResourceDropped(str, (Time) null, 2, (DefaultConstructorMarker) null));
        } else if (i == 3) {
            handleEvent$dd_sdk_android_release(new RumRawEvent.ErrorDropped(str, (Time) null, 2, (DefaultConstructorMarker) null));
        } else if (i == 4) {
            handleEvent$dd_sdk_android_release(new RumRawEvent.LongTaskDropped(str, false, (Time) null, 4, (DefaultConstructorMarker) null));
        } else if (i == 5) {
            handleEvent$dd_sdk_android_release(new RumRawEvent.LongTaskDropped(str, true, (Time) null, 4, (DefaultConstructorMarker) null));
        }
    }

    public final void drainExecutorService$dd_sdk_android_release() {
        BlockingQueue<Runnable> queue;
        ArrayList<Runnable> arrayList = new ArrayList<>();
        ExecutorService executorService = this.f3863e;
        ThreadPoolExecutor threadPoolExecutor = executorService instanceof ThreadPoolExecutor ? (ThreadPoolExecutor) executorService : null;
        if (!(threadPoolExecutor == null || (queue = threadPoolExecutor.getQueue()) == null)) {
            queue.drainTo(arrayList);
        }
        this.f3863e.shutdown();
        this.f3863e.awaitTermination(10, TimeUnit.SECONDS);
        for (Runnable run : arrayList) {
            run.run();
        }
    }

    public final void handleEvent$dd_sdk_android_release(RumRawEvent rumRawEvent) {
        Intrinsics.checkNotNullParameter(rumRawEvent, "event");
        if (!(rumRawEvent instanceof RumRawEvent.AddError) || !((RumRawEvent.AddError) rumRawEvent).isFatal()) {
            this.f3862d.removeCallbacks(this.f3865g);
            if (!this.f3863e.isShutdown()) {
                this.f3863e.submit(new Runnable(rumRawEvent) {
                    public final /* synthetic */ RumRawEvent f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DatadogRumMonitor.m2498a(DatadogRumMonitor.this, this.f$1);
                    }
                });
                return;
            }
            return;
        }
        this.f3864f.handleEvent(rumRawEvent, this.f3861c);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m2498a(DatadogRumMonitor datadogRumMonitor, RumRawEvent rumRawEvent) {
        Intrinsics.checkNotNullParameter(datadogRumMonitor, "this$0");
        Intrinsics.checkNotNullParameter(rumRawEvent, "$event");
        synchronized (datadogRumMonitor.getRootScope$dd_sdk_android_release()) {
            datadogRumMonitor.getRootScope$dd_sdk_android_release().handleEvent(rumRawEvent, datadogRumMonitor.f3861c);
        }
        datadogRumMonitor.getHandler$dd_sdk_android_release().postDelayed(datadogRumMonitor.getKeepAliveRunnable$dd_sdk_android_release(), f3858h);
    }

    public final void stopKeepAliveCallback$dd_sdk_android_release() {
        this.f3862d.removeCallbacks(this.f3865g);
    }

    /* renamed from: a */
    private final Time m2496a(Map<String, ? extends Object> map) {
        Object obj = map.get(RumAttributes.INTERNAL_TIMESTAMP);
        Time time = null;
        Long l = obj instanceof Long ? (Long) obj : null;
        if (l != null) {
            time = TimeKt.asTime(l.longValue());
        }
        return time == null ? new Time(0, 0, 3, (DefaultConstructorMarker) null) : time;
    }

    /* renamed from: b */
    private final String m2499b(Map<String, ? extends Object> map) {
        Object obj = map.get(RumAttributes.INTERNAL_ERROR_TYPE);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* renamed from: c */
    private final RumErrorSourceType m2500c(Map<String, ? extends Object> map) {
        Object obj = map.get(RumAttributes.INTERNAL_ERROR_SOURCE_TYPE);
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            return null;
        }
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, GlobalCountryCode.AMERICA);
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        int hashCode = lowerCase.hashCode();
        if (hashCode != -861391249) {
            if (hashCode != 150940456) {
                if (hashCode == 828638245 && lowerCase.equals("react-native")) {
                    return RumErrorSourceType.REACT_NATIVE;
                }
            } else if (lowerCase.equals("browser")) {
                return RumErrorSourceType.BROWSER;
            }
        } else if (lowerCase.equals("android")) {
            return RumErrorSourceType.ANDROID;
        }
        return RumErrorSourceType.ANDROID;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/monitor/DatadogRumMonitor$Companion;", "", "()V", "KEEP_ALIVE_MS", "", "getKEEP_ALIVE_MS$dd_sdk_android_release", "()J", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: DatadogRumMonitor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getKEEP_ALIVE_MS$dd_sdk_android_release() {
            return DatadogRumMonitor.f3858h;
        }
    }
}
