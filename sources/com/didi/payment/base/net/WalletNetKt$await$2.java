package com.didi.payment.base.net;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Deferred;

@Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.didi.payment.base.net.WalletNetKt", mo176687f = "WalletNet.kt", mo176688i = {0, 0}, mo176689l = {50}, mo176690m = "await", mo176691n = {"onFailure", "onComplete"}, mo176692s = {"L$0", "L$1"})
/* compiled from: WalletNet.kt */
final class WalletNetKt$await$2<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    WalletNetKt$await$2(Continuation<? super WalletNetKt$await$2> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WalletNetKt.await((Deferred) null, (Function1<? super Exception, Unit>) null, (Function0<Unit>) null, this);
    }
}
