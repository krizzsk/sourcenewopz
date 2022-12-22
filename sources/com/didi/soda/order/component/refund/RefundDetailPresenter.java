package com.didi.soda.order.component.refund;

import android.os.Bundle;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.order.component.refund.Contract;
import com.didi.soda.order.omega.OrderOmegaHelper;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/order/component/refund/RefundDetailPresenter;", "Lcom/didi/soda/order/component/refund/Contract$AbsRefundDetailPresenter;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "orderId", "", "orderOmegaHelper", "Lcom/didi/soda/order/omega/OrderOmegaHelper;", "finish", "", "getOrderOmegaHelper", "onCreate", "onRefundDetailSw", "onTotalTipsCk", "ruleDesc", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/RuleDescEntity;", "retryRequest", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RefundDetailPresenter.kt */
public final class RefundDetailPresenter extends Contract.AbsRefundDetailPresenter implements IRFFloatingExpand {

    /* renamed from: a */
    private OrderOmegaHelper f43459a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f43460b;

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

    public void onCreate() {
        super.onCreate();
        retryRequest();
    }

    public void retryRequest() {
        Bundle bundle = getScopeContext().getBundle();
        Intrinsics.checkNotNullExpressionValue(bundle, "scopeContext.bundle");
        String string = bundle.getString("orderid", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(Const.P…ER_ID, StringConst.EMPTY)");
        this.f43460b = string;
        DialogUtil.showLoadingDialog(getScopeContext(), false);
        CustomerRpcService customerRpcService = CustomerRpcManagerProxy.get();
        String str = this.f43460b;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderId");
            str = null;
        }
        customerRpcService.gotoRefund(str, new RefundDetailPresenter$retryRequest$1(this));
    }

    public void onTotalTipsCk(RuleDescEntity ruleDescEntity) {
        OrderOmegaHelper a = m30779a();
        String str = null;
        if (a != null) {
            String str2 = this.f43460b;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orderId");
                str2 = null;
            }
            a.traceRefundTotalTipsCk(str2);
        }
        Request.Builder putInt = DiRouter.request().path(RoutePath.REFUND_RULE_PAGE).putInt("from", 2);
        String str3 = this.f43460b;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderId");
        } else {
            str = str3;
        }
        putInt.putString("orderid", str).putSerializable("entity", ruleDescEntity).open();
    }

    public void finish() {
        dismiss(getScopeContext());
    }

    public void onRefundDetailSw() {
        OrderOmegaHelper a = m30779a();
        if (a != null) {
            String str = this.f43460b;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orderId");
                str = null;
            }
            a.trackRefundDetailSw(str);
        }
    }

    /* renamed from: a */
    private final OrderOmegaHelper m30779a() {
        if (this.f43459a == null) {
            ScopeContext scopeContext = getScopeContext();
            Intrinsics.checkNotNullExpressionValue(scopeContext, "scopeContext");
            this.f43459a = new OrderOmegaHelper(scopeContext);
        }
        return this.f43459a;
    }
}
