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
/* compiled from: CustomerBillPresenterV2.kt */
final class CustomerBillPresenterV2$showPayErrorDialog$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PayChannelEntity $channelEntity;
    final /* synthetic */ CustomerBillPresenterV2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerBillPresenterV2$showPayErrorDialog$1$1(CustomerBillPresenterV2 customerBillPresenterV2, PayChannelEntity payChannelEntity) {
        super(0);
        this.this$0 = customerBillPresenterV2;
        this.$channelEntity = payChannelEntity;
    }

    public final void invoke() {
        this.this$0.f38879t.hidePayFailGuideView();
        CustomerBillPresenterV2 customerBillPresenterV2 = this.this$0;
        customerBillPresenterV2.onCreateOrder(((Contract.AbsBillView) customerBillPresenterV2.getLogicView()).getPayButtonCallback());
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String access$getCartId$p = this.this$0.f38860a;
        String str = null;
        if (access$getCartId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
            access$getCartId$p = null;
        }
        String access$getShopId$p = this.this$0.f38861b;
        if (access$getShopId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
        } else {
            str = access$getShopId$p;
        }
        companion.tracePayErrorGuideDialogCK(access$getCartId$p, str, this.$channelEntity, 1);
    }
}
