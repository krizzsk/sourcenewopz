package p242io.reactivex.internal.operators.completable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.CompletableSource;
import p242io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableCache */
public final class CompletableCache extends Completable implements CompletableObserver {

    /* renamed from: a */
    static final InnerCompletableCache[] f58086a = new InnerCompletableCache[0];

    /* renamed from: b */
    static final InnerCompletableCache[] f58087b = new InnerCompletableCache[0];

    /* renamed from: c */
    final CompletableSource f58088c;

    /* renamed from: d */
    final AtomicReference<InnerCompletableCache[]> f58089d = new AtomicReference<>(f58086a);

    /* renamed from: e */
    final AtomicBoolean f58090e = new AtomicBoolean();

    /* renamed from: f */
    Throwable f58091f;

    public void onSubscribe(Disposable disposable) {
    }

    public CompletableCache(CompletableSource completableSource) {
        this.f58088c = completableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        InnerCompletableCache innerCompletableCache = new InnerCompletableCache(completableObserver);
        completableObserver.onSubscribe(innerCompletableCache);
        if (mo174270a(innerCompletableCache)) {
            if (innerCompletableCache.isDisposed()) {
                mo174271b(innerCompletableCache);
            }
            if (this.f58090e.compareAndSet(false, true)) {
                this.f58088c.subscribe(this);
                return;
            }
            return;
        }
        Throwable th = this.f58091f;
        if (th != null) {
            completableObserver.onError(th);
        } else {
            completableObserver.onComplete();
        }
    }

    public void onError(Throwable th) {
        this.f58091f = th;
        for (InnerCompletableCache innerCompletableCache : this.f58089d.getAndSet(f58087b)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onError(th);
            }
        }
    }

    public void onComplete() {
        for (InnerCompletableCache innerCompletableCache : this.f58089d.getAndSet(f58087b)) {
            if (!innerCompletableCache.get()) {
                innerCompletableCache.downstream.onComplete();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo174270a(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.f58089d.get();
            if (innerCompletableCacheArr == f58087b) {
                return false;
            }
            int length = innerCompletableCacheArr.length;
            innerCompletableCacheArr2 = new InnerCompletableCache[(length + 1)];
            System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, length);
            innerCompletableCacheArr2[length] = innerCompletableCache;
        } while (!this.f58089d.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo174271b(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        do {
            innerCompletableCacheArr = this.f58089d.get();
            int length = innerCompletableCacheArr.length;
            if (length != 0) {
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (innerCompletableCacheArr[i2] == innerCompletableCache) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    if (length == 1) {
                        innerCompletableCacheArr2 = f58086a;
                    } else {
                        InnerCompletableCache[] innerCompletableCacheArr3 = new InnerCompletableCache[(length - 1)];
                        System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr3, 0, i);
                        System.arraycopy(innerCompletableCacheArr, i + 1, innerCompletableCacheArr3, i, (length - i) - 1);
                        innerCompletableCacheArr2 = innerCompletableCacheArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f58089d.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableCache$InnerCompletableCache */
    final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        private static final long serialVersionUID = 8943152917179642732L;
        final CompletableObserver downstream;

        InnerCompletableCache(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public boolean isDisposed() {
            return get();
        }

        public void dispose() {
            if (compareAndSet(false, true)) {
                CompletableCache.this.mo174271b(this);
            }
        }
    }
}
