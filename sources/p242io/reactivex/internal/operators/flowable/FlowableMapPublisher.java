package p242io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p242io.reactivex.Flowable;
import p242io.reactivex.functions.Function;
import p242io.reactivex.internal.operators.flowable.FlowableMap;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableMapPublisher */
public final class FlowableMapPublisher<T, U> extends Flowable<U> {

    /* renamed from: a */
    final Publisher<T> f58364a;

    /* renamed from: b */
    final Function<? super T, ? extends U> f58365b;

    public FlowableMapPublisher(Publisher<T> publisher, Function<? super T, ? extends U> function) {
        this.f58364a = publisher;
        this.f58365b = function;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.f58364a.subscribe(new FlowableMap.MapSubscriber(subscriber, this.f58365b));
    }
}
