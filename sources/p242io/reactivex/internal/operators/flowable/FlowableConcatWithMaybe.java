package p242io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import p242io.reactivex.Flowable;
import p242io.reactivex.MaybeObserver;
import p242io.reactivex.MaybeSource;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatWithMaybe */
public final class FlowableConcatWithMaybe<T> extends C21208a<T, T> {

    /* renamed from: a */
    final MaybeSource<? extends T> f58247a;

    public FlowableConcatWithMaybe(Flowable<T> flowable, MaybeSource<? extends T> maybeSource) {
        super(flowable);
        this.f58247a = maybeSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ConcatWithSubscriber(subscriber, this.f58247a));
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableConcatWithMaybe$ConcatWithSubscriber */
    static final class ConcatWithSubscriber<T> extends SinglePostCompleteSubscriber<T, T> implements MaybeObserver<T> {
        private static final long serialVersionUID = -7346385463600070225L;
        boolean inMaybe;
        MaybeSource<? extends T> other;
        final AtomicReference<Disposable> otherDisposable = new AtomicReference<>();

        ConcatWithSubscriber(Subscriber<? super T> subscriber, MaybeSource<? extends T> maybeSource) {
            super(subscriber);
            this.other = maybeSource;
        }

        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this.otherDisposable, disposable);
        }

        public void onNext(T t) {
            this.produced++;
            this.downstream.onNext(t);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onSuccess(T t) {
            complete(t);
        }

        public void onComplete() {
            if (this.inMaybe) {
                this.downstream.onComplete();
                return;
            }
            this.inMaybe = true;
            this.upstream = SubscriptionHelper.CANCELLED;
            MaybeSource<? extends T> maybeSource = this.other;
            this.other = null;
            maybeSource.subscribe(this);
        }

        public void cancel() {
            super.cancel();
            DisposableHelper.dispose(this.otherDisposable);
        }
    }
}
