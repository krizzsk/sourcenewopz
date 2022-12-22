package p242io.reactivex.internal.observers;

import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.Action;
import p242io.reactivex.functions.Consumer;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.observers.DisposableLambdaObserver */
public final class DisposableLambdaObserver<T> implements Observer<T>, Disposable {

    /* renamed from: a */
    final Observer<? super T> f58061a;

    /* renamed from: b */
    final Consumer<? super Disposable> f58062b;

    /* renamed from: c */
    final Action f58063c;

    /* renamed from: d */
    Disposable f58064d;

    public DisposableLambdaObserver(Observer<? super T> observer, Consumer<? super Disposable> consumer, Action action) {
        this.f58061a = observer;
        this.f58062b = consumer;
        this.f58063c = action;
    }

    public void onSubscribe(Disposable disposable) {
        try {
            this.f58062b.accept(disposable);
            if (DisposableHelper.validate(this.f58064d, disposable)) {
                this.f58064d = disposable;
                this.f58061a.onSubscribe(this);
            }
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            disposable.dispose();
            this.f58064d = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, (Observer<?>) this.f58061a);
        }
    }

    public void onNext(T t) {
        this.f58061a.onNext(t);
    }

    public void onError(Throwable th) {
        if (this.f58064d != DisposableHelper.DISPOSED) {
            this.f58064d = DisposableHelper.DISPOSED;
            this.f58061a.onError(th);
            return;
        }
        RxJavaPlugins.onError(th);
    }

    public void onComplete() {
        if (this.f58064d != DisposableHelper.DISPOSED) {
            this.f58064d = DisposableHelper.DISPOSED;
            this.f58061a.onComplete();
        }
    }

    public void dispose() {
        Disposable disposable = this.f58064d;
        if (disposable != DisposableHelper.DISPOSED) {
            this.f58064d = DisposableHelper.DISPOSED;
            try {
                this.f58063c.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            disposable.dispose();
        }
    }

    public boolean isDisposed() {
        return this.f58064d.isDisposed();
    }
}
