package com.didi.trackupload.sdk.location;

import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;

public interface TrackLocationListener {
    void onLocationChanged(TrackLocationInfo trackLocationInfo);

    void onLocationError(int i, String str);
}
