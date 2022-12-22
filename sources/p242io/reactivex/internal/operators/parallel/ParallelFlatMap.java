package p242io.reactivex.internal.operators.parallel;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p242io.reactivex.functions.Function;
import p242io.reactivex.internal.operators.flowable.FlowableFlatMap;
import p242io.reactivex.parallel.ParallelFlowable;

/* renamed from: io.reactivex.internal.operators.parallel.ParallelFlatMap */
public final class ParallelFlatMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    final ParallelFlowable<T> f59043a;

    /* renamed from: b */
    final Function<? super T, ? extends Publisher<? extends R>> f59044b;

    /* renamed from: c */
    final boolean f59045c;

    /* renamed from: d */
    final int f59046d;

    /* renamed from: e */
    final int f59047e;

    public ParallelFlatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i, int i2) {
        this.f59043a = parallelFlowable;
        this.f59044b = function;
        this.f59045c = z;
        this.f59046d = i;
        this.f59047e = i2;
    }

    public int parallelism() {
        return this.f59043a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = FlowableFlatMap.subscribe(subscriberArr[i], this.f59044b, this.f59045c, this.f59046d, this.f59047e);
            }
            this.f59043a.subscribe(subscriberArr2);
        }
    }
}
