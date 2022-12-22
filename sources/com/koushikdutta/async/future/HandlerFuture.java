package com.koushikdutta.async.future;

import android.os.Handler;
import android.os.Looper;

public class HandlerFuture<T> extends SimpleFuture<T> {

    /* renamed from: a */
    Handler f55260a;

    public HandlerFuture() {
        Looper myLooper = Looper.myLooper();
        this.f55260a = new Handler(myLooper == null ? Looper.getMainLooper() : myLooper);
    }

    public void setCallback(final FutureCallback<T> futureCallback) {
        super.setCallback(new FutureCallback<T>() {
            public void onCompleted(final Exception exc, final T t) {
                if (Looper.myLooper() == HandlerFuture.this.f55260a.getLooper()) {
                    futureCallback.onCompleted(exc, t);
                } else {
                    HandlerFuture.this.f55260a.post(new Runnable() {
                        public void run() {
                            C201591.this.onCompleted(exc, t);
                        }
                    });
                }
            }
        });
    }
}
