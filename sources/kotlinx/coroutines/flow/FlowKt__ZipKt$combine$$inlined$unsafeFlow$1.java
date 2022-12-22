package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.CombineKt;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, mo175978d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$1 implements Flow<R> {
    final /* synthetic */ Flow $flow$inlined;
    final /* synthetic */ Flow $this_combine$inlined;
    final /* synthetic */ Function3 $transform$inlined;

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$1(Flow flow, Flow flow2, Function3 function3) {
        this.$this_combine$inlined = flow;
        this.$flow$inlined = flow2;
        this.$transform$inlined = function3;
    }

    public Object collect(FlowCollector<? super R> flowCollector, Continuation<? super Unit> continuation) {
        Object combineInternal = CombineKt.combineInternal(flowCollector, new Flow[]{this.$this_combine$inlined, this.$flow$inlined}, C21967v.m45933b(), new FlowKt__ZipKt$combine$1$1(this.$transform$inlined, (Continuation<? super FlowKt__ZipKt$combine$1$1>) null), continuation);
        if (combineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return combineInternal;
        }
        return Unit.INSTANCE;
    }
}
