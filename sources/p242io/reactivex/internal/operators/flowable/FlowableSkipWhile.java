package p242io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.Flowable;
import p242io.reactivex.FlowableSubscriber;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.Predicate;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableSkipWhile */
public final class FlowableSkipWhile<T> extends C21208a<T, T> {

    /* renamed from: a */
    final Predicate<? super T> f58462a;

    public FlowableSkipWhile(Flowable<T> flowable, Predicate<? super T> predicate) {
        super(flowable);
        this.f58462a = predicate;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new SkipWhileSubscriber(subscriber, this.f58462a));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableSkipWhile$SkipWhileSubscriber */
    static final class SkipWhileSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> downstream;
        boolean notSkipping;
        final Predicate<? super T> predicate;
        Subscription upstream;

        SkipWhileSubscriber(Subscriber<? super T> subscriber, Predicate<? super T> predicate2) {
            this.downstream = subscriber;
            this.predicate = predicate2;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (this.notSkipping) {
                this.downstream.onNext(t);
                return;
            }
            try {
                if (this.predicate.test(t)) {
                    this.upstream.request(1);
                    return;
                }
                this.notSkipping = true;
                this.downstream.onNext(t);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.cancel();
                this.downstream.onError(th);
            }
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            this.downstream.onComplete();
        }

        public void request(long j) {
            this.upstream.request(j);
        }

        public void cancel() {
            this.upstream.cancel();
        }
    }
}
