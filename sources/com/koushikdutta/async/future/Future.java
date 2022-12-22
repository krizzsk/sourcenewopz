package com.koushikdutta.async.future;

import java.util.concurrent.Executor;

public interface Future<T> extends Cancellable, java.util.concurrent.Future<T> {
    Future<T> done(DoneCallback<T> doneCallback);

    Future<T> executorThread(Executor executor);

    Future<T> fail(FailCallback failCallback);

    Future<T> failConvert(FailConvertCallback<T> failConvertCallback);

    Future<T> failRecover(FailRecoverCallback<T> failRecoverCallback);

    void setCallback(FutureCallback<T> futureCallback);

    Future<T> success(SuccessCallback<T> successCallback);

    <R> Future<R> then(ThenFutureCallback<R, T> thenFutureCallback);

    <R> Future<R> thenConvert(ThenCallback<R, T> thenCallback);

    T tryGet();

    Exception tryGetException();

    /* renamed from: com.koushikdutta.async.future.Future$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Future $default$executorThread(Future _this, Executor executor) {
            SimpleFuture simpleFuture = new SimpleFuture();
            executor.execute(new Runnable(simpleFuture) {
                public final /* synthetic */ SimpleFuture f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    this.f$1.setComplete(Future.this);
                }
            });
            return simpleFuture;
        }
    }
}
