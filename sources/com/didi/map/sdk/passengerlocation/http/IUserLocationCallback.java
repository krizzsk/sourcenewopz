package com.didi.map.sdk.passengerlocation.http;

import com.didi.map.sdk.proto.driver_gl.UserLocationRes;

public interface IUserLocationCallback {
    void onFinished(UserLocationRes userLocationRes, String str);

    void onStarted();
}
