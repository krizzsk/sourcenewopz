package com.didichuxing.routesearchsdk.multi;

import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanRes;

public class MultiRouteSearchApiImpl implements IMultiRouteSearchApi {
    public void calculateRoute(MultiRouteSearchParam multiRouteSearchParam, IMultiRouteSearchCallback iMultiRouteSearchCallback) {
        if (iMultiRouteSearchCallback != null) {
            if (multiRouteSearchParam == null) {
                iMultiRouteSearchCallback.onFinishToSearch((MultiRoutePlanRes) null, "param can not be null!");
                return;
            }
            new MultiRouteSearchTask(iMultiRouteSearchCallback).execute(new MultiRouteSearchParam[]{multiRouteSearchParam});
        }
    }
}
