package p242io.reactivex.internal.operators.completable;

import org.reactivestreams.Subscriber;
import p242io.reactivex.CompletableSource;
import p242io.reactivex.Flowable;
import p242io.reactivex.internal.observers.SubscriberCompletableObserver;

/* renamed from: io.reactivex.internal.operators.completable.CompletableToFlowable */
public final class CompletableToFlowable<T> extends Flowable<T> {

    /* renamed from: a */
    final CompletableSource f58159a;

    public CompletableToFlowable(CompletableSource completableSource) {
        this.f58159a = completableSource;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f58159a.subscribe(new SubscriberCompletableObserver(subscriber));
    }
}
