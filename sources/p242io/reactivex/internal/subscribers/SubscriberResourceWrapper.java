package p242io.reactivex.internal.subscribers;

import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.FlowableSubscriber;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;
import p242io.reactivex.internal.subscriptions.SubscriptionHelper;

/* renamed from: io.reactivex.internal.subscribers.SubscriberResourceWrapper */
public final class SubscriberResourceWrapper<T> extends AtomicReference<Disposable> implements FlowableSubscriber<T>, Disposable, Subscription {
    private static final long serialVersionUID = -8612022020200669122L;
    final Subscriber<? super T> downstream;
    final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public SubscriberResourceWrapper(Subscriber<? super T> subscriber) {
        this.downstream = subscriber;
    }

    public void onSubscribe(Subscription subscription) {
        if (SubscriptionHelper.setOnce(this.upstream, subscription)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    public void onError(Throwable th) {
        DisposableHelper.dispose(this);
        this.downstream.onError(th);
    }

    public void onComplete() {
        DisposableHelper.dispose(this);
        this.downstream.onComplete();
    }

    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            this.upstream.get().request(j);
        }
    }

    public void dispose() {
        SubscriptionHelper.cancel(this.upstream);
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return this.upstream.get() == SubscriptionHelper.CANCELLED;
    }

    public void cancel() {
        dispose();
    }

    public void setResource(Disposable disposable) {
        DisposableHelper.set(this, disposable);
    }
}
