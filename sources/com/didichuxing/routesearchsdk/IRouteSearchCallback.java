package com.didichuxing.routesearchsdk;

import com.didi.map.sdk.proto.driver_gl.RoutePlanRes;

public interface IRouteSearchCallback {
    void onBeginToSearch();

    void onFinishToSearch(RoutePlanRes routePlanRes, String str);
}
