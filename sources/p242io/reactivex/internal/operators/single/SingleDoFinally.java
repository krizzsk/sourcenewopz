package p242io.reactivex.internal.operators.single;

import java.util.concurrent.atomic.AtomicInteger;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.SingleSource;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.Action;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.single.SingleDoFinally */
public final class SingleDoFinally<T> extends Single<T> {

    /* renamed from: a */
    final SingleSource<T> f59117a;

    /* renamed from: b */
    final Action f59118b;

    public SingleDoFinally(SingleSource<T> singleSource, Action action) {
        this.f59117a = singleSource;
        this.f59118b = action;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f59117a.subscribe(new DoFinallyObserver(singleObserver, this.f59118b));
    }

    /* renamed from: io.reactivex.internal.operators.single.SingleDoFinally$DoFinallyObserver */
    static final class DoFinallyObserver<T> extends AtomicInteger implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 4109457741734051389L;
        final SingleObserver<? super T> downstream;
        final Action onFinally;
        Disposable upstream;

        DoFinallyObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.downstream = singleObserver;
            this.onFinally = action;
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
            runFinally();
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        public void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        /* access modifiers changed from: package-private */
        public void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
