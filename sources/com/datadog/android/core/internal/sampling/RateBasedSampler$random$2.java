package com.datadog.android.core.internal.sampling;

import java.security.SecureRandom;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Ljava/security/SecureRandom;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RateBasedSampler.kt */
final class RateBasedSampler$random$2 extends Lambda implements Function0<SecureRandom> {
    public static final RateBasedSampler$random$2 INSTANCE = new RateBasedSampler$random$2();

    RateBasedSampler$random$2() {
        super(0);
    }

    public final SecureRandom invoke() {
        return new SecureRandom();
    }
}
