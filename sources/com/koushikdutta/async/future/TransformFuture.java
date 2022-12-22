package com.koushikdutta.async.future;

public abstract class TransformFuture<T, F> extends SimpleFuture<T> implements FutureCallback<F> {
    /* access modifiers changed from: protected */
    public abstract void transform(F f) throws Exception;

    public TransformFuture(F f) {
        onCompleted((Exception) null, f);
    }

    public TransformFuture() {
    }

    public void onCompleted(Exception exc, F f) {
        if (!isCancelled()) {
            if (exc != null) {
                error(exc);
                return;
            }
            try {
                transform(f);
            } catch (Exception e) {
                error(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void error(Exception exc) {
        setComplete(exc);
    }
}
