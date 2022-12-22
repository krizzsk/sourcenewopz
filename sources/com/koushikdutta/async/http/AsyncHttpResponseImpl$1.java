package com.koushikdutta.async.http;

import com.koushikdutta.async.callback.CompletedCallback;

class AsyncHttpResponseImpl$1 implements CompletedCallback {
    final /* synthetic */ C20198a this$0;

    AsyncHttpResponseImpl$1(C20198a aVar) {
        this.this$0 = aVar;
    }

    public void onCompleted(Exception exc) {
        this.this$0.onRequestCompleted(exc);
    }
}
