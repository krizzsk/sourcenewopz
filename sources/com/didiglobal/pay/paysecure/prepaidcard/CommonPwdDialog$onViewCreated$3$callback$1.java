package com.didiglobal.pay.paysecure.prepaidcard;

import android.content.Intent;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import com.didi.soda.compose.card.BaseCard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo175978d2 = {"<anonymous>", "", "res", "Lcom/didi/drouter/router/Result;", "onResult"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: CommonPwdDialog.kt */
final class CommonPwdDialog$onViewCreated$3$callback$1 implements RouterCallback {
    final /* synthetic */ CommonPwdDialog$onViewCreated$3 this$0;

    CommonPwdDialog$onViewCreated$3$callback$1(CommonPwdDialog$onViewCreated$3 commonPwdDialog$onViewCreated$3) {
        this.this$0 = commonPwdDialog$onViewCreated$3;
    }

    public final void onResult(Result result) {
        Intrinsics.checkParameterIsNotNull(result, "res");
        this.this$0.this$0.getCardLoading().hideLoading();
        if (result.getInt("result") == 1) {
            this.this$0.this$0.f50360g = result.getString("session_id");
            Intent intent = new Intent(this.this$0.this$0.getActivity(), CardPwdManagerActivity.class);
            intent.putExtra(CardPwdManagerActivity.CARD_MODE_KEY, 4);
            intent.putExtra(BaseCard.KEY_CARD_ID, this.this$0.this$0.f50357d);
            intent.putExtra("scene", PrepaidConstant.SCENE_FORGET_PASSWORD);
            intent.putExtra("session_id", this.this$0.this$0.f50360g);
            this.this$0.this$0.startActivity(intent);
            this.this$0.this$0.f50355b = 3;
            this.this$0.this$0.dismiss();
        }
    }
}
