package com.didi.soda.bill.component.ordertip;

import android.os.Bundle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.soda.bill.component.Contract;
import com.didi.soda.bill.manager.CreateOrderState;
import com.didi.soda.bill.repo.CartInfoConfirmRepo;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.repo.RepoFactory;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0014J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/bill/component/ordertip/CartInfoConfirmPresenter;", "Lcom/didi/soda/bill/component/Contract$AbsCartInfoConfirmPresenter;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "dismissByType", "", "type", "", "onClickBack", "onConfirm", "onCreate", "onEditInfo", "onHandleBack", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartInfoConfirmPresenter.kt */
public final class CartInfoConfirmPresenter extends Contract.AbsCartInfoConfirmPresenter implements IRFFloatingExpand {
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

    /* access modifiers changed from: protected */
    public void onCreate() {
        PayChannelEntity payChannelEntity;
        super.onCreate();
        Serializable serializable = getScopeContext().getBundle().getSerializable(Const.PageParams.CART_INFO_CONFIRM_ENTITY);
        if (serializable != null && (serializable instanceof CreateOrderState) && (payChannelEntity = ((CreateOrderState) serializable).getPayChannelEntity()) != null) {
            ((Contract.AbsCartInfoConfirmView) getLogicView()).setData(payChannelEntity);
        }
    }

    public void onConfirm() {
        m27662a(3);
    }

    public void onEditInfo() {
        m27662a(4);
    }

    public void onClickBack() {
        m27662a(1);
    }

    public void onHandleBack() {
        m27662a(2);
    }

    /* renamed from: a */
    private final void m27662a(int i) {
        ((CartInfoConfirmRepo) RepoFactory.getRepo(CartInfoConfirmRepo.class)).setValue(Integer.valueOf(i));
        dismiss(getScopeContext());
    }
}
