package com.didiglobal.pay.paysecure.prepaidcard;

import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: CardPwdManagerFragment.kt */
final class CardPwdManagerFragment$onFail$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $msg;
    final /* synthetic */ CardPwdManagerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CardPwdManagerFragment$onFail$1(CardPwdManagerFragment cardPwdManagerFragment, String str) {
        super(0);
        this.this$0 = cardPwdManagerFragment;
        this.$msg = str;
    }

    public final void invoke() {
        if (!TextUtils.isEmpty(this.$msg)) {
            CardPwdManagerFragment.access$getTvDesc$p(this.this$0).setText(this.$msg);
            CardPwdManagerFragment.access$getTvDesc$p(this.this$0).setTextColor(ContextCompat.getColor(CardPwdManagerFragment.access$getEditView$p(this.this$0).getContext(), R.color.color_ff4060));
        }
    }
}
