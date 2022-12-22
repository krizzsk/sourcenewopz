package p242io.reactivex.internal.observers;

import java.util.concurrent.CountDownLatch;
import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.util.BlockingHelper;
import p242io.reactivex.internal.util.ExceptionHelper;

/* renamed from: io.reactivex.internal.observers.BlockingBaseObserver */
public abstract class BlockingBaseObserver<T> extends CountDownLatch implements Observer<T>, Disposable {

    /* renamed from: a */
    T f58053a;

    /* renamed from: b */
    Throwable f58054b;

    /* renamed from: c */
    Disposable f58055c;

    /* renamed from: d */
    volatile boolean f58056d;

    public BlockingBaseObserver() {
        super(1);
    }

    public final void onSubscribe(Disposable disposable) {
        this.f58055c = disposable;
        if (this.f58056d) {
            disposable.dispose();
        }
    }

    public final void onComplete() {
        countDown();
    }

    public final void dispose() {
        this.f58056d = true;
        Disposable disposable = this.f58055c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.f58056d;
    }

    public final T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f58054b;
        if (th == null) {
            return this.f58053a;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }
}
