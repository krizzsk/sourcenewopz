package com.didichuxing.doraemonkit.kit.network.okhttp;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

public class DoraemonWeakNetworkInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) throws IOException {
        return chain.proceed(chain.request());
    }
}
