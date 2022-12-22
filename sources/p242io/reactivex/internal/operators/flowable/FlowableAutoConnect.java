package p242io.reactivex.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;
import p242io.reactivex.Flowable;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.flowables.ConnectableFlowable;
import p242io.reactivex.functions.Consumer;

/* renamed from: io.reactivex.internal.operators.flowable.FlowableAutoConnect */
public final class FlowableAutoConnect<T> extends Flowable<T> {

    /* renamed from: a */
    final ConnectableFlowable<? extends T> f58182a;

    /* renamed from: b */
    final int f58183b;

    /* renamed from: c */
    final Consumer<? super Disposable> f58184c;

    /* renamed from: d */
    final AtomicInteger f58185d = new AtomicInteger();

    public FlowableAutoConnect(ConnectableFlowable<? extends T> connectableFlowable, int i, Consumer<? super Disposable> consumer) {
        this.f58182a = connectableFlowable;
        this.f58183b = i;
        this.f58184c = consumer;
    }

    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.f58182a.subscribe(subscriber);
        if (this.f58185d.incrementAndGet() == this.f58183b) {
            this.f58182a.connect(this.f58184c);
        }
    }
}
