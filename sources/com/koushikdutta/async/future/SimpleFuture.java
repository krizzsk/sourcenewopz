package com.koushikdutta.async.future;

import com.koushikdutta.async.AsyncSemaphore;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.SimpleFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class SimpleFuture<T> extends SimpleCancellable implements DependentFuture<T> {
    private Exception exception;
    private FutureCallbackInternal<T> internalCallback;
    private T result;
    private boolean silent;
    private AsyncSemaphore waiter;

    protected interface FutureCallbackInternal<T> {
        void onCompleted(Exception exc, T t, FutureCallsite futureCallsite);
    }

    public /* synthetic */ Future<T> executorThread(Executor executor) {
        return Future.CC.$default$executorThread(this, executor);
    }

    public SimpleFuture() {
    }

    public SimpleFuture(T t) {
        setComplete(t);
    }

    public SimpleFuture(Exception exc) {
        setComplete(exc);
    }

    public SimpleFuture(Future<T> future) {
        setComplete(future);
    }

    public boolean cancel(boolean z) {
        return cancel();
    }

    private boolean cancelInternal(boolean z) {
        FutureCallbackInternal handleInternalCompleteLocked;
        if (!super.cancel()) {
            return false;
        }
        synchronized (this) {
            this.exception = new CancellationException();
            releaseWaiterLocked();
            handleInternalCompleteLocked = handleInternalCompleteLocked();
            this.silent = z;
        }
        handleCallbackUnlocked((FutureCallsite) null, handleInternalCompleteLocked);
        return true;
    }

    public boolean cancelSilently() {
        return cancelInternal(true);
    }

    public boolean cancel() {
        return cancelInternal(this.silent);
    }

    public T get() throws InterruptedException, ExecutionException {
        synchronized (this) {
            if (!isCancelled()) {
                if (!isDone()) {
                    AsyncSemaphore ensureWaiterLocked = ensureWaiterLocked();
                    ensureWaiterLocked.acquire();
                    return getResultOrThrow();
                }
            }
            T resultOrThrow = getResultOrThrow();
            return resultOrThrow;
        }
    }

    private T getResultOrThrow() throws ExecutionException {
        if (this.exception == null) {
            return this.result;
        }
        throw new ExecutionException(this.exception);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r0.tryAcquire(r2, r4) == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        return getResultOrThrow();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        throw new java.util.concurrent.TimeoutException();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T get(long r2, java.util.concurrent.TimeUnit r4) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isCancelled()     // Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x0024
            boolean r0 = r1.isDone()     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x000e
            goto L_0x0024
        L_0x000e:
            com.koushikdutta.async.AsyncSemaphore r0 = r1.ensureWaiterLocked()     // Catch:{ all -> 0x002a }
            monitor-exit(r1)     // Catch:{ all -> 0x002a }
            boolean r2 = r0.tryAcquire(r2, r4)
            if (r2 == 0) goto L_0x001e
            java.lang.Object r2 = r1.getResultOrThrow()
            return r2
        L_0x001e:
            java.util.concurrent.TimeoutException r2 = new java.util.concurrent.TimeoutException
            r2.<init>()
            throw r2
        L_0x0024:
            java.lang.Object r2 = r1.getResultOrThrow()     // Catch:{ all -> 0x002a }
            monitor-exit(r1)     // Catch:{ all -> 0x002a }
            return r2
        L_0x002a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002a }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.future.SimpleFuture.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    public boolean setComplete() {
        return setComplete((Object) null);
    }

    private FutureCallbackInternal<T> handleInternalCompleteLocked() {
        FutureCallbackInternal<T> futureCallbackInternal = this.internalCallback;
        this.internalCallback = null;
        return futureCallbackInternal;
    }

    static class FutureCallsite {
        FutureCallbackInternal callback;

        /* renamed from: e */
        Exception f55261e;
        Object result;

        FutureCallsite() {
        }

        /* access modifiers changed from: package-private */
        public void loop() {
            while (true) {
                FutureCallbackInternal futureCallbackInternal = this.callback;
                if (futureCallbackInternal != null) {
                    Exception exc = this.f55261e;
                    Object obj = this.result;
                    this.callback = null;
                    this.f55261e = null;
                    this.result = null;
                    futureCallbackInternal.onCompleted(exc, obj, this);
                } else {
                    return;
                }
            }
        }
    }

    private void handleCallbackUnlocked(FutureCallsite futureCallsite, FutureCallbackInternal<T> futureCallbackInternal) {
        if (!this.silent && futureCallbackInternal != null) {
            boolean z = false;
            if (futureCallsite == null) {
                z = true;
                futureCallsite = new FutureCallsite();
            }
            futureCallsite.callback = futureCallbackInternal;
            futureCallsite.f55261e = this.exception;
            futureCallsite.result = this.result;
            if (z) {
                futureCallsite.loop();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void releaseWaiterLocked() {
        AsyncSemaphore asyncSemaphore = this.waiter;
        if (asyncSemaphore != null) {
            asyncSemaphore.release();
            this.waiter = null;
        }
    }

    /* access modifiers changed from: package-private */
    public AsyncSemaphore ensureWaiterLocked() {
        if (this.waiter == null) {
            this.waiter = new AsyncSemaphore();
        }
        return this.waiter;
    }

    public boolean setComplete(Exception exc) {
        return setComplete(exc, (Object) null, (FutureCallsite) null);
    }

    public boolean setCompleteException(Exception exc) {
        return setComplete(exc, (Object) null, (FutureCallsite) null);
    }

    public boolean setComplete(T t) {
        return setComplete((Exception) null, t, (FutureCallsite) null);
    }

    public boolean setCompleteValue(T t) {
        return setComplete((Exception) null, t, (FutureCallsite) null);
    }

    public boolean setComplete(Exception exc, T t) {
        return setComplete(exc, t, (FutureCallsite) null);
    }

    private boolean setComplete(Exception exc, T t, FutureCallsite futureCallsite) {
        synchronized (this) {
            if (!super.setComplete()) {
                return false;
            }
            this.result = t;
            this.exception = exc;
            releaseWaiterLocked();
            FutureCallbackInternal handleInternalCompleteLocked = handleInternalCompleteLocked();
            handleCallbackUnlocked(futureCallsite, handleInternalCompleteLocked);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void setCallbackInternal(FutureCallsite futureCallsite, FutureCallbackInternal<T> futureCallbackInternal) {
        synchronized (this) {
            this.internalCallback = futureCallbackInternal;
            if (isDone() || isCancelled()) {
                FutureCallbackInternal handleInternalCompleteLocked = handleInternalCompleteLocked();
                handleCallbackUnlocked(futureCallsite, handleInternalCompleteLocked);
            }
        }
    }

    public void setCallback(FutureCallback<T> futureCallback) {
        if (futureCallback == null) {
            setCallbackInternal((FutureCallsite) null, (FutureCallbackInternal) null);
        } else {
            setCallbackInternal((FutureCallsite) null, new FutureCallbackInternal() {
                public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                    FutureCallback.this.onCompleted(exc, obj);
                }
            });
        }
    }

    private Future<T> setComplete(Future<T> future, FutureCallsite futureCallsite) {
        setParent(future);
        SimpleFuture simpleFuture = new SimpleFuture();
        if (future instanceof SimpleFuture) {
            ((SimpleFuture) future).setCallbackInternal(futureCallsite, new FutureCallbackInternal(simpleFuture) {
                public final /* synthetic */ SimpleFuture f$1;

                {
                    this.f$1 = r2;
                }

                public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                    SimpleFuture.this.lambda$setComplete$1$SimpleFuture(this.f$1, exc, obj, futureCallsite);
                }
            });
        } else {
            future.setCallback(new FutureCallback(simpleFuture) {
                public final /* synthetic */ SimpleFuture f$1;

                {
                    this.f$1 = r2;
                }

                public final void onCompleted(Exception exc, Object obj) {
                    SimpleFuture.this.lambda$setComplete$2$SimpleFuture(this.f$1, exc, obj);
                }
            });
        }
        return simpleFuture;
    }

    public /* synthetic */ void lambda$setComplete$1$SimpleFuture(SimpleFuture simpleFuture, Exception exc, Object obj, FutureCallsite futureCallsite) {
        simpleFuture.setComplete(setComplete(exc, obj, futureCallsite) ? null : new CancellationException(), obj, futureCallsite);
    }

    public /* synthetic */ void lambda$setComplete$2$SimpleFuture(SimpleFuture simpleFuture, Exception exc, Object obj) {
        CancellationException cancellationException = null;
        if (!setComplete(exc, obj, (FutureCallsite) null)) {
            cancellationException = new CancellationException();
        }
        simpleFuture.setComplete((Exception) cancellationException);
    }

    public Future<T> setComplete(Future<T> future) {
        return setComplete(future, (FutureCallsite) null);
    }

    public Future<T> setCompleteFuture(Future<T> future) {
        return setComplete(future, (FutureCallsite) null);
    }

    @Deprecated
    public Object getCallback() {
        return this.internalCallback;
    }

    public Future<T> done(DoneCallback<T> doneCallback) {
        SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setParent(this);
        setCallbackInternal((FutureCallsite) null, new FutureCallbackInternal(simpleFuture) {
            public final /* synthetic */ SimpleFuture f$1;

            {
                this.f$1 = r2;
            }

            public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                SimpleFuture.lambda$done$3(DoneCallback.this, this.f$1, exc, obj, futureCallsite);
            }
        });
        return simpleFuture;
    }

    static /* synthetic */ void lambda$done$3(DoneCallback doneCallback, SimpleFuture simpleFuture, Exception e, Object obj, FutureCallsite futureCallsite) {
        if (e == null) {
            try {
                doneCallback.done(e, obj);
            } catch (Exception e2) {
                e = e2;
            }
        }
        simpleFuture.setComplete(e, obj, futureCallsite);
    }

    public Future<T> success(SuccessCallback<T> successCallback) {
        SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setParent(this);
        setCallbackInternal((FutureCallsite) null, new FutureCallbackInternal(simpleFuture) {
            public final /* synthetic */ SimpleFuture f$1;

            {
                this.f$1 = r2;
            }

            public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                SimpleFuture.lambda$success$4(SuccessCallback.this, this.f$1, exc, obj, futureCallsite);
            }
        });
        return simpleFuture;
    }

    static /* synthetic */ void lambda$success$4(SuccessCallback successCallback, SimpleFuture simpleFuture, Exception e, Object obj, FutureCallsite futureCallsite) {
        if (e == null) {
            try {
                successCallback.success(obj);
            } catch (Exception e2) {
                e = e2;
            }
        }
        simpleFuture.setComplete(e, obj, futureCallsite);
    }

    public <R> Future<R> then(ThenFutureCallback<R, T> thenFutureCallback) {
        SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setParent(this);
        setCallbackInternal((FutureCallsite) null, new FutureCallbackInternal(thenFutureCallback) {
            public final /* synthetic */ ThenFutureCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                SimpleFuture.lambda$then$5(SimpleFuture.this, this.f$1, exc, obj, futureCallsite);
            }
        });
        return simpleFuture;
    }

    static /* synthetic */ void lambda$then$5(SimpleFuture simpleFuture, ThenFutureCallback thenFutureCallback, Exception exc, Object obj, FutureCallsite futureCallsite) {
        if (exc != null) {
            simpleFuture.setComplete(exc, (Object) null, futureCallsite);
            return;
        }
        try {
            simpleFuture.setComplete(thenFutureCallback.then(obj), futureCallsite);
        } catch (Exception e) {
            simpleFuture.setComplete(e, (Object) null, futureCallsite);
        }
    }

    static /* synthetic */ Future lambda$thenConvert$6(ThenCallback thenCallback, Object obj) throws Exception {
        return new SimpleFuture(thenCallback.then(obj));
    }

    public <R> Future<R> thenConvert(ThenCallback<R, T> thenCallback) {
        return then(new ThenFutureCallback() {
            public final Future then(Object obj) {
                return SimpleFuture.lambda$thenConvert$6(ThenCallback.this, obj);
            }
        });
    }

    public Future<T> fail(FailCallback failCallback) {
        return failRecover(new FailRecoverCallback() {
            public final Future fail(Exception exc) {
                return FailCallback.this.fail(exc);
            }
        });
    }

    public Future<T> failRecover(FailRecoverCallback<T> failRecoverCallback) {
        SimpleFuture simpleFuture = new SimpleFuture();
        simpleFuture.setParent(this);
        setCallbackInternal((FutureCallsite) null, new FutureCallbackInternal(failRecoverCallback) {
            public final /* synthetic */ FailRecoverCallback f$1;

            {
                this.f$1 = r2;
            }

            public final void onCompleted(Exception exc, Object obj, SimpleFuture.FutureCallsite futureCallsite) {
                SimpleFuture.lambda$failRecover$8(SimpleFuture.this, this.f$1, exc, obj, futureCallsite);
            }
        });
        return simpleFuture;
    }

    static /* synthetic */ void lambda$failRecover$8(SimpleFuture simpleFuture, FailRecoverCallback failRecoverCallback, Exception exc, Object obj, FutureCallsite futureCallsite) {
        if (exc == null) {
            simpleFuture.setComplete(exc, obj, futureCallsite);
            return;
        }
        try {
            simpleFuture.setComplete(failRecoverCallback.fail(exc), futureCallsite);
        } catch (Exception e) {
            simpleFuture.setComplete(e, (Object) null, futureCallsite);
        }
    }

    static /* synthetic */ Future lambda$failConvert$9(FailConvertCallback failConvertCallback, Exception exc) throws Exception {
        return new SimpleFuture(failConvertCallback.fail(exc));
    }

    public Future<T> failConvert(FailConvertCallback<T> failConvertCallback) {
        return failRecover(new FailRecoverCallback() {
            public final Future fail(Exception exc) {
                return SimpleFuture.lambda$failConvert$9(FailConvertCallback.this, exc);
            }
        });
    }

    public boolean setParent(Cancellable cancellable) {
        return super.setParent(cancellable);
    }

    public SimpleFuture<T> reset() {
        super.reset();
        this.result = null;
        this.exception = null;
        this.waiter = null;
        this.internalCallback = null;
        this.silent = false;
        return this;
    }

    public Exception tryGetException() {
        return this.exception;
    }

    public T tryGet() {
        return this.result;
    }
}
