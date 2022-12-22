package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class LottieTask<T> {
    public static Executor EXECUTOR = Executors.newCachedThreadPool();

    /* renamed from: a */
    private final Set<LottieListener<T>> f1169a;

    /* renamed from: b */
    private final Set<LottieListener<Throwable>> f1170b;

    /* renamed from: c */
    private final Handler f1171c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public volatile LottieResult<T> f1172d;

    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        this.f1169a = new LinkedHashSet(1);
        this.f1170b = new LinkedHashSet(1);
        this.f1171c = new Handler(Looper.getMainLooper());
        this.f1172d = null;
        if (z) {
            try {
                m1250a(callable.call());
            } catch (Throwable th) {
                m1250a(new LottieResult(th));
            }
        } else {
            EXECUTOR.execute(new LottieFutureTask(callable));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1250a(LottieResult<T> lottieResult) {
        if (this.f1172d == null) {
            this.f1172d = lottieResult;
            m1249a();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> lottieListener) {
        if (!(this.f1172d == null || this.f1172d.getValue() == null)) {
            lottieListener.onResult(this.f1172d.getValue());
        }
        this.f1169a.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        this.f1169a.remove(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        if (!(this.f1172d == null || this.f1172d.getException() == null)) {
            lottieListener.onResult(this.f1172d.getException());
        }
        this.f1170b.add(lottieListener);
        return this;
    }

    public synchronized LottieTask<T> removeFailureListener(LottieListener<Throwable> lottieListener) {
        this.f1170b.remove(lottieListener);
        return this;
    }

    /* renamed from: a */
    private void m1249a() {
        this.f1171c.post(new Runnable() {
            public void run() {
                if (LottieTask.this.f1172d != null) {
                    LottieResult a = LottieTask.this.f1172d;
                    if (a.getValue() != null) {
                        LottieTask.this.m1254a(a.getValue());
                    } else {
                        LottieTask.this.m1255a(a.getException());
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m1254a(T t) {
        for (LottieListener onResult : new ArrayList(this.f1169a)) {
            onResult.onResult(t);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m1255a(Throwable th) {
        ArrayList<LottieListener> arrayList = new ArrayList<>(this.f1170b);
        if (arrayList.isEmpty()) {
            Logger.warning("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        for (LottieListener onResult : arrayList) {
            onResult.onResult(th);
        }
    }

    private class LottieFutureTask extends FutureTask<LottieResult<T>> {
        LottieFutureTask(Callable<LottieResult<T>> callable) {
            super(callable);
        }

        /* access modifiers changed from: protected */
        public void done() {
            if (!isCancelled()) {
                try {
                    LottieTask.this.m1250a((LottieResult) get());
                } catch (InterruptedException | ExecutionException e) {
                    LottieTask.this.m1250a(new LottieResult(e));
                }
            }
        }
    }
}
