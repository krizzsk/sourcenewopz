package p242io.reactivex.subjects;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.annotations.CheckReturnValue;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.subjects.CompletableSubject */
public final class CompletableSubject extends Completable implements CompletableObserver {

    /* renamed from: b */
    static final CompletableDisposable[] f59432b = new CompletableDisposable[0];

    /* renamed from: c */
    static final CompletableDisposable[] f59433c = new CompletableDisposable[0];

    /* renamed from: a */
    final AtomicReference<CompletableDisposable[]> f59434a = new AtomicReference<>(f59432b);

    /* renamed from: d */
    final AtomicBoolean f59435d = new AtomicBoolean();

    /* renamed from: e */
    Throwable f59436e;

    @CheckReturnValue
    public static CompletableSubject create() {
        return new CompletableSubject();
    }

    CompletableSubject() {
    }

    public void onSubscribe(Disposable disposable) {
        if (this.f59434a.get() == f59433c) {
            disposable.dispose();
        }
    }

    public void onError(Throwable th) {
        ObjectHelper.requireNonNull(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f59435d.compareAndSet(false, true)) {
            this.f59436e = th;
            for (CompletableDisposable completableDisposable : this.f59434a.getAndSet(f59433c)) {
                completableDisposable.downstream.onError(th);
            }
            return;
        }
        RxJavaPlugins.onError(th);
    }

    public void onComplete() {
        if (this.f59435d.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.f59434a.getAndSet(f59433c)) {
                completableDisposable.downstream.onComplete();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        CompletableDisposable completableDisposable = new CompletableDisposable(completableObserver, this);
        completableObserver.onSubscribe(completableDisposable);
        if (!mo175537a(completableDisposable)) {
            Throwable th = this.f59436e;
            if (th != null) {
                completableObserver.onError(th);
            } else {
                completableObserver.onComplete();
            }
        } else if (completableDisposable.isDisposed()) {
            mo175538b(completableDisposable);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo175537a(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f59434a.get();
            if (completableDisposableArr == f59433c) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[(length + 1)];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!this.f59434a.compareAndSet(completableDisposableArr, completableDisposableArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo175538b(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f59434a.get();
            int length = completableDisposableArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (completableDisposableArr[i2] == completableDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        completableDisposableArr2 = f59432b;
                    } else {
                        CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[(length - 1)];
                        System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i);
                        System.arraycopy(completableDisposableArr, i + 1, completableDisposableArr3, i, (length - i) - 1);
                        completableDisposableArr2 = completableDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f59434a.compareAndSet(completableDisposableArr, completableDisposableArr2));
    }

    public Throwable getThrowable() {
        if (this.f59434a.get() == f59433c) {
            return this.f59436e;
        }
        return null;
    }

    public boolean hasThrowable() {
        return this.f59434a.get() == f59433c && this.f59436e != null;
    }

    public boolean hasComplete() {
        return this.f59434a.get() == f59433c && this.f59436e == null;
    }

    public boolean hasObservers() {
        return this.f59434a.get().length != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo175536a() {
        return this.f59434a.get().length;
    }

    /* renamed from: io.reactivex.subjects.CompletableSubject$CompletableDisposable */
    static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements Disposable {
        private static final long serialVersionUID = -7650903191002190468L;
        final CompletableObserver downstream;

        CompletableDisposable(CompletableObserver completableObserver, CompletableSubject completableSubject) {
            this.downstream = completableObserver;
            lazySet(completableSubject);
        }

        public void dispose() {
            CompletableSubject completableSubject = (CompletableSubject) getAndSet((Object) null);
            if (completableSubject != null) {
                completableSubject.mo175538b(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }
}
