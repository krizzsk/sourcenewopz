package com.didi.sdk.map;

import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

public interface ILocation {

    public interface ILocateStatusListener {
        void onStatusUpdate(String str, int i, String str2);
    }

    public interface ILocationChangedListener {
        void onLocationChanged(DIDILocation dIDILocation);
    }

    public interface ILocationErrorListener {
        void onLocationError(int i, ErrInfo errInfo);
    }
}
