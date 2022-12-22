package com.didi.payment.pix.utils;

import com.pay99.diff_base.DiffConstants;
import com.pay99.diff_base.DiffUtil;
import com.pay99.diff_base.base.IDiff;
import com.pay99.diff_base.base.ITrackEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/pix/utils/TrackUtils;", "", "()V", "Companion", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TrackUtils.kt */
public final class TrackUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\t¨\u0006\n"}, mo175978d2 = {"Lcom/didi/payment/pix/utils/TrackUtils$Companion;", "", "()V", "trackEvent", "", "driverKey", "", "passengerKey", "params", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TrackUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void trackEvent(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "driverKey");
            Intrinsics.checkNotNullParameter(str2, "passengerKey");
            IDiff diffValue = DiffUtil.INSTANCE.getDiffValue(DiffConstants.DIFF_WALLET_TRACK);
            ITrackEvent iTrackEvent = diffValue instanceof ITrackEvent ? (ITrackEvent) diffValue : null;
            if (iTrackEvent != null) {
                iTrackEvent.trackEvent(str, str2);
            }
        }

        public final void trackEvent(String str, String str2, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(str, "driverKey");
            Intrinsics.checkNotNullParameter(str2, "passengerKey");
            Intrinsics.checkNotNullParameter(map, "params");
            IDiff diffValue = DiffUtil.INSTANCE.getDiffValue(DiffConstants.DIFF_WALLET_TRACK);
            ITrackEvent iTrackEvent = diffValue instanceof ITrackEvent ? (ITrackEvent) diffValue : null;
            if (iTrackEvent != null) {
                iTrackEvent.trackEvent(str, str2, map);
            }
        }
    }
}
