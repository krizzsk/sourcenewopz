package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", mo176687f = "Deprecated.kt", mo176688i = {0, 0, 1, 1, 1}, mo176689l = {97, 100}, mo176690m = "last", mo176691n = {"$this$consume$iv", "iterator", "$this$consume$iv", "iterator", "last"}, mo176692s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* compiled from: Deprecated.kt */
final class ChannelsKt__DeprecatedKt$last$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__DeprecatedKt$last$1(Continuation<? super ChannelsKt__DeprecatedKt$last$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return C21833e.m45607c((ReceiveChannel) null, this);
    }
}
