package p242io.reactivex.internal.operators.flowable;

import org.reactivestreams.Subscription;
import p242io.reactivex.Flowable;
import p242io.reactivex.FlowableSubscriber;
import p242io.reactivex.Maybe;
import p242io.reactivex.MaybeObserver;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.fuseable.FuseToFlowable;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;
import p242io.reactivex.plugins.RxJavaPlugins;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableSingleMaybe */
public final class FlowableSingleMaybe<T> extends Maybe<T> implements FuseToFlowable<T> {

    /* renamed from: a */
    final Flowable<T> f58451a;

    public FlowableSingleMaybe(Flowable<T> flowable) {
        this.f58451a = flowable;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.f58451a.subscribe(new SingleElementSubscriber(maybeObserver));
    }

    public Flowable<T> fuseToFlowable() {
        return RxJavaPlugins.onAssembly(new FlowableSingle(this.f58451a, null, false));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableSingleMaybe$SingleElementSubscriber */
    static final class SingleElementSubscriber<T> implements FlowableSubscriber<T>, Disposable {
        boolean done;
        final MaybeObserver<? super T> downstream;
        Subscription upstream;
        T value;

        SingleElementSubscriber(MaybeObserver<? super T> maybeObserver) {
            this.downstream = maybeObserver;
        }

        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.value != null) {
                    this.done = true;
                    this.upstream.cancel();
                    this.upstream = SubscriptionHelper.CANCELLED;
                    this.downstream.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.value = t;
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            this.downstream.onError(th);
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.upstream = SubscriptionHelper.CANCELLED;
                T t = this.value;
                this.value = null;
                if (t == null) {
                    this.downstream.onComplete();
                } else {
                    this.downstream.onSuccess(t);
                }
            }
        }

        public void dispose() {
            this.upstream.cancel();
            this.upstream = SubscriptionHelper.CANCELLED;
        }

        public boolean isDisposed() {
            return this.upstream == SubscriptionHelper.CANCELLED;
        }
    }
}
