package com.koushikdutta.async.http.server;

import com.koushikdutta.async.http.server.AsyncHttpServerRouter;

public interface RouteMatcher {
    AsyncHttpServerRouter.RouteMatch route(String str, String str2);
}
