package com.didi.soda.bill.component.outofstock;

import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.customer.foundation.rpc.entity.cart.AbnormalItemDetailEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/bill/component/outofstock/OutOfStockView$initItemBinders$1", "Lcom/didi/soda/bill/component/outofstock/OutOfStockSelectionBinder;", "onItemClick", "", "item", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/AbnormalItemDetailEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OutOfStockView.kt */
public final class OutOfStockView$initItemBinders$1 extends OutOfStockSelectionBinder {
    final /* synthetic */ OutOfStockView this$0;

    OutOfStockView$initItemBinders$1(OutOfStockView outOfStockView) {
        this.this$0 = outOfStockView;
    }

    public void onItemClick(AbnormalItemDetailEntity abnormalItemDetailEntity) {
        Intrinsics.checkNotNullParameter(abnormalItemDetailEntity, "item");
        ((Contract.AbsOutOfStockPresenter) this.this$0.getPresenter()).updateSelected(abnormalItemDetailEntity.getType());
        BillOmegaHelper.Companion.trackOutOfStockSelectCk(this.this$0.f38951c, this.this$0.f38952d, Integer.valueOf(abnormalItemDetailEntity.getType()));
    }
}
