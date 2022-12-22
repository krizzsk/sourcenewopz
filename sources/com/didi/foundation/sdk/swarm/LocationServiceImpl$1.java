package com.didi.foundation.sdk.swarm;

import com.didi.foundation.sdk.location.BaseLocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;

class LocationServiceImpl$1 extends BaseLocationListener {
    final /* synthetic */ C8396d this$0;

    LocationServiceImpl$1(C8396d dVar) {
        this.this$0 = dVar;
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        this.this$0.m15691a(dIDILocation);
    }
}
