package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.handler;

import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.wallet.global.model.WalletPageModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H@"}, mo175978d2 = {"<anonymous>", "Lcom/didi/payment/commonsdk/net/WBaseResp;", "kotlin.jvm.PlatformType"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handlePwdVerify$1$onSuccess$1$baseResp$1", mo176687f = "WalletOpenSessionHandler.kt", mo176688i = {}, mo176689l = {}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$handlePwdVerify$1$onSuccess$1$baseResp$1 */
/* compiled from: WalletOpenSessionHandler.kt */
final class C11400x335ec297 extends SuspendLambda implements Function1<Continuation<? super WBaseResp>, Object> {
    final /* synthetic */ String $cardId;
    final /* synthetic */ WalletPageModel $netModel;
    final /* synthetic */ String $scene;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $token;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C11400x335ec297(WalletPageModel walletPageModel, String str, String str2, String str3, String str4, Continuation<? super C11400x335ec297> continuation) {
        super(1, continuation);
        this.$netModel = walletPageModel;
        this.$cardId = str;
        this.$sessionId = str2;
        this.$scene = str3;
        this.$token = str4;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new C11400x335ec297(this.$netModel, this.$cardId, this.$sessionId, this.$scene, this.$token, continuation);
    }

    public final Object invoke(Continuation<? super WBaseResp> continuation) {
        return ((C11400x335ec297) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.$netModel.verifyPassword(this.$cardId, this.$sessionId, this.$scene, "1", this.$token);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
