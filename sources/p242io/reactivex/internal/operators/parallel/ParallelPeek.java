package p242io.reactivex.internal.operators.parallel;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.FlowableSubscriber;
import p242io.reactivex.exceptions.CompositeException;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.Action;
import p242io.reactivex.functions.Consumer;
import p242io.reactivex.functions.LongConsumer;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.subscriptions.EmptySubscription;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.parallel.ParallelFlowable;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.parallel.ParallelPeek */
public final class ParallelPeek<T> extends ParallelFlowable<T> {

    /* renamed from: a */
    final ParallelFlowable<T> f59062a;

    /* renamed from: b */
    final Consumer<? super T> f59063b;

    /* renamed from: c */
    final Consumer<? super T> f59064c;

    /* renamed from: d */
    final Consumer<? super Throwable> f59065d;

    /* renamed from: e */
    final Action f59066e;

    /* renamed from: f */
    final Action f59067f;

    /* renamed from: g */
    final Consumer<? super Subscription> f59068g;

    /* renamed from: h */
    final LongConsumer f59069h;

    /* renamed from: i */
    final Action f59070i;

    public ParallelPeek(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, Consumer<? super T> consumer2, Consumer<? super Throwable> consumer3, Action action, Action action2, Consumer<? super Subscription> consumer4, LongConsumer longConsumer, Action action3) {
        this.f59062a = parallelFlowable;
        this.f59063b = (Consumer) ObjectHelper.requireNonNull(consumer, "onNext is null");
        this.f59064c = (Consumer) ObjectHelper.requireNonNull(consumer2, "onAfterNext is null");
        this.f59065d = (Consumer) ObjectHelper.requireNonNull(consumer3, "onError is null");
        this.f59066e = (Action) ObjectHelper.requireNonNull(action, "onComplete is null");
        this.f59067f = (Action) ObjectHelper.requireNonNull(action2, "onAfterTerminated is null");
        this.f59068g = (Consumer) ObjectHelper.requireNonNull(consumer4, "onSubscribe is null");
        this.f59069h = (LongConsumer) ObjectHelper.requireNonNull(longConsumer, "onRequest is null");
        this.f59070i = (Action) ObjectHelper.requireNonNull(action3, "onCancel is null");
    }

    public void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = new ParallelPeekSubscriber(subscriberArr[i], this);
            }
            this.f59062a.subscribe(subscriberArr2);
        }
    }

    public int parallelism() {
        return this.f59062a.parallelism();
    }

    /* renamed from: io.reactivex.internal.operators.parallel.ParallelPeek$ParallelPeekSubscriber */
    static final class ParallelPeekSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super T> downstream;
        final ParallelPeek<T> parent;
        Subscription upstream;

        ParallelPeekSubscriber(Subscriber<? super T> subscriber, ParallelPeek<T> parallelPeek) {
            this.downstream = subscriber;
            this.parent = parallelPeek;
        }

        public void request(long j) {
            try {
                this.parent.f59069h.accept(j);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.upstream.request(j);
        }

        public void cancel() {
            try {
                this.parent.f59070i.run();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
            this.upstream.cancel();
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                try {
                    this.parent.f59068g.accept(subscription);
                    this.downstream.onSubscribe(this);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    subscription.cancel();
                    this.downstream.onSubscribe(EmptySubscription.INSTANCE);
                    onError(th);
                }
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                try {
                    this.parent.f59063b.accept(t);
                    this.downstream.onNext(t);
                    try {
                        this.parent.f59064c.accept(t);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    onError(th2);
                }
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            try {
                this.parent.f59065d.accept(th);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                th = new CompositeException(th, th2);
            }
            this.downstream.onError(th);
            try {
                this.parent.f59067f.run();
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.onError(th3);
            }
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                try {
                    this.parent.f59066e.run();
                    this.downstream.onComplete();
                    try {
                        this.parent.f59067f.run();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        RxJavaPlugins.onError(th);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.downstream.onError(th2);
                }
            }
        }
    }
}
