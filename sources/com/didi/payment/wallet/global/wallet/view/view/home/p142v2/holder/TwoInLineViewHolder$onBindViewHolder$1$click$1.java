package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder;

import android.content.Context;
import android.view.ContextThemeWrapper;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.FinancialEntry;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.FreezeInterceptor;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TwoInLineViewHolder$onBindViewHolder$1$click$1 */
/* compiled from: TwoInLineViewHolder.kt */
final class TwoInLineViewHolder$onBindViewHolder$1$click$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ FinancialEntry $data;
    final /* synthetic */ FinancialEntry $this_apply;
    final /* synthetic */ TwoInLineViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TwoInLineViewHolder$onBindViewHolder$1$click$1(TwoInLineViewHolder twoInLineViewHolder, FinancialEntry financialEntry, FinancialEntry financialEntry2) {
        super(0);
        this.this$0 = twoInLineViewHolder;
        this.$this_apply = financialEntry;
        this.$data = financialEntry2;
    }

    public final Boolean invoke() {
        FreezeInterceptor freezeInterceptor = FreezeInterceptor.INSTANCE;
        Context context = this.this$0.itemView.getContext();
        final FinancialEntry financialEntry = this.$this_apply;
        final TwoInLineViewHolder twoInLineViewHolder = this.this$0;
        final FinancialEntry financialEntry2 = this.$data;
        return Boolean.valueOf(FreezeInterceptor.onInterceptor$default(freezeInterceptor, context, 1, false, new Function1<Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                Request build = DRouter.build(financialEntry.getCardLinkUrl());
                Context context = twoInLineViewHolder.itemView.getContext();
                if (context != null) {
                    build.start(((ContextThemeWrapper) context).getBaseContext());
                    WalletHomeTrackerManager.Companion.trackFinancialClick(financialEntry2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ContextThemeWrapper");
            }
        }, 4, (Object) null));
    }
}
