package com.datadog.android.rum.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RumFeature.kt */
final class RumFeature$initializeVitalMonitors$vitalFrameCallback$1 extends Lambda implements Function0<Boolean> {
    public static final RumFeature$initializeVitalMonitors$vitalFrameCallback$1 INSTANCE = new RumFeature$initializeVitalMonitors$vitalFrameCallback$1();

    RumFeature$initializeVitalMonitors$vitalFrameCallback$1() {
        super(0);
    }

    public final boolean invoke() {
        return RumFeature.INSTANCE.isInitialized();
    }
}
