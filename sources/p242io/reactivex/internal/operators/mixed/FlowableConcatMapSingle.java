package p242io.reactivex.internal.operators.mixed;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.Flowable;
import p242io.reactivex.FlowableSubscriber;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.SingleSource;
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
import p242io.reactivex.internal.util.BackpressureHelper;
import p242io.reactivex.internal.util.ErrorMode;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.mixed.FlowableConcatMapSingle */
public final class FlowableConcatMapSingle<T, R> extends Flowable<R> {

    /* renamed from: a */
    final Flowable<T> f58660a;

    /* renamed from: b */
    final Function<? super T, ? extends SingleSource<? extends R>> f58661b;

    /* renamed from: c */
    final ErrorMode f58662c;

    /* renamed from: d */
    final int f58663d;

    public FlowableConcatMapSingle(Flowable<T> flowable, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i) {
        this.f58660a = flowable;
        this.f58661b = function;
        this.f58662c = errorMode;
        this.f58663d = i;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.f58660a.subscribe(new ConcatMapSingleSubscriber(subscriber, this.f58661b, this.f58663d, this.f58662c));
    }

    /* renamed from: io.reactivex.internal.operators.mixed.FlowableConcatMapSingle$ConcatMapSingleSubscriber */
    static final class ConcatMapSingleSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        static final int STATE_ACTIVE = 1;
        static final int STATE_INACTIVE = 0;
        static final int STATE_RESULT_VALUE = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        long emitted;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final ConcatMapSingleObserver<R> inner = new ConcatMapSingleObserver<>(this);
        R item;
        final Function<? super T, ? extends SingleSource<? extends R>> mapper;
        final int prefetch;
        final SimplePlainQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        volatile int state;
        Subscription upstream;

        ConcatMapSingleSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends SingleSource<? extends R>> function, int i, ErrorMode errorMode2) {
            this.downstream = subscriber;
            this.mapper = function;
            this.prefetch = i;
            this.errorMode = errorMode2;
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
            if (!this.queue.offer(t)) {
                this.upstream.cancel();
                onError(new MissingBackpressureException("queue full?!"));
                return;
            }
            drain();
        }

        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.inner.dispose();
                }
                this.done = true;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void request(long j) {
            BackpressureHelper.add(this.requested, j);
            drain();
        }

        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.inner.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void innerSuccess(R r) {
            this.item = r;
            this.state = 2;
            drain();
        }

        /* access modifiers changed from: package-private */
        public void innerError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.cancel();
                }
                this.state = 0;
                drain();
                return;
            }
            RxJavaPlugins.onError(th);
        }

        /* access modifiers changed from: package-private */
        public void drain() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.downstream;
                ErrorMode errorMode2 = this.errorMode;
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                AtomicLong atomicLong = this.requested;
                int i = this.prefetch;
                int i2 = i - (i >> 1);
                int i3 = 1;
                while (true) {
                    if (this.cancelled) {
                        simplePlainQueue.clear();
                        this.item = null;
                    } else {
                        int i4 = this.state;
                        if (atomicThrowable.get() == null || !(errorMode2 == ErrorMode.IMMEDIATE || (errorMode2 == ErrorMode.BOUNDARY && i4 == 0))) {
                            if (i4 == 0) {
                                boolean z = this.done;
                                T poll = simplePlainQueue.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate == null) {
                                        subscriber.onComplete();
                                        return;
                                    } else {
                                        subscriber.onError(terminate);
                                        return;
                                    }
                                } else if (!z2) {
                                    int i5 = this.consumed + 1;
                                    if (i5 == i2) {
                                        this.consumed = 0;
                                        this.upstream.request((long) i2);
                                    } else {
                                        this.consumed = i5;
                                    }
                                    try {
                                        SingleSource singleSource = (SingleSource) ObjectHelper.requireNonNull(this.mapper.apply(poll), "The mapper returned a null SingleSource");
                                        this.state = 1;
                                        singleSource.subscribe(this.inner);
                                    } catch (Throwable th) {
                                        Exceptions.throwIfFatal(th);
                                        this.upstream.cancel();
                                        simplePlainQueue.clear();
                                        atomicThrowable.addThrowable(th);
                                        subscriber.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i4 == 2) {
                                long j = this.emitted;
                                if (j != atomicLong.get()) {
                                    R r = this.item;
                                    this.item = null;
                                    subscriber.onNext(r);
                                    this.emitted = j + 1;
                                    this.state = 0;
                                }
                            }
                        }
                    }
                    i3 = addAndGet(-i3);
                    if (i3 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.item = null;
                subscriber.onError(atomicThrowable.terminate());
            }
        }

        /* renamed from: io.reactivex.internal.operators.mixed.FlowableConcatMapSingle$ConcatMapSingleSubscriber$ConcatMapSingleObserver */
        static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final ConcatMapSingleSubscriber<?, R> parent;

            ConcatMapSingleObserver(ConcatMapSingleSubscriber<?, R> concatMapSingleSubscriber) {
                this.parent = concatMapSingleSubscriber;
            }

            public void onSubscribe(Disposable disposable) {
                DisposableHelper.replace(this, disposable);
            }

            public void onSuccess(R r) {
                this.parent.innerSuccess(r);
            }

            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            /* access modifiers changed from: package-private */
            public void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
