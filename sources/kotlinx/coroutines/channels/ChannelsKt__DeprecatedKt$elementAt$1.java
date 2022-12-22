package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", mo176687f = "Deprecated.kt", mo176688i = {0, 0, 0}, mo176689l = {38}, mo176690m = "elementAt", mo176691n = {"$this$consume$iv", "index", "count"}, mo176692s = {"L$0", "I$0", "I$1"})
/* compiled from: Deprecated.kt */
final class ChannelsKt__DeprecatedKt$elementAt$1<E> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__DeprecatedKt$elementAt$1(Continuation<? super ChannelsKt__DeprecatedKt$elementAt$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return C21833e.m45574a((ReceiveChannel) null, 0, (Continuation) this);
    }
}
