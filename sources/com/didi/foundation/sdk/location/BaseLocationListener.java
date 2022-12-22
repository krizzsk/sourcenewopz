package com.didi.foundation.sdk.location;

import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

public abstract class BaseLocationListener implements DIDILocationListener {
    public void onLocationChanged(DIDILocation dIDILocation) {
    }

    public void onLocationError(int i, ErrInfo errInfo) {
    }

    public void onStatusUpdate(String str, int i, String str2) {
    }
}
