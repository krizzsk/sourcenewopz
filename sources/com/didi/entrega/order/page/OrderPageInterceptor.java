package com.didi.entrega.order.page;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.foundation.util.ToastUtil;
import com.didi.entrega.order.omega.OrderOmegaHelper;
import com.didi.entrega.router.IInterceptor;
import com.didi.entrega.router.Request;
import com.didi.entrega.router.Response;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/didi/entrega/order/page/OrderPageInterceptor;", "Lcom/didi/entrega/router/IInterceptor;", "()V", "intercept", "", "request", "Lcom/didi/entrega/router/Request;", "response", "Lcom/didi/entrega/router/Response;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderPageInterceptor.kt */
public final class OrderPageInterceptor implements IInterceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private static final String f20908a = "EntregaOrderPageInterceptor";

    public boolean intercept(Request request, Response response) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        Bundle extras = request.getExtras();
        boolean z = true;
        int i = -1;
        if (extras == null) {
            LogUtil.m14765i(f20908a, "intercept args ==null");
        } else {
            String string = extras.getString("orderId");
            i = extras.getInt("from", -1);
            if (!TextUtils.isEmpty(string) || i == 2) {
                z = false;
            } else {
                LogUtil.m14765i(f20908a, "intercept orderId ==null");
            }
        }
        if (z) {
            ToastUtil.showCustomerToast((ScopeContext) null, ResourceHelper.getString(R.string.FoodC_orderlist3_No_service_laow));
            OrderOmegaHelper.INSTANCE.trackOrderIdError(i);
        }
        return z;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/order/page/OrderPageInterceptor$Companion;", "", "()V", "TAG", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderPageInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
