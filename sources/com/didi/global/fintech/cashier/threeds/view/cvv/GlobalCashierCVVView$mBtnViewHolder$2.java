package com.didi.global.fintech.cashier.threeds.view.cvv;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.p117ui.viewholder.GlobalCashierCVVBtnViewHolder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierCVVBtnViewHolder;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierCVVView.kt */
final class GlobalCashierCVVView$mBtnViewHolder$2 extends Lambda implements Function0<GlobalCashierCVVBtnViewHolder> {
    final /* synthetic */ GlobalCashierCVVView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierCVVView$mBtnViewHolder$2(GlobalCashierCVVView globalCashierCVVView) {
        super(0);
        this.this$0 = globalCashierCVVView;
    }

    public final GlobalCashierCVVBtnViewHolder invoke() {
        GlobalCashierCVVBtnViewHolder.Companion companion = GlobalCashierCVVBtnViewHolder.Companion;
        Context access$getMContext$p = this.this$0.f21689a;
        ViewGroup access$getMBottomView$p = this.this$0.f21693e;
        Intrinsics.checkNotNullExpressionValue(access$getMBottomView$p, "mBottomView");
        return companion.newInstance(access$getMContext$p, access$getMBottomView$p);
    }
}
