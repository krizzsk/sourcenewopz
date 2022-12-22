package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "kotlinx.coroutines.channels.AbstractChannel", mo176687f = "AbstractChannel.kt", mo176688i = {}, mo176689l = {633}, mo176690m = "receiveCatching-JP2dKIU", mo176691n = {}, mo176692s = {})
/* compiled from: AbstractChannel.kt */
final class AbstractChannel$receiveCatching$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbstractChannel<E> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractChannel$receiveCatching$1(AbstractChannel<E> abstractChannel, Continuation<? super AbstractChannel$receiveCatching$1> continuation) {
        super(continuation);
        this.this$0 = abstractChannel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r2 = this.this$0.m48244receiveCatchingJP2dKIU(this);
        return r2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r2 : ChannelResult.m48254boximpl(r2);
    }
}
