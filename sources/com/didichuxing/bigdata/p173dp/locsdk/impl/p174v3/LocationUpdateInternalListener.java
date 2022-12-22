package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3;

import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocationUpdateInternalListener */
public interface LocationUpdateInternalListener {
    void onLocationErr(ErrInfo errInfo, long j);

    void onLocationUpdate(DIDILocation dIDILocation, long j);
}
