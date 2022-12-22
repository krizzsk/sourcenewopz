package com.didi.entrega.order;

import android.app.Activity;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerPayManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"com/didi/entrega/order/CreateOrderPayHandler$doPay$1", "Lcom/didi/entrega/manager/base/ICustomerPayManager$PayCallback;", "isPayPayFailed", "", "()Z", "setPayPayFailed", "(Z)V", "thirdPayRunnable", "Ljava/lang/Runnable;", "onThirdPayStart", "", "channelId", "", "payFail", "code", "msg", "", "paySucceed", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateOrderPayHandler.kt */
public final class CreateOrderPayHandler$doPay$1 implements ICustomerPayManager.PayCallback {
    final /* synthetic */ ICustomerPayManager.PayParamEntity $payParam;
    private boolean isPayPayFailed;
    /* access modifiers changed from: private */
    public final Runnable thirdPayRunnable = new Runnable() {
        public final void run() {
            CreateOrderPayHandler$doPay$1.m46389thirdPayRunnable$lambda0(CreateOrderPayHandler.this);
        }
    };
    final /* synthetic */ CreateOrderPayHandler this$0;

    CreateOrderPayHandler$doPay$1(CreateOrderPayHandler createOrderPayHandler, ICustomerPayManager.PayParamEntity payParamEntity) {
        this.this$0 = createOrderPayHandler;
        this.$payParam = payParamEntity;
    }

    public final boolean isPayPayFailed() {
        return this.isPayPayFailed;
    }

    public final void setPayPayFailed(boolean z) {
        this.isPayPayFailed = z;
    }

    public void payFail(int i, String str) {
        if (i == -1 || i == 2) {
            this.this$0.payMaybeSuccess(str, i);
        } else if (i != 100) {
            this.this$0.payFailed(str, i);
        } else {
            this.this$0.getTimeoutHandler().cancel();
            this.isPayPayFailed = true;
            ((ICustomerPayManager) CustomerManagerLoader.loadManager(ICustomerPayManager.class)).pay(this.this$0.getScopeContext(), (Activity) GlobalContext.getContext(), this.$payParam, this);
        }
        if (this.isPayPayFailed) {
            UiHandlerUtil.removeCallbacks(this.thirdPayRunnable);
        }
    }

    public void paySucceed() {
        if (this.isPayPayFailed) {
            UiHandlerUtil.removeCallbacks(this.thirdPayRunnable);
        }
        this.this$0.paySuccess();
    }

    public void onThirdPayStart(int i) {
        this.this$0.getScopeContext().addObserver(new CreateOrderPayHandler$doPay$1$onThirdPayStart$1(this, this.this$0));
    }

    /* access modifiers changed from: private */
    /* renamed from: thirdPayRunnable$lambda-0  reason: not valid java name */
    public static final void m46389thirdPayRunnable$lambda0(CreateOrderPayHandler createOrderPayHandler) {
        Intrinsics.checkNotNullParameter(createOrderPayHandler, "this$0");
        createOrderPayHandler.paySuccess();
    }
}
