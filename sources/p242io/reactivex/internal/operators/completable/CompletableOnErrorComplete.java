package p242io.reactivex.internal.operators.completable;

import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.CompletableSource;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.exceptions.CompositeException;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.Predicate;

/* renamed from: io.reactivex.internal.operators.completable.CompletableOnErrorComplete */
public final class CompletableOnErrorComplete extends Completable {

    /* renamed from: a */
    final CompletableSource f58136a;

    /* renamed from: b */
    final Predicate<? super Throwable> f58137b;

    public CompletableOnErrorComplete(CompletableSource completableSource, Predicate<? super Throwable> predicate) {
        this.f58136a = completableSource;
        this.f58137b = predicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f58136a.subscribe(new OnError(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableOnErrorComplete$OnError */
    final class OnError implements CompletableObserver {
        private final CompletableObserver downstream;

        OnError(CompletableObserver completableObserver) {
            this.downstream = completableObserver;
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void onError(Throwable th) {
            try {
                if (CompletableOnErrorComplete.this.f58137b.test(th)) {
                    this.downstream.onComplete();
                } else {
                    this.downstream.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        public void onSubscribe(Disposable disposable) {
            this.downstream.onSubscribe(disposable);
        }
    }
}
