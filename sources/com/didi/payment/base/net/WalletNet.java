package com.didi.payment.base.net;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jm\u0010\u0003\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tø\u0001\u0000¢\u0006\u0002\u0010\u0011Jh\u0010\u0012\u001a\u0004\u0018\u0001H\u0005\"\u0004\b\u0000\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001c\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/payment/base/net/WalletNet;", "", "()V", "async", "Lkotlinx/coroutines/Deferred;", "T", "scope", "Lkotlinx/coroutines/CoroutineScope;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "onFailure", "Ljava/lang/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Deferred;", "withContext", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletNet.kt */
public final class WalletNet {
    public static final WalletNet INSTANCE = new WalletNet();

    private WalletNet() {
    }

    public static /* synthetic */ Deferred async$default(WalletNet walletNet, CoroutineScope coroutineScope, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function12 = null;
        }
        return walletNet.async(coroutineScope, function1, function12);
    }

    public final <T> Deferred<T> async(CoroutineScope coroutineScope, Function1<? super Continuation<? super T>, ? extends Object> function1, Function1<? super Exception, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if (coroutineScope == null) {
            return null;
        }
        return C21836d.m45640b(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new WalletNet$async$def$1(function1, function12, (Continuation<? super WalletNet$async$def$1>) null), 2, (Object) null);
    }

    public static /* synthetic */ Object withContext$default(WalletNet walletNet, CoroutineScope coroutineScope, Function1 function1, Function1 function12, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            function12 = null;
        }
        return walletNet.withContext(coroutineScope, function1, function12, continuation);
    }

    public final <T> Object withContext(CoroutineScope coroutineScope, Function1<? super Continuation<? super T>, ? extends Object> function1, Function1<? super Exception, Unit> function12, Continuation<? super T> continuation) {
        Deferred<T> async = async(coroutineScope, function1, function12);
        if (async == null) {
            return null;
        }
        return WalletNetKt.await$default(async, function12, (Function0) null, continuation, 2, (Object) null);
    }
}
