package com.didiglobal.pay.paysecure.prepaidcard;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didiglobal.pay.paysecure.prepaidcard.p203ui.ICardPwdUI;
import com.didiglobal.pay.paysecure.prepaidcard.p203ui.IConfirmCardUI;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: CardPwdManagerFragment.kt */
final class CardPwdManagerFragment$onViewCreated$2 implements View.OnClickListener {
    final /* synthetic */ CardPwdManagerFragment this$0;

    CardPwdManagerFragment$onViewCreated$2(CardPwdManagerFragment cardPwdManagerFragment) {
        this.this$0 = cardPwdManagerFragment;
    }

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.this$0.getPwdUI() instanceof IConfirmCardUI) {
            ICardPwdUI pwdUI = this.this$0.getPwdUI();
            if (pwdUI != null) {
                ((IConfirmCardUI) pwdUI).onConfirm(this.this$0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.didiglobal.pay.paysecure.prepaidcard.ui.IConfirmCardUI");
        }
    }
}
