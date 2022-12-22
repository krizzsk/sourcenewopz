package p242io.reactivex.internal.observers;

/* renamed from: io.reactivex.internal.observers.BlockingLastObserver */
public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    public void onNext(T t) {
        this.f58053a = t;
    }

    public void onError(Throwable th) {
        this.f58053a = null;
        this.f58054b = th;
        countDown();
    }
}
