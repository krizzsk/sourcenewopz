package com.didi.entrega.order;

import android.os.Bundle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.pay.ValidateCardHelper;
import com.didi.entrega.pay.PayMethodPage;
import com.didi.entrega.router.DiRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u0018"}, mo175978d2 = {"com/didi/entrega/order/CreateOrderManager$consumeCreateFailed$1", "Lcom/didi/entrega/order/CreateOrderErrorHandler;", "closeBill", "", "doCall", "phoneNumber", "", "goToOrder", "orderId", "goToPayMethod", "cartId", "payChannel", "Lcom/didi/entrega/customer/foundation/rpc/entity/PayChannel;", "gotoSecurity", "cid", "bundle", "Landroid/os/Bundle;", "login", "popToRoot", "recreateOrder", "duplicateOrderConfirm", "", "refreshBill", "validateCard", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderManager.kt */
public final class CreateOrderManager$consumeCreateFailed$1 extends CreateOrderErrorHandler {
    final /* synthetic */ CreateOrderManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateOrderManager$consumeCreateFailed$1(CreateOrderManager createOrderManager, ScopeContext scopeContext) {
        super(scopeContext);
        this.this$0 = createOrderManager;
    }

    public void refreshBill(String str) {
        this.this$0.refreshBillInfo(str);
    }

    public void goToOrder(String str) {
        this.this$0.gotoOrderPage(str);
    }

    public void popToRoot() {
        getScopeContext().getNavigator().popToRoot();
    }

    public void recreateOrder(int i) {
        CreateOrderManager createOrderManager = this.this$0;
        CreateOrderCallBack access$getCreateOrderFunction$p = createOrderManager.createOrderFunction;
        if (access$getCreateOrderFunction$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createOrderFunction");
            access$getCreateOrderFunction$p = null;
        }
        createOrderManager.createOrder(i, access$getCreateOrderFunction$p);
    }

    public void closeBill() {
        getScopeContext().getNavigator().finish();
    }

    public void goToPayMethod(String str, PayChannel payChannel) {
        PayMethodPage.toPayMethod(getScopeContext(), 0, 0, str, payChannel);
    }

    public void doCall(String str) {
        CustomerSystemUtil.doCall(GlobalContext.getContext(), str);
    }

    public void login() {
        LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), 3);
    }

    public void validateCard(PayChannel payChannel) {
        Intrinsics.checkNotNullParameter(payChannel, "payChannel");
        String cardSuffix = payChannel.getCardSuffix();
        String str = "";
        if (cardSuffix == null) {
            cardSuffix = str;
        }
        String cardIndex = payChannel.getCardIndex();
        if (cardIndex != null) {
            str = cardIndex;
        }
        ValidateCardHelper.validateCard(cardSuffix, str, 102);
    }

    public void gotoSecurity(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        DiRouter.request().path("securityPage").putString(Const.BundleKey.CART_ID, str).putBundle("bundle", bundle).open();
    }
}
