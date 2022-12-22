package p242io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p242io.reactivex.Flowable;
import p242io.reactivex.functions.Function;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher */
public final class FlowableFlatMapPublisher<T, U> extends Flowable<U> {

    /* renamed from: a */
    final Publisher<T> f58307a;

    /* renamed from: b */
    final Function<? super T, ? extends Publisher<? extends U>> f58308b;

    /* renamed from: c */
    final boolean f58309c;

    /* renamed from: d */
    final int f58310d;

    /* renamed from: e */
    final int f58311e;

    public FlowableFlatMapPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends U>> function, boolean z, int i, int i2) {
        this.f58307a = publisher;
        this.f58308b = function;
        this.f58309c = z;
        this.f58310d = i;
        this.f58311e = i2;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super U> subscriber) {
        if (!FlowableScalarXMap.tryScalarXMapSubscribe(this.f58307a, subscriber, this.f58308b)) {
            this.f58307a.subscribe(FlowableFlatMap.subscribe(subscriber, this.f58308b, this.f58309c, this.f58310d, this.f58311e));
        }
    }
}
