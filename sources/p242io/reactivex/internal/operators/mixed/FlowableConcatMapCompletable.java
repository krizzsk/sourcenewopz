package p242io.reactivex.internal.operators.mixed;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;
import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.CompletableSource;
import p242io.reactivex.Flowable;
import p242io.reactivex.FlowableSubscriber;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.exceptions.MissingBackpressureException;
import p242io.reactivex.functions.Function;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.fuseable.SimplePlainQueue;
import p242io.reactivex.internal.queue.SpscArrayQueue;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.internal.util.AtomicThrowable;
import p242io.reactivex.internal.util.ErrorMode;
import p242io.reactivex.internal.util.ExceptionHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable */
public final class FlowableConcatMapCompletable<T> extends Completable {

    /* renamed from: a */
    final Flowable<T> f58652a;

    /* renamed from: b */
    final Function<? super T, ? extends CompletableSource> f58653b;

    /* renamed from: c */
    final ErrorMode f58654c;

    /* renamed from: d */
    final int f58655d;

    public FlowableConcatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i) {
        this.f58652a = flowable;
        this.f58653b = function;
        this.f58654c = errorMode;
        this.f58655d = i;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(CompletableObserver completableObserver) {
        this.f58652a.subscribe(new ConcatMapCompletableObserver(completableObserver, this.f58653b, this.f58654c, this.f58655d));
    }

    /* renamed from: io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable$ConcatMapCompletableObserver */
    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        int consumed;
        volatile boolean disposed;
        volatile boolean done;
        final CompletableObserver downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final ConcatMapInnerObserver inner = new ConcatMapInnerObserver(this);
        final Function<? super T, ? extends CompletableSource> mapper;
        final int prefetch;
        final SimplePlainQueue<T> queue;
        Subscription upstream;

        ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode2, int i) {
            this.downstream = completableObserver;
            this.mapper = function;
            this.errorMode = errorMode2;
            this.prefetch = i;
            this.queue = new SpscArrayQueue(i);
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request((long) this.prefetch);
            }
        }

        public void onNext(T t) {
            if (this.queue.offer(t)) {
                drain();
                return;
            }
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }

        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.inner.dispose();
                Throwable terminate = this.errors.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            } else {
                this.done = true;
                drain();
            }
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void dispose() {
            this.disposed = true;
            this.upstream.cancel();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public boolean isDisposed() {
            return this.disposed;
        }

        /* access modifiers changed from: package-private */
        public void innerError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.upstream.cancel();
                Throwable terminate = this.errors.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.downstream.onError(terminate);
                }
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            } else {
                this.active = false;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public void innerComplete() {
            this.active = false;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                while (!this.disposed) {
                    if (!this.active) {
                        if (this.errorMode != ErrorMode.BOUNDARY || this.errors.get() == null) {
                            boolean z = this.done;
                            T poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                Throwable terminate = this.errors.terminate();
                                if (terminate != null) {
                                    this.downstream.onError(terminate);
                                    return;
                                } else {
                                    this.downstream.onComplete();
                                    return;
                                }
                            } else if (!z2) {
                                int i = this.prefetch;
                                int i2 = i - (i >> 1);
                                int i3 = this.consumed + 1;
                                if (i3 == i2) {
                                    this.consumed = 0;
                                    this.upstream.request((long) i2);
                                } else {
                                    this.consumed = i3;
                                }
                                try {
                                    CompletableSource completableSource = (CompletableSource) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null CompletableSource");
                                    this.active = true;
                                    completableSource.subscribe(this.inner);
                                } catch (Throwable th) {
                                    Exceptions.throwIfFatal(th);
                                    this.queue.clear();
                                    this.upstream.cancel();
                                    this.errors.addThrowable(th);
                                    this.downstream.onError(this.errors.terminate());
                                    return;
                                }
                            }
                        } else {
                            this.queue.clear();
                            this.downstream.onError(this.errors.terminate());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.queue.clear();
            }
        }

        /* renamed from: io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable$ConcatMapCompletableObserver$ConcatMapInnerObserver */
        static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5638352172918776687L;
            final ConcatMapCompletableObserver<?> parent;

            ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.parent = concatMapCompletableObserver;
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            public void onComplete() {
                this.parent.innerComplete();
            }

            /* access modifiers changed from: package-private */
            public void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
