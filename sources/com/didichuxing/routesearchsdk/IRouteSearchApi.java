package com.didichuxing.routesearchsdk;

public interface IRouteSearchApi {
    void calculateRoute(RouteSearchParam routeSearchParam, IRouteSearchCallback iRouteSearchCallback);
}
