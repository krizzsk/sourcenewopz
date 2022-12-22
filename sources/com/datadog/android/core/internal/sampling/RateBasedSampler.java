package com.datadog.android.core.internal.sampling;

import java.security.SecureRandom;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, mo175978d2 = {"Lcom/datadog/android/core/internal/sampling/RateBasedSampler;", "Lcom/datadog/android/core/internal/sampling/Sampler;", "sampleRate", "", "(F)V", "random", "Ljava/security/SecureRandom;", "getRandom", "()Ljava/security/SecureRandom;", "random$delegate", "Lkotlin/Lazy;", "getSampleRate$dd_sdk_android_release", "()F", "sample", "", "dd-sdk-android_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RateBasedSampler.kt */
public final class RateBasedSampler implements Sampler {

    /* renamed from: a */
    private final float f3581a;

    /* renamed from: b */
    private final Lazy f3582b = LazyKt.lazy(RateBasedSampler$random$2.INSTANCE);

    public RateBasedSampler(float f) {
        this.f3581a = f;
    }

    public final float getSampleRate$dd_sdk_android_release() {
        return this.f3581a;
    }

    /* renamed from: a */
    private final SecureRandom m2364a() {
        return (SecureRandom) this.f3582b.getValue();
    }

    public boolean sample() {
        if (this.f3581a == 0.0f) {
            return false;
        }
        if (!(this.f3581a == 1.0f) && m2364a().nextFloat() > this.f3581a) {
            return false;
        }
        return true;
    }
}
