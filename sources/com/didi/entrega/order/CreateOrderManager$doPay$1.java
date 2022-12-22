package com.didi.entrega.order;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.foundation.rpc.entity.OrderCreateEntity;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0003H\u0014¨\u0006\n"}, mo175978d2 = {"com/didi/entrega/order/CreateOrderManager$doPay$1", "Lcom/didi/entrega/order/CreateOrderPayHandler;", "payFailed", "", "msg", "", "code", "", "payMaybeSuccess", "paySuccess", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderManager.kt */
public final class CreateOrderManager$doPay$1 extends CreateOrderPayHandler {
    final /* synthetic */ Function0<Unit> $goToOrder;
    final /* synthetic */ OrderCreateEntity $order;
    final /* synthetic */ Function0<Unit> $refreshBillInfo;
    final /* synthetic */ CreateOrderManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateOrderManager$doPay$1(CreateOrderManager createOrderManager, OrderCreateEntity orderCreateEntity, Function0<Unit> function0, Function0<Unit> function02, ScopeContext scopeContext, CreateOrderManager$timeoutHandler$1 createOrderManager$timeoutHandler$1) {
        super(scopeContext, createOrderManager$timeoutHandler$1);
        this.this$0 = createOrderManager;
        this.$order = orderCreateEntity;
        this.$goToOrder = function0;
        this.$refreshBillInfo = function02;
    }

    /* access modifiers changed from: protected */
    public void paySuccess() {
        LogUtil.m14765i("CreateOrderManager", "doPay paySuccess cartId=" + this.this$0.getBillEntity().getCartId() + " order=" + this.$order.getOrderId() + ' ');
        this.$goToOrder.invoke();
    }

    /* access modifiers changed from: protected */
    public void payFailed(String str, int i) {
        LogUtil.m14765i("CreateOrderManager", "doPay payFailed cartId=" + this.this$0.getBillEntity().getCartId() + " order=" + this.$order.getOrderId() + " code=" + i + " msg=" + str);
        this.this$0.onProgressEnd();
        DialogUtil.showOuterPayFailDialog(getScopeContext(), str, new RFDialogInterface.OnClickListener(this.$order, this.$refreshBillInfo) {
            public final /* synthetic */ OrderCreateEntity f$1;
            public final /* synthetic */ Function0 f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(RFDialog rFDialog) {
                CreateOrderManager$doPay$1.m46386payFailed$lambda0(CreateOrderManager.this, this.f$1, this.f$2, rFDialog);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: payFailed$lambda-0  reason: not valid java name */
    public static final void m46386payFailed$lambda0(CreateOrderManager createOrderManager, OrderCreateEntity orderCreateEntity, Function0 function0, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(createOrderManager, "this$0");
        Intrinsics.checkNotNullParameter(orderCreateEntity, "$order");
        Intrinsics.checkNotNullParameter(function0, "$refreshBillInfo");
        createOrderManager.updateLoading(true);
        CustomerRpcManagerProxy.get().cancelOrder(orderCreateEntity.getOrderId(), 1, new CreateOrderManager$doPay$1$payFailed$1$1(function0));
    }

    /* access modifiers changed from: protected */
    public void payMaybeSuccess(String str, int i) {
        LogUtil.m14765i("CreateOrderManager", "doPay payMaybeSuccess cartId=" + this.this$0.getBillEntity().getCartId() + " order=" + this.$order.getOrderId() + " code=" + i + " msg=" + str);
        this.this$0.onProgressEnd();
        DialogUtil.showPayFailDialog(getScopeContext(), str, i, new RFDialogInterface.OnClickListener() {
            public final void onClick(RFDialog rFDialog) {
                CreateOrderManager$doPay$1.m46387payMaybeSuccess$lambda1(Function0.this, rFDialog);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: payMaybeSuccess$lambda-1  reason: not valid java name */
    public static final void m46387payMaybeSuccess$lambda1(Function0 function0, RFDialog rFDialog) {
        Intrinsics.checkNotNullParameter(function0, "$goToOrder");
        function0.invoke();
    }
}
