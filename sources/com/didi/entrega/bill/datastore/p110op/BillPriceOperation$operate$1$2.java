package com.didi.entrega.bill.datastore.p110op;

import android.view.View;
import com.didi.entrega.bill.BillExt;
import com.didi.entrega.bill.BillOmegaHelper;
import com.didi.entrega.bill.datastore.BillRepo;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.order.CreateOrderManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "it", "Landroid/view/View;"}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.entrega.bill.datastore.op.BillPriceOperation$operate$1$2 */
/* compiled from: BillPriceOperation.kt */
final class BillPriceOperation$operate$1$2 extends Lambda implements Function1<View, Unit> {
    final /* synthetic */ BillEntity $entity;
    final /* synthetic */ BillRepo $repo;
    final /* synthetic */ BillPriceOperation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillPriceOperation$operate$1$2(BillEntity billEntity, BillPriceOperation billPriceOperation, BillRepo billRepo) {
        super(1);
        this.$entity = billEntity;
        this.this$0 = billPriceOperation;
        this.$repo = billRepo;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        BillOmegaHelper.INSTANCE.trackPayClick(this.$entity, BillRepo.Companion.get(this.this$0.getScopeContext()).getPageSource());
        if (!BillExt.Companion.billNextBtnOpenPage(BillRepo.Companion.get(this.this$0.getScopeContext()).getPageSource(), 1, this.this$0.getScopeContext())) {
            new CreateOrderManager(this.$repo, this.this$0, this.$entity, this.this$0.getScopeContext()) {
                final /* synthetic */ BillEntity $entity;
                final /* synthetic */ BillRepo $repo;
                final /* synthetic */ BillPriceOperation this$0;

                {
                    this.$repo = r1;
                    this.this$0 = r2;
                    this.$entity = r3;
                }

                public void updateLoading(boolean z) {
                    if (z) {
                        DialogUtil.showLoadingDialog(getScopeContext(), true);
                    } else {
                        DialogUtil.hideLoadingDialog();
                    }
                    this.$repo.updateOperation(this.this$0, new BillPriceOperation$operate$1$2$1$updateLoading$1(z));
                }
            }.start();
        }
    }
}
