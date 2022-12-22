package com.didichuxing.routesearchsdk.walk;

import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, mo175978d2 = {"Lcom/didichuxing/routesearchsdk/walk/IWalkNavRouteSearchApi;", "", "calculateRoute", "", "param", "Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchParam;", "callback", "Lcom/didichuxing/routesearchsdk/walk/WalkNavRouteSearchCallback;", "cancelRequest", "RouteSearchSDK_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IWalkNavRouteSearchApi.kt */
public interface IWalkNavRouteSearchApi {
    void calculateRoute(WalkNavRouteSearchParam walkNavRouteSearchParam, WalkNavRouteSearchCallback walkNavRouteSearchCallback);

    void cancelRequest();
}
