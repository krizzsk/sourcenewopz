package com.didiglobal.pay.paysecure.prepaidcard;

import com.didiglobal.pay.paysecure.prepaidcard.p203ui.ICardPwdUI;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, mo175978d2 = {"com/didiglobal/pay/paysecure/prepaidcard/CardPwdManagerFragment$onViewCreated$4", "Lcom/didiglobal/pay/paysecure/prepaidcard/InputListener;", "onInputChange", "", "onInputDone", "text", "", "onInputEmpty", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CardPwdManagerFragment.kt */
public final class CardPwdManagerFragment$onViewCreated$4 implements InputListener {
    final /* synthetic */ CardPwdManagerFragment this$0;

    CardPwdManagerFragment$onViewCreated$4(CardPwdManagerFragment cardPwdManagerFragment) {
        this.this$0 = cardPwdManagerFragment;
    }

    public void onInputDone(String str) {
        ICardPwdUI pwdUI = this.this$0.getPwdUI();
        CardPwdManagerFragment cardPwdManagerFragment = this.this$0;
        pwdUI.onInputDone(cardPwdManagerFragment, cardPwdManagerFragment, str);
    }

    public void onInputChange() {
        CardPwdManagerFragment.access$getTvConfirm$p(this.this$0).setEnabled(false);
    }

    public void onInputEmpty() {
        CardPwdManagerFragment.access$getTvConfirm$p(this.this$0).setEnabled(false);
    }
}
