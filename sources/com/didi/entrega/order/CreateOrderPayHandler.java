package com.didi.entrega.order;

import android.app.Activity;
import android.content.Context;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerPayManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u001a\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H$J\u001a\u0010\u0014\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H$J\b\u0010\u0015\u001a\u00020\fH$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/entrega/order/CreateOrderPayHandler;", "", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "timeoutHandler", "Lcom/didi/entrega/order/PayTimeoutHandler;", "(Lcom/didi/app/nova/skeleton/ScopeContext;Lcom/didi/entrega/order/PayTimeoutHandler;)V", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "getTimeoutHandler", "()Lcom/didi/entrega/order/PayTimeoutHandler;", "doPay", "", "transId", "", "orderId", "payFailed", "msg", "code", "", "payMaybeSuccess", "paySuccess", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderPayHandler.kt */
public abstract class CreateOrderPayHandler {
    private final ScopeContext scopeContext;
    private final PayTimeoutHandler timeoutHandler;

    /* access modifiers changed from: protected */
    public abstract void payFailed(String str, int i);

    /* access modifiers changed from: protected */
    public abstract void payMaybeSuccess(String str, int i);

    /* access modifiers changed from: protected */
    public abstract void paySuccess();

    public CreateOrderPayHandler(ScopeContext scopeContext2, PayTimeoutHandler payTimeoutHandler) {
        Intrinsics.checkNotNullParameter(scopeContext2, "scopeContext");
        Intrinsics.checkNotNullParameter(payTimeoutHandler, "timeoutHandler");
        this.scopeContext = scopeContext2;
        this.timeoutHandler = payTimeoutHandler;
    }

    public final ScopeContext getScopeContext() {
        return this.scopeContext;
    }

    public final PayTimeoutHandler getTimeoutHandler() {
        return this.timeoutHandler;
    }

    public final void doPay(String str, String str2) {
        ICustomerPayManager.PayParamEntity payParamEntity = new ICustomerPayManager.PayParamEntity();
        payParamEntity.token = LoginUtil.getToken();
        payParamEntity.transId = str;
        payParamEntity.orderId = str2;
        ICustomerPayManager iCustomerPayManager = (ICustomerPayManager) CustomerManagerLoader.loadManager(ICustomerPayManager.class);
        Context context = GlobalContext.getContext();
        if (context != null) {
            iCustomerPayManager.getPayStatus((Activity) context, this.scopeContext, payParamEntity, new CreateOrderPayHandler$doPay$1(this, payParamEntity));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
}
