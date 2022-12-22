package com.didi.soda.bill.component.deliverymethod;

import android.os.Bundle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.model.datamodel.DeliveryModel;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.address.DeliveryMethodEntity;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/bill/component/deliverymethod/DeliveryMethodPresenter;", "Lcom/didi/soda/bill/component/Contract$AbsDeliveryMethodPresenter;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "finish", "", "onCreate", "updateDeliveryMethod", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/DeliveryMethodEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DeliveryMethodPresenter.kt */
public final class DeliveryMethodPresenter extends Contract.AbsDeliveryMethodPresenter implements IRFFloatingExpand {
    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    public void finish() {
        dismiss(getScopeContext());
    }

    public void updateDeliveryMethod(DeliveryMethodEntity deliveryMethodEntity) {
        String string = getScopeContext().getBundle().getString(Const.PageParams.SHOP_ID);
        String string2 = getScopeContext().getBundle().getString(Const.PageParams.CART_ID);
        BillOmegaHelper.Companion companion = BillOmegaHelper.Companion;
        String str = null;
        Integer valueOf = deliveryMethodEntity == null ? null : Integer.valueOf(deliveryMethodEntity.type);
        if (deliveryMethodEntity != null) {
            str = deliveryMethodEntity.remark;
        }
        CharSequence charSequence = str;
        companion.trackDeliveryConfirmCK(valueOf, !(charSequence == null || charSequence.length() == 0), string2, string);
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(deliveryMethodEntity);
        dismiss(getScopeContext());
    }

    public void onCreate() {
        super.onCreate();
        Bundle bundle = getScopeContext().getBundle();
        Intrinsics.checkNotNullExpressionValue(bundle, "scopeContext.bundle");
        Serializable serializable = bundle.getSerializable("entity");
        if (serializable != null) {
            DeliveryModel deliveryModel = (DeliveryModel) serializable;
            ((Contract.AbsDeliveryMethodView) getLogicView()).initDeliveryMethod(deliveryModel.getMethods(), deliveryModel.getDeliveryRulesModel());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.bill.model.datamodel.DeliveryModel");
    }
}
