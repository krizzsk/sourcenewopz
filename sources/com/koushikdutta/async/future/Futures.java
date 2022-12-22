package com.koushikdutta.async.future;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Futures {
    public static <T> Future<List<T>> waitAll(final List<Future<T>> list) {
        final ArrayList arrayList = new ArrayList();
        final SimpleFuture simpleFuture = new SimpleFuture();
        if (list.isEmpty()) {
            simpleFuture.setComplete(arrayList);
            return simpleFuture;
        }
        list.get(0).setCallback(new FutureCallback<T>() {
            int count = 0;

            public void onCompleted(Exception exc, T t) {
                arrayList.add(t);
                int i = this.count + 1;
                this.count = i;
                if (i < list.size()) {
                    ((Future) list.get(this.count)).setCallback(this);
                } else {
                    simpleFuture.setComplete(arrayList);
                }
            }
        });
        return simpleFuture;
    }

    public static <T> Future<List<T>> waitAll(Future<T>... futureArr) {
        return waitAll(Arrays.asList(futureArr));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static <T, F> void m39818a(Iterator<F> it, ThenFutureCallback<T, F> thenFutureCallback, SimpleFuture<T> simpleFuture, Exception e) {
        while (it.hasNext()) {
            try {
                Future<T> then = thenFutureCallback.then(it.next());
                simpleFuture.getClass();
                then.success(new SuccessCallback() {
                    public final void success(Object obj) {
                        SimpleFuture.this.setComplete(obj);
                    }
                }).fail(new FailCallback(it, thenFutureCallback, simpleFuture) {
                    public final /* synthetic */ Iterator f$0;
                    public final /* synthetic */ ThenFutureCallback f$1;
                    public final /* synthetic */ SimpleFuture f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void fail(Exception exc) {
                        Futures.m39818a(this.f$0, this.f$1, this.f$2, exc);
                    }
                });
                return;
            } catch (Exception e2) {
                e = e2;
            }
        }
        if (e == null) {
            simpleFuture.setComplete(new Exception("empty list"));
        } else {
            simpleFuture.setComplete(e);
        }
    }

    public static <T, F> Future<T> loopUntil(Iterable<F> iterable, ThenFutureCallback<T, F> thenFutureCallback) {
        SimpleFuture simpleFuture = new SimpleFuture();
        m39818a(iterable.iterator(), thenFutureCallback, simpleFuture, (Exception) null);
        return simpleFuture;
    }

    public static <T, F> Future<T> loopUntil(F[] fArr, ThenFutureCallback<T, F> thenFutureCallback) {
        return loopUntil(Arrays.asList(fArr), thenFutureCallback);
    }
}
