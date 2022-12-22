package com.didi.map.global.sctx.server;

import com.didi.map.sdk.proto.driver_gl.MapPassengeOrderRouteRes;

public interface IDataCallback {
    void onError(String str);

    void onStart();

    void onSuccess(MapPassengeOrderRouteRes mapPassengeOrderRouteRes);
}
