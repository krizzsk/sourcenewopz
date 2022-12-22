package com.didi.soda.customer.p165h5;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\u0007"}, mo175978d2 = {"trackDidiPassPayCallBack", "", "data", "", "trackDidiPassPayCk", "params", "trackGoDidiPass", "customer-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.CustomerDidiPassTrackKt */
/* compiled from: CustomerDidiPassTrack.kt */
public final class CustomerDidiPassTrackKt {
    public static final void trackGoDidiPass() {
        OmegaTracker.Builder.create(EventConst.DidiPass.GO_DIDI_PASS).build().track();
    }

    public static final void trackDidiPassPayCk(String str) {
        Intrinsics.checkNotNullParameter(str, "params");
        OmegaTracker.Builder.create(EventConst.DidiPass.DIDI_PASS_PAY_CK).addEventParam("params", str).build().track();
    }

    public static final void trackDidiPassPayCallBack(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        OmegaTracker.Builder.create(EventConst.DidiPass.DIDI_PASS_PAY_CALLBACK).addEventParam("data", str).build().track();
    }
}
