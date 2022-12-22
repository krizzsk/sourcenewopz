package com.didichuxing.publicservice.network;

import java.net.URL;

public interface INonRpcInterceptor {
    URL intercept(URL url);
}
