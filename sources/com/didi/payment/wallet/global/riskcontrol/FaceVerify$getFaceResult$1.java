package com.didi.payment.wallet.global.riskcontrol;

import com.didi.payment.base.net.WalletNet;
import com.didi.payment.wallet.global.riskcontrol.FaceVerify;
import com.didi.payment.wallet.global.riskcontrol.resp.FaceResultResp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo175978d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.didi.payment.wallet.global.riskcontrol.FaceVerify$getFaceResult$1", mo176687f = "FaceVerify.kt", mo176688i = {}, mo176689l = {53}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
/* compiled from: FaceVerify.kt */
final class FaceVerify$getFaceResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FaceVerify.IFaceCallback $callback;
    final /* synthetic */ String $sessionId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FaceVerify this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FaceVerify$getFaceResult$1(FaceVerify.IFaceCallback iFaceCallback, FaceVerify faceVerify, String str, Continuation<? super FaceVerify$getFaceResult$1> continuation) {
        super(2, continuation);
        this.$callback = iFaceCallback;
        this.this$0 = faceVerify;
        this.$sessionId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FaceVerify$getFaceResult$1 faceVerify$getFaceResult$1 = new FaceVerify$getFaceResult$1(this.$callback, this.this$0, this.$sessionId, continuation);
        faceVerify$getFaceResult$1.L$0 = obj;
        return faceVerify$getFaceResult$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FaceVerify$getFaceResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        boolean z2;
        Integer errno;
        Integer errno2;
        Integer errno3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z3 = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WalletNet walletNet = WalletNet.INSTANCE;
            this.label = 1;
            obj = WalletNet.withContext$default(walletNet, (CoroutineScope) this.L$0, new FaceVerify$getFaceResult$1$result$1(this.this$0, this.$sessionId, (Continuation<? super FaceVerify$getFaceResult$1$result$1>) null), (Function1) null, this, 4, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        FaceResultResp faceResultResp = (FaceResultResp) obj;
        if (faceResultResp == null || (errno3 = faceResultResp.getErrno()) == null || errno3.intValue() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            FaceResultResp.Data data = faceResultResp.getData();
            if (data == null ? false : Intrinsics.areEqual((Object) data.getPass(), (Object) Boxing.boxBoolean(true))) {
                this.$callback.onResult(1);
            } else {
                this.$callback.onResult(0);
            }
        } else {
            if (faceResultResp == null || (errno2 = faceResultResp.getErrno()) == null || errno2.intValue() != 500) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                this.this$0.m22540a(this.$sessionId, this.$callback);
            } else {
                if (faceResultResp == null || (errno = faceResultResp.getErrno()) == null || errno.intValue() != 140002) {
                    z3 = false;
                }
                if (z3) {
                    this.$callback.onResult(3);
                } else {
                    this.$callback.onResult(0);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
