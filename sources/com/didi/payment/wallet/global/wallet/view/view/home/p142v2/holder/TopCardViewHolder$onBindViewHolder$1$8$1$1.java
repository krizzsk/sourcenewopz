package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder;

import com.didi.payment.wallet.global.wallet.contract.WalletHomeContract;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Button;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Data;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$8$1$1 */
/* compiled from: TopCardViewHolder.kt */
final class TopCardViewHolder$onBindViewHolder$1$8$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Data $data;
    final /* synthetic */ Button $it;
    final /* synthetic */ Data $this_apply;
    final /* synthetic */ TopCardViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopCardViewHolder$onBindViewHolder$1$8$1$1(TopCardViewHolder topCardViewHolder, Button button, Data data, Data data2) {
        super(0);
        this.this$0 = topCardViewHolder;
        this.$it = button;
        this.$this_apply = data;
        this.$data = data2;
    }

    public final void invoke() {
        WalletHomeContract.V2Listener access$getLister$p = this.this$0.f32717a;
        if (access$getLister$p != null) {
            String linkUrl = this.$it.getLinkUrl();
            AccountSection accountSection = this.$this_apply.getAccountSection();
            access$getLister$p.onAccountMainEnterClicked(linkUrl, accountSection == null ? null : accountSection.getKycStatus());
        }
        WalletHomeTrackerManager.Companion.trackHomeCardClick(this.this$0.itemView.getContext(), this.$data, "topup");
    }
}
