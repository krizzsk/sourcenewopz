package com.didi.map.global.sctx;

import com.didi.map.global.sctx.model.SctxTripParam;
import com.didi.map.google.util.DLog;

public class SctxServiceFactory {

    /* renamed from: a */
    private static final String f27623a = "SctxServiceFactory";

    public SctxService getSctxService(SctxTripParam sctxTripParam) {
        DLog.m19914d(f27623a, "disable float window", new Object[0]);
        return new PassengerSctxServiceImp(sctxTripParam);
    }
}
