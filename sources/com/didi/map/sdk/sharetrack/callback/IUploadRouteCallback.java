package com.didi.map.sdk.sharetrack.callback;

import com.didi.map.sdk.proto.driver_gl.PickupHint;

public interface IUploadRouteCallback {
    void finishToUpload(long j, PickupHint pickupHint);
}
