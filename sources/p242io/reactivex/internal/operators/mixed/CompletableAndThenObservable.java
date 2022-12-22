package p242io.reactivex.internal.operators.mixed;

import java.util.concurrent.atomic.AtomicReference;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.CompletableSource;
import p242io.reactivex.Observable;
import p242io.reactivex.ObservableSource;
import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.operators.mixed.CompletableAndThenObservable */
public final class CompletableAndThenObservable<R> extends Observable<R> {

    /* renamed from: a */
    final CompletableSource f58648a;

    /* renamed from: b */
    final ObservableSource<? extends R> f58649b;

    public CompletableAndThenObservable(CompletableSource completableSource, ObservableSource<? extends R> observableSource) {
        this.f58648a = completableSource;
        this.f58649b = observableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super R> observer) {
        AndThenObservableObserver andThenObservableObserver = new AndThenObservableObserver(observer, this.f58649b);
        observer.onSubscribe(andThenObservableObserver);
        this.f58648a.subscribe(andThenObservableObserver);
    }

    /* renamed from: io.reactivex.internal.operators.mixed.CompletableAndThenObservable$AndThenObservableObserver */
    static final class AndThenObservableObserver<R> extends AtomicReference<Disposable> implements CompletableObserver, Observer<R>, Disposable {
        private static final long serialVersionUID = -8948264376121066672L;
        final Observer<? super R> downstream;
        ObservableSource<? extends R> other;

        AndThenObservableObserver(Observer<? super R> observer, ObservableSource<? extends R> observableSource) {
            this.other = observableSource;
            this.downstream = observer;
        }

        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            ObservableSource<? extends R> observableSource = this.other;
            if (observableSource == null) {
                this.downstream.onComplete();
                return;
            }
            this.other = null;
            observableSource.subscribe(this);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public boolean isDisposed() {
            return DisposableHelper.isDisposed((Disposable) get());
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.replace(this, disposable);
        }
    }
}
