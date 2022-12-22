package com.didichuxing.bigdata.p173dp.locsdk;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.DIDILocationListener */
public interface DIDILocationListener {
    void onLocationChanged(DIDILocation dIDILocation);

    void onLocationError(int i, ErrInfo errInfo);

    void onStatusUpdate(String str, int i, String str2);
}
