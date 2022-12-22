package p242io.reactivex.observers;

import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.exceptions.CompositeException;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.disposables.EmptyDisposable;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.observers.SafeObserver */
public final class SafeObserver<T> implements Observer<T>, Disposable {

    /* renamed from: a */
    final Observer<? super T> f59313a;

    /* renamed from: b */
    Disposable f59314b;

    /* renamed from: c */
    boolean f59315c;

    public SafeObserver(Observer<? super T> observer) {
        this.f59313a = observer;
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f59314b, disposable)) {
            this.f59314b = disposable;
            try {
                this.f59313a.onSubscribe(this);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(th, th));
            }
        }
    }

    public void dispose() {
        this.f59314b.dispose();
    }

    public boolean isDisposed() {
        return this.f59314b.isDisposed();
    }

    public void onNext(T t) {
        if (!this.f59315c) {
            if (this.f59314b == null) {
                mo175365a();
            } else if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f59314b.dispose();
                    onError(nullPointerException);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    onError(new CompositeException(nullPointerException, th));
                }
            } else {
                try {
                    this.f59313a.onNext(t);
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    onError(new CompositeException(th, th2));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo175365a() {
        this.f59315c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f59313a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f59313a.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
        }
    }

    public void onError(Throwable th) {
        if (this.f59315c) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.f59315c = true;
        if (this.f59314b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            try {
                this.f59313a.onSubscribe(EmptyDisposable.INSTANCE);
                try {
                    this.f59313a.onError(new CompositeException(th, nullPointerException));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th2));
                }
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(new CompositeException(th, nullPointerException, th3));
            }
        } else {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f59313a.onError(th);
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.onError(new CompositeException(th, th4));
            }
        }
    }

    public void onComplete() {
        if (!this.f59315c) {
            this.f59315c = true;
            if (this.f59314b == null) {
                mo175366b();
                return;
            }
            try {
                this.f59313a.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo175366b() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f59313a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f59313a.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaPlugins.onError(new CompositeException(nullPointerException, th2));
        }
    }
}
