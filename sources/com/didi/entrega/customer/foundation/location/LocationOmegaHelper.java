package com.didi.entrega.customer.foundation.location;

import com.didi.entrega.customer.foundation.tracker.OmegaTracker;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

public class LocationOmegaHelper {

    /* renamed from: a */
    private static boolean f19918a = true;

    /* renamed from: b */
    private long f19919b;

    /* renamed from: c */
    private long f19920c;

    /* access modifiers changed from: protected */
    public void traceLocStart() {
        this.f19919b = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void traceLocEnd(DIDILocation dIDILocation) {
        this.f19920c = System.currentTimeMillis();
        OmegaTracker.Builder.create(ErrorConst.ErrorName.SAILING_C_SERVICE_LOCATION_SUCCESS).addEventParam("time", Long.valueOf(this.f19920c - this.f19919b)).addEventParam("lat", Double.valueOf(dIDILocation.getLatitude())).addEventParam("lng", Double.valueOf(dIDILocation.getLongitude())).addEventParam("first_locate", Integer.valueOf(f19918a ? 1 : 2)).build().track();
        f19918a = false;
    }

    /* access modifiers changed from: protected */
    public void traceLocError(ErrInfo errInfo) {
        OmegaTracker.Builder.create(ErrorConst.ErrorName.SAILING_C_SERVICE_LOCATION_ERROR).addEventParam("error_code", Integer.valueOf(errInfo.getErrNo())).build().track();
    }
}
