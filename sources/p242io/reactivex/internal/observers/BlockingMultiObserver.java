package p242io.reactivex.internal.observers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.MaybeObserver;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.util.BlockingHelper;
import p242io.reactivex.internal.util.ExceptionHelper;

/* renamed from: io.reactivex.internal.observers.BlockingMultiObserver */
public final class BlockingMultiObserver<T> extends CountDownLatch implements CompletableObserver, MaybeObserver<T>, SingleObserver<T> {

    /* renamed from: a */
    T f58057a;

    /* renamed from: b */
    Throwable f58058b;

    /* renamed from: c */
    Disposable f58059c;

    /* renamed from: d */
    volatile boolean f58060d;

    public BlockingMultiObserver() {
        super(1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo174231a() {
        this.f58060d = true;
        Disposable disposable = this.f58059c;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public void onSubscribe(Disposable disposable) {
        this.f58059c = disposable;
        if (this.f58060d) {
            disposable.dispose();
        }
    }

    public void onSuccess(T t) {
        this.f58057a = t;
        countDown();
    }

    public void onError(Throwable th) {
        this.f58058b = th;
        countDown();
    }

    public void onComplete() {
        countDown();
    }

    public T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                mo174231a();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f58058b;
        if (th == null) {
            return this.f58057a;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public T blockingGet(T t) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                mo174231a();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f58058b;
        if (th == null) {
            T t2 = this.f58057a;
            return t2 != null ? t2 : t;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public Throwable blockingGetError() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e) {
                mo174231a();
                return e;
            }
        }
        return this.f58058b;
    }

    public Throwable blockingGetError(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!await(j, timeUnit)) {
                    mo174231a();
                    throw ExceptionHelper.wrapOrThrow(new TimeoutException(ExceptionHelper.timeoutMessage(j, timeUnit)));
                }
            } catch (InterruptedException e) {
                mo174231a();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        return this.f58058b;
    }

    public boolean blockingAwait(long j, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!await(j, timeUnit)) {
                    mo174231a();
                    return false;
                }
            } catch (InterruptedException e) {
                mo174231a();
                throw ExceptionHelper.wrapOrThrow(e);
            }
        }
        Throwable th = this.f58058b;
        if (th == null) {
            return true;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }
}
