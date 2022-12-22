package com.didichuxing.routesearchsdk.multi;

import com.didi.map.sdk.proto.driver_gl.MultiRoutePlanRes;

public interface IMultiRouteSearchCallback {

    /* renamed from: com.didichuxing.routesearchsdk.multi.IMultiRouteSearchCallback$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onFinishToSearch(IMultiRouteSearchCallback iMultiRouteSearchCallback, MultiRoutePlanRes multiRoutePlanRes, String str, int i) {
        }
    }

    void onBeginToSearch();

    void onFinishToSearch(MultiRoutePlanRes multiRoutePlanRes, String str);

    void onFinishToSearch(MultiRoutePlanRes multiRoutePlanRes, String str, int i);
}
