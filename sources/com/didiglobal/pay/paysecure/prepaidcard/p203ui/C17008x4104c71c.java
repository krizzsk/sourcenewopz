package com.didiglobal.pay.paysecure.prepaidcard.p203ui;

import android.app.Dialog;
import com.didiglobal.pay.paysecure.prepaidcard.BottomDialog;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo175978d2 = {"<anonymous>", "", "run", "com/didiglobal/pay/paysecure/prepaidcard/ui/CardPwdResetVerifyUI$onInputDone$2$onSuccess$2$1"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.CardPwdResetVerifyUI$onInputDone$2$onSuccess$$inlined$let$lambda$1 */
/* compiled from: CardPwdResetVerifyUI.kt */
final class C17008x4104c71c implements Runnable {
    final /* synthetic */ BottomDialog $dialog$inlined;
    final /* synthetic */ CardPwdResetVerifyUI$onInputDone$2 this$0;

    C17008x4104c71c(CardPwdResetVerifyUI$onInputDone$2 cardPwdResetVerifyUI$onInputDone$2, BottomDialog bottomDialog) {
        this.this$0 = cardPwdResetVerifyUI$onInputDone$2;
        this.$dialog$inlined = bottomDialog;
    }

    public final void run() {
        Dialog dialog = this.$dialog$inlined.getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
    }
}
