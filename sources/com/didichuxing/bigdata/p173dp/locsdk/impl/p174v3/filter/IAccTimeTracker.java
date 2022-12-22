package com.didichuxing.bigdata.p173dp.locsdk.impl.p174v3.filter;

import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.filter.IAccTimeTracker */
public interface IAccTimeTracker {
    void startTracking();

    void stopTracking();

    void updateNotifiedLocation(DIDILocation dIDILocation, String str);
}
