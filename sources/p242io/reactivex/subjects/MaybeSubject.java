package p242io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Maybe;
import p242io.reactivex.MaybeObserver;
import p242io.reactivex.annotations.CheckReturnValue;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.subjects.MaybeSubject */
public final class MaybeSubject<T> extends Maybe<T> implements MaybeObserver<T> {

    /* renamed from: b */
    static final MaybeDisposable[] f59437b = new MaybeDisposable[0];

    /* renamed from: c */
    static final MaybeDisposable[] f59438c = new MaybeDisposable[0];

    /* renamed from: a */
    final AtomicReference<MaybeDisposable<T>[]> f59439a = new AtomicReference<>(f59437b);

    /* renamed from: d */
    final AtomicBoolean f59440d = new AtomicBoolean();

    /* renamed from: e */
    T f59441e;

    /* renamed from: f */
    Throwable f59442f;

    @CheckReturnValue
    public static <T> MaybeSubject<T> create() {
        return new MaybeSubject<>();
    }

    MaybeSubject() {
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f59439a.get() == f59438c) {
            disposable.dispose();
        }
    }

    public void onSuccess(T t) {
        ObjectHelper.requireNonNull(t, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f59440d.compareAndSet(false, true)) {
            this.f59441e = t;
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f59439a.getAndSet(f59438c)) {
                maybeDisposable.downstream.onSuccess(t);
            }
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f59440d.compareAndSet(false, true)) {
            this.f59442f = th;
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f59439a.getAndSet(f59438c)) {
                maybeDisposable.downstream.onError(th);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    public void onComplete() {
        if (this.f59440d.compareAndSet(false, true)) {
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f59439a.getAndSet(f59438c)) {
                maybeDisposable.downstream.onComplete();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        MaybeDisposable maybeDisposable = new MaybeDisposable(maybeObserver, this);
        maybeObserver.onSubscribe(maybeDisposable);
        if (!mo175544a(maybeDisposable)) {
            Throwable th = this.f59442f;
            if (th != null) {
                maybeObserver.onError(th);
                return;
            }
            T t = this.f59441e;
            if (t == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(t);
            }
        } else if (maybeDisposable.isDisposed()) {
            mo175545b(maybeDisposable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo175544a(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.f59439a.get();
            if (maybeDisposableArr == f59438c) {
                return false;
            }
            int length = maybeDisposableArr.length;
            maybeDisposableArr2 = new MaybeDisposable[(length + 1)];
            System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
            maybeDisposableArr2[length] = maybeDisposable;
        } while (!this.f59439a.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo175545b(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.f59439a.get();
            int length = maybeDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (maybeDisposableArr[i2] == maybeDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        maybeDisposableArr2 = f59437b;
                    } else {
                        MaybeDisposable[] maybeDisposableArr3 = new MaybeDisposable[(length - 1)];
                        System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr3, 0, i);
                        System.arraycopy(maybeDisposableArr, i + 1, maybeDisposableArr3, i, (length - i) - 1);
                        maybeDisposableArr2 = maybeDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f59439a.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
    }

    public T getValue() {
        if (this.f59439a.get() == f59438c) {
            return this.f59441e;
        }
        return null;
    }

    public boolean hasValue() {
        return this.f59439a.get() == f59438c && this.f59441e != null;
    }

    public Throwable getThrowable() {
        if (this.f59439a.get() == f59438c) {
            return this.f59442f;
        }
        return null;
    }

    public boolean hasThrowable() {
        return this.f59439a.get() == f59438c && this.f59442f != null;
    }

    public boolean hasComplete() {
        return this.f59439a.get() == f59438c && this.f59441e == null && this.f59442f == null;
    }

    public boolean hasObservers() {
        return ((MaybeDisposable[]) this.f59439a.get()).length != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo175543a() {
        return ((MaybeDisposable[]) this.f59439a.get()).length;
    }

    /* renamed from: io.reactivex.subjects.MaybeSubject$MaybeDisposable */
    static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final MaybeObserver<? super T> downstream;

        MaybeDisposable(MaybeObserver<? super T> maybeObserver, MaybeSubject<T> maybeSubject) {
            this.downstream = maybeObserver;
            lazySet(maybeSubject);
        }

        public void dispose() {
            MaybeSubject maybeSubject = (MaybeSubject) getAndSet((Object) null);
            if (maybeSubject != null) {
                maybeSubject.mo175545b(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }
}
