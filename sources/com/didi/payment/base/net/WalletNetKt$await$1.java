package com.didi.payment.base.net;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, mo175978d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.didi.payment.base.net.WalletNetKt$await$1", mo176687f = "WalletNet.kt", mo176688i = {}, mo176689l = {38}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
/* compiled from: WalletNet.kt */
final class WalletNetKt$await$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $onComplete;
    final /* synthetic */ Function1<Exception, Unit> $onFailure;
    final /* synthetic */ Function1<T, Unit> $onSuccess;
    final /* synthetic */ Deferred<T> $this_await;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletNetKt$await$1(Deferred<? extends T> deferred, Function1<? super T, Unit> function1, Function1<? super Exception, Unit> function12, Function0<Unit> function0, Continuation<? super WalletNetKt$await$1> continuation) {
        super(2, continuation);
        this.$this_await = deferred;
        this.$onSuccess = function1;
        this.$onFailure = function12;
        this.$onComplete = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WalletNetKt$await$1(this.$this_await, this.$onSuccess, this.$onFailure, this.$onComplete, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WalletNetKt$await$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        if (r4 == null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        r4.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        if (r4 != null) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r3.label
            r2 = 1
            if (r1 == 0) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r4)     // Catch:{ Exception -> 0x0011 }
            goto L_0x002c
        L_0x000f:
            r4 = move-exception
            goto L_0x0046
        L_0x0011:
            r4 = move-exception
            goto L_0x003a
        L_0x0013:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r4)
            kotlinx.coroutines.Deferred<T> r4 = r3.$this_await     // Catch:{ Exception -> 0x0011 }
            r1 = r3
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch:{ Exception -> 0x0011 }
            r3.label = r2     // Catch:{ Exception -> 0x0011 }
            java.lang.Object r4 = r4.await(r1)     // Catch:{ Exception -> 0x0011 }
            if (r4 != r0) goto L_0x002c
            return r0
        L_0x002c:
            kotlin.jvm.functions.Function1<T, kotlin.Unit> r0 = r3.$onSuccess     // Catch:{ Exception -> 0x0011 }
            r0.invoke(r4)     // Catch:{ Exception -> 0x0011 }
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r3.$onComplete
            if (r4 != 0) goto L_0x0036
            goto L_0x0043
        L_0x0036:
            r4.invoke()
            goto L_0x0043
        L_0x003a:
            kotlin.jvm.functions.Function1<java.lang.Exception, kotlin.Unit> r0 = r3.$onFailure     // Catch:{ all -> 0x000f }
            r0.invoke(r4)     // Catch:{ all -> 0x000f }
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r3.$onComplete
            if (r4 != 0) goto L_0x0036
        L_0x0043:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x0046:
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r3.$onComplete
            if (r0 != 0) goto L_0x004b
            goto L_0x004e
        L_0x004b:
            r0.invoke()
        L_0x004e:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.net.WalletNetKt$await$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
