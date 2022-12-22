package com.didi.soda.bill.component.editremark2;

import android.os.Bundle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.customer.foundation.rpc.entity.cart.RemarkEntity;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/bill/component/editremark2/EditRemarkPresenter2;", "Lcom/didi/soda/bill/component/Contract$AbsEditRemarkPresenter;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "finish", "", "onCreate", "updateRemark", "remark", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: EditRemarkPresenter2.kt */
public final class EditRemarkPresenter2 extends Contract.AbsEditRemarkPresenter implements IRFFloatingExpand {
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

    public void updateRemark(String str) {
        Intrinsics.checkNotNullParameter(str, ParamConst.PARAM_CART_REMARK);
        Bundle bundle = new Bundle();
        RemarkEntity remarkEntity = new RemarkEntity();
        remarkEntity.setContent(str);
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(remarkEntity);
        dismiss(getScopeContext(), bundle);
    }

    public void onCreate() {
        super.onCreate();
        Bundle bundle = getScopeContext().getBundle();
        Intrinsics.checkNotNullExpressionValue(bundle, "scopeContext.bundle");
        String string = bundle.getString("cart_note");
        Contract.AbsEditRemarkView absEditRemarkView = (Contract.AbsEditRemarkView) getLogicView();
        if (string == null) {
            string = "";
        }
        absEditRemarkView.initDefaultNote(string);
    }
}
