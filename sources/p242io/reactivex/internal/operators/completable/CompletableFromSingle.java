package p242io.reactivex.internal.operators.completable;

import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.SingleSource;
import p242io.reactivex.disposables.Disposable;

/* renamed from: io.reactivex.internal.operators.completable.CompletableFromSingle */
public final class CompletableFromSingle<T> extends Completable {

    /* renamed from: a */
    final SingleSource<T> f58120a;

    public CompletableFromSingle(SingleSource<T> singleSource) {
        this.f58120a = singleSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f58120a.subscribe(new CompletableFromSingleObserver(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableFromSingle$CompletableFromSingleObserver */
    static final class CompletableFromSingleObserver<T> implements SingleObserver<T> {

        /* renamed from: co */
        final CompletableObserver f58121co;

        CompletableFromSingleObserver(CompletableObserver completableObserver) {
            this.f58121co = completableObserver;
        }

        public void onError(Throwable th) {
            this.f58121co.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.f58121co.onSubscribe(disposable);
        }

        public void onSuccess(T t) {
            this.f58121co.onComplete();
        }
    }
}
