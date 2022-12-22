package p242io.reactivex.internal.subscribers;

/* renamed from: io.reactivex.internal.subscribers.BlockingLastSubscriber */
public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    public void onNext(T t) {
        this.f59257a = t;
    }

    public void onError(Throwable th) {
        this.f59257a = null;
        this.f59258b = th;
        countDown();
    }
}
