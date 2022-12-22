package p242io.reactivex.internal.observers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.internal.disposables.DisposableHelper;

/* renamed from: io.reactivex.internal.observers.SubscriberCompletableObserver */
public final class SubscriberCompletableObserver<T> implements CompletableObserver, Subscription {

    /* renamed from: a */
    final Subscriber<? super T> f58073a;

    /* renamed from: b */
    Disposable f58074b;

    public void request(long j) {
    }

    public SubscriberCompletableObserver(Subscriber<? super T> subscriber) {
        this.f58073a = subscriber;
    }

    public void onComplete() {
        this.f58073a.onComplete();
    }

    public void onError(Throwable th) {
        this.f58073a.onError(th);
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f58074b, disposable)) {
            this.f58074b = disposable;
            this.f58073a.onSubscribe(this);
        }
    }

    public void cancel() {
        this.f58074b.dispose();
    }
}
