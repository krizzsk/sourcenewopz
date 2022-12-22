package com.didi.soda.bill.component.bill;

import android.os.Bundle;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.model.ComponentModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo175978d2 = {"com/didi/soda/bill/component/bill/CustomerBillPresenterV2$showErrorDialog$1$3", "Lcom/didi/soda/bill/component/Contract$IPayCardErrorListener;", "onDismiss", "", "onEditAddress", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillPresenterV2.kt */
public final class CustomerBillPresenterV2$showErrorDialog$1$3 implements Contract.IPayCardErrorListener {
    final /* synthetic */ CustomerBillPresenterV2 this$0;

    CustomerBillPresenterV2$showErrorDialog$1$3(CustomerBillPresenterV2 customerBillPresenterV2) {
        this.this$0 = customerBillPresenterV2;
    }

    public void onCashPay() {
        Contract.IPayCardErrorListener.DefaultImpls.onCashPay(this);
    }

    public void onOtherPay() {
        Contract.IPayCardErrorListener.DefaultImpls.onOtherPay(this);
    }

    public void onEditAddress() {
        ComponentModel access$findModelByType = this.this$0.m27584b(2);
        if (access$findModelByType != null) {
            CustomerBillPresenterV2 customerBillPresenterV2 = this.this$0;
            IView logicView = customerBillPresenterV2.getLogicView();
            Intrinsics.checkNotNullExpressionValue(logicView, "logicView");
            Contract.AbsBillView.autoClickItem$default((Contract.AbsBillView) logicView, access$findModelByType, 3, (Bundle) null, 4, (Object) null);
            BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
            String access$getCartId$p = customerBillPresenterV2.f38860a;
            String str = null;
            if (access$getCartId$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
                access$getCartId$p = null;
            }
            String access$getShopId$p = customerBillPresenterV2.f38861b;
            if (access$getShopId$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shopId");
            } else {
                str = access$getShopId$p;
            }
            companion.traceDeliveryConfirmCK(access$getCartId$p, str, 2);
        }
    }

    public void onDismiss() {
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
        companion.traceDeliveryConfirmCK(access$getCartId$p, str, 1);
    }
}
