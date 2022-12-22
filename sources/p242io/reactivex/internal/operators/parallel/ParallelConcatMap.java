package p242io.reactivex.internal.operators.parallel;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import p242io.reactivex.functions.Function;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.operators.flowable.FlowableConcatMap;
import p242io.reactivex.internal.util.ErrorMode;
import p242io.reactivex.parallel.ParallelFlowable;

/* renamed from: io.reactivex.internal.operators.parallel.ParallelConcatMap */
public final class ParallelConcatMap<T, R> extends ParallelFlowable<R> {

    /* renamed from: a */
    final ParallelFlowable<T> f59031a;

    /* renamed from: b */
    final Function<? super T, ? extends Publisher<? extends R>> f59032b;

    /* renamed from: c */
    final int f59033c;

    /* renamed from: d */
    final ErrorMode f59034d;

    public ParallelConcatMap(ParallelFlowable<T> parallelFlowable, Function<? super T, ? extends Publisher<? extends R>> function, int i, ErrorMode errorMode) {
        this.f59031a = parallelFlowable;
        this.f59032b = (Function) ObjectHelper.requireNonNull(function, "mapper");
        this.f59033c = i;
        this.f59034d = (ErrorMode) ObjectHelper.requireNonNull(errorMode, "errorMode");
    }

    public int parallelism() {
        return this.f59031a.parallelism();
    }

    public void subscribe(Subscriber<? super R>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                subscriberArr2[i] = FlowableConcatMap.subscribe(subscriberArr[i], this.f59032b, this.f59033c, this.f59034d);
            }
            this.f59031a.subscribe(subscriberArr2);
        }
    }
}
