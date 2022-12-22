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
import kotlinx.coroutines.Job;

@Metadata(mo175977d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\\\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022%\b\u0002\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001ai\u0010\u0000\u001a\u00020\t\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\t0\u00042!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, mo175978d2 = {"await", "T", "Lkotlinx/coroutines/Deferred;", "onFailure", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/ParameterName;", "name", "e", "", "onComplete", "Lkotlin/Function0;", "(Lkotlinx/coroutines/Deferred;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onSuccess", "base_globalRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletNet.kt */
public final class WalletNetKt {
    public static /* synthetic */ void await$default(Deferred deferred, CoroutineScope coroutineScope, Function1 function1, Function1 function12, Function0 function0, int i, Object obj) {
        if ((i & 8) != 0) {
            function0 = null;
        }
        await(deferred, coroutineScope, function1, function12, function0);
    }

    public static final <T> void await(Deferred<? extends T> deferred, CoroutineScope coroutineScope, Function1<? super T, Unit> function1, Function1<? super Exception, Unit> function12, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(deferred, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onFailure");
        if (coroutineScope != null) {
            Job unused = C21836d.m45637a(coroutineScope, Dispatchers.getMain(), (CoroutineStart) null, new WalletNetKt$await$1(deferred, function1, function12, function0, (Continuation<? super WalletNetKt$await$1>) null), 2, (Object) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: kotlin.jvm.functions.Function0<kotlin.Unit>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Exception, kotlin.Unit>} */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r6 != null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        r6.invoke();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        if (r6 != null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        return r7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object await(kotlinx.coroutines.Deferred<? extends T> r4, kotlin.jvm.functions.Function1<? super java.lang.Exception, kotlin.Unit> r5, kotlin.jvm.functions.Function0<kotlin.Unit> r6, kotlin.coroutines.Continuation<? super T> r7) {
        /*
            boolean r0 = r7 instanceof com.didi.payment.base.net.WalletNetKt$await$2
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.didi.payment.base.net.WalletNetKt$await$2 r0 = (com.didi.payment.base.net.WalletNetKt$await$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.didi.payment.base.net.WalletNetKt$await$2 r0 = new com.didi.payment.base.net.WalletNetKt$await$2
            r0.<init>(r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r4 = r0.L$1
            r6 = r4
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            java.lang.Object r4 = r0.L$0
            r5 = r4
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ Exception -> 0x0055 }
            goto L_0x004c
        L_0x0034:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5     // Catch:{ Exception -> 0x0055 }
            r0.L$1 = r6     // Catch:{ Exception -> 0x0055 }
            r0.label = r3     // Catch:{ Exception -> 0x0055 }
            java.lang.Object r7 = r4.await(r0)     // Catch:{ Exception -> 0x0055 }
            if (r7 != r1) goto L_0x004c
            return r1
        L_0x004c:
            if (r6 != 0) goto L_0x004f
            goto L_0x005f
        L_0x004f:
            r6.invoke()
            goto L_0x005f
        L_0x0053:
            r4 = move-exception
            goto L_0x0060
        L_0x0055:
            r4 = move-exception
            if (r5 != 0) goto L_0x0059
            goto L_0x005c
        L_0x0059:
            r5.invoke(r4)     // Catch:{ all -> 0x0053 }
        L_0x005c:
            r7 = 0
            if (r6 != 0) goto L_0x004f
        L_0x005f:
            return r7
        L_0x0060:
            if (r6 != 0) goto L_0x0063
            goto L_0x0066
        L_0x0063:
            r6.invoke()
        L_0x0066:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.net.WalletNetKt.await(kotlinx.coroutines.Deferred, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object await$default(Deferred deferred, Function1 function1, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        return await(deferred, function1, function0, continuation);
    }
}
