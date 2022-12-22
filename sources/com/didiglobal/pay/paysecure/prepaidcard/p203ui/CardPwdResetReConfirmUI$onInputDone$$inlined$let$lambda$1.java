package com.didiglobal.pay.paysecure.prepaidcard.p203ui;

import android.app.Dialog;
import androidx.fragment.app.Fragment;
import com.didiglobal.pay.paysecure.prepaidcard.BottomDialog;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, mo175978d2 = {"<anonymous>", "", "run", "com/didiglobal/pay/paysecure/prepaidcard/ui/CardPwdResetReConfirmUI$onInputDone$1$1"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.CardPwdResetReConfirmUI$onInputDone$$inlined$let$lambda$1 */
/* compiled from: CardPwdResetVerifyUI.kt */
final class CardPwdResetReConfirmUI$onInputDone$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ BottomDialog $dialog$inlined;
    final /* synthetic */ Fragment $fragment$inlined;

    CardPwdResetReConfirmUI$onInputDone$$inlined$let$lambda$1(BottomDialog bottomDialog, Fragment fragment) {
        this.$dialog$inlined = bottomDialog;
        this.$fragment$inlined = fragment;
    }

    public final void run() {
        Dialog dialog = this.$dialog$inlined.getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
    }
}
