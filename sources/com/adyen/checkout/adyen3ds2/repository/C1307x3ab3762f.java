package com.adyen.checkout.adyen3ds2.repository;

import com.adyen.checkout.adyen3ds2.model.SubmitFingerprintResponse;
import com.adyen.checkout.core.api.Connection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo175977d1 = {"\u0000\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0003H@¨\u0006\u0004"}, mo175978d2 = {"<anonymous>", "T", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;", "com/adyen/checkout/components/api/ConnectionExtKt$suspendedCall$2"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.adyen.checkout.components.api.ConnectionExtKt$suspendedCall$2", mo176687f = "ConnectionExt.kt", mo176688i = {}, mo176689l = {}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
/* renamed from: com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository$submitFingerprint$$inlined$suspendedCall$1 */
/* compiled from: ConnectionExt.kt */
public final class C1307x3ab3762f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SubmitFingerprintResponse>, Object> {
    final /* synthetic */ Connection $this_suspendedCall;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1307x3ab3762f(Connection connection, Continuation continuation) {
        super(2, continuation);
        this.$this_suspendedCall = connection;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C1307x3ab3762f(this.$this_suspendedCall, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SubmitFingerprintResponse> continuation) {
        return ((C1307x3ab3762f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.$this_suspendedCall.call();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
