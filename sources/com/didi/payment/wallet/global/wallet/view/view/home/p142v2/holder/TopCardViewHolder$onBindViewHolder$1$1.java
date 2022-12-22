package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder;

import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Data;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeFreeze;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TopCardViewHolder$onBindViewHolder$1$1 */
/* compiled from: TopCardViewHolder.kt */
final class TopCardViewHolder$onBindViewHolder$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Data $this_apply;
    final /* synthetic */ TopCardViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TopCardViewHolder$onBindViewHolder$1$1(TopCardViewHolder topCardViewHolder, Data data) {
        super(1);
        this.this$0 = topCardViewHolder;
        this.$this_apply = data;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        WalletHomeFreeze.Companion.setPrepaidUI(this.this$0, this.$this_apply.getAccountSection());
    }
}
