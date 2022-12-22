package com.didichuxing.routesearchsdk.walk;

import com.didi.map.sdk.proto.driver_gl.OrderWalkingRes;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, mo175978d2 = {"Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchCallback;", "", "onBeginToSearch", "", "onFinishToSearch", "BubblePageRes", "Lcom/didi/map/sdk/proto/driver_gl/OrderWalkingRes;", "errMessage", "", "RouteSearchSDK_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalkNavRouteSearchCallback.kt */
public interface WalkNavRouteSearchCallback {
    void onBeginToSearch();

    void onFinishToSearch(OrderWalkingRes orderWalkingRes, String str);
}
