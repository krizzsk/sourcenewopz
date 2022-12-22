package com.pay99.diff_passenger;

import com.didi.payment.base.tracker.FinOmegaSDK;
import com.pay99.diff_base.base.ITrackEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/pay99/diff_passenger/PassengerTrackEvent;", "Lcom/pay99/diff_base/base/ITrackEvent;", "()V", "trackEvent", "", "driverKey", "", "passengerKey", "params", "", "", "diff-base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PassengerTrackEvent.kt */
public final class PassengerTrackEvent implements ITrackEvent {
    public void trackEvent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "driverKey");
        Intrinsics.checkNotNullParameter(str2, "passengerKey");
        FinOmegaSDK.trackEvent(str2, new LinkedHashMap());
    }

    public void trackEvent(String str, String str2, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "driverKey");
        Intrinsics.checkNotNullParameter(str2, "passengerKey");
        Intrinsics.checkNotNullParameter(map, "params");
        FinOmegaSDK.trackEvent(str2, map);
    }
}
