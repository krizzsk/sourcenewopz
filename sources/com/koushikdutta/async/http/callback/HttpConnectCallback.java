package com.koushikdutta.async.http.callback;

import com.koushikdutta.async.http.AsyncHttpResponse;

public interface HttpConnectCallback {
    void onConnectCompleted(Exception exc, AsyncHttpResponse asyncHttpResponse);
}
