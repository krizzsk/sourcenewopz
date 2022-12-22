package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.core.internal.net.FirstPartyHostDetector;
import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.internal.time.TimeProvider;
import com.datadog.android.rum.RumSessionListener;
import com.datadog.android.rum.internal.domain.RumContext;
import com.datadog.android.rum.internal.vitals.VitalMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u001e\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006#"}, mo175978d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumApplicationScope;", "Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "applicationId", "", "samplingRate", "", "backgroundTrackingEnabled", "", "firstPartyHostDetector", "Lcom/datadog/android/core/internal/net/FirstPartyHostDetector;", "cpuVitalMonitor", "Lcom/datadog/android/rum/internal/vitals/VitalMonitor;", "memoryVitalMonitor", "frameRateVitalMonitor", "timeProvider", "Lcom/datadog/android/core/internal/time/TimeProvider;", "sessionListener", "Lcom/datadog/android/rum/RumSessionListener;", "(Ljava/lang/String;FZLcom/datadog/android/core/internal/net/FirstPartyHostDetector;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/rum/internal/vitals/VitalMonitor;Lcom/datadog/android/core/internal/time/TimeProvider;Lcom/datadog/android/rum/RumSessionListener;)V", "getBackgroundTrackingEnabled$dd_sdk_android_release", "()Z", "childScope", "getChildScope$dd_sdk_android_release", "()Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "rumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "getSamplingRate$dd_sdk_android_release", "()F", "getRumContext", "handleEvent", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "writer", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumApplicationScope.kt */
public final class RumApplicationScope implements RumScope {

    /* renamed from: a */
    private final float f3742a;

    /* renamed from: b */
    private final boolean f3743b;

    /* renamed from: c */
    private final RumContext f3744c;

    /* renamed from: d */
    private final RumScope f3745d;

    public RumApplicationScope(String str, float f, boolean z, FirstPartyHostDetector firstPartyHostDetector, VitalMonitor vitalMonitor, VitalMonitor vitalMonitor2, VitalMonitor vitalMonitor3, TimeProvider timeProvider, RumSessionListener rumSessionListener) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "applicationId");
        Intrinsics.checkNotNullParameter(firstPartyHostDetector, "firstPartyHostDetector");
        Intrinsics.checkNotNullParameter(vitalMonitor, "cpuVitalMonitor");
        Intrinsics.checkNotNullParameter(vitalMonitor2, "memoryVitalMonitor");
        Intrinsics.checkNotNullParameter(vitalMonitor3, "frameRateVitalMonitor");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.f3742a = f;
        this.f3743b = z;
        this.f3744c = new RumContext(str2, (String) null, (String) null, (String) null, (String) null, (String) null, 62, (DefaultConstructorMarker) null);
        this.f3745d = new RumSessionScope(this, this.f3742a, this.f3743b, firstPartyHostDetector, vitalMonitor, vitalMonitor2, vitalMonitor3, timeProvider, rumSessionListener, 0, 0, 1536, (DefaultConstructorMarker) null);
    }

    public final float getSamplingRate$dd_sdk_android_release() {
        return this.f3742a;
    }

    public final boolean getBackgroundTrackingEnabled$dd_sdk_android_release() {
        return this.f3743b;
    }

    public final RumScope getChildScope$dd_sdk_android_release() {
        return this.f3745d;
    }

    public RumScope handleEvent(RumRawEvent rumRawEvent, DataWriter<Object> dataWriter) {
        Intrinsics.checkNotNullParameter(rumRawEvent, "event");
        Intrinsics.checkNotNullParameter(dataWriter, "writer");
        this.f3745d.handleEvent(rumRawEvent, dataWriter);
        return this;
    }

    public RumContext getRumContext() {
        return this.f3744c;
    }
}
