package com.didi.soda.bill.component.bill;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentEntity;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.pay.PayMethodPage;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillPresenter.kt */
final class CustomerBillPresenter$showPayErrorDialog$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PayChannelEntity $channelEntity;
    final /* synthetic */ BillComponentEntity $componentEntity;
    final /* synthetic */ CustomerBillPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerBillPresenter$showPayErrorDialog$1$2(CustomerBillPresenter customerBillPresenter, BillComponentEntity billComponentEntity, PayChannelEntity payChannelEntity) {
        super(0);
        this.this$0 = customerBillPresenter;
        this.$componentEntity = billComponentEntity;
        this.$channelEntity = payChannelEntity;
    }

    public final void invoke() {
        String str;
        String str2;
        this.this$0.f38847s.hidePayFailGuideView();
        ScopeContext scopeContext = this.this$0.getScopeContext();
        String access$getShopId$p = this.this$0.f38830b;
        String str3 = null;
        if (access$getShopId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
            str = null;
        } else {
            str = access$getShopId$p;
        }
        String access$getCartId$p = this.this$0.f38829a;
        if (access$getCartId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
            str2 = null;
        } else {
            str2 = access$getCartId$p;
        }
        BillComponentEntity billComponentEntity = this.$componentEntity;
        PayMethodPage.toPayMethod(scopeContext, str, 0, 0, str2, ExtentionsKt.orZero(billComponentEntity == null ? null : Integer.valueOf(billComponentEntity.getHintType())), this.$channelEntity);
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String access$getCartId$p2 = this.this$0.f38829a;
        if (access$getCartId$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
            access$getCartId$p2 = null;
        }
        String access$getShopId$p2 = this.this$0.f38830b;
        if (access$getShopId$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
        } else {
            str3 = access$getShopId$p2;
        }
        companion.tracePayErrorGuideDialogCK(access$getCartId$p2, str3, this.$channelEntity, 2);
    }
}
