package com.datadog.android.rum.internal.domain.scope;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import com.datadog.android.Datadog;
import com.datadog.android.core.internal.net.FirstPartyHostDetector;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.persistence.NoOpDataWriter;
import com.datadog.android.core.internal.time.TimeProvider;
import com.datadog.android.core.internal.utils.RuntimeUtilsKt;
import com.datadog.android.log.Logger;
import com.datadog.android.rum.GlobalRum;
import com.datadog.android.rum.RumSessionListener;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.domain.scope.RumRawEvent;
import com.datadog.android.rum.internal.vitals.NoOpVitalMonitor;
import com.datadog.android.rum.internal.vitals.VitalMonitor;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 L2\u00020\u0001:\u0001LBc\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0002\u0010\u0014J\b\u00109\u001a\u00020:H\u0016J\u001e\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020=2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020(0?H\u0016J\u001e\u0010@\u001a\u00020A2\u0006\u0010<\u001a\u00020=2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020(0?H\u0002J+\u0010C\u001a\u00020A2\u0006\u0010<\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020(0?H\u0000¢\u0006\u0002\bGJ\u0015\u0010H\u001a\u00020F2\u0006\u0010<\u001a\u00020=H\u0000¢\u0006\u0002\bIJ\b\u0010J\u001a\u00020\u0012H\u0002J\b\u0010K\u001a\u00020AH\u0002R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\f\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0004\n\u0002\u0010,R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u00020#X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope;", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "parentScope", "samplingRate", "", "backgroundTrackingEnabled", "", "firstPartyHostDetector", "Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "cpuVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "memoryVitalMonitor", "frameRateVitalMonitor", "timeProvider", "Lcom/datadog/android/core/internal/time/TimeProvider;", "sessionListener", "Lcom/datadog/android/rum/RumSessionListener;", "sessionInactivityNanos", "", "sessionMaxDurationNanos", "(Lcom/datadog/android/rum/internal/domain/scope/RumScope;FZLcom/datadog/android/core/internal/net/FirstPartyHostDetector;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/core/internal/time/TimeProvider;Lcom/datadog/android/rum/RumSessionListener;JJ)V", "activeChildrenScopes", "", "getActiveChildrenScopes$dd_sdk_android_release", "()Ljava/util/List;", "applicationDisplayed", "getBackgroundTrackingEnabled$dd_sdk_android_release", "()Z", "getFirstPartyHostDetector$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "keepSession", "getKeepSession$dd_sdk_android_release", "setKeepSession$dd_sdk_android_release", "(Z)V", "lastUserInteractionNs", "Ljava/util/concurrent/atomic/AtomicLong;", "getLastUserInteractionNs$dd_sdk_android_release", "()Ljava/util/concurrent/atomic/AtomicLong;", "noOpWriter", "Lcom/datadog/android/core/internal/persistence/NoOpDataWriter;", "", "random", "Ljava/security/SecureRandom;", "resetSessionTime", "Ljava/lang/Long;", "getSamplingRate$dd_sdk_android_release", "()F", "sessionId", "", "getSessionId$dd_sdk_android_release", "()Ljava/lang/String;", "setSessionId$dd_sdk_android_release", "(Ljava/lang/String;)V", "getSessionListener$dd_sdk_android_release", "()Lcom/datadog/android/rum/RumSessionListener;", "sessionStartNs", "getSessionStartNs$dd_sdk_android_release", "getRumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "handleEvent", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "writer", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "handleOrphanEvent", "", "actualWriter", "onApplicationDisplayed", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent$StartView;", "viewScope", "Lcom/datadog/android/rum/internal/domain/scope/RumViewScope;", "onApplicationDisplayed$dd_sdk_android_release", "produceRumBackgroundViewScope", "produceRumBackgroundViewScope$dd_sdk_android_release", "resolveStartupTimeNs", "updateSessionIdIfNeeded", "Companion", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumSessionScope.kt */
public final class RumSessionScope implements RumScope {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String MESSAGE_MISSING_VIEW = "A RUM event was detected, but no view is active. To track views automatically, try calling the Configuration.Builder.useViewTrackingStrategy() method.\nYou can also track views manually using the RumMonitor.startView() and RumMonitor.stopView() methods.";
    /* access modifiers changed from: private */

    /* renamed from: u */
    public static final long f3764u = TimeUnit.MINUTES.toNanos(15);
    /* access modifiers changed from: private */

    /* renamed from: v */
    public static final long f3765v = TimeUnit.HOURS.toNanos(4);

    /* renamed from: a */
    private final RumScope f3766a;

    /* renamed from: b */
    private final float f3767b;

    /* renamed from: c */
    private final boolean f3768c;

    /* renamed from: d */
    private final FirstPartyHostDetector f3769d;

    /* renamed from: e */
    private final VitalMonitor f3770e;

    /* renamed from: f */
    private final VitalMonitor f3771f;

    /* renamed from: g */
    private final VitalMonitor f3772g;

    /* renamed from: h */
    private final TimeProvider f3773h;

    /* renamed from: i */
    private final RumSessionListener f3774i;

    /* renamed from: j */
    private final long f3775j;

    /* renamed from: k */
    private final long f3776k;

    /* renamed from: l */
    private final List<RumScope> f3777l;

    /* renamed from: m */
    private boolean f3778m;

    /* renamed from: n */
    private String f3779n;

    /* renamed from: o */
    private final AtomicLong f3780o;

    /* renamed from: p */
    private final AtomicLong f3781p;

    /* renamed from: q */
    private Long f3782q;

    /* renamed from: r */
    private boolean f3783r;

    /* renamed from: s */
    private final SecureRandom f3784s;

    /* renamed from: t */
    private final NoOpDataWriter<Object> f3785t;

    public RumSessionScope(RumScope rumScope, float f, boolean z, FirstPartyHostDetector firstPartyHostDetector, VitalMonitor vitalMonitor, VitalMonitor vitalMonitor2, VitalMonitor vitalMonitor3, TimeProvider timeProvider, RumSessionListener rumSessionListener, long j, long j2) {
        Intrinsics.checkNotNullParameter(rumScope, "parentScope");
        Intrinsics.checkNotNullParameter(firstPartyHostDetector, "firstPartyHostDetector");
        Intrinsics.checkNotNullParameter(vitalMonitor, "cpuVitalMonitor");
        Intrinsics.checkNotNullParameter(vitalMonitor2, "memoryVitalMonitor");
        Intrinsics.checkNotNullParameter(vitalMonitor3, "frameRateVitalMonitor");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.f3766a = rumScope;
        this.f3767b = f;
        this.f3768c = z;
        this.f3769d = firstPartyHostDetector;
        this.f3770e = vitalMonitor;
        this.f3771f = vitalMonitor2;
        this.f3772g = vitalMonitor3;
        this.f3773h = timeProvider;
        this.f3774i = rumSessionListener;
        this.f3775j = j;
        this.f3776k = j2;
        this.f3777l = new ArrayList();
        this.f3779n = RumContext.Companion.getNULL_UUID();
        this.f3780o = new AtomicLong(System.nanoTime());
        this.f3781p = new AtomicLong(0);
        this.f3784s = new SecureRandom();
        this.f3785t = new NoOpDataWriter<>();
        GlobalRum.INSTANCE.updateRumContext$dd_sdk_android_release(getRumContext());
    }

    public final float getSamplingRate$dd_sdk_android_release() {
        return this.f3767b;
    }

    public final boolean getBackgroundTrackingEnabled$dd_sdk_android_release() {
        return this.f3768c;
    }

    public final FirstPartyHostDetector getFirstPartyHostDetector$dd_sdk_android_release() {
        return this.f3769d;
    }

    public final RumSessionListener getSessionListener$dd_sdk_android_release() {
        return this.f3774i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RumSessionScope(com.datadog.android.rum.internal.domain.scope.RumScope r18, float r19, boolean r20, com.datadog.android.core.internal.net.FirstPartyHostDetector r21, com.datadog.android.rum.internal.vitals.VitalMonitor r22, com.datadog.android.rum.internal.vitals.VitalMonitor r23, com.datadog.android.rum.internal.vitals.VitalMonitor r24, com.datadog.android.core.internal.time.TimeProvider r25, com.datadog.android.rum.RumSessionListener r26, long r27, long r29, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x000a
            long r1 = f3764u
            r13 = r1
            goto L_0x000c
        L_0x000a:
            r13 = r27
        L_0x000c:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0014
            long r0 = f3765v
            r15 = r0
            goto L_0x0016
        L_0x0014:
            r15 = r29
        L_0x0016:
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r12 = r26
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.rum.internal.domain.scope.RumSessionScope.<init>(com.datadog.android.rum.internal.domain.scope.RumScope, float, boolean, com.datadog.android.core.internal.net.FirstPartyHostDetector, com.datadog.android.rum.internal.vitals.VitalMonitor, com.datadog.android.rum.internal.vitals.VitalMonitor, com.datadog.android.rum.internal.vitals.VitalMonitor, com.datadog.android.core.internal.time.TimeProvider, com.datadog.android.rum.RumSessionListener, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<RumScope> getActiveChildrenScopes$dd_sdk_android_release() {
        return this.f3777l;
    }

    public final boolean getKeepSession$dd_sdk_android_release() {
        return this.f3778m;
    }

    public final void setKeepSession$dd_sdk_android_release(boolean z) {
        this.f3778m = z;
    }

    public final String getSessionId$dd_sdk_android_release() {
        return this.f3779n;
    }

    public final void setSessionId$dd_sdk_android_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f3779n = str;
    }

    public final AtomicLong getSessionStartNs$dd_sdk_android_release() {
        return this.f3780o;
    }

    public final AtomicLong getLastUserInteractionNs$dd_sdk_android_release() {
        return this.f3781p;
    }

    public RumScope handleEvent(RumRawEvent rumRawEvent, DataWriter<Object> dataWriter) {
        Intrinsics.checkNotNullParameter(rumRawEvent, "event");
        Intrinsics.checkNotNullParameter(dataWriter, "writer");
        if (rumRawEvent instanceof RumRawEvent.ResetSession) {
            this.f3779n = RumContext.Companion.getNULL_UUID();
            this.f3782q = Long.valueOf(System.nanoTime());
            this.f3783r = false;
        }
        m2447b();
        if (!this.f3778m) {
            dataWriter = this.f3785t;
        }
        Iterator<RumScope> it = this.f3777l.iterator();
        while (it.hasNext()) {
            if (it.next().handleEvent(rumRawEvent, dataWriter) == null) {
                it.remove();
            }
        }
        if (rumRawEvent instanceof RumRawEvent.StartView) {
            RumRawEvent.StartView startView = (RumRawEvent.StartView) rumRawEvent;
            RumViewScope fromEvent$dd_sdk_android_release = RumViewScope.Companion.fromEvent$dd_sdk_android_release(this, startView, this.f3769d, this.f3770e, this.f3771f, this.f3772g, this.f3773h);
            onApplicationDisplayed$dd_sdk_android_release(startView, fromEvent$dd_sdk_android_release, dataWriter);
            this.f3777l.add(fromEvent$dd_sdk_android_release);
        } else if (this.f3777l.size() == 0) {
            m2446a(rumRawEvent, dataWriter);
        }
        return this;
    }

    public RumContext getRumContext() {
        m2447b();
        if (this.f3778m) {
            return RumContext.copy$default(this.f3766a.getRumContext(), (String) null, this.f3779n, (String) null, (String) null, (String) null, (String) null, 61, (Object) null);
        }
        return new RumContext((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    /* renamed from: a */
    private final void m2446a(RumRawEvent rumRawEvent, DataWriter<Object> dataWriter) {
        if (!((rumRawEvent instanceof RumRawEvent.AddError) || (rumRawEvent instanceof RumRawEvent.AddLongTask) || (rumRawEvent instanceof RumRawEvent.StartAction) || (rumRawEvent instanceof RumRawEvent.StartResource)) || !this.f3768c) {
            Logger.w$default(RuntimeUtilsKt.getDevLogger(), MESSAGE_MISSING_VIEW, (Throwable) null, (Map) null, 6, (Object) null);
            return;
        }
        RumViewScope produceRumBackgroundViewScope$dd_sdk_android_release = produceRumBackgroundViewScope$dd_sdk_android_release(rumRawEvent);
        produceRumBackgroundViewScope$dd_sdk_android_release.handleEvent(rumRawEvent, dataWriter);
        this.f3777l.add(produceRumBackgroundViewScope$dd_sdk_android_release);
    }

    public final RumViewScope produceRumBackgroundViewScope$dd_sdk_android_release(RumRawEvent rumRawEvent) {
        Intrinsics.checkNotNullParameter(rumRawEvent, "event");
        return new RumViewScope(this, RumViewScope.RUM_BACKGROUND_VIEW_URL, RumViewScope.RUM_BACKGROUND_VIEW_NAME, rumRawEvent.getEventTime(), MapsKt.emptyMap(), this.f3769d, new NoOpVitalMonitor(), new NoOpVitalMonitor(), new NoOpVitalMonitor(), this.f3773h);
    }

    public final void onApplicationDisplayed$dd_sdk_android_release(RumRawEvent.StartView startView, RumViewScope rumViewScope, DataWriter<Object> dataWriter) {
        Intrinsics.checkNotNullParameter(startView, "event");
        Intrinsics.checkNotNullParameter(rumViewScope, "viewScope");
        Intrinsics.checkNotNullParameter(dataWriter, "writer");
        if (!this.f3783r) {
            this.f3783r = true;
            rumViewScope.handleEvent(new RumRawEvent.ApplicationStarted(startView.getEventTime(), m2445a()), dataWriter);
        }
    }

    /* renamed from: a */
    private final long m2445a() {
        Long l = this.f3782q;
        if (l != null) {
            return l.longValue();
        }
        if (Build.VERSION.SDK_INT < 24) {
            return Datadog.INSTANCE.getStartupTimeNs$dd_sdk_android_release();
        }
        return System.nanoTime() - TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
    }

    /* renamed from: b */
    private final synchronized void m2447b() {
        long nanoTime = System.nanoTime();
        boolean areEqual = Intrinsics.areEqual((Object) this.f3779n, (Object) RumContext.Companion.getNULL_UUID());
        long j = nanoTime - this.f3780o.get();
        boolean z = true;
        boolean z2 = nanoTime - this.f3781p.get() >= this.f3775j;
        boolean z3 = j >= this.f3776k;
        if (areEqual || z2 || z3) {
            this.f3778m = this.f3784s.nextFloat() * 100.0f < this.f3767b;
            this.f3780o.set(nanoTime);
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            this.f3779n = uuid;
            RumSessionListener rumSessionListener = this.f3774i;
            if (rumSessionListener != null) {
                if (this.f3778m) {
                    z = false;
                }
                rumSessionListener.onSessionStarted(uuid, z);
            }
        }
        this.f3781p.set(nanoTime);
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumSessionScope$Companion;", "", "()V", "DEFAULT_SESSION_INACTIVITY_NS", "", "getDEFAULT_SESSION_INACTIVITY_NS$dd_sdk_android_release", "()J", "DEFAULT_SESSION_MAX_DURATION_NS", "getDEFAULT_SESSION_MAX_DURATION_NS$dd_sdk_android_release", "MESSAGE_MISSING_VIEW", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RumSessionScope.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final long getDEFAULT_SESSION_INACTIVITY_NS$dd_sdk_android_release() {
            return RumSessionScope.f3764u;
        }

        public final long getDEFAULT_SESSION_MAX_DURATION_NS$dd_sdk_android_release() {
            return RumSessionScope.f3765v;
        }
    }
}
