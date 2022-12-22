package com.didi.payment.wallet.global.riskcontrol;

import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.payment.wallet.global.riskcontrol.FaceVerify;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceParam;
import com.didichuxing.diface.DiFaceResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo175978d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.didi.payment.wallet.global.riskcontrol.FaceVerify$startFaceVerify$1", mo176687f = "FaceVerify.kt", mo176688i = {}, mo176689l = {}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
/* compiled from: FaceVerify.kt */
final class FaceVerify$startFaceVerify$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FaceVerify.IFaceCallback $callback;
    int label;
    final /* synthetic */ FaceVerify this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FaceVerify$startFaceVerify$1(FaceVerify faceVerify, FaceVerify.IFaceCallback iFaceCallback, Continuation<? super FaceVerify$startFaceVerify$1> continuation) {
        super(2, continuation);
        this.this$0 = faceVerify;
        this.$callback = iFaceCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FaceVerify$startFaceVerify$1(this.this$0, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FaceVerify$startFaceVerify$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Integer intOrNull;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DiFaceParam diFaceParam = new DiFaceParam();
            String faceBizCode = this.this$0.getFaceBizCode();
            int i = 0;
            if (!(faceBizCode == null || (intOrNull = StringsKt.toIntOrNull(faceBizCode)) == null)) {
                i = intOrNull.intValue();
            }
            diFaceParam.setBizCode(i);
            diFaceParam.setSessionId(this.this$0.f31780b);
            diFaceParam.setToken(PayBaseParamUtil.getStringParam(this.this$0.getContext(), "token"));
            DiFace.startFaceRecognition(diFaceParam, new DiFace.IDiFaceCallback(this.this$0) {
                public final /* synthetic */ FaceVerify f$1;

                {
                    this.f$1 = r2;
                }

                public final void onResult(DiFaceResult diFaceResult) {
                    FaceVerify$startFaceVerify$1.m46620invokeSuspend$lambda0(FaceVerify.IFaceCallback.this, this.f$1, diFaceResult);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m46620invokeSuspend$lambda0(FaceVerify.IFaceCallback iFaceCallback, FaceVerify faceVerify, DiFaceResult diFaceResult) {
        if (diFaceResult.getCode() >= 100) {
            iFaceCallback.onResult(0);
        } else {
            faceVerify.m22540a(faceVerify.getSessionId(), iFaceCallback);
        }
    }
}
