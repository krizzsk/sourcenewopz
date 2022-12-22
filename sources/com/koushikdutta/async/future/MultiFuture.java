package com.koushikdutta.async.future;

import com.koushikdutta.async.future.SimpleFuture;
import java.util.ArrayList;
import java.util.Iterator;

public class MultiFuture<T> extends SimpleFuture<T> {
    private final SimpleFuture.FutureCallbackInternal<T> internalCallback = new SimpleFuture.FutureCallbackInternal() {
        public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
            MultiFuture.this.lambda$new$0$MultiFuture(exc, obj, futureCallsite);
        }
    };
    private ArrayList<SimpleFuture.FutureCallbackInternal<T>> internalCallbacks;

    public MultiFuture() {
    }

    public MultiFuture(T t) {
        super(t);
    }

    public MultiFuture(Exception exc) {
        super(exc);
    }

    public MultiFuture(Future<T> future) {
        super(future);
    }

    public /* synthetic */ void lambda$new$0$MultiFuture(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
        ArrayList<SimpleFuture.FutureCallbackInternal<T>> arrayList;
        synchronized (this) {
            arrayList = this.internalCallbacks;
            this.internalCallbacks = null;
        }
        if (arrayList != null) {
            Iterator<SimpleFuture.FutureCallbackInternal<T>> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onCompleted(exc, obj, futureCallsite);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setCallbackInternal(SimpleFuture.FutureCallsite futureCallsite, SimpleFuture.FutureCallbackInternal<T> futureCallbackInternal) {
        synchronized (this) {
            if (futureCallbackInternal != null) {
                if (this.internalCallbacks == null) {
                    this.internalCallbacks = new ArrayList<>();
                }
                this.internalCallbacks.add(futureCallbackInternal);
            }
        }
        super.setCallbackInternal(futureCallsite, this.internalCallback);
    }
}
