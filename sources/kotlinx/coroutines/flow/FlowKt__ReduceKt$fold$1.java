package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", mo176687f = "Reduce.kt", mo176688i = {0}, mo176689l = {173}, mo176690m = "fold", mo176691n = {"accumulator"}, mo176692s = {"L$0"})
/* compiled from: Reduce.kt */
final class FlowKt__ReduceKt$fold$1<T, R> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    FlowKt__ReduceKt$fold$1(Continuation<? super FlowKt__ReduceKt$fold$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return C21964s.m45888a((Flow) null, null, (Function3) null, this);
    }
}
