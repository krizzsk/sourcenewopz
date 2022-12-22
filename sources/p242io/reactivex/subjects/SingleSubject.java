package p242io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.annotations.CheckReturnValue;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.subjects.SingleSubject */
public final class SingleSubject<T> extends Single<T> implements SingleObserver<T> {

    /* renamed from: b */
    static final SingleDisposable[] f59453b = new SingleDisposable[0];

    /* renamed from: c */
    static final SingleDisposable[] f59454c = new SingleDisposable[0];

    /* renamed from: a */
    final AtomicReference<SingleDisposable<T>[]> f59455a = new AtomicReference<>(f59453b);

    /* renamed from: d */
    final AtomicBoolean f59456d = new AtomicBoolean();

    /* renamed from: e */
    T f59457e;

    /* renamed from: f */
    Throwable f59458f;

    @CheckReturnValue
    public static <T> SingleSubject<T> create() {
        return new SingleSubject<>();
    }

    SingleSubject() {
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f59455a.get() == f59454c) {
            disposable.dispose();
        }
    }

    public void onSuccess(T t) {
        ObjectHelper.requireNonNull(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f59456d.compareAndSet(false, true)) {
            this.f59457e = t;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f59455a.getAndSet(f59454c)) {
                singleDisposable.downstream.onSuccess(t);
            }
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f59456d.compareAndSet(false, true)) {
            this.f59458f = th;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f59455a.getAndSet(f59454c)) {
                singleDisposable.downstream.onError(th);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        SingleDisposable singleDisposable = new SingleDisposable(singleObserver, this);
        singleObserver.onSubscribe(singleDisposable);
        if (!mo175582a(singleDisposable)) {
            Throwable th = this.f59458f;
            if (th != null) {
                singleObserver.onError(th);
            } else {
                singleObserver.onSuccess(this.f59457e);
            }
        } else if (singleDisposable.isDisposed()) {
            mo175583b(singleDisposable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo175582a(SingleDisposable<T> singleDisposable) {
        SingleDisposable[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f59455a.get();
            if (singleDisposableArr == f59454c) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[(length + 1)];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!this.f59455a.compareAndSet(singleDisposableArr, singleDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo175583b(SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f59455a.get();
            int length = singleDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (singleDisposableArr[i2] == singleDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        singleDisposableArr2 = f59453b;
                    } else {
                        SingleDisposable[] singleDisposableArr3 = new SingleDisposable[(length - 1)];
                        System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i);
                        System.arraycopy(singleDisposableArr, i + 1, singleDisposableArr3, i, (length - i) - 1);
                        singleDisposableArr2 = singleDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f59455a.compareAndSet(singleDisposableArr, singleDisposableArr2));
    }

    public T getValue() {
        if (this.f59455a.get() == f59454c) {
            return this.f59457e;
        }
        return null;
    }

    public boolean hasValue() {
        return this.f59455a.get() == f59454c && this.f59457e != null;
    }

    public Throwable getThrowable() {
        if (this.f59455a.get() == f59454c) {
            return this.f59458f;
        }
        return null;
    }

    public boolean hasThrowable() {
        return this.f59455a.get() == f59454c && this.f59458f != null;
    }

    public boolean hasObservers() {
        return ((SingleDisposable[]) this.f59455a.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo175581a() {
        return ((SingleDisposable[]) this.f59455a.get()).length;
    }

    /* renamed from: io.reactivex.subjects.SingleSubject$SingleDisposable */
    static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final SingleObserver<? super T> downstream;

        SingleDisposable(SingleObserver<? super T> singleObserver, SingleSubject<T> singleSubject) {
            this.downstream = singleObserver;
            lazySet(singleSubject);
        }

        public void dispose() {
            SingleSubject singleSubject = (SingleSubject) getAndSet((Object) null);
            if (singleSubject != null) {
                singleSubject.mo175583b(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }
}
