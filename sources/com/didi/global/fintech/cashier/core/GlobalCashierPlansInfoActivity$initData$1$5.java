package com.didi.global.fintech.cashier.core;

import android.widget.TextView;
import com.didi.global.fintech.cashier.core.adapter.PlansAdapter;
import com.didi.global.fintech.cashier.p117ui.viewholder.item.InstallmentVo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "item", "Lcom/didi/global/fintech/cashier/ui/viewholder/item/InstallmentVo$PlansVo;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierPlansInfoActivity.kt */
final class GlobalCashierPlansInfoActivity$initData$1$5 extends Lambda implements Function1<InstallmentVo.PlansVo, Unit> {
    final /* synthetic */ PlansAdapter $adapter;
    final /* synthetic */ GlobalCashierPlansInfoActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPlansInfoActivity$initData$1$5(GlobalCashierPlansInfoActivity globalCashierPlansInfoActivity, PlansAdapter plansAdapter) {
        super(1);
        this.this$0 = globalCashierPlansInfoActivity;
        this.$adapter = plansAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InstallmentVo.PlansVo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InstallmentVo.PlansVo plansVo) {
        Intrinsics.checkNotNullParameter(plansVo, "item");
        this.this$0.m15721a(3, plansVo.getNumber());
        if (!plansVo.isSelected()) {
            this.this$0.f21418g = plansVo.getNumber();
            TextView access$getTaxTV$p = this.this$0.f21413b;
            if (access$getTaxTV$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("taxTV");
                access$getTaxTV$p = null;
            }
            access$getTaxTV$p.setText(plansVo.getAccessoryAmount());
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (Object next : this.$adapter.getList()) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                InstallmentVo.PlansVo plansVo2 = (InstallmentVo.PlansVo) next;
                if (plansVo2.isSelected()) {
                    i = i3;
                }
                if (Intrinsics.areEqual((Object) plansVo, (Object) plansVo2)) {
                    i2 = i3;
                }
                plansVo2.setSelected(Boolean.valueOf(Intrinsics.areEqual((Object) plansVo2, (Object) plansVo)));
                i3 = i4;
            }
            if (i != i2) {
                this.$adapter.notifyItemChanged(i);
                this.$adapter.notifyItemChanged(i2);
            }
        }
    }
}
