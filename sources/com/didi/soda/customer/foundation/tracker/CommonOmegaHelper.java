package com.didi.soda.customer.foundation.tracker;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/tracker/CommonOmegaHelper;", "", "()V", "locationOpenSettingGpsStatusCk", "", "source", "", "hasLocationPermission", "", "hasGps", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CommonOmegaHelper.kt */
public final class CommonOmegaHelper {
    public static final CommonOmegaHelper INSTANCE = new CommonOmegaHelper();

    private CommonOmegaHelper() {
    }

    public final void locationOpenSettingGpsStatusCk(int i, boolean z, boolean z2) {
        int i2 = 1;
        OmegaTracker.Builder addEventParam = OmegaTracker.Builder.create(EventConst.Technology.TECH_SAILING_C_STATUS_GET_GPS_EVENT).addEventParam(ParamConst.PARAM_ADDRESS_FAILURE_LOCATION_SOURCE, Integer.valueOf(i)).addEventParam(ParamConst.PARAM_IS_LOCATION, Integer.valueOf(z ? 1 : 2));
        if (!z2) {
            i2 = 2;
        }
        addEventParam.addEventParam(ParamConst.PARAM_ADDRESS_GPS_OPEN, Integer.valueOf(i2)).build().track();
    }
}
