package p242io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicInteger;
import p242io.reactivex.Observable;
import p242io.reactivex.ObservableSource;
import p242io.reactivex.Observer;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.exceptions.CompositeException;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.Predicate;
import p242io.reactivex.internal.disposables.SequentialDisposable;

/* renamed from: io.reactivex.internal.operators.observable.ObservableRetryPredicate */
public final class ObservableRetryPredicate<T> extends C21211a<T, T> {

    /* renamed from: a */
    final Predicate<? super Throwable> f58914a;

    /* renamed from: b */
    final long f58915b;

    public ObservableRetryPredicate(Observable<T> observable, long j, Predicate<? super Throwable> predicate) {
        super(observable);
        this.f58914a = predicate;
        this.f58915b = j;
    }

    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        new RepeatObserver(observer, this.f58915b, this.f58914a, sequentialDisposable, this.source).subscribeNext();
    }

    /* renamed from: io.reactivex.internal.operators.observable.ObservableRetryPredicate$RepeatObserver */
    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Observer<? super T> downstream;
        final Predicate<? super Throwable> predicate;
        long remaining;
        final ObservableSource<? extends T> source;
        final SequentialDisposable upstream;

        RepeatObserver(Observer<? super T> observer, long j, Predicate<? super Throwable> predicate2, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.downstream = observer;
            this.upstream = sequentialDisposable;
            this.source = observableSource;
            this.predicate = predicate2;
            this.remaining = j;
        }

        public void onSubscribe(Disposable disposable) {
            this.upstream.replace(disposable);
        }

        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        public void onError(Throwable th) {
            long j = this.remaining;
            if (j != Long.MAX_VALUE) {
                this.remaining = j - 1;
            }
            if (j == 0) {
                this.downstream.onError(th);
                return;
            }
            try {
                if (!this.predicate.test(th)) {
                    this.downstream.onError(th);
                } else {
                    subscribeNext();
                }
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                this.downstream.onError(new CompositeException(th, th2));
            }
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        /* access modifiers changed from: package-private */
        public void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.upstream.isDisposed()) {
                    this.source.subscribe(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }
}
