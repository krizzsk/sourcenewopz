package com.didi.payment.wallet.global.prepaidcard;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.net.WalletNet;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.soda.compose.card.BaseCard;
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
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo175978d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@DebugMetadata(mo176686c = "com.didi.payment.wallet.global.prepaidcard.VerifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1", mo176687f = "VerifyPwdUtil.kt", mo176688i = {}, mo176689l = {42}, mo176690m = "invokeSuspend", mo176691n = {}, mo176692s = {})
/* compiled from: VerifyPwdUtil.kt */
final class VerifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ Bundle $bundle;
    final /* synthetic */ IPwdVerify $callback;
    final /* synthetic */ WalletPageModel $netModel;
    final /* synthetic */ String $token;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1(Bundle bundle, IPwdVerify iPwdVerify, FragmentActivity fragmentActivity, WalletPageModel walletPageModel, String str, Continuation<? super VerifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1> continuation) {
        super(2, continuation);
        this.$bundle = bundle;
        this.$callback = iPwdVerify;
        this.$activity = fragmentActivity;
        this.$netModel = walletPageModel;
        this.$token = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VerifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1 verifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1 = new VerifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1(this.$bundle, this.$callback, this.$activity, this.$netModel, this.$token, continuation);
        verifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1.L$0 = obj;
        return verifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VerifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Integer num;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String string = this.$bundle.getString(BaseCard.KEY_CARD_ID);
            String string2 = this.$bundle.getString("session_id");
            String string3 = this.$bundle.getString("scene");
            WalletNet walletNet = WalletNet.INSTANCE;
            this.label = 1;
            obj = WalletNet.withContext$default(walletNet, (CoroutineScope) this.L$0, new VerifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1$baseResp$1(this.$netModel, string, string2, string3, this.$token, (Continuation<? super VerifyPwdUtil$Companion$handlePwdVerify$1$onSuccess$1$baseResp$1>) null), (Function1) null, this, 4, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        WBaseResp wBaseResp = (WBaseResp) obj;
        String str = null;
        if (wBaseResp == null) {
            num = null;
        } else {
            num = Boxing.boxInt(wBaseResp.errno);
        }
        if (num != null && num.intValue() == 0) {
            IPwdVerify iPwdVerify = this.$callback;
            if (iPwdVerify != null) {
                iPwdVerify.onSuccess(1);
            }
        } else if (num != null && num.intValue() == 505) {
            WalletToastNew.showFailedMsg(this.$activity, wBaseResp.errmsg);
            IPwdVerify iPwdVerify2 = this.$callback;
            if (iPwdVerify2 != null) {
                iPwdVerify2.onFail();
            }
        } else if (num != null && num.intValue() == 500) {
            WalletToastNew.showFailedMsg(this.$activity, wBaseResp.errmsg);
            IPwdVerify iPwdVerify3 = this.$callback;
            if (iPwdVerify3 != null) {
                iPwdVerify3.onFail();
            }
        } else if (num != null && num.intValue() == 140002) {
            WalletToastNew.showFailedMsg(this.$activity, wBaseResp.errmsg);
            IPwdVerify iPwdVerify4 = this.$callback;
            if (iPwdVerify4 != null) {
                iPwdVerify4.onFail();
            }
        } else if (num != null && num.intValue() == 140005) {
            WalletToastNew.showFailedMsg(this.$activity, wBaseResp.errmsg);
            IPwdVerify iPwdVerify5 = this.$callback;
            if (iPwdVerify5 != null) {
                iPwdVerify5.onFail();
            }
        } else {
            Context context = this.$activity;
            if (wBaseResp != null) {
                str = wBaseResp.errmsg;
            }
            WalletToastNew.showFailedMsg(context, str);
            IPwdVerify iPwdVerify6 = this.$callback;
            if (iPwdVerify6 != null) {
                iPwdVerify6.onFail();
            }
        }
        return Unit.INSTANCE;
    }
}
