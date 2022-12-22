package com.didi.trackupload.sdk.location;

import android.content.Context;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.util.List;

public interface ILocationClient {
    String getLastError();

    DIDILocation getLastLocation();

    List<DIDILocation> getRecentLocations(int i);

    void init(Context context);

    boolean isLocationServiceAlive();

    void removeDirectNotifyLocationUpdates();

    void removeNormalLocationUpdates();

    void requestDirectNotifyLocationUpdates(TrackLocationListener trackLocationListener, long j);

    void requestLocationUpdateOnce(TrackLocationListener trackLocationListener);

    void requestNormalLocationUpdates(TrackLocationListener trackLocationListener, long j);
}
