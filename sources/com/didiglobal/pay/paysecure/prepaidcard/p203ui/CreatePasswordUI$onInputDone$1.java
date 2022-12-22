package com.didiglobal.pay.paysecure.prepaidcard.p203ui;

import androidx.fragment.app.Fragment;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManager;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManagerFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.prepaidcard.ui.CreatePasswordUI$onInputDone$1 */
/* compiled from: ICardPwdUI.kt */
final class CreatePasswordUI$onInputDone$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CardPwdManagerFragment $cardFragment;
    final /* synthetic */ Fragment $fragment;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreatePasswordUI$onInputDone$1(Fragment fragment, CardPwdManagerFragment cardPwdManagerFragment) {
        super(0);
        this.$fragment = fragment;
        this.$cardFragment = cardPwdManagerFragment;
    }

    public final void invoke() {
        CardPwdManager.startFragment$default(CardPwdManager.INSTANCE, ((CardPwdManagerFragment) this.$fragment).getFragmentManager(), 3, false, this.$cardFragment.getCardId(), this.$cardFragment.getSessionId(), this.$cardFragment.getScene(), (String) null, 68, (Object) null);
    }
}
