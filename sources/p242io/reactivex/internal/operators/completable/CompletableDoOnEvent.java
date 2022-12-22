package p242io.reactivex.internal.operators.completable;

import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.CompletableSource;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.exceptions.CompositeException;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.Consumer;

/* renamed from: io.reactivex.internal.operators.completable.CompletableDoOnEvent */
public final class CompletableDoOnEvent extends Completable {

    /* renamed from: a */
    final CompletableSource f58110a;

    /* renamed from: b */
    final Consumer<? super Throwable> f58111b;

    public CompletableDoOnEvent(CompletableSource completableSource, Consumer<? super Throwable> consumer) {
        this.f58110a = completableSource;
        this.f58111b = consumer;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f58110a.subscribe(new DoOnEvent(completableObserver));
    }

    /* renamed from: io.reactivex.internal.operators.completable.CompletableDoOnEvent$DoOnEvent */
    final class DoOnEvent implements CompletableObserver {
        private final CompletableObserver observer;

        DoOnEvent(CompletableObserver completableObserver) {
            this.observer = completableObserver;
        }

        public void onComplete() {
            try {
                CompletableDoOnEvent.this.f58111b.accept(null);
                this.observer.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.observer.onError(th);
            }
        }

        public void onError(Throwable th) {
            try {
                CompletableDoOnEvent.this.f58111b.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.observer.onError(th);
        }

        public void onSubscribe(Disposable disposable) {
            this.observer.onSubscribe(disposable);
        }
    }
}
