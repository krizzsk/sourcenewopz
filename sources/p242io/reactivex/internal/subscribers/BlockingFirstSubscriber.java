package p242io.reactivex.internal.subscribers;

import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.subscribers.BlockingFirstSubscriber */
public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    public void onNext(T t) {
        if (this.f59257a == null) {
            this.f59257a = t;
            this.f59259c.cancel();
            countDown();
        }
    }

    public void onError(Throwable th) {
        if (this.f59257a == null) {
            this.f59258b = th;
        } else {
            RxJavaPlugins.onError(th);
        }
        countDown();
    }
}
