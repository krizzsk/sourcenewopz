package com.didi.soda.customer.foundation.location;

import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

public class LocationOmegaHelper {

    /* renamed from: a */
    private static boolean f40925a = true;

    /* renamed from: b */
    private long f40926b;

    /* renamed from: c */
    private long f40927c;

    /* access modifiers changed from: protected */
    public void traceLocStart() {
        this.f40926b = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void traceLocEnd(DIDILocation dIDILocation) {
        this.f40927c = System.currentTimeMillis();
        OmegaTracker.Builder.create(ErrorConst.ErrorName.SAILING_C_SERVICE_LOCATION_SUCCESS).addEventParam("time", Long.valueOf(this.f40927c - this.f40926b)).addEventParam("lat", Double.valueOf(dIDILocation.getLatitude())).addEventParam("lng", Double.valueOf(dIDILocation.getLongitude())).addEventParam("first_locate", Integer.valueOf(f40925a ? 1 : 2)).build().track();
        f40925a = false;
    }

    /* access modifiers changed from: protected */
    public void traceLocError(ErrInfo errInfo) {
        OmegaTracker.Builder.create(ErrorConst.ErrorName.SAILING_C_SERVICE_LOCATION_ERROR).addEventParam("error_code", Integer.valueOf(errInfo.getErrNo())).build().track();
    }
}
