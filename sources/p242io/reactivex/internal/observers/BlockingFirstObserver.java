package p242io.reactivex.internal.observers;

/* renamed from: io.reactivex.internal.observers.BlockingFirstObserver */
public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    public void onNext(T t) {
        if (this.f58053a == null) {
            this.f58053a = t;
            this.f58055c.dispose();
            countDown();
        }
    }

    public void onError(Throwable th) {
        if (this.f58053a == null) {
            this.f58054b = th;
        }
        countDown();
    }
}
