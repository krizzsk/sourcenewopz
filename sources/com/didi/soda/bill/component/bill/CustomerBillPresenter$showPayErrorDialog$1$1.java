package com.didi.soda.bill.component.bill;

import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillPresenter.kt */
final class CustomerBillPresenter$showPayErrorDialog$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PayChannelEntity $channelEntity;
    final /* synthetic */ CustomerBillPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerBillPresenter$showPayErrorDialog$1$1(CustomerBillPresenter customerBillPresenter, PayChannelEntity payChannelEntity) {
        super(0);
        this.this$0 = customerBillPresenter;
        this.$channelEntity = payChannelEntity;
    }

    public final void invoke() {
        this.this$0.f38847s.hidePayFailGuideView();
        CustomerBillPresenter customerBillPresenter = this.this$0;
        customerBillPresenter.onCreateOrder(((Contract.AbsBillView) customerBillPresenter.getLogicView()).getPayButtonCallback());
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String access$getCartId$p = this.this$0.f38829a;
        String str = null;
        if (access$getCartId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
            access$getCartId$p = null;
        }
        String access$getShopId$p = this.this$0.f38830b;
        if (access$getShopId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
        } else {
            str = access$getShopId$p;
        }
        companion.tracePayErrorGuideDialogCK(access$getCartId$p, str, this.$channelEntity, 1);
    }
}
