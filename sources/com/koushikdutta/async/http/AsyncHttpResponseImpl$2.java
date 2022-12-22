package com.koushikdutta.async.http;

import com.koushikdutta.async.callback.CompletedCallback;

class AsyncHttpResponseImpl$2 implements CompletedCallback {
    final /* synthetic */ C20198a this$0;

    AsyncHttpResponseImpl$2(C20198a aVar) {
        this.this$0 = aVar;
    }

    public void onCompleted(Exception exc) {
        if (this.this$0.headers() == null) {
            this.this$0.report(new ConnectionClosedException("connection closed before headers received.", exc));
        } else if (exc == null || this.this$0.mCompleted) {
            this.this$0.report(exc);
        } else {
            this.this$0.report(new ConnectionClosedException("connection closed before response completed.", exc));
        }
    }
}
