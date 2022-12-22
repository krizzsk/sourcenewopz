package com.koushikdutta.async.future;

public abstract class MultiTransformFuture<T, F> extends MultiFuture<T> implements FutureCallback<F> {
    /* access modifiers changed from: protected */
    public abstract void transform(F f) throws Exception;

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
