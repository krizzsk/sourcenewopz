package com.didi.payment.base.net;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo175977d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H@"}, mo175978d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.didi.payment.base.net.WalletNet$async$def$1", mo176687f = "WalletNet.kt", mo176688i = {}, mo176689l = {15}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
/* compiled from: WalletNet.kt */
final class WalletNet$async$def$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    final /* synthetic */ Function1<Continuation<? super T>, Object> $block;
    final /* synthetic */ Function1<Exception, Unit> $onFailure;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletNet$async$def$1(Function1<? super Continuation<? super T>, ? extends Object> function1, Function1<? super Exception, Unit> function12, Continuation<? super WalletNet$async$def$1> continuation) {
        super(2, continuation);
        this.$block = function1;
        this.$onFailure = function12;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WalletNet$async$def$1(this.$block, this.$onFailure, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
        return ((WalletNet$async$def$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super T>, Object> function1 = this.$block;
            this.label = 1;
            Object invoke = function1.invoke(this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            return invoke;
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
                return obj;
            } catch (Exception e) {
                Function1<Exception, Unit> function12 = this.$onFailure;
                if (function12 != null) {
                    function12.invoke(e);
                }
                return null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
