package com.didi.soda.bill.component.bill;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillSection;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.pay.PayMethodPage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/soda/bill/component/bill/CustomerBillPresenter$showErrorDialog$1$2", "Lcom/didi/soda/bill/component/Contract$IPayCardErrorListener;", "onCashPay", "", "onDismiss", "onOtherPay", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CustomerBillPresenter.kt */
public final class CustomerBillPresenter$showErrorDialog$1$2 implements Contract.IPayCardErrorListener {
    final /* synthetic */ String $orderId;
    final /* synthetic */ CustomerBillPresenter this$0;

    CustomerBillPresenter$showErrorDialog$1$2(CustomerBillPresenter customerBillPresenter, String str) {
        this.this$0 = customerBillPresenter;
        this.$orderId = str;
    }

    public void onEditAddress() {
        Contract.IPayCardErrorListener.DefaultImpls.onEditAddress(this);
    }

    public void onCashPay() {
        CustomerBillPresenter customerBillPresenter = this.this$0;
        customerBillPresenter.onCreateOrder(((Contract.AbsBillView) customerBillPresenter.getLogicView()).getPayButtonCallback());
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String str = this.$orderId;
        String access$getShopId$p = this.this$0.f38830b;
        String str2 = null;
        if (access$getShopId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
            access$getShopId$p = null;
        }
        String access$getCartId$p = this.this$0.f38829a;
        if (access$getCartId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
        } else {
            str2 = access$getCartId$p;
        }
        companion.traceGuideCashDialogCK(str, access$getShopId$p, str2, 1);
    }

    public void onOtherPay() {
        BillComponentEntity billComponentEntity;
        PayChannelEntity payChannelEntity;
        String str;
        String str2;
        Integer num;
        BillComponentDataEntity data;
        Object obj;
        boolean z;
        BillInfoEntity access$getMBillInfoEntity$p = this.this$0.f38841m;
        String str3 = null;
        if (access$getMBillInfoEntity$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBillInfoEntity");
            access$getMBillInfoEntity$p = null;
        }
        List<BillSection> sections = access$getMBillInfoEntity$p.getSections();
        if (sections == null) {
            billComponentEntity = null;
        } else {
            Collection arrayList = new ArrayList();
            for (BillSection components : sections) {
                ArrayList<BillComponentEntity> components2 = components.getComponents();
                if (components2 != null) {
                    arrayList.add(components2);
                }
            }
            Collection arrayList2 = new ArrayList();
            for (ArrayList addAll : (List) arrayList) {
                CollectionsKt.addAll(arrayList2, addAll);
            }
            Iterator it = ((List) arrayList2).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((BillComponentEntity) obj).getType() == 4) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            billComponentEntity = (BillComponentEntity) obj;
        }
        if (billComponentEntity == null || (data = billComponentEntity.getData()) == null) {
            payChannelEntity = null;
        } else {
            payChannelEntity = data.getPayChannel();
        }
        ScopeContext scopeContext = this.this$0.getScopeContext();
        String access$getShopId$p = this.this$0.f38830b;
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
        if (billComponentEntity == null) {
            num = null;
        } else {
            num = Integer.valueOf(billComponentEntity.getHintType());
        }
        PayMethodPage.toPayMethod(scopeContext, str, 0, 0, str2, ExtentionsKt.orZero(num), payChannelEntity);
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String str4 = this.$orderId;
        String access$getShopId$p2 = this.this$0.f38830b;
        if (access$getShopId$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
            access$getShopId$p2 = null;
        }
        String access$getCartId$p2 = this.this$0.f38829a;
        if (access$getCartId$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
        } else {
            str3 = access$getCartId$p2;
        }
        companion.traceGuideCashDialogCK(str4, access$getShopId$p2, str3, 2);
    }

    public void onDismiss() {
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String str = this.$orderId;
        String access$getShopId$p = this.this$0.f38830b;
        String str2 = null;
        if (access$getShopId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopId");
            access$getShopId$p = null;
        }
        String access$getCartId$p = this.this$0.f38829a;
        if (access$getCartId$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Const.BundleKey.CART_ID);
        } else {
            str2 = access$getCartId$p;
        }
        companion.traceGuideCashDialogCK(str, access$getShopId$p, str2, 3);
    }
}
