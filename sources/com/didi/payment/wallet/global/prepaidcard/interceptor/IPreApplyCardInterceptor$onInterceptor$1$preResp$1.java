package com.didi.payment.wallet.global.prepaidcard.interceptor;

import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.prepaidcard.PrepaidSource;
import com.didi.payment.wallet.global.prepaidcard.resp.PreApplyCardResp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H@"}, mo175978d2 = {"<anonymous>", "Lcom/didi/payment/wallet/global/prepaidcard/resp/PreApplyCardResp;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.didi.payment.wallet.global.prepaidcard.interceptor.IPreApplyCardInterceptor$onInterceptor$1$preResp$1", mo176687f = "IPreApplyCardInterceptor.kt", mo176688i = {}, mo176689l = {}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
/* compiled from: IPreApplyCardInterceptor.kt */
final class IPreApplyCardInterceptor$onInterceptor$1$preResp$1 extends SuspendLambda implements Function1<Continuation<? super PreApplyCardResp>, Object> {
    final /* synthetic */ WalletPageModel $netModel;
    final /* synthetic */ String $source;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IPreApplyCardInterceptor$onInterceptor$1$preResp$1(String str, WalletPageModel walletPageModel, Continuation<? super IPreApplyCardInterceptor$onInterceptor$1$preResp$1> continuation) {
        super(1, continuation);
        this.$source = str;
        this.$netModel = walletPageModel;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new IPreApplyCardInterceptor$onInterceptor$1$preResp$1(this.$source, this.$netModel, continuation);
    }

    public final Object invoke(Continuation<? super PreApplyCardResp> continuation) {
        return ((IPreApplyCardInterceptor$onInterceptor$1$preResp$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$source;
            if (Intrinsics.areEqual((Object) str, (Object) PrepaidSource.SETTING_REQUEST.getValue())) {
                str = PrepaidSource.SETTING.getValue();
            }
            return this.$netModel.preApplyCard(str);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
