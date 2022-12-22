package com.didiglobal.pay.paysecure.prepaidcard.p203ui;

import com.didiglobal.pay.paysecure.prepaidcard.BottomDialog;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManager;
import com.didiglobal.pay.paysecure.prepaidcard.TrackerManager;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didiglobal/pay/paysecure/prepaidcard/ui/CardPwdResetVerifyUI$onInputDone$2$onSuccess$dialog$1", "Lcom/didiglobal/pay/paysecure/prepaidcard/BottomDialog$IClickListener;", "onClick", "", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.CardPwdResetVerifyUI$onInputDone$2$onSuccess$dialog$1 */
/* compiled from: CardPwdResetVerifyUI.kt */
public final class CardPwdResetVerifyUI$onInputDone$2$onSuccess$dialog$1 implements BottomDialog.IClickListener {
    final /* synthetic */ CardPwdResetVerifyUI$onInputDone$2 this$0;

    CardPwdResetVerifyUI$onInputDone$2$onSuccess$dialog$1(CardPwdResetVerifyUI$onInputDone$2 cardPwdResetVerifyUI$onInputDone$2) {
        this.this$0 = cardPwdResetVerifyUI$onInputDone$2;
    }

    public void onClick() {
        CardPwdManager.INSTANCE.finishActivity(this.this$0.$fragment);
        TrackerManager.Companion.trackOldPwdLimitClick();
    }
}
